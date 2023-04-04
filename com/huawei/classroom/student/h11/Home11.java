package com.huawei.classroom.student.h11;

import java.util.*;

public class Home11 {

	public Home11() {
		// TODO Auto-generated constructor stub
	}

 
	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 * 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 */
	public String getFrequentItem(String content)  {
		String[] shoppingLists= content.split(";");//把清单分开
		HashMap<String,Integer> hashMap = new HashMap<>();//用哈希表来保存出现次数
		for (String s : shoppingLists) {
			String[] items = s.split(",");
			Arrays.sort(items); //确保统计时不会重复，单词顺序一样
			for(int i= 0; i< items.length; i ++) {
				for(int j = i + 1; j < items.length; j++) {
					String ans = items[i] + "," + items[j];
					if(!hashMap.containsKey(ans)) {
						hashMap.put(ans,0);
					}
					hashMap.replace(ans,hashMap.get(ans) + 1);
				}
			}
		}
		String ans = "";
		int mx = -1;
		for( String s : hashMap.keySet()) {
			if( mx < hashMap.get(s)) {
				mx = hashMap.get(s);
				ans = s;
			}
		}
		return ans;
	}

 
}
