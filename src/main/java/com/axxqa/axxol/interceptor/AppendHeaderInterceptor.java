package com.axxqa.axxol.interceptor;

import com.axxqa.axxol.teacher.HttpClient;
import okhttp3.*;

import java.io.IOException;


public class AppendHeaderInterceptor  implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request=chain.request();
        Request newRequest;
        HttpUrl url=request.url();
        System.out.println("url:"+url);

        //统一追加header,判断不同域名
        // 其他域名均不需要传入header
        if (url.toString().contains("teachapi.aixuexi.com/live/auth") ){
            newRequest=request.newBuilder()
                    .build();
            return chain.proceed(newRequest);
        }else if(url.toString().contains("teachapi.aixuexi.com") ){
            Headers.Builder builder=request.headers().newBuilder();
            Headers newHeader = builder
                    .add("ptaxxzxzbtpc", HttpClient.ptaxxzxzbtpc)
                    .add("ptaxxzxzbtpcUserId", String.valueOf(HttpClient.userId))
                    .add("Content-Type","application/json;charset=UTF-8")
                    .build();
            newRequest=request.newBuilder()
                    .headers(newHeader)
                    .build();
            return chain.proceed(newRequest);
        }
        else {
            newRequest=request.newBuilder()
                    .build();
            return chain.proceed(newRequest);
        }
    }
}
