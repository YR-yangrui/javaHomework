package com.huawei.classroom.student.h08;

public class Bank {

    private double money;
    public Bank() {
        money = 0;
    }
    public Bank(double money) {
        this.money = money;
    }
    public void save(double money) {
        this.money += money;
    }

    public void get(double money) {
        if( this.money < money) {
            throw new NoMoneyException();
        }
        this.money -= money;
    }
}
