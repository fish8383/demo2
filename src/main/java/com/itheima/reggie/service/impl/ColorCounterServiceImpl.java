package com.itheima.reggie.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.entity.Plcbodydata;
import com.itheima.reggie.entity.colorCounter;
import com.itheima.reggie.mapper.ColorCounterMapper;
import com.itheima.reggie.mapper.PlcbodydataMapper;
import com.itheima.reggie.service.ColorCounterService;
import com.itheima.reggie.service.PlcbodydataService;
import org.springframework.stereotype.Service;

@Service
@DS("datasql")
public class ColorCounterServiceImpl extends ServiceImpl<ColorCounterMapper, colorCounter> implements ColorCounterService {

}
