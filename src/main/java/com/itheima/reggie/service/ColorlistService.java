package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.entity.Colorlist;
import com.itheima.reggie.entity.Plcbodydata;

import java.util.List;

public interface ColorlistService extends IService<Colorlist> {
    public  void  SaveOrUpdateColorList(List<Plcbodydata> list);
    void  UpdateNeedDrain();

    void   UpdateNoNeedDrain();

    void   UpdateDrainDone();


    void  UpdateNeedDrainWhenProduction(List<Plcbodydata> plcbodydataList);

    List<Colorlist> listDrainDate();


}
