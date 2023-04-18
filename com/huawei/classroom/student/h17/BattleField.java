package com.huawei.classroom.student.h17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BattleField {

    private static GameBase gameBase = new GameBase();
    private static List<Player> players = new ArrayList<>();

    static List<GameObject> gameObjects = new ArrayList<>();

    private  static void initGameOject(Properties properties,String name, GameObject obj) {
        name = name + ".";
        obj.setHealth(Integer.parseInt(properties.getProperty(name + "health").trim()));
        obj.setRange(Integer.parseInt(properties.getProperty(name + "range").trim()));
        obj.setStrength(Integer.parseInt(properties.getProperty(name + "strength").trim()));
    }

    public static void init(String filepath) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(filepath);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        initGameOject(properties, "base",gameBase);
        initGameOject(properties, "warFactory",GameBase.getWarFactory());
        initGameOject(properties, "barrack",GameBase.getBarrack());
        initGameOject(properties, "dog",Barrack.getDog());
        initGameOject(properties, "RPGSoldier",Barrack.getRpgSoldier());
        initGameOject(properties, "rifleSoldier",Barrack.getRifleSoldier());
        initGameOject(properties, "heavyTank",WarFactory.getHeavyTank());
        initGameOject(properties, "mediumTank",WarFactory.getMediumTank());
    }

    public static void createPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    public static List<Player> getAllPlayer() {
        return players;
    }

    public static GameBase createGameBase(Player player, int x, int y) {
        return new GameBase(player, x, y, gameBase);
    }
}
