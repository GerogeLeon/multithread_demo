package com.practice.multithread._1_thread_safe._1_5_question.domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
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
