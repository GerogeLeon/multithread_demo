package com.practice.multithread._1_thread_safe._1_2_atomic;

/**
 * @author Luo Bao Ding
 *
 */
public class UnsafeCounterDemo {

    private int count = 0;

    public void demo() {
        Runnable runnable = () -> {
            count++;
            System.out.println("count = " + count);
/* 打印的结果中可能没有1000 （借助ctrl+F查看控制台）
* */
        };
        for (int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }

    }


    public static void main(String[] args) {
        new UnsafeCounterDemo().demo();

    }

}
