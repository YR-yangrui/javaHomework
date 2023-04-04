package com.huawei.classroom.student.h04;

public class Triangle {

    private double A,B,C;

    public Triangle() {
        A = 3;
        B = 4;
        C = 5;
    }

    public Triangle(double a, double b, double c) {
        A = a;
        B = b;
        C = c;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double getArea() {
        double sinA= (B * B + C * C - A * A) / 2 / B / C;
        sinA = Math.sqrt(1d - sinA * sinA);
        return  0.5 * B * C * sinA;
    }
}
