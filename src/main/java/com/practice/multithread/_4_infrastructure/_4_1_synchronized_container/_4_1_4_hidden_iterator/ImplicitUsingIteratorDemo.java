package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_4_hidden_iterator;

import java.util.Vector;

/**
 * @author Luo Bao Ding
 * @since 2018/8/6
 */
public class ImplicitUsingIteratorDemo {

    public void unsafe(Vector vector) {
        System.out.println("vector = [" + vector + "]");//隐含使用了迭代器,潜在ConcurrentModificationException
    }
}
