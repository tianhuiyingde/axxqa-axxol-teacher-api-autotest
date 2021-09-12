package com.axxqa.axxol.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5utils {
	/*
	 * 定义md5 32位加密方法
	 */
	public static String getMd532(String text) {
		/**
		　　* @description: 定义md5 32位加密方法
		　　* @param [text 需要加密的字符串]
		　　* @return java.lang.String
		　　* @author lujichao
		　　* @date 2019/3/15 14:24
		　　*/
		String md5text=null;

	        try {
	            // 生成一个MD5加密计算摘要
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 计算md5函数
	            md.update(text.getBytes());
	            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	            md5text=new BigInteger(1, md.digest()).toString(16);
	            //BigInteger会把0省略掉，需补全至32位

	        } catch (Exception e) {
	            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
	        }

	        return fillMD5(md5text);

	}
	private static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }
}
