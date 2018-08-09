package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Luo Bao Ding
 */
public class MemoizerV3_2<A, V> implements Computable<A, V> {
    private final Map<A, FutureTask<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public MemoizerV3_2(Computable<A, V> computable) {
        this.computable = computable;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            FutureTask<V> future0 = cache.get(arg);
            V result = null;
            if (future0 == null) {
                future0 = new FutureTask<>(() -> computable.compute(arg));
                FutureTask<V> previous = cache.putIfAbsent(arg, future0);//lkm: 设计缺陷，应该要赋给futureResult
                if (previous == null) {
                    future0.run();
                }
            }
            try {
                result = future0.get();
                /**
                 * 注：有设计缺陷。
                 * 仍然会相同arg重复算
                 */
            } catch (ExecutionException e) {
                cache.remove(arg, future0);
                throw new RuntimeException(e);
            }
            return result;
        }
    }
}
/**
 * 重复计算
 */
