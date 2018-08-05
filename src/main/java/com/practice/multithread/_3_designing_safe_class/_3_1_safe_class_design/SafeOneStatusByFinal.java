package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design;

/**
 * @author Luo Bao Ding
 * @since 2018/8/4
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
