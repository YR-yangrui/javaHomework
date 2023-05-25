package com.huawei.classroom.student.h52;

import java.util.HashSet;
import java.util.Set;

public class NumDecompose {
	/**
	 * 将num进行质因数分解，将分解到的质因数放到Set里面返回
	 */

	int isPrime(int p) {
		if(p == 1) {
			return 0;
		}
		if(p == 2) {
			return 1;
		}
		for(int i = 2; i * i <= p; i++) {
			if(p % i == 0) {
				return 0;
			}
		}
		return 1;
	}
	public Set<Integer> decompose(int num) {
		Set<Integer> set = new HashSet<>();
		for(int i = 2; i <= num; i ++) {
			if(isPrime(i) == 1 && num % i == 0) {
				while(num % i == 0) {
					num /= i;
					set.add(i);
				}

			}
		}
		return set;
	}
}
