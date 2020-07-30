package com.jn.springboot_data.druid;


import com.jn.springboot_data.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * 自定义注解
 */

@Target({ElementType.METHOD})//元注解，注解可能出现在Java程序中的语法位置
@Retention(RetentionPolicy.RUNTIME)//明确生命周期长度 SOURCE < CLASS < RUNTIME,指定注释要保留多长时间
@Documented//表明这个注解是由 javadoc记录的，在默认情况下也有类似的记录工具。
public @interface DataSource {

    /**
     * 切换数据源
     */

    public DataSourceType value() default DataSourceType.REMOVE;
}
