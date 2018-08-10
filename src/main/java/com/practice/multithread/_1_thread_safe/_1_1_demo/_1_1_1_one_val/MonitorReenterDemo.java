package com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val;

/**
 *
 *内置锁可重入。
 *<p>
 *  synchronized对应的是获取锁的指令，没有去获取锁就不存在被阻塞。
 *
 */
public class MonitorReenterDemo {
    int count = 0;

    public synchronized void reenter() {
        count++;
        if (count < 10) {
            reenter();
        } else {
            print();
        }
    }

    public synchronized void print() {
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        new MonitorReenterDemo().reenter();
    }
}
