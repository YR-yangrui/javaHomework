package com.huawei.classroom.student.h08;

public class LoginUtil {
    public void login(String a, String a1) {

        if( a.equals("a") && a1.equals("a")) {
            return;
        }
        throw new InvalidUserException();

    }
}
