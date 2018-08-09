package com.practice.multithread._1_thread_safe._1_4_immutable.domain;

/**
 * 不变容器，竞争变量放容器中
 *
 *
 *
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
