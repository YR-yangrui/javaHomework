package com.huawei.classroom.student.h60;

import java.io.*;
import java.net.Socket;

public class ChatClient {

	 /**
	  * 根据情况适当抛出异常 
	  * @param ip
	  * @param port
	  */
	 private Socket socket;
	 private BufferedReader reader;
	 private BufferedWriter writer;
	 private boolean isLogin;
	public ChatClient (String ip, int port) {
		try {
			socket = new Socket(ip,port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		isLogin = false;
	}
	/**
	 * 登录,成功返回true，否则返回false，根据情况适当抛出异常 
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(String userName,String password) throws IOException {
		writer.write("login##" + userName + "##" + password +"\r\n");
		writer.flush();
		String line = reader.readLine();
		if("login success".equals(line)) {
			isLogin = true;
		}
		return isLogin;
	}
	/**
	 * 退出，根据情况适当抛出异常 
	 */
	public void logout() throws IOException {
		writer.write("logout##\r\n");
		writer.flush();
		isLogin = false;
	}
	/**
	 * 发言, 只有登录以后才能发言， 根据情况适当抛出异常 
	 * 如果没有登录 抛出异常
	 *  
	 * @param str
	 */
	public void speak(String str) throws Exception {
		if(!isLogin) {
			throw new Exception("not login");
		}
		writer.write("speak##" + str + "\r\n");
		writer.flush();
	}
	/**
	 * 读取聊天室目前的发言，根据情况适当抛出异常 
	 * 只有登录以后才可以读到,否则返回null
	 * 得到聊天室里面所有的发言（包括自己的），如果此时没有发言则立刻返回null，否则每次调用read的时候按队的方式返回一个句话
	 */
	public String read() throws Exception{
		String message = null;
		if(isLogin) {
			writer.write("read##\r\n");
			writer.flush();
			message = reader.readLine();
		}
		return message;
	}
	
}
