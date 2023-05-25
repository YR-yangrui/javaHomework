package com.huawei.classroom.student.h55;

public class Tuple implements Comparable<Tuple>{
    private String key;
    private Integer value;

    @Override
    public String toString() {
        return key + ":" + value;
    }

    public Tuple(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Tuple o) {
        return o.value - value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
