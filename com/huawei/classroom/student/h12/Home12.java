package com.huawei.classroom.student.h12;

import java.util.*;

public class Home12 {
	public Home12() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 * 
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @param n
	 * @return 哪n个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 *  不会出现并列的情况
	 */


	public Set<String> getFrequentItem(String content,int n)  {
		String[] shoppingLists= content.split(";");
		HashMap<String,Integer> hashMap = new HashMap<>();
		//...
		ArrayList<String> arrayList = new ArrayList<>();
		for (String s : shoppingLists) {
			String[] items = s.split(",");
			Arrays.sort(items);
			find(hashMap,items,"",0,n,0);
		}
		String ans = "";
		int mx = -1;
		for( String s : hashMap.keySet()) {
			if( mx < hashMap.get(s)) {
				mx = hashMap.get(s);
				ans = s;
			}
		}
		Set<String> set = new HashSet<>();
		ans = ans.trim();
		String[] items = ans.split(" ");
		for (String item : items) {
			set.add(item);
		}
		return set;
	}

	void find(HashMap<String,Integer> hashMap,String[] items, String ans, int from, int n, int now) {
		if( now == n) {
			if(!hashMap.containsKey(ans)) {
				hashMap.put(ans,0);
			}
			hashMap.replace(ans, hashMap.get(ans) + 1);
			return;
		}
		for(int i = from; i < items.length; i++) {
			String temp = ans +" " + items[i];
			find(hashMap,items,temp,i + 1,n,now + 1);
		}
		return;
	}

	public boolean findShopping(ArrayList<Shopping> arrayList, String s) {
		for (Shopping shopping : arrayList) {
			if( shopping.getItems().equals(s)) {
				shopping.setNum(shopping.getNum() + 1);
				return true;
			}
		}
		return false;
	}

	 
}
