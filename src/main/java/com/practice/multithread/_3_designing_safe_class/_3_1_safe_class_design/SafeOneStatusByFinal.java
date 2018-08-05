package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

/**
 * 由于不可变，那么外部要设置新的状态则需要new一个新的对象
 *
 */
public class SafeOneStatusByFinal {

    private final int status;

    public SafeOneStatusByFinal(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
