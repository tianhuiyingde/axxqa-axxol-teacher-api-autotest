package com.axxqa.axxol.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.util.TextUtils;

import java.io.IOException;

import static com.axxqa.axxol.interceptor.ReceivedCookiesInterceptor.COOKIE;

public class AddCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {


        final Request.Builder builder = chain.request().newBuilder();

        //添加Cookie
        if(!TextUtils.isEmpty(COOKIE)){
            builder.addHeader("Cookie", COOKIE);
        }
        return chain.proceed(builder.build());
    }
}
