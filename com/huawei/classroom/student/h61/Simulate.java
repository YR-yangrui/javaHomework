package com.huawei.classroom.student.h61;

import java.util.Random;

public class Simulate {

    private Random random = new Random(System.currentTimeMillis());
    boolean check(double d) {
        int r = (int)(d * 100);
        return random.nextInt() % 100 <= r;
    }
    public SimResult sim(Param param, int days) {
        return null;
    }
}
