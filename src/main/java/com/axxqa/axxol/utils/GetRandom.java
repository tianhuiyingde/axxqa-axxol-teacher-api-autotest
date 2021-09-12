package com.axxqa.axxol.utils;

import java.util.Random;

public class GetRandom {
	public static int getRandom(){
		int random;
		random=(int)Math.random();
		return random;
	}
	public static boolean  getBooleanRandom(){
		boolean random;
		Random randomno = new Random();
		random=randomno.nextBoolean();

		return random;
	}
	/*
	 * 生成【0-figure】间的随机数
	 */
	public static int getRandom(int figure) {
		/**
		 　　* @description: 生成【0-figure】间的随机数
		 　　* @param [figure 区间最大值]
		 　　* @return int
		 　　* @author lujichao
		 　　* @date 2019/3/15 14:11
		 　　*/
		return (int)(Math.random()*figure+1);
	}
	/*
	 * 生成【m-n】间的随机数
	 */
	public static int getRandom(int minNum,int maxNum) {
		/**
		 　　* @description: 生成【m-n】间的随机数
		 　　* @param minNum最小数，maxNum 最大数
		 　　* @return int
		 　　* @author lujichao
		 　　* @date 2019/3/15 14:11
		 　　*/
		Random random = new Random();
		int number = random.nextInt(maxNum - minNum + 1) + minNum;
		return number;
	}
	/*
	 * 生成n位随机数范围的随机数
	 */
	public static String getDigitsRandom(int number ) {
		/**
		　　* @description: 生成n位随机数范围的随机数
		　　* @param [number 随机数的位数]
		　　* @return java.lang.String
		　　* @author lujichao
		　　* @date 2019/3/15 14:11
		　　*/
		StringBuffer result=new StringBuffer();
		int num;
		for (int i = 0; i < number; i++) {
			num=getRandom(9);
			if (num==0) {
				continue;
			}else {
				result.append(num);
			}

		}
		return result.toString();
	}
/*
public static void main(String[] args) {
	for (int i = 0; i < 20; i++) {
		System.out.println(getRandom(0,3));

	}

}*/
}
