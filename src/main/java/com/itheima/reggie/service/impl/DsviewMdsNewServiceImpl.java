package com.itheima.reggie.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.entity.DsViewMdsNew;
import com.itheima.reggie.mapper.ColorDruidMapper;
import com.itheima.reggie.mapper.DsViewMdsNewMapper;
import com.itheima.reggie.service.ColorDruidService;
import com.itheima.reggie.service.DsViewMdsNewService;
import org.springframework.stereotype.Service;

@DS("durrDxqSqlserver")
@Service
public class DsviewMdsNewServiceImpl extends ServiceImpl<DsViewMdsNewMapper, DsViewMdsNew> implements DsViewMdsNewService {
}
