package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Plcbodydata;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;


public interface PlcbodydataService extends IService<Plcbodydata> {
    public  int  CountByDate();
}
