package com.lancelot.mq.dead;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author lancelot
 * @date 2020/3/15
 * [RabbitMQ 延迟任务（限时订单） 原理 以及代码 实战 \- 残剑今生 \- 博客园](https://www.cnblogs.com/DBGzxx/p/10090840.html)
 */
public class DelayProducer {

    public static Logger logger = LoggerFactory.getLogger(DelayProducer.class);

    // 交换机
    public static final String exchangeName = "delay_Task";
    // 声明路由键
    public static final String routekey = "delay_order";

    public static void pend(List<String> orderNos) throws IOException, TimeoutException {
        // 通过单例得到工厂
        ConnectionFactory connectionFactory = RQconnFactory.getrQconnFactory();
        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        // 声明一个交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);

        // 消息绑定
        for (String orderNo : orderNos) {
            channel.basicPublish(exchangeName, routekey, null, orderNo.getBytes());
            logger.info("发送订单 : " + orderNo);
        }
        // 关闭频道和连接
        channel.close();
        connection.close();
    }

    public static void main(String[] args) {
        List orders = new ArrayList();
        orders.add("order 0001");
        orders.add("order 0002");
        orders.add("order 0003");
        try {
            pend(orders);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
