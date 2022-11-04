package com.itheima.reggie.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.mapper.ColorDruidMapper;
import com.itheima.reggie.service.ColorDruidService;
import org.springframework.stereotype.Service;
@DS("sqlserver")
@Service
public class ColorDruidServiceImpl extends ServiceImpl<ColorDruidMapper, ColorDruid> implements ColorDruidService {
}
