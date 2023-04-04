package com.huawei.classroom.student.h05;

public class Unit{
    private int health;
    private int strength;

    public Unit(int health, int strength) {
        this.health = health;
        this.strength= strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Unit unit) {
        unit.health -= this.strength;
        if(unit.isDestroyed() && unit instanceof Soldier) {
            Soldier.addDead();
        }
    }

    public boolean isDestroyed() {
        return this.health <= 0;
    }
}
