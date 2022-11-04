package com.itheima.reggie.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColorDruid {
    private Integer fid;
    private LocalDateTime ftmstamp;
    private String foperator;
    private String fshift;
    private String foperation;
    private String foperationcn  ;
    private String color ;
    private String code;
}
