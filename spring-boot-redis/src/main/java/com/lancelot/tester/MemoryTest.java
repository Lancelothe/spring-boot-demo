package com.lancelot.tester;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @author lancelot
 **/
public class MemoryTest {
    public static void main(String[] args) {
        MemoryMXBean mxBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = mxBean.getHeapMemoryUsage();
        System.out.printf("memoryUsage init : %d\n", memoryUsage.getInit());
        System.out.printf("memoryUsage used : %d\n", memoryUsage.getUsed());
        System.out.printf("memoryUsage committed : %d\n", memoryUsage.getCommitted());
        System.out.printf("memoryUsage max : %d\n", memoryUsage.getMax());
        System.out.printf("memoryUsage : %s\n", memoryUsage.toString());
    }
}
