package com.huawei.classroom.student.h17;

public class Barrack extends Building{
    private static Dog dog = new Dog();
    private static RifleSoldier rifleSoldier = new RifleSoldier();
    private static RPGSoldier rpgSoldier = new RPGSoldier();
    public Barrack(Player player, int x, int y, GameObject temp) {
        super(player, x, y, temp);
    }

    public Barrack() {
        super();
    }

    public static Dog getDog() {
        return dog;
    }

    public static RifleSoldier getRifleSoldier() {
        return rifleSoldier;
    }

    public static RPGSoldier getRpgSoldier() {
        return rpgSoldier;
    }

    public GameObject traing(EnumObjectType type) {
        if(type == EnumObjectType.dog) {
            return new Dog(this.getPlayer(), this.getX(), this.getY(), dog);
        }
        if(type == EnumObjectType.RPGSoldier) {
            return new RPGSoldier(this.getPlayer(), this.getX(), this.getY(), rpgSoldier);
        }
        if(type == EnumObjectType.rifleSoldier) {
            return new RifleSoldier(this.getPlayer(), this.getX(), this.getY(), rifleSoldier);
        }
        return null;
    }
}
