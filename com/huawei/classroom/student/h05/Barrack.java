package com.huawei.classroom.student.h05;

public class Barrack extends Unit{

    public Barrack() {
        super(100, 0);
    }
    public Unit traing(EnumObjectType type) {
        if( type == EnumObjectType.rifleSoldier) {
            return new RifleSoldier();
        }
        if( type == EnumObjectType.RPGSoldier) {
            return new RPGSoldier();
        }
        if( type == EnumObjectType.dog) {
            return new Dog();
        }

        return null;

    }
}
