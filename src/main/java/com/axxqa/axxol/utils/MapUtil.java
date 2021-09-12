package com.axxqa.axxol.utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {//将map类型的parms转成string类型
    public static String map2Str(Map<String,String> map){
        //用NameValuePair的list来添加form表单格式 请求body参数: param={"phone":"13691286660"}
        List<NameValuePair> params= new ArrayList<NameValuePair>();
        //遍历map，将key和value传入params中
        for(String key : map.keySet()){
            params.add(new BasicNameValuePair(key, map.get(key)));
        }
        //截取params的前后[]字符，获得bodyString
        String bodyString=params.toString();
        bodyString=bodyString.substring(1,bodyString.length()-1);
        bodyString=bodyString.replace(", ","&");
        System.out.println("bodyString:"+bodyString);
        return bodyString;
    }
}
