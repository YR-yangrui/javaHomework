package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread{
    private StringBuffer stringBuffer;
    ThreadUtil(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }
    @Override
    public void run() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stringBuffer.append("ok");
    }
}
