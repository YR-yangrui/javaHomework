package com.huawei.classroom.student.h06;

public class GameBase extends GameObject {
	public GameBase(int x, int y) {
		super(x, y);
	}

	public static GameBase createGameBase(int x, int y) {
		GameBase gameBase = new GameBase(x, y);
		gameBase.setHealth(500);
		return gameBase;
	}

	public Building building(EnumObjectType type, int x, int y) {
		if (type == EnumObjectType.barrack) {
			Barrack barrack = new Barrack(x, y);
			barrack.setHealth(100);
			return barrack;
		}
		if (type == EnumObjectType.warFactory) {
			WarFactory warFactory = new WarFactory(x, y);
			warFactory.setHealth(100);
			return warFactory;
		}
		return null;

	}
}
