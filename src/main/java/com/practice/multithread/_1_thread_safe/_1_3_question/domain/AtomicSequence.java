package com.practice.multithread._1_thread_safe._1_3_question.domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Luo Bao Ding
 *
 */
public class AtomicSequence {
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }

    public synchronized int incr() {
        return value.incrementAndGet();
    }

    public synchronized int decr() {
        return value.decrementAndGet();
    }
}
