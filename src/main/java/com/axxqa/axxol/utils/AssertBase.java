package com.axxqa.axxol.utils;


import org.testng.Assert;

/**
 * @author tianhuiying on 2019/11/16.
 * @version 1.0
 */
public class AssertBase {//封装好的断言方法

    public  static void assertSuccess(int statusCode,int status){
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(status,1);
    }
    public static void assertFail(int statusCode,int status){
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(status,0);
    }
}
