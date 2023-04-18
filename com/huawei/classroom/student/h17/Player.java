package com.huawei.classroom.student.h17;

public class Player {

    static int num = 0;
    String name;
    int id;

    public Player(String name) {
        this.name = name;
        this.id = ++num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
