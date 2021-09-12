package com.axxqa.axxol.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class ReceivedCookiesInterceptor implements Interceptor {
    //    private static final String TAG = "ceshi";
    public static String COOKIE;

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            //解析Cookie
            for (String header : originalResponse.headers("Set-Cookie")) {
                if(header.contains("JSESSIONID")){
                    COOKIE= header.substring(header.indexOf("JSESSIONID"), header.indexOf(";"));

                }
            }
        }

        return originalResponse;
    }
}
