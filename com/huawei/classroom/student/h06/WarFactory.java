package com.huawei.classroom.student.h06;

public class WarFactory extends Building{
    public WarFactory(int x, int y) {
        super(x, y);
    }

    public Tank building(EnumObjectType type) {
        if(type == EnumObjectType.heavyTank) {
            return new HeavyTank(this.getX(), this.getY());
        }
        if(type == EnumObjectType.mediumTank) {
            return new MediumTank(this.getX(), this.getY());
        }
        return null;
    }

}
