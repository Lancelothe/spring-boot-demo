package com.lancelot.controller;

import com.lancelot.annotation.RateLimit;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lancelot
 * @date 2020/4/26
 */
@RestController
public class LimiterController {

    @Resource
    private RedisTemplate redisTemplate;

    // 10 秒中，可以访问10次
    @RateLimit(key = "test", time = 10, count = 10)
    @GetMapping("/get_limit")
    public String luaLimiter() {
        RedisAtomicInteger entityIdCounter = new RedisAtomicInteger("entity:id:counter", redisTemplate.getConnectionFactory());

        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");

        return date + " 累计访问次数：" + entityIdCounter.getAndIncrement();
    }
}
