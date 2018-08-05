package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

import sun.misc.Unsafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/***
 * AQS {@link AbstractQueuedSynchronizer} <br>
 *   本质：通过队列来调度各线程，并利用CAS保证原子操作, {@link ReentrantLock#lock()}
 *
 */
public class SafeMultiDimStatusByAQS {

    private volatile int x;
    private volatile int y;

    private ReentrantLock lock = new ReentrantLock();


    public SafeMultiDimStatusByAQS(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] get() {
        return new int[]{x, y};
    }

    public void set(int x, int y) {
        try {
            lock.lock();
            this.x = x;
            this.y = y;
        } finally {
            lock.unlock();
        }
    }

}
