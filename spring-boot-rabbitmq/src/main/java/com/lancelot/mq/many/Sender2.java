package com.lancelot.mq.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@Component
public class Sender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int index) {
        String context = "spring boot many queue" + " ****** " + index;
        System.out.println("Sender 2: " + context);
        this.rabbitTemplate.convertAndSend("many", context);
    }

}
