package com.huawei.classroom.student.h14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 * 在本包下增加合适的类和方法， 本程序不但要测试通过，还需要写适当的注释
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class MyTools {

	public MyTools( ) {
		// TODO Auto-generated constructor stub
	}


//	class Student{
//		private int number;
//		private String name;
//		private int classId;
//		public Student(int number,String name,int classId) {
//			this.number = number;
//			this.name = name;
//			this.classId = classId;
//		}
//	}
	public Set<String> copyToTargetDirAndReturnNoExist(String studentListFile,String picDir,String target) throws Exception {
		File file = new File(studentListFile);
		Scanner scanner = new Scanner(file);
		String number,classId,name;
		Set<String> set = new HashSet<>();

		while(scanner.hasNext()) {
			number = scanner.next();
			name = scanner.next();
			classId = scanner.next();
			File img = new File(picDir + number + ".jpg");
			if(!img.exists()) {
				set.add(number);
				continue;
			}
			FileChannel input = new FileInputStream(img).getChannel();
			String filename;
			if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
				filename = target + classId + "\\" + number + "_" + name + ".jpg";
			} else {
				filename = target + classId + "/" + number + "_" + name + ".jpg";
			}
			File dir = new File(target + classId);
			dir.mkdirs();
			File newimg = new File(filename);
			if(!newimg.exists()) {
				newimg.createNewFile();
			}
			FileChannel output = new FileOutputStream(newimg,true).getChannel();
			output.transferFrom(input, 0, input.size());
		}

		return set;
	}
 

}
