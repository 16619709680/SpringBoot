package com.jn.springboot_data;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDataApplicationTests {

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() {

        System.out.println("......"+dataSource.getClass());

        try {

            DruidDataSource druidDataSource = (DruidDataSource) dataSource;

            Connection connection = dataSource.getConnection();

            System.out.println("xxxxxxxx"+connection);

            System.out.println("Max:" + druidDataSource.getMaxActive());

            System.out.println("Init:" + druidDataSource.getInitialSize());

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
