package com.practice.multithread._4_infrastructure._4_5_memoizer_design;

import java.math.BigInteger;

/**
 * @author Luo Bao Ding
 * @since 2018/8/8
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }

}
