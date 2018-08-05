package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

import java.util.HashSet;

/**
 * 代理模式：以synchronized代理原来的方法
 *
 * <p>
 *     jdk中有大量应用： <br/>
 *     {@link java.util.Collections.SynchronizedCollection#add(java.lang.Object)}
 * </p>
 *
 * @author Luo Bao Ding
 * @since 2018/8/4
 */
public class SafeHashSetBySync {

    private HashSet<Object> mySet = new HashSet<>();

    public synchronized boolean add(Object item) {
        return mySet.add(item);
    }

    public synchronized boolean remove(Object item) {
        return mySet.remove(item);
    }

    public synchronized boolean contains(Object item) {
        return mySet.contains(item);
    }
}
