package com.practice.multithread._3_designing_safe_class._3_3_add_method;

import java.util.Vector;

/**
 * 组合形式，原来的方法代理（最好实现相同接口）
 *
 * @author Luo Bao Ding
 * @since 2018/8/5
 */
public class MyVectorByComposing<T> /*implements List<T>*/{
    private final Vector<T> vector;

    public MyVectorByComposing() {
        this.vector = new Vector<>();
    }

    public synchronized boolean addIfAbsent(T item) {
        if (!vector.contains(item)) {
            vector.add(item);
            return true;
        }
        return false;
    }

    //    。。。。其他方法代理,最好实现相同接口
    public synchronized void add(T item) {
        vector.add(item);
    }

}
