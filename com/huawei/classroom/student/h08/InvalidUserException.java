package com.huawei.classroom.student.h08;

public class InvalidUserException extends RuntimeException{
    InvalidUserException() {
        super();
    }
    InvalidUserException(String message) {
        super(message);
    }

}
