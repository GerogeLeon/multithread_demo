package com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val;

/**
 * synchronized对应的是获取锁的指令，没有去获取锁就不存在被阻塞。
 *
 * @author Luo Bao Ding
 *
 */
public class SynchronizedUsageDemo {
    final Object lock1 = new Object();
    final byte[] lock2 = new byte[0];

    synchronized void syncMehtod() {
    }

    /**
     * 同一线程可重入
     */
    synchronized void syncMehtod2() {
        syncMehtod();
    }



    void syncBlock() {
        synchronized (this) {

        }

        synchronized (lock1) {

        }

        synchronized (lock2) {

        }
        /*可重入*/
        synchronized (lock2) {
            syncMehtod();
        }


    }

//==============  static ========

    synchronized static void synchStatickMethod() {

    }

    void syncStaticBlock(){
        synchronized (SynchronizedUsageDemo.class) {

        }
    }
/*
深入：  synchronized的本质
--》synchronized底层对应的是一条获取锁的指令，没有去获取锁就不存在使不到而被阻塞。

* */

}
