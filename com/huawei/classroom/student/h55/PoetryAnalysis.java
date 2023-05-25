package com.huawei.classroom.student.h55;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PoetryAnalysis {

	/**
	 * 
	 * @param pathFilename 包含诗歌内容的源文件
	 * 统计
	 * 
	 */

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
				if (!(reader.read(buff) != -1)) {
					break;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			builder.append(buff);
		}
		return builder.toString();
	}
	public void analysis(String pathFilename,String chars) {
		Map<String,Integer> mp = new HashMap<>();
		String [] words = chars.split(";");
		String text = readFile(pathFilename);
		String res;
		for (String word : words) {
			int idx = text.indexOf(word, 0);
			while(idx != -1) {
				char c1 = text.charAt(idx - 1);
				char c2 = text.charAt(idx + 1);
				if(c1 != '。' && c1 != '，') {
					res = c1 + word;
					mp.putIfAbsent(res, 0);
					mp.put(res, mp.get(res) + 1);
				}
				if(c2 != '。' && c2 != '，') {
					res = word + c2;
					mp.putIfAbsent(res, 0);
					mp.put(res, mp.get(res) + 1);
				}
				idx = text.indexOf(word, idx + 1);
			}
			Set<Map.Entry<String, Integer>> entries = mp.entrySet();
			List<Tuple> tupleList = new ArrayList<>();
			for (Map.Entry<String, Integer> entry : entries) {
				tupleList.add(new Tuple(entry.getKey(), entry.getValue()));
			}
			Collections.sort(tupleList);
			System.out.println(word + "-----------");
			for(int i = 0;i < 10 && i < tupleList.size(); i++) {
				System.out.println(tupleList.get(i));
			}
			mp.clear();
		}
	}
}
