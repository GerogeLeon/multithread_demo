package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_2_race_condition;

import java.util.Vector;

/**
 * @author Luo Bao Ding
 *
 */
public class ProblemInForLoopDemo {

    private static final int SIZE = 50;

    private void unsafeLoop(Vector vector) {
        try {
            for (int i = vector.size() - 1; i >= 0 && vector.size() > 0; i--) {//竞态条件
                Thread.sleep(4);
                Object item = vector.get(i);
                System.out.println(Thread.currentThread().getName() + ": item = " + item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void demo() {
        Vector<String> vector = new Vector<>();
        init(vector);

        Runnable loop = () -> {
            unsafeLoop(vector);
        };

        for (int i = 0; i < 5; i++) {
            new Thread(loop).start();
        }

        Runnable remove = () -> {
            remove(vector);
        };

        for (int i = 0; i < 5; i++) {
            new Thread(remove).start();
        }

    }

    private void init(Vector<String> vector) {
        for (int i = 0; i < SIZE; i++) {
            vector.add("a" + i);
        }
    }

    private void remove(Vector<String> vector) {
        try {
            for (int i = 0; i < vector.size(); i++) {
                vector.remove(i);
                Thread.sleep(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProblemInForLoopDemo().demo();
    }

}
