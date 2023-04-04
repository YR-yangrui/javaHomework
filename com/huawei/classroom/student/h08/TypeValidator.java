package com.huawei.classroom.student.h08;

public class TypeValidator {
    public void validate(Object obj) {
        if(obj instanceof String) {
            return;
        }
        throw new RuntimeException();
    }
}
