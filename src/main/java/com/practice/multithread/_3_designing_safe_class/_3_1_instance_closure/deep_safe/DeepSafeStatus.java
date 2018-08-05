package com.practice.multithread._3_designing_safe_class._3_1_instance_closure.deep_safe;

import com.practice.multithread._3_designing_safe_class._3_1_instance_closure.SafeOneStatusByFinal;

/**
 * @author Luo Bao Ding
 * @since 2018/8/5
 */
public class DeepSafeStatus {
    private final SafeOneStatusByFinal status;


    public DeepSafeStatus(SafeOneStatusByFinal status) {
        this.status = status;
    }

    public SafeOneStatusByFinal getStatus() {
        return status;
    }
}
