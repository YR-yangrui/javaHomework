package com.huawei.classroom.student.h17;

import java.util.List;

public class GameObject {

    private int health;
    private int strength;
    private int range;
    private int x;
    private int y;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;
    public GameObject(Player player, int x,int y, GameObject temp) {
        this.health = temp.health;
        this.range = temp.range;
        this.strength = temp.strength;
        this.x = x;
        this.y = y;
        this.player = player;
        BattleField.gameObjects.add(this);
    }

    public GameObject() {}

    public void move(int dx, int dy) {
        if(this instanceof Building) {
            return;
        }
        this.x += dx;
        this.y += dy;
    }

    private static int CalDis(int dx,int dy) {
        return dx * dx + dy * dy;
    }

    public boolean canAttack(GameObject target) {
        int delta = CalDis(this.x - target.x, this.y - target.y) - this.range;
        return delta <= 0;
    }

    public void attack(GameObject target) {
        if(target == null) { return; }
        if(canAttack(target)) {
            target.health -= this.strength;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public boolean isEnemy(GameObject obj) {
        return this.player != obj.player;
    }

    public void attack() {
        List<GameObject> gameObjects = BattleField.gameObjects;
        GameObject target = null;
        for (GameObject obj : gameObjects) {
            if (isEnemy(obj) && canAttack(obj)) {
                if (target != null) {
                    int disTarget = GameObject.CalDis(this.x - target.x, this.y - target.y);
                    int disObj = GameObject.CalDis(this.x - obj.x, this.y - target.y);
                    if (disObj > disTarget) {
                        target = obj;
                    }
                } else {
                    target = obj;
                }
            }
        }
        if(target != null) {
            target.health -= this.strength;
        }
    }

    @Override
    public String toString() {
        return "[" + player +
                "." + this.getClass().getSimpleName() +
                " live=" + !isDestroyed() +
                ", x=" + x +
                ", y=" + y +
                ", health=" + health +
                ']';
    }
}
