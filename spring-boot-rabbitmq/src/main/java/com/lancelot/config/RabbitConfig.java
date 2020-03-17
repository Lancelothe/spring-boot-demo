package com.lancelot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue manyQueue() {
        return new Queue("many");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }
}