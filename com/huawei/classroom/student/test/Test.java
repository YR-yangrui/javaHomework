package com.huawei.classroom.student.test;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        TestClass testClass = new TestClass("更改失败");
        change(testClass);
        System.out.println(testClass.getSay());
    }
    public static void change(TestClass testClass) {
        testClass.setSay("更改语句成功");
    }
}

class  TestClass {
    private String say;

    public TestClass(String say) {
        this.say = say;
    }
    public String getSay() {
        return say;
    }
    public void setSay(String say) {
        this.say = say;
    }

}
