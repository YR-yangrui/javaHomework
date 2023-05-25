/**
 * 
 */
package com.huawei.classroom.student.h54;

/**
 * @author Administrator
 *
 */
public class PasswordChecker {
	/**
	 * 判断一个口令是否是一个复杂度合法的口令，复杂度合法的口令有如下要求：
	 * 1  长度>=8
	 * 2 最少包含一个数字
	 * 3 最少包含一个小写英文字母
	 * 4 虽少包含一个大写英文字母
	 * 5 最少包含一个特殊字符 特殊字符定义为   ~!@#$%^&*()_+
	 * 
	 *   
	 */
	public boolean isValidPassword(String password){
		if(password.length() < 8) {
			return false;
		}
		String[] reg = {
				".*[0-9]+.*",
				".*[a-z]+.*",
				".*[A-Z]+.*",
				".*[~!@#$%^&*()_+]+.*"
		};
		for (String s : reg) {
			if(!password.matches(s)) {
//				System.out.println(password + " match " + s + " wrong!");
				return false;
			}
		}
		return true;
	}
}
