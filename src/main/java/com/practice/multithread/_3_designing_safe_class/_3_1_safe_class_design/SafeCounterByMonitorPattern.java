package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

/**
 * 监视器模式
 *
 * @author Luo Bao Ding
 *
 */
public class SafeCounterByMonitorPattern {
    private Integer count = 0;

    private final Object lock = new Object();

    public void increase() {
        synchronized (lock) {
            count++;
        }
    }

    public void decrease() {
        synchronized (lock) {
            count--;
        }
    }

}
