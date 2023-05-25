package com.huawei.classroom.student.h51;

import java.sql.Timestamp;
import java.util.Random;

public class HongBao {

	/**
	 * 
	 * @param total  红包总金额，以元为单位，精确到分，系统测试的时候保证总金额至少够每人分得1分钱
	 * @param personCount 分红包的总人数>0
	 * @return 每个人分得的钱数
	 * 规则遵循微信分红包规则 例如：
	 * 要求 每人分得的钱数总和=total
	 * 每个人分得钱数必须是正数，且不能少于1分
	 * 
	 */
	public double[] getHongbao(double total,int personCount) {
		Random rnd = new Random(System.currentTimeMillis());
		int sum = (int)(total * 100);
		double[] result=new double[personCount];
		for(int i = 0; i < personCount - 1; i ++) {
			result[i] = rnd.nextInt(sum - (personCount - i) + 1) + 1;
			sum -= result[i];
			result[i] /= 100;
		}
		result[personCount - 1] = sum/100d;
		return result;
	}
}
