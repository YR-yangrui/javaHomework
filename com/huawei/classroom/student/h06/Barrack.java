package com.huawei.classroom.student.h06;

public class Barrack extends Building {

	public Barrack(int x, int y) {

		super(x, y);
		// super( Param.BARRACK_HEALTH,Param.BARRACK_STRENGTH);
		// TODO Auto-generated constructor stub
	}

	public GameObject traing(EnumObjectType type) {
		GameObject gameObject;

		if (type == EnumObjectType.rifleSoldier) {
			gameObject = new RifleSoldier(this.getX(), this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(5);
			gameObject.setRange(5);
		} else if (type == EnumObjectType.RPGSoldier) {
			gameObject = new RPGSoldier(this.getX(),this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(10);
			gameObject.setRange(10);
		} else if (type == EnumObjectType.dog) {
			gameObject = new Dog(this.getX(),this.getY());
			gameObject.setHealth(50);
			gameObject.setStrength(5);
			gameObject.setRange(5);
		} else {
			gameObject = null;
		}
		return gameObject;
	}

}
