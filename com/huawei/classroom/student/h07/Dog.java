package com.huawei.classroom.student.h07;

public class Dog extends GameObject {

	public Dog(int x,int y) {
		super(x, y);
	}

	@Override
	public void attack(GameObject soldier) {
		if(this.isDestroyed() || soldier.isDestroyed()) {
			return;
		}
		int dx = this.getX() - soldier.getX();
		int dy = this.getY() - soldier.getY();
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		if (this.getRange() < dis) {
			return;
		}
		if (soldier instanceof Soldier) {
			soldier.setHealth(0);
			Soldier.livingSoldierCount --;
			Soldier.deadedSoldierCount ++;

		} else {
			soldier.setHealth(soldier.getHealth() - this.getStrength());
		}
	}

}
