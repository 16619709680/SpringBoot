package com.jn.springboot_data.druid;

/**
 * 数据源切换处理类，有对数据源变量的获取、设置和清空的方法 ，其中Threadlocal 用于保存某个线程的共享变量
 *
 * */
public class DynamicDataSourceContextHolder {

    /**
     * 使用Threadlocal维护变量，Threadlocal为每一个使用使用该变量的线程提供了变量副本
     * 每个线程都可以独立的改变自己的副本，而且不会影响其他线程的变量副本
     * */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();


    /**设置数据源变量*/

    public static  void setDataSourceType(String dataSourceType){

        System.out.println(".......切换到{%s}数据源........."+dataSourceType);

        CONTEXT_HOLDER.set(dataSourceType);
    }


    /**获取数据源变量*/
    public static  String getDataSourceType(){

        return  CONTEXT_HOLDER.get();
    }


    /**清空数据源变量*/
    public static  void clearDataSourceType(){

          CONTEXT_HOLDER.remove();
    }

}
