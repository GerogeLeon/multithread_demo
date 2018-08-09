package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_1_compound_operation;

import java.util.Vector;

/**
 * 多线程获取vector第一个元素和最后元素。<p>
 *
 * 出现ArrayIndexOutOfBoundsException
 *
 * @author Luo Bao Ding
 */
public class VectorCompoundOptProblemDemo {

    private Object getLast(Vector vector) {
        try {
            int lastIndex = vector.size() - 1;
            Thread.sleep(10);
            return vector.get(lastIndex);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void removeLast(Vector vector) {
        try {
            int lastIndex = vector.size() - 1;
            Thread.sleep(10);
            vector.remove(lastIndex);

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

    private void runRemoveLast(Vector<String> vector) {
        Runnable runnable = () -> removeLast(vector);

        for (int i = 0; i <10; i++) {
            new Thread(runnable).start();
        }
    }

    private void runGetLast(Vector<String> vector) {
        Runnable runnable = () -> getLast(vector);

        for (int i = 0; i <10; i++) {
            new Thread(runnable).start();
        }
    }

    private void init(Vector<String> vector) {
        for (int i = 0; i < 100; i++) {
            vector.add("a" + i);
        }
    }

    public static void main(String[] args) {
        new VectorCompoundOptProblemDemo().demo();
    }

}
