package com.practice.multithread._3_designing_safe_class._3_1_instance_closure;

/**
 * 监视器模式
 *
 * @author Luo Bao Ding
 * @since 2018/8/4
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
