package com.huawei.classroom.student.h12;

public class Shopping implements Comparable<Shopping>{
    private String items;
    private int num;

    @Override
    public int compareTo(Shopping o) {
        return o.num - this.num;
    }

    public Shopping(String items, int num) {
        this.items = items;
        this.num = num;
    }


    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
