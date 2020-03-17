package com.lancelot.mq.object;

import com.lancelot.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送的对象必须实现 Serializable序列化对象接口才能被传输
     * @param user
     */
    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }
}
