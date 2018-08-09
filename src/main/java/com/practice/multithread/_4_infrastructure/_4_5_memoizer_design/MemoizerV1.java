package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.HashMap;
import java.util.Map;

/**
 * 同步整个方法；局限：吞吐量低，不适使高并发
 *
 * @author Luo Bao Ding
 */
public class MemoizerV1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> computable;

    public MemoizerV1(Computable<A, V> computable) {
        this.computable = computable;
    }


    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = computable.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
/**
 * 吞吐量很低
 */
