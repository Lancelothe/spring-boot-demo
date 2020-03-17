package com.lancelot.mq.many;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lancelot
 */
@Slf4j
@Component
@RabbitListener(queues = "many")
public class Receiver2 {

    @RabbitHandler
    public void process(String msg) {
        log.info("Receiver  2: " + msg);
    }

}