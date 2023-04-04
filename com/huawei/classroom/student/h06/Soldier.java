package com.huawei.classroom.student.h06;

public abstract class Soldier extends GameObject {

	public static int livingSoldierCount = 0;
	public static int deadedSoldierCount = 0;

	public Soldier(int x,int y) {
		super(x, y);
		livingSoldierCount++;
		// TODO Auto-generated constructor stub
	}

	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}

	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	
}
