package com.huawei.classroom.student.h16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyServer {

    private ServerSocket ss;
    MyServer() {
    }
    public void startListen(int port) {
        Thread t = new Listener(port);
        t.start();
    }

}

class Listener extends Thread {
    private int port;

    Listener(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(port)) {
            try (Socket accept = ss.accept()) {
                Thread t = new Handler(accept);
                t.start();
                t.join();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Handler extends Thread {
    Socket sock;
    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try(InputStream input  = this.sock.getInputStream()) {
            try(OutputStream output = this.sock.getOutputStream()) {
                handle(input,output);
            }

        } catch (IOException e) {
            try {
                this.sock.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        while(true) {
            String s = reader.readLine();
            writer.write(s + "\n");
            writer.flush();
            if("bye".equals(s)) {
                break;
            }
        }
    }

}