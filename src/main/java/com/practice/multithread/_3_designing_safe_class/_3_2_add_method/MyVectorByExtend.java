package com.practice.multithread._3_designing_safe_class._3_2_add_method;

import java.util.Vector;

/**
 *
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
