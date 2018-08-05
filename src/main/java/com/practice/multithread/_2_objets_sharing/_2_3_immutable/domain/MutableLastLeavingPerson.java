package com.practice.multithread._2_objets_sharing._2_3_immutable.domain;

/**
 * 可变容器
 *
 * @author Luo Bao Ding
 * @since 2018/8/3
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
