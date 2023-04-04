package com.huawei.classroom.student.h04;

public class Apple {
    private int size;
    private String color;

    public Apple(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public Apple() {
        this.size = 10;
        this.color = "red";
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
