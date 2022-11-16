package com.itheima.reggie.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.DsViewMdsNew;
import org.apache.ibatis.annotations.Mapper;
@DS("durrDxqSqlserver")
@Mapper
public interface DsViewMdsNewMapper extends BaseMapper<DsViewMdsNew> {
}
