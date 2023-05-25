package com.huawei.classroom.student.h19.q03;

public class ArrayUtil {
    public int getMin(int[] ints) {
        int mn = ints[0];
        for (int anInt : ints) {
            if(anInt < mn) mn = anInt;
        }
        return mn;
    }
}
