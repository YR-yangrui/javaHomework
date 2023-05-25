/**
 * 
 */
package com.huawei.classroom.student.h56;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Administrator
 *
 */
public class FileTool {

	public static String readFile(String pathFilename) {
		FileReader reader = null;
		try {
			reader = new FileReader(pathFilename);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		char[] buff = new char[64];
		StringBuilder builder = new StringBuilder();
		while(true) {
			try {
				int len = reader.read(buff);
				if(len == -1) {
					break;
				}
				builder.append(buff,0,len);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return builder.toString();
	}

	/**
	 * 将homeDir 目录下（包括子目录）所有的文本文件（扩展名为.txt，扩展名不是.txt的文件不要动，扩展名区分大小写) 文件中，orgStr替换为 targetStr
	 * 所有文本文件均为UTF-8编码
	 * 例如将某个目录中所有文本文件中的 南开大学 替换为 天津大学
	 * @param homeDir
	 * @param orgStr
	 * @param targetStr
	 */
	public void replaceTxtFileContent(String homeDir,String orgStr,String targetStr) {
		Queue<File> que = new ArrayDeque<>();
		que.add(new File(homeDir));
		while(!que.isEmpty()) {
			File dir = que.remove();
			for (File file : dir.listFiles()) {
				if(file.isDirectory()) {
					que.add(file);
				} else if(file.getName().endsWith(".txt")) {
					String text = readFile(file.getAbsolutePath());
					text = text.replaceAll(orgStr,targetStr);
					try {
						FileWriter writer = new FileWriter(file, false);
						writer.write(text);
						writer.flush();
						writer.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		 
	}

}
