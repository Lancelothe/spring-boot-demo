package com.lancelot.mq;

import org.junit.Test;
import org.springframework.Worker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lancelot
 * @date 2020/3/20
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("numbers: " + applicationContext.getBeanDefinitionCount());
        ((Worker)applicationContext.getBean("worker")).work();
    }
}
