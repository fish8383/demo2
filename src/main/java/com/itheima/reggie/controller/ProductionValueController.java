package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Shopdata;
import com.itheima.reggie.entity.TimeRange;
import com.itheima.reggie.service.ShopdataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/production")
public class ProductionValueController {
    @Autowired
    private ShopdataService shopdataService;
@PostMapping("/dayvalue")
    public R<String> dayValueCharts(@RequestBody TimeRange timeRange) {
         log.info("date===>{}",timeRange);
    LambdaQueryWrapper<Shopdata> queryWrapper =new LambdaQueryWrapper();
    queryWrapper.ge(Shopdata::getTs,timeRange.getDate1());
    queryWrapper.le(Shopdata::getTs,timeRange.getDate2());
    queryWrapper.eq(Shopdata::getPlc,"L3FKT2");
        queryWrapper.eq(Shopdata::getRb,"1D060RB");
    int count = shopdataService.count(queryWrapper);
    System.out.println(count);

    return null;
    }
}
