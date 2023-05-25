package com.huawei.classroom.student.h60;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
	/**
	 * 初始化 ， 根据情况适当抛出异常
	 * @param port
	 * @param passwordFilename 所有用户的用户名 口令
	 */

	private List<String> messages;
	private List<String> users;
	private ServerSocket socket;
	public ChatServer (int port, String passwordFilename) throws IOException {
		socket = new ServerSocket(port);
		messages = new CopyOnWriteArrayList<>();
		users = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(passwordFilename));
		String line = reader.readLine();
		while(line != null) {
			users.add(line);
			line = reader.readLine();
		}
	}
	/**
	 *  根据情况适当抛出异常
	 * 开始监听
	 */
	public void startListen( ) {
		Thread listen = new Thread() {
			@Override
			public void run() {
				while (true) {
					Socket sock;
					try {
						sock = socket.accept();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					Thread t = new Handler(sock,messages,users);
					t.start();
				}
			}
		};
		listen.start();
	}
	 
}
