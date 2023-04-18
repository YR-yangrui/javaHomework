package com.huawei.classroom.student.h17;

public class WarFactory extends Building{

    private static HeavyTank heavyTank = new HeavyTank();
    private static  MediumTank mediumTank = new MediumTank();
    public WarFactory(Player player, int x, int y, GameObject temp) {
        super(player, x, y, temp);
    }

    public WarFactory() {
        super();
    }

    public static HeavyTank getHeavyTank() {
        return heavyTank;
    }

    public static MediumTank getMediumTank() {
        return mediumTank;
    }

    public GameObject building(EnumObjectType type) {
        if(type == EnumObjectType.heavyTank) {
            return new HeavyTank(this.getPlayer(), this.getX(), this.getY(), heavyTank);
        }
        if(type == EnumObjectType.mediumTank) {
            return new MediumTank(this.getPlayer(), this.getX(), this.getY(), mediumTank);
        }
        return null;
    }
}
