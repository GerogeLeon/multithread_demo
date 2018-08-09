package com.practice.multithread._4_infrastructure._4_1_synchronized_container._4_1_4_hidden_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 隐藏使用迭代器：集合的toString, 类似的还有集合的equals, hashcode, containsAll, removeAll等方法
 *
 * @author Luo Bao Ding
 * @since 2018/8/6
 */
public class HiddenIteratorDemo {

    public void unsafe(List list) {
        System.out.println("list = [" + list + "]");//隐含使用了迭代器,潜在ConcurrentModificationException
    }

    public void demo() {
        List<String> list = new ArrayList<>();
        init(list);

        startHiddenItr(list);

        startModify(list);
    }

    private void init(List<String> list) {
        for (int i = 0; i < 50; i++) {
            list.add("a" + i);
        }
    }

    private void startHiddenItr(List<String> list) {
        Runnable hiddenItr = () -> {
            for (int i = 0; i < 10; i++) {
                unsafe(list);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(hiddenItr).start();
        }
    }

    private void startModify(List<String> list) {
        Runnable modify = () -> {
            for (int i = 0; i < 20; i++) {
                list.add("b" + i);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(modify).start();
        }
    }

    public static void main(String[] args) {
        new HiddenIteratorDemo().demo();
    }
}
