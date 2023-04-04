package com.huawei.classroom.student.h08;

public class NoMoneyException extends RuntimeException{
    NoMoneyException() {
        super();
    }
    NoMoneyException(String message) {
        super(message);
    }
}
