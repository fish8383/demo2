package com.itheima.reggie.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Tboperation {
            private Integer fid;
            private LocalDateTime ftmstamp;
            private String foperator;
            private String fshift;
            private String foperation;
            private String foperationcn  ;
//            private   String color;
}