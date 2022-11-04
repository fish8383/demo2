package com.itheima.reggie.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.entity.Colorlist;

import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.mapper.ColorlistMapper;

import com.itheima.reggie.service.ColorDruidService;
import com.itheima.reggie.service.ColorlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@DS("datasql")
@Service
public class ColorlistServiceImpl extends ServiceImpl<ColorlistMapper, Colorlist> implements ColorlistService {
    @Autowired
    private ColorDruidService colorDruidService;

    @Override
    public void SaveOrUpdateColorList(List<Plcbodydata> plcbodydataList) {
        //刷新所有颜色在车间状态位 -》0
        List<Colorlist> colorlistList = this.list();
        List<Colorlist> colorlists = colorlistList.stream().map((item) -> {
            item.setStatues("0");
            return item;
        }).collect(Collectors.toList());
        this.updateBatchById(colorlists);


        //提取车间内颜色清单中前两位单色
        for (Plcbodydata p : plcbodydataList
        ) {
            String color = p.getColor().substring(0, 2);
            LambdaQueryWrapper<Colorlist> colorQuery = new LambdaQueryWrapper<>();
            colorQuery.eq(Colorlist::getColor, color);
            Colorlist one = this.getOne(colorQuery);
            if (null == one) {
                //颜色表中新增颜色和状态
                Colorlist newColor = new Colorlist();
                newColor.setColor(color);
                newColor.setNeedDrain("N");
                newColor.setStatues("1");
                this.save(newColor);
            } else {
                //颜色表中刷新颜色状态
                one.setStatues("1");
                this.update(one, colorQuery);
            }

        }

    }

    /**
     * 车间内存在状态为1的，周末需排状态为Y
     */
    @Override
    public void UpdateNeedDrain() {
        LambdaQueryWrapper<Colorlist> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Colorlist::getStatues, 1);
        queryWrapper.ne(Colorlist::getNeedDrain, "D");
        List<Colorlist> colorlists = this.list(queryWrapper);
        List<Colorlist> list = colorlists.stream().map((item) -> {
            item.setNeedDrain("Y");
            return item;
        }).collect(Collectors.toList());
        this.updateBatchById(list);
    }

    /***
     * 车间内存在状态为0的，周末不需排状态为N
     */
    @Override
    public void UpdateNoNeedDrain() {
        LambdaQueryWrapper<Colorlist> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Colorlist::getStatues, 0);
        List<Colorlist> colorlists = this.list(queryWrapper);
        List<Colorlist> list = colorlists.stream().map((item) -> {
            item.setNeedDrain("N");
            return item;
        }).collect(Collectors.toList());
        this.updateBatchById(list);

    }

    /***
     * 周日完成排
     */
    @Override
    public void UpdateDrainDone() {
        LambdaQueryWrapper<ColorDruid> queryWrapper = new LambdaQueryWrapper<>();
        //查询条件  机器人数据库内排漆日期等于当日
        queryWrapper.ge(ColorDruid::getFtmstamp, DateUtilsByUser.getbeforDays(1));
        List<ColorDruid> colorDruids = colorDruidService.list(queryWrapper);

        //已排的颜色列表
        List<String> colors = colorDruids.stream().map((item) -> {
            return item.getColor();
        }).collect(Collectors.toList());

        //按已排颜色列表为查询条件，查询数据库颜色列表，刷新排漆状态 D
        LambdaQueryWrapper<Colorlist> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Colorlist::getColor, colors);
        Colorlist colorlist = new Colorlist();
        colorlist.setNeedDrain("D");
        //更新数据库
        this.update(colorlist, wrapper);
    }
    //当日过车数大于10，则为生产日，将车间内颜色清单，查找状态为N的数据库颜色清单，如存在，则改为Y

    @Override
    public void UpdateNeedDrainWhenProduction(List<Plcbodydata> plcbodydataList) {
        List<String> colorLists = plcbodydataList.stream().map((item) -> {
            return item.getColor().substring(0, 2);
        }).collect(Collectors.toList());

        LambdaQueryWrapper<Colorlist> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Colorlist::getColor, colorLists);
        queryWrapper.eq(Colorlist::getNeedDrain, "N");

        Colorlist colorlist = new Colorlist();
        colorlist.setNeedDrain("Y");
        this.update(colorlist, queryWrapper);

    }

    @Override
    public List<Colorlist> listDrainDate() {
        List<Colorlist> colorlists = this.list();
        List<ColorDruid> colorDruidList = colorDruidService.list();
        List<Colorlist> list = colorlists.stream().map((item) -> {
            String color = item.getColor();
            for (ColorDruid colorDruid : colorDruidList
            ) {
                if (colorDruid.getColor().equals(color)) {
                    item.setFoperator(colorDruid.getFoperator());
                    item.setFtmstamp(colorDruid.getFtmstamp());
                }
            }
            return item;
        }).collect(Collectors.toList());
        this.updateBatchById(list);
        return list;
    }


}
