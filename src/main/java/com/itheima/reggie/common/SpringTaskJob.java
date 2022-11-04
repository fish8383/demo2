package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.entity.Colorlist;
import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.service.ColorlistService;
import com.itheima.reggie.service.PlcbodydataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@EnableScheduling
@Slf4j
@Configuration
public class SpringTaskJob {
    @Autowired
    private PlcbodydataService plcbodydataService;
    @Autowired
    private ColorlistService colorlistService;

    /**
     * 定时查找车间内的车的所有颜色，并刷新表格
     */
    @Scheduled(cron = "0 0/2 * *  * ?")
//    @Scheduled(cron = "0/10 * * *  * ?")

    public void findColorTask() {
        log.info("定时刷新颜色任务={}", Thread.currentThread().getName() + LocalDate.now());
        LambdaQueryWrapper<Plcbodydata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notLike(Plcbodydata::getPlc, "18");
        queryWrapper.groupBy(Plcbodydata::getColor);
        List<Plcbodydata> list = plcbodydataService.list(queryWrapper);

        colorlistService.SaveOrUpdateColorList(list);


        int count = plcbodydataService.CountByDate();
        log.info("过车的数量={}", count);
        //当日过车数小于10 ，则为停产日
        // 将车间内STATUE 1 的颜色的need drain设为 Y 代表需排
        // 将车间内 STATUE 0 的颜色 need drain设为 N 代表未排
        // 将当日排了的颜色  need drain          设为 D 代表已排
        if (count < 10) {
            colorlistService.UpdateNeedDrain();
            colorlistService.UpdateNoNeedDrain();
            colorlistService.UpdateDrainDone();

        }else {
            //当日过车数大于10，则为生产日，将车间内N和 STATUE 1的 设为警告

            colorlistService.UpdateNeedDrainWhenProduction(list);
        }


    }


}