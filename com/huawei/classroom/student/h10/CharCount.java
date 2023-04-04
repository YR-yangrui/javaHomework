package com.huawei.classroom.student.h10;

public class CharCount implements Comparable<CharCount>{

    private Character c;
    private Integer count;
    private Integer location;

    CharCount(Character c, Integer count, Integer location) {
        this.c = c;
        this.count = count;
        this.location = location;
    }

    @Override
    public int compareTo(CharCount charCount) {

        if ( this.count.equals(charCount.count)) {
            return this.location.compareTo(charCount.location);
        }
        return charCount.count.compareTo(this.count);
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
