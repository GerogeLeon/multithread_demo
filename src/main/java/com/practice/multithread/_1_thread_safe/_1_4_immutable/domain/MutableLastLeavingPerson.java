package com.practice.multithread._1_thread_safe._1_4_immutable.domain;

/**
 * 可变容器
 *
 * @author Luo Bao Ding
 *
 */
public class MutableLastLeavingPerson {
    private String name;

    private Integer leavingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(Integer leavingTime) {
        this.leavingTime = leavingTime;
    }

    @Override
    public String toString() {
        return "(" + name + "," + leavingTime + ")";
    }
}
