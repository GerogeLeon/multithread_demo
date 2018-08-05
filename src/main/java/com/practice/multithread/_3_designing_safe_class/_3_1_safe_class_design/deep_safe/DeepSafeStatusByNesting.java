package com.practice.multithread._3_designing_safe_class._3_1_safe_class_design.deep_safe;

import com.practice.multithread._3_designing_safe_class._3_1_safe_class_design.SafeOneStatusByFinal;

/**
 * 通过递归嵌套安全类达到深安全
 *
 */
public class DeepSafeStatusByNesting {
    private final SafeOneStatusByFinal status;

    public DeepSafeStatusByNesting(SafeOneStatusByFinal status) {
        this.status = status;
    }

    public SafeOneStatusByFinal getStatus() {
        return status;
    }
}
