package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

/**
 * @author Luo Bao Ding
 * @since 2018/8/8
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
