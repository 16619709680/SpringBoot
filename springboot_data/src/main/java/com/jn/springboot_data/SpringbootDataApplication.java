package com.jn.springboot_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//Spring Boot将不会会自动创建默认的内存数据库的数据源DataSource，使用用户定义数据源
public class SpringbootDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataApplication.class, args);
    }

}
