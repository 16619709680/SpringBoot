package com.jn.springboot_data.druid;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

/**
 * 动态切换数据源主要依靠AbstractRoutingDataSource。
 * 创建一个AbstractRoutingDataSource的子类，重写determineCurrentLookupKey方法，用于决定使用哪一个数据源。
 * 这里主要用到AbstractRoutingDataSource的两个属性defaultTargetDataSource和targetDataSources。
 * defaultTargetDataSource默认目标数据源，
 * targetDataSources（map类型）存放用来切换的数据源。
 */


public class DynamicDataSource extends AbstractRoutingDataSource {


    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource) {

        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        // afterPropertiesSet()方法调用时用来将targetDataSources的属性写入resolvedDataSources中的
        super.afterPropertiesSet();
    }

    /**
     * 根据Key获取数据源的信息
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
