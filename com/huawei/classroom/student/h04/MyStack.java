package com.huawei.classroom.student.h04;

public class MyStack {
    private int size;
    private int[] value;
    private int top;

    MyStack(int size) {
        this.size = size;
        value = new int [size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int i) {
        //未处理栈满了的情况
        if( top < size - 1 ) {
            value[++top] = i;
        }
    }

    public boolean isFull() {
        return top == (size -1);
    }

    public int pop() {
        return value[top--];
    }
}
