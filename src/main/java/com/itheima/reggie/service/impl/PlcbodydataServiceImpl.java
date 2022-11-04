package com.itheima.reggie.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.mapper.PlcbodydataMapper;
import com.itheima.reggie.service.PlcbodydataService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@DS("datasql")
public class PlcbodydataServiceImpl extends ServiceImpl<PlcbodydataMapper, Plcbodydata> implements PlcbodydataService {
    @Override
    public int CountByDate() {
        LambdaQueryWrapper<Plcbodydata> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.ge(Plcbodydata::getTs, DateUtilsByUser.getbeforDays(1));
        queryWrapper.like(Plcbodydata::getPlc,"CC");
        int count = this.count(queryWrapper);
        return  count;
    }
}
