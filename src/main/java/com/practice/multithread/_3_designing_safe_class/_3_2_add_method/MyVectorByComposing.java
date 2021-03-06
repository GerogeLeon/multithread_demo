package com.practice.multithread._3_designing_safe_class._3_2_add_method;

import java.util.Vector;

/**
 * 组合形式，原来的方法代理（最好实现相同接口）
 *
 *
 *
 */
public class MyVectorByComposing<T> /*implements List<T>*/ {
    private final Vector<T> vector;

    public MyVectorByComposing() {
        this.vector = new Vector<>();
    }

    public boolean addIfAbsent(T item) {
        synchronized (vector) {
            if (!vector.contains(item)) {
                vector.add(item);
                return true;
            }
            return false;
        }
    }

    //    。。。。其他方法委托给vector,最好实现相同接口，以免遗漏
    public void add(T item) {
        vector.add(item);
    }

}
