package com.itheima.reggie;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.entity.Tboperation;
import com.itheima.reggie.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j

@SpringBootTest
public class testMSSQL {
    @Autowired
    private TboperationService tboperationService;
    @Autowired
    private ColorDruidService colorDruidService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PlcbodydataService plcbodydataService;


    @Autowired
    private ColorlistService colorlistService;

    @Test
    void testRobotData() {
        LambdaQueryWrapper<ColorDruid> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.like(Tboperation::getFoperation,"421 0");
//        queryWrapper.like(Tboperation::getFoperationcn,"R21");
//        queryWrapper.ge(Tboperation::getFtmstamp, DateUtilsByUser.getbeforDays(7));
//        List<Tboperation> list = tboperationService.list();

        List<ColorDruid> list = colorDruidService.list();
//
//
//        List<Tboperation> tboperationList = list.stream().map((item) -> {
//         item.setFoperation(item.getFoperation().substring(15,17));
//            return item;
//        }).collect(Collectors.toList());
        log.info("tboperationList={}", list);

    }

    @Test
    void testEployeeService() {
        List<Employee> list = employeeService.list();
        log.info("list={}", list);
    }

    /**
     * 车间入口颜色
     */

    @Test
    void testPlcBodyData() {
        LambdaQueryWrapper<Plcbodydata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Plcbodydata::getPlc, "L3F01").or().eq(Plcbodydata::getPlc, "L3F02");
        queryWrapper.groupBy(Plcbodydata::getColor);
        plcbodydataService.list(queryWrapper);
    }

    /**
     * 车间内颜色
     */
    @Test
    void testPlcBodyData2() {
        LambdaQueryWrapper<Plcbodydata> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notLike(Plcbodydata::getPlc, "18");
        queryWrapper.groupBy(Plcbodydata::getColor);
        plcbodydataService.list(queryWrapper);
    }

    @Test
    void testDrainUpdateDone() {
        colorlistService.UpdateDrainDone();
    }

    @Test
    void testDrainNeed() {
        colorlistService.UpdateNeedDrain();
        colorlistService.UpdateNoNeedDrain();
    }
@Test
    void UpdateNeedDrainWhenProduction() {
        Plcbodydata plcbodydata = new Plcbodydata();
        plcbodydata.setColor("2828");
        List<Plcbodydata> plcbodydataList = new ArrayList<>();
        plcbodydataList.add(plcbodydata);
         colorlistService.UpdateNeedDrainWhenProduction(plcbodydataList);
    }

}
