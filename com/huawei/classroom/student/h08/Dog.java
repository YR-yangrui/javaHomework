package com.huawei.classroom.student.h08;

public class Dog {
    private int feedCount;
    Dog() {
        feedCount = 0;
    }
    public void feed() {
        if(feedCount >= 3) {
            throw new RuntimeException("I can not eat more!");
        }
        feedCount ++;
    }
}
