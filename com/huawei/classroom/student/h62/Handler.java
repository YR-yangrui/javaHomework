package com.huawei.classroom.student.h62;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Handler extends Thread {

    private Socket sock;
    private Map<String, String> userMap;
    private String root;
    private boolean isLogin;
    private File file;
    public Handler(Socket sock, Map<String, String> userMap, String root) throws IOException {
        this.sock = sock;
        this.userMap = userMap;
        this.root = root.replace("\\","/");
        isLogin = false;
    }
    @Override
    public void run() {
        try(InputStream input = sock.getInputStream()) {
            try(OutputStream output = sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void handle(InputStream input, OutputStream output) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            while (sock.isConnected()) {
                String line = reader.readLine();
                String[] args = line.split("\t");
                switch (args[0]) {
                    case "login" :
                        writer.write(String.valueOf(userMap.get(args[1]).equals(args[2])) + "\r\n");
                        break;
                    case "link file" :
                        file = new File(root + args[1]);
                        writer.write(file.getPath().replace("\\","/").substring(root.length()) +"/" + "\r\n");
                        break;
                    case "dirByNameAsc" :
                        StringBuilder builderFile = new StringBuilder("");
                        StringBuilder builderDir = new StringBuilder("");
                        for (String s : Objects.requireNonNull(file.list())) {
                            String path = file.getPath().replace("\\","/").substring(root.length()) +  "/" + s;
                            if(Files.isDirectory(Paths.get(root + path))) {
                                path = path + "/";
                                builderDir.append(path);
                                builderDir.append("\t");
                            } else {
                                builderFile.append(path);
                                builderFile.append("\t");
                            }
                        }
                        if(builderDir.length() != 0) {
                            builderDir.deleteCharAt(builderDir.length() - 1);
                        }
                        if(builderFile.length() != 0) {
                            builderFile.deleteCharAt(builderFile.length() - 1);
                            if(builderDir.length() != 0) {
                                builderDir.append("\t");
                            }
                            builderDir.append(builderFile);
                        }
                        writer.write(builderDir.toString()  + "\r\n");
                        break;
                    case "isDirectory" :
                        writer.write(String.valueOf(file.isDirectory()) + "\r\n");
                        break;
                    case "isFile" :
                        writer.write(String.valueOf(file.isFile()) + "\r\n");
                        break;
                    case "getPathFileName" :
                        String s = file.getPath().replace("\\","/").substring(root.length());
                        if(file.isDirectory()) {
                            s += "/";
                        }
                        writer.write(s + "\r\n");
                        break;
                    case "writeByBytes" :
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write(args[1]);
                        fileWriter.close();
                        break;
                    case "length" :
                        writer.write(file.length() + "\r\n");
                        break;
                    case "delete" :
                        if(file.exists()) {
                            file.delete();
                        }
                        break;
                    case "exists" :
                        writer.write(String.valueOf(file.exists()) + "\r\n");
                        break;
                    case "close" :
                        sock.close();
                        break;
                    default :
                        writer.write("command error" + "\r\n");
                        break;
                }
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
