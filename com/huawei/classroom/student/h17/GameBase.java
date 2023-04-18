package com.huawei.classroom.student.h17;

public class GameBase extends Building{

    private static WarFactory warFactory = new WarFactory();
    private static Barrack barrack = new Barrack();

    public GameBase(Player player, int x, int y, GameObject temp) {
        super(player, x, y, temp);
    }

    public GameBase() {
        super();
    }

    public static WarFactory getWarFactory() {
        return warFactory;
    }

    public static Barrack getBarrack() {
        return barrack;
    }

    public GameObject building(EnumObjectType type, int x, int y) {
        if(type == EnumObjectType.barrack) {
            return new Barrack(this.getPlayer(), x, y, barrack);
        }
        if(type == EnumObjectType.warFactory) {
            return new WarFactory(this.getPlayer(), x, y, warFactory);
        }
        return null;
    }

}
