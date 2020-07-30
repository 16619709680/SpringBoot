package com.jn.springboot_redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * 自定义序列化器
 */
@Configuration
public class MyTemplate {

    @Bean
    public StringRedisTemplate changeTemplate(RedisConnectionFactory fc) {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(fc);

        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return stringRedisTemplate;
    }


}
