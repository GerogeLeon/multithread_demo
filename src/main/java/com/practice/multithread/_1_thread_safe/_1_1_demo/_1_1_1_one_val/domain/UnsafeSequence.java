package com.practice.multithread._1_thread_safe._1_1_demo._1_1_1_one_val.domain;

/**
 *
 *
 */
public class UnsafeSequence {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public int incr() {
       return this.value++;
    }

    public int decr() {
       return this.value--;
    }


}
