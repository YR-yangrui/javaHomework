package com.huawei.classroom.student.h62;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDaemon {

    private MyDeamonConfigVo config;
    private ServerSocket serverSocket;
    private Map<String, String> userMap;
    public MyDaemon(MyDeamonConfigVo config) {
        this.config = config;
        userMap = new HashMap<>();
        List<String> userList = null;
        try {
            userList = Files.readAllLines(Paths.get(config.getPasswordFilePath()));
            serverSocket = new ServerSocket(config.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : userList) {
            if(s.startsWith("#")) {
                continue;
            }
            String[] info = s.split("\t");
            userMap.put(info[0], info[1]);
        }
    }

    public void start() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Socket socket = serverSocket.accept();
                        Thread t = new Handler(socket,userMap, config.getRoot());
                        t.start();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
