package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_2_race_condition;

import java.util.Vector;

/**
 * @author Luo Bao Ding
 * @since 2018/8/6
 */
public class SolvingProblemInForLoop {

    public void safe(Vector vector) {
        synchronized (vector) {
            for (int i = 0; i < vector.size(); i++) {
                Object item = vector.get(i);
                //...
            }
        }
    }

    /**
     * lkm:  question: 这两者有何区别： for (Object item : vector) 与 for (int i = 0; i < vector.size(); i++)
     * =》见 4_1_3
     */
    public void contrast(Vector vector) {
        for (Object item : vector) {
            //...
        }
    }



}
