package com.huawei.classroom.student.h57;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class FileTool {

	/*
	 * 统计一个目录下所有文件大小的加和
	 */
	public long recursiveCalcFileSize(String homeDir) {
		long totSize = 0;
		Queue<File> que = new ArrayDeque<>();
		que.add(new File(homeDir));
		while(!que.isEmpty()) {
			File file = que.remove();
			for (File listFile : file.listFiles()) {
				if(listFile.isDirectory()) {
					que.add(listFile);
				} else {
					totSize += listFile.length();
				}
			}
		}
		return totSize;
	}
}
