package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_3_concurrent_modification_exception_problem;

import java.util.Vector;

/**
 *
 *
 *
 */
public class SolvingConcurrentModificationExceptionProblemDemo {
    private Vector<String> vector = new Vector<>();

    {
        init();
    }

    private void init() {
        for (int i = 0; i < 100; i++) {
            vector.add("a" + i);
        }
    }

    public void demo() {
        runIterating();

        runModifying();

    }

    /**
     * 迭代vector
     */
    private void runIterating() {
        Runnable iterateRunnable = () -> {
            synchronized (vector) {
                for (String item : vector) {
                    System.out.println("item = " + item);
                }
            }//lkm: vector很大时，性能损耗明显，需要权衡
        };
        for (int i = 0; i < 10; i++) {
            new Thread(iterateRunnable).start();
        }
    }

    /**
     * 修改vector
     */
    private void runModifying() {
        Runnable modifyRunnable = () -> {
            for (int i = 0; i <10; i++) {
                vector.add("b"+i);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(modifyRunnable).start();
        }
    }

    public static void main(String[] args) {
        new SolvingConcurrentModificationExceptionProblemDemo().demo();
    }


}
