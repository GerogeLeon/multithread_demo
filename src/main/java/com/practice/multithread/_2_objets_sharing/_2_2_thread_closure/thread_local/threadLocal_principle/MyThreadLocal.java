package com.practice.multithread._2_objets_sharing._2_2_thread_closure.thread_local.threadLocal_principle;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟一个ThreadLocal
 *
 * @author Luo Bao Ding
 */
public class MyThreadLocal<T> {

    private Map<Thread, T> map = new HashMap<>();

    public void set(T val) {
        map.put(Thread.currentThread(), val);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }
}
