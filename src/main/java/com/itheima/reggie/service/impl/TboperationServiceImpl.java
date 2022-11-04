package com.itheima.reggie.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.Tboperation;
import com.itheima.reggie.mapper.TboperationMapper;
import com.itheima.reggie.service.TboperationService;
import org.springframework.stereotype.Service;
@DS("sqlserver")
@Service
public class TboperationServiceImpl extends ServiceImpl<TboperationMapper, Tboperation> implements TboperationService {
}
