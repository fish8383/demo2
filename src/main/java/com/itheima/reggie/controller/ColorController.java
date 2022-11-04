package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.DateUtilsByUser;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.ColorDruid;
import com.itheima.reggie.entity.Colorlist;
import com.itheima.reggie.entity.Tboperation;
import com.itheima.reggie.service.ColorDruidService;
import com.itheima.reggie.service.ColorlistService;
import com.itheima.reggie.service.TboperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RestController
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorlistService colorlistService;
    @GetMapping("/list")
    public R<List<Colorlist>> List(){

        List<Colorlist> list = colorlistService.listDrainDate();
        log.info("tboperationList={}",list);
        return R.success(list);
    }
}
