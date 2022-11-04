package com.itheima.reggie.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;


public class DateUtilsByUser {
    public  static  String getbeforDays(int days){
        Calendar calendar =Calendar.getInstance();
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime =sdf.format(calendar.getTime());
        return  startTime;
    }
}
