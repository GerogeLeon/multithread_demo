package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Luo Bao Ding
 */
public class MemoizerV2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public MemoizerV2(Computable<A, V> computable) {
        this.computable = computable;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = computable.compute(arg);//lkm：重复计算
            cache.put(arg, result);
        }
        return result;
    }
}
/**
 * 重复计算
 */
