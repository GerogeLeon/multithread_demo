package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_1_problem_1;

import java.util.Vector;

/**
 * 复合操作：
 * 出现ArrayIndexOutOfBoundsException
 *
 * @author Luo Bao Ding
 * @since 2018/8/6
 */
public class SolvingVectorCompoundOptProblemDemo {

    public Object getLast(Vector vector) {
        try {
            synchronized (vector) {
                int lastIndex = vector.size() - 1;
                Thread.sleep(10);
                return vector.get(lastIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeLast(Vector vector) {
        try {
            synchronized (vector) {
                int lastIndex = vector.size() - 1;
                Thread.sleep(10);
                vector.remove(lastIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demo() {
        Vector<String> vector = new Vector<>();
        init(vector);

        runGetLast(vector);

        runRemoveLast(vector);

    }

    private void runGetLast(Vector<String> vector) {
        Runnable getLastRunnable = () -> getLast(vector);

        for (int i = 0; i < 10; i++) {
            new Thread(getLastRunnable).start();
        }
    }

    private void runRemoveLast(Vector<String> vector) {
        Runnable removeLastRunnable = () -> removeLast(vector);

        for (int i = 0; i < 10; i++) {
            new Thread(removeLastRunnable).start();
        }
    }


    private void init(Vector<String> vector) {
        for (int i = 0; i < 100; i++) {
            vector.add("a" + i);
        }
    }

    public static void main(String[] args) {
        new SolvingVectorCompoundOptProblemDemo().demo();
    }

}
