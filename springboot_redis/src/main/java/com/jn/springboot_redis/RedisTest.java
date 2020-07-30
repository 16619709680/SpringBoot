package com.jn.springboot_redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("changeTemplate")
    StringRedisTemplate stringRedisTemplate2;//自定义


    @Autowired
    ObjectMapper objectMapper;

    public void testRedis() {

        //高级API
        redisTemplate.opsForValue().set("hello", "china");
        stringRedisTemplate.opsForValue().set("hello,A", "china");

        /****************************************************************/

        //低级API
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.set("hello".getBytes(), "chinese".getBytes());

        /****************************************************************/

        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put("person", "name", "zhangsan");
        stringObjectObjectHashOperations.put("person", "age", "18");


        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);

        //序列化器
        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        Jackson2HashMapper jackson2HashMapper = new Jackson2HashMapper(objectMapper, false);
        redisTemplate.opsForHash().putAll("person", jackson2HashMapper.toHash(person));

        Map person1 = redisTemplate.opsForHash().entries("person");
        Person person2 = objectMapper.convertValue(person1, Person.class);
        System.out.println(person2);


        /****************************************************************/

        //发布
        stringRedisTemplate.convertAndSend("OOXX", "hello");

        //订阅
        RedisConnection connection1 = stringRedisTemplate.getConnectionFactory().getConnection();
        connection1.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                byte[] body = message.getBody();

                System.out.println(new String(body));

            }
        }, "OOXX".getBytes());

        
        while (true) {
            stringRedisTemplate.convertAndSend("OOXX", "hello");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
