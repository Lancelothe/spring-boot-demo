package com.lancelot.mq.dead;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author lancelot
 * @date 2020/3/15
 */
public class RQconnFactory {
    private volatile static ConnectionFactory rQconnFactory;

    private RQconnFactory(){

    }

    public static ConnectionFactory getrQconnFactory() {
        if (rQconnFactory == null) {
            synchronized (RQconnFactory.class){
                if (rQconnFactory  == null ){
                    rQconnFactory = new ConnectionFactory();
                    rQconnFactory.setHost("192.168.199.191");
                    return rQconnFactory;
                }
            }
        }
        return rQconnFactory;
    }
}
