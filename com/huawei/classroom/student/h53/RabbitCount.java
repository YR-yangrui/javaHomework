/**
 * 
 */
package com.huawei.classroom.student.h53;

/**
 * @author Administrator
 *
 */
public class RabbitCount {

	/**
	 * 1对兔子出生以后经过180天可以生出一窝（2对）兔子，以后每隔90天繁殖一次生出一窝（2对）兔子
	 * 每对兔子的寿命是700天 
	 * @param startCount 第0天 开始的时候初生的兔子对数
	 * @param days 经过的天份数
	 * @return 目前系统中存活的兔子的对数
	 */
	public int getLivingRabbit(int startCount,int days) {
		int[] birthNum = new int [days];
		int totSum = startCount;
		birthNum[0] = startCount;
		for(int i = 1; i < days && i < 180; i++) {
			birthNum[i] = 0;
		}
		for(int i = 180; i < days; i++) {
			birthNum[i] = 0;
			int t = i - 180;
			while(t >= 0 && (t - i) <= 700) {
				birthNum[i] += birthNum[t];
				t -= 90;
			}
			birthNum[i] <<= 1;
			totSum += birthNum[i];
//			if(birthNum[i] != 0) {
//				System.out.println(i + ":" + birthNum[i] + " " + totSum);
//			}
			if(i >= 700) {
				totSum -= birthNum[i - 700];
			}
		}
		return totSum;
	}
}
