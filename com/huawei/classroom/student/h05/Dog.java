package com.huawei.classroom.student.h05;


public class Dog extends Unit{
    public Dog() {
        super(50, 5);
    }
    @Override
    public void attack(Unit unit) {
        unit.setHealth(unit.getHealth() - this.getStrength());
        if( unit instanceof Soldier) {
            unit.setHealth(0);
            Soldier.addDead();
        }
    }
}
