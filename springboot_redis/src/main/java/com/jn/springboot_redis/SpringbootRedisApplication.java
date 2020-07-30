package com.jn.springboot_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootRedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootRedisApplication.class, args);

        RedisTest bean = context.getBean(RedisTest.class);

        bean.testRedis();


    }

}
