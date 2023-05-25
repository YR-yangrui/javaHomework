package com.huawei.classroom.student.h60;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Handler extends Thread {

    private Socket socket;
    private List<String> messages;
    private List<String> users;
    private boolean isLogin;
    private int idx;
    public Handler(Socket socket, List<String> messages,List<String> users) {
        this.socket = socket;
        this.messages = messages;
        this.users = users;
        isLogin = false;
        idx = 0;
    }

    @Override
    public void run() {
        try(InputStream input = socket.getInputStream()) {
            try(OutputStream output = socket.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        while(true) {
            String line = reader.readLine();
            String[] info = line.split("##");
            if(line.startsWith("login##")) {
                for (String user : users) {
                    String[] userInfo = user.split("\\t");
                    if(info[1].equals(userInfo[0]) && info[2].equals(userInfo[1])) {
                        writer.write("login success\r\n");
                        isLogin = true;
                        break;
                    }
                }
                if(!isLogin) {
                    writer.write("login fail\r\n");
                }
            }
            if(line.startsWith("speak##")) {
                if(isLogin) {
                    messages.add(info[1]);
                } else {
//                    writer.write("please login first");
                }
            }
            if(line.startsWith("read##")) {
                if(isLogin) {
                    writer.write(messages.get(idx) + "\r\n");
                    idx ++;
                } else {
//                    writer.write("please login first");
                }
            }
            if(line.startsWith("logout##")) {
                isLogin = false;
                idx = 0;
//                writer.write("logout");
            }
            writer.flush();
        }
    }

}
