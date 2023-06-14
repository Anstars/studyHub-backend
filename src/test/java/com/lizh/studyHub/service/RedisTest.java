package com.lizh.studyHub.service;

import com.lizh.studyHub.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * This class is for xxxx.
 *
 * @author Mr.Li
 * @version 2023-06-12 下午 03:49
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("lizhString","dog");
        valueOperations.set("lizhInt",1);
        valueOperations.set("lizhDouble",2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("lizh");
        valueOperations.set("lizhUser",user);
        //查
        Object lizh = valueOperations.get("lizhStirng");
        Assertions.assertTrue("dog".equals((String) lizh));
        lizh = valueOperations.get("lizhInt");
        Assertions.assertTrue(1 == (Integer) lizh);
        lizh = valueOperations.get("lizhDouble");
        Assertions.assertTrue(2.0 == (Double) lizh);
        System.out.println(valueOperations.get("lizhUser"));
//        valueOperations.set("lizhString","dog");
//        redisTemplate.delete("lizhString");

    }
}
