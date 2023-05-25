package com.huawei.classroom.student.h62;

public class MyDeamonConfigVo {

    private String root;
    private int port;
    private String passwordFile;

    public String getPasswordFilePath() {
        return passwordFile;
    }

    public void setPasswordFile(String passwordFile) {
        this.passwordFile = passwordFile;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
