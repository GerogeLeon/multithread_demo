package com.practice.multithread._2_objets_sharing._2_3_immutable.domain;

/**
 * 不变容器，竞争变量放容器中
 *
 * @author Luo Bao Ding
 * @since 2018/8/3
 */
public class ImmutableLastLeavingPerson {
    private final String name;

    private final Integer leavingTime;

    public ImmutableLastLeavingPerson(String name, Integer leavingTime) {
        this.name = name;
        this.leavingTime = leavingTime;
    }

    public String getName() {
        return name;
    }

    public Integer getLeavingTime() {
        return leavingTime;
    }

    @Override
    public String toString() {
        return "(" + name + "," + leavingTime + ")";
    }
}
