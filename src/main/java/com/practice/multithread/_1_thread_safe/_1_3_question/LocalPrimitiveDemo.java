package com.practice.multithread._1_thread_safe._1_3_question;

/**
 * @author Luo Bao Ding
 *
 */
public class LocalPrimitiveDemo {

    public int work() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum++;
        }
        return sum;
    }

    public void demo() {
        Runnable runnable = () -> {
            int result = work();
            System.out.println("result = " + result);
        };
        for (int i = 0; i < 20; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        new LocalPrimitiveDemo().demo();
    }

}
