package com.practice.multithread._3_designing_safe_class._3_3_add_method;

import java.util.Vector;

/**
 * @author Luo Bao Ding
 */
public class MyVectorByExtend<T> extends Vector<T> {

    public synchronized boolean addIfAbsent(T item) {
        if (!super.contains(item)) {
            super.add(item);
            return true;
        }
        return false;
    }

}
