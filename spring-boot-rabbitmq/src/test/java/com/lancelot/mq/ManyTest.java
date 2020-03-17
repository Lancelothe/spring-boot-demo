package com.lancelot.mq;

import com.lancelot.mq.many.Sender1;
import com.lancelot.mq.many.Sender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lancelot
 * @date 2020/3/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
    @Autowired
    private Sender1 sender1;

    @Autowired
    private Sender2 sender2;

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sender1.send(i);
            sender2.send(i);
        }
    }
}
