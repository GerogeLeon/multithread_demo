package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_2_race_condition;

import java.util.Vector;

/**
 * @author Luo Bao Ding
 * @since 2018/8/6
 */
public class ProblemInForLoop {

    public void unsafe(Vector vector) {
        for (int i = 0; i < vector.size(); i++) {//竞态条件
            Object item = vector.get(i);
            //...
        }

    }

}
