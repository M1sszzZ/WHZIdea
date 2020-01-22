package com.youcash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Package: com.youcash
 * @FileName: RedisTest2
 * @Desc:
 * @Author: Wanghezi
 * @CreateTime: 2019-12-06 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest2 {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Test
    public void test(){
        //redisTemplate.opsForValue().set("name","ZhangBo");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
