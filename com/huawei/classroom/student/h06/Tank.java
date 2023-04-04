package com.huawei.classroom.student.h06;

public abstract class Tank extends GameObject{
    public Tank(int x,int y,int health, int strength) {
        super(x, y);
        this.setHealth(health);
        this.setStrength(strength);
        this.setRange(10);
    }
}
