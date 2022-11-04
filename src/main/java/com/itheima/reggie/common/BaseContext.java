package com.itheima.reggie.common;

/**
 * 基于ThreadLocal工具类存放Employee.id
 * threadlocal中针对线程有一个存储空间
 */
public class BaseContext {
    public static ThreadLocal<Long> threadLocal =new ThreadLocal<>();
    public static void  SetCurrentId(Long id){
        threadLocal.set( id);
    }
    public static Long  GetCurrentId(){
       return threadLocal.get();
    }
}
