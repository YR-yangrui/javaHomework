package com.huawei.classroom.student.h05;

public class WarFactory extends Unit{
    public WarFactory() {
        super(100, 0);
    }
    public Tank building(EnumObjectType type) {
        if( type == EnumObjectType.heavyTank) {
            return new HeavyTank();
        }
        if( type == EnumObjectType.mediumTank) {
            return new MediumTank();
        }
        return null;
    }
}
