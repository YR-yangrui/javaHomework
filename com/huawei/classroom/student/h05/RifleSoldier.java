package com.huawei.classroom.student.h05;

public class RifleSoldier extends Soldier{

    public RifleSoldier() {
        super(50, 5);
    }
    @Override
    public void attack(Unit unit) {
        if ( unit instanceof Dog) {
            unit.setHealth(0);
            return;
        }
        unit.setHealth(unit.getHealth() - this.getStrength());
    }
}
