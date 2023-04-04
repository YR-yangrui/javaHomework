
package com.huawei.classroom.student.h13;

import java.io.*;
import java.util.*;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过 
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Analysis {
	private String[] chapters = null;
	private String content;
	private String fimename;

	/**
	 * @throws Exception
	 * 
	 */
	public Analysis(String filename) throws Exception {
		this.fimename = filename;
		File file = new File(filename);
		if(!file.exists()) {
			throw new FileNotFoundException();
		}
		try {
			content = readFromTxt(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		content = content.substring(content.indexOf("第一回"));
		chapters = splitContentToChapter(content);
	}

	/**
	 * 提示 ：将一个文本文件读取到一个字符串中返回
	 * 
	 * @param filename
	 *            红楼梦文本文件的全路径名
	 * @return 文本的内容
	 */
	private String readFromTxt(String filename) throws Exception {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}

	class WordCount implements Comparable<WordCount> {
		public String word;
		public int num;
		WordCount() {
			word = "";
			num = 0;
		}
		WordCount(String word, int num) {
			this.word = word;
			this.num = num;
		}

		@Override
		public int compareTo(WordCount o) {
			return (o.num - this.num);
		}
	}
	/**
	 * 返回红楼梦中出现频率最高的N个次，频率从高到低排列（所谓词就是两个相邻的汉字）
	 * @param n
	 * @return
	 */
	public List<String> getTopNWords(int n){
		String txt = content.trim();
		txt = txt.replaceAll("[，”“,：． 《》？`'。_)\n(！*…]","");
		txt = txt.replaceAll("\\p{Punct}","");
		HashMap<String,Integer> hashMap = new HashMap<>();
		for(int i = 0; i < txt.length() - 1; i++) {
			String word = txt.substring(i,i+2);
			if(!hashMap.containsKey(word)) {
				hashMap.put(word,0);
			}
			hashMap.replace(word,hashMap.get(word) + 1);
		}
		WordCount[] wordCounts = new WordCount[hashMap.size()];
		int cnt = 0;
		Set<String> keys = hashMap.keySet();
		for (String key : keys) {
			WordCount wordCount = new WordCount(key,hashMap.get(key));
			wordCounts[cnt++] = wordCount;
		}
		Arrays.sort(wordCounts);

		List<String> list = new ArrayList<>();
		for(int i =0;i<n;i++) {
			list.add(wordCounts[i].word);
		}
		return list;
	}
	/**
	 * 关闭输入输入流
	 * 
	 * @param inout
	 */
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 提示 将红楼梦文本文件拆分为120个章节的方法
	 * 
	 * @param content
	 * @return 返回120个元素的字符串数组
	 */
	private String[] splitContentToChapter(String content) {
		// 提示 使用 content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");正则表达拆分
		// 百度一下正则表达式
		String contents[] = content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");
		chapters = contents;
		return contents;
	}

	 
	/**
	 * 统计红楼梦章节字符串str出现的频率
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int[] getStringFrequent(String str) throws Exception {
		int [] ans = new int[chapters.length];
		for(int i = 0; i < chapters.length; i++) {
			ans[i] = 0;
			int from = 0;
			while(true) {
				from = chapters[i].indexOf(str,from+1);
				if(from == -1) {
					break;
				}
				ans[i] ++;
			}
		}
		return ans;
	}

}
