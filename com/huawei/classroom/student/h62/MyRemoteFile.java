package com.huawei.classroom.student.h62;

import java.io.*;
import java.net.Socket;

public class MyRemoteFile {

    private MyHost host;
    private Socket sock;
    private String path;
    private BufferedWriter writer;
    private BufferedReader reader;
    public MyRemoteFile(MyHost host, String path) throws IOException {
        this.host = host;
        sock = new Socket(host.getIp(),host.getPort());
        writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        //登录检测
        writer.write("login\t" + host.getUsername() + "\t" + host.getPassword() + "\r\n");
        writer.flush();
        String line = reader.readLine();
        if(!"true".equals(line)) {
            throw new IOException("login error");
        }

        //连接远程文件
        writer.write("link file\t" + path + "\r\n");
        writer.flush();
        this.path = reader.readLine();
    }

    public MyRemoteFile[] dirByNameAsc() throws IOException {
        writer.write("dirByNameAsc" + "\r\n");
        writer.flush();
        String pathList = reader.readLine();
        String[] paths = pathList.split("\t");
        MyRemoteFile[] files = new MyRemoteFile[paths.length];
        for(int i = 0; i < paths.length; i ++) {
            files[i] = new MyRemoteFile(host, paths[i]);
        }
        return files;
    }

    public boolean isDirectory() throws IOException {
        writer.write("isDirectory" + "\r\n");
        writer.flush();;
        return "true".equals(reader.readLine());
    }

    public boolean isFile() throws IOException {
        writer.write("isFile" + "\r\n");
        writer.flush();
        return "true".equals(reader.readLine());
    }

    public String getPathFileName() throws IOException {
        writer.write("getPathFileName" + "\r\n");
        writer.flush();
        return reader.readLine();
    }

    public void writeByBytes(byte[] bytes) throws IOException {
        writer.write("writeByBytes" + "\t" + new String(bytes) + "\r\n");
        writer.flush();
    }

    public int length() throws IOException {
        writer.write("length" + "\r\n");
        writer.flush();;
        return Integer.parseInt(reader.readLine());
    }

    public void delete() throws IOException {
        writer.write("delete" + "\r\n");
        writer.flush();;
    }

    public boolean exists() throws IOException {
        writer.write("exists" + "\r\n");
        writer.flush();
        return "true".equals(reader.readLine());
    }
    public void close() throws IOException {
        writer.write("close" + "\r\n");
        writer.flush();
        sock.close();
    }
}
