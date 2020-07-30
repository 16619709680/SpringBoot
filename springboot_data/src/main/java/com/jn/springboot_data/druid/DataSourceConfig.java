package com.jn.springboot_data.druid;

import com.jn.springboot_data.enums.DataSourceType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.remote")
    public DataSource remoteDataSource(){

        return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary//Primary可以理解为默认优先选择,不可以同时设置多个,
    public DynamicDataSource dataSource(DataSource remoteDataSource, DataSource localDataSource){

        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put(DataSourceType.REMOVE.name(),remoteDataSource);
        hashMap.put(DataSourceType.LOCAL.name(),localDataSource);

        return new DynamicDataSource(remoteDataSource,hashMap);
    }


}
