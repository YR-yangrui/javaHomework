package com.huawei.classroom.student.h05;

public abstract class Soldier extends Unit{

    private static int livingSoldierCount= 0;
    private static int deadedSoldierCount = 0;
    public Soldier(int health, int strength) {
        super(health, strength);
        livingSoldierCount ++;
    }

    public static int getLivingSoldierCount() {
        return livingSoldierCount;
    }

    public static int getDeadedSoldierCount() {
        return  deadedSoldierCount;
    }
    public static void addDead() {
        if(livingSoldierCount > 0) {
            deadedSoldierCount++;
            livingSoldierCount--;
        }
    }
}
