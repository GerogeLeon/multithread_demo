package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

/**
 * @author Luo Bao Ding
 *
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
