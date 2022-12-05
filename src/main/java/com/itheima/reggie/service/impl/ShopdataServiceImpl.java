package com.itheima.reggie.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.entity.Shopdata;
import com.itheima.reggie.mapper.PlcbodydataMapper;
import com.itheima.reggie.mapper.ShopdataMapper;
import com.itheima.reggie.service.PlcbodydataService;
import com.itheima.reggie.service.ShopdataService;
import org.springframework.stereotype.Service;

@Service
@DS("datasql")
public class ShopdataServiceImpl extends ServiceImpl<ShopdataMapper,Shopdata >implements ShopdataService {

}
