package com.lancelot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lancelot
 * @date 2020/4/26
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    /**
     * 限流唯一标示
     */
    String key() default "";

    /**
     * 限流时间，单位：秒
     */
    int time();

    /**
     * 限流次数
     */
    int count();
}
