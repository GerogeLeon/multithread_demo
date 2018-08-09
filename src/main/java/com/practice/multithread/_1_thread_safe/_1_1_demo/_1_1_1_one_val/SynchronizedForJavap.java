package com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val;

/**
 * 查看synchronized的字节码指令
 *
 * <pre>{@code
 *  javac SynchronizedForJavap.java
 *  javap -verbose  SynchronizedForJavap.class
 * }
 * </pre>
 *
 *
 */
public class SynchronizedForJavap {
    public synchronized void hello() {
        int a = 0;
        a++;
    }

    public void world() {
        synchronized (this) {
            int b = 0;
            b++;
        }
    }
}
