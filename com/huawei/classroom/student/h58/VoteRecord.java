package com.huawei.classroom.student.h58;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.*;

public class VoteRecord {
	/**
	 * fileName是一个投票的明细记录，里面逐行存放了 投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
	 * 存放按时间递增（但是可能出现同一秒出现若干条记录的情况）
	 * 现在需要完成投票统计的过程，具体要求如下：
	 * 1个微信ID 1分钟内 最多投1票 多余的票数无效
	 * 1个微信ID 10分钟内 最多只能投5票 多余的票无效
	 * 其中微信ID不固定，候选人姓名不固定
	 * 测试的时候要求10万行记录处理时间不超过3秒 
	 * @param fileName
	 * @return 返回一个map，其中key是候选人名字，value的票数
	 */
	static Integer MINUTE = 60 * 1000;
	public Map<String,Integer> calcRecording(String fileName){
		BufferedReader reader;
		Map<String,Integer> mp = new HashMap<>();
		Map<String, List<Date> > voteMap = new HashMap<>();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String record = reader.readLine();
			while(record != null) {
				String[] info = record.split("\t");
				record = reader.readLine();
				voteMap.putIfAbsent(info[1],new ArrayList<Date>());
				List<Date> dateList = voteMap.get(info[1]);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
				Date date = dateFormat.parse(info[0]);
				int size = dateList.size();
				if(size != 0 && (date.getTime() - dateList.get(size - 1).getTime()) < MINUTE) {
					continue;
				}
				if(size >=5 && (date.getTime() - dateList.get(size - 5).getTime()) < 10L * MINUTE) {
					continue;
				}
				dateList.add(date);
				mp.putIfAbsent(info[2], 0);
				mp.put(info[2], mp.get(info[2]) + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mp;
	}

}
