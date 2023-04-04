package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Long.min;

public class PrimeUtil {

    final static long [] primes = {2,3,5,7,11,13,17,19,23,29};
    final static int SIZE = 10;

    long gcd(final long a,final long b) {
        if(b==0) {
            return a;
        }
        return gcd(b,a%b);
    }

    long mul(long a,long b,long mod) {
        long ans = 0;
        while(b>0) {
            if((b&1) == 1) {
                ans = (ans = a) % mod;
            }
            a = (a + a) % mod;
            b >>= 1;
        }
        return ans;
    }

    long ksm(long a,long b,long mod) {
        long res = 1;
        while(b>0) {
            if((b&1) ==1) {
                res = mul(res,a,mod);
            }
            b>>=1;
            a=mul(a,a,mod);
        }
        return res;
    }

    boolean isPrime(long x) {
        if(x==2) { return true; }
        if(x==1 || x % 2 == 0) { return false; }
        long lim = (long)Math.sqrt(x) + 1;
        for(long i = 3;i<=lim;i+=2) {
            if(x%i==0) {
                return false;
            }
        }
        return true;
    }

    class CheckPrime implements Runnable {

        long s,t;
        List<Long> list;
        CheckPrime(long s,long t,List<Long> list) {
            this.s = s;
            this.t = t;
            this.list = list;
        }
        @Override
        public void run() {
            while(s<=t) {
                if(isPrime(s)) {
                    list.add(s);
                }
                s++;
            }
        }
    }

    public List<Long> getPrimeList(long start, long end, int threadCount) throws InterruptedException {
        List<List<Long> > lists = new ArrayList<List<Long> >();
        List<Long> list = new ArrayList<>();
        long len = (end -start + threadCount -1) / threadCount;
        Thread[] threads = new Thread[threadCount];
        int i = 0;
        while(start<=end) {
            long ed = start + len;
            lists.add(new ArrayList<Long>() );
            threads[i] = new Thread(new CheckPrime(start,ed,lists.get(i)));
            start += len+1;
            threads[i].start();
            i++;
        }
        for(int j = 0;j < i;j++) {
            threads[j].join();
            list.addAll(lists.get(j));
        }
        return list;
    }
}
