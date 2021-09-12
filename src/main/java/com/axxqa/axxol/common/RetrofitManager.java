package com.axxqa.axxol.common;

import com.alibaba.fastjson.JSONObject;
import com.axxqa.automation.http.HttpLogger;
import com.axxqa.automation.http.HttpResponse;
import com.axxqa.automation.http.HttpRetrofitManager;
import com.axxqa.automation.utils.ChineseUtil;
import com.axxqa.automation.utils.JsonUtil;
import com.axxqa.axxol.interceptor.AddCookiesInterceptor;
import com.axxqa.axxol.interceptor.AppendHeaderInterceptor;
import com.axxqa.axxol.interceptor.ReceivedCookiesInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RetrofitManager extends HttpRetrofitManager {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static OkHttpClient okHttpClient;
    private Retrofit retrofit = null;
    private int TIMEOUT = 120;

    public RetrofitManager() {
    }

    public synchronized Retrofit HttpRetrofitManager(String hostName) {
        if (okHttpClient == null) {
            okHttpClient = this.initOkHttpClient();
        }

        if (this.retrofit == null) {
            this.retrofit = (new Retrofit.Builder()).baseUrl(hostName).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return this.retrofit;
    }



    private synchronized OkHttpClient initOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = (new okhttp3.OkHttpClient.Builder())
                .addNetworkInterceptor(loggingInterceptor)
                .connectTimeout((long)this.TIMEOUT, TimeUnit.SECONDS)
                .readTimeout((long)this.TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout((long)this.TIMEOUT, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(100, 30L, TimeUnit.SECONDS))
                .retryOnConnectionFailure(true)
                .addInterceptor(new AppendHeaderInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .addInterceptor(new AddCookiesInterceptor()).build();
        return okHttpClient;
    }

    public <T> HttpResponse sendRequestHandlerWithBean(Call<T> call) {
        try {
            Response<T> response = call.execute();
            int statusCode = response.raw().code();
            String requestUrl = ChineseUtil.decodeToUtf8(response.raw().request().url().toString());
            T responseBodyObj = response.body();
            String responseBodyStrFormat = JsonUtil.formatJson(JSONObject.toJSONString(responseBodyObj));
            if (response != null && !response.isSuccessful() && response.errorBody() != null) {
                this.logger.error("【请求失败】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", new Object[]{statusCode, requestUrl, responseBodyStrFormat});
            }

            this.logger.info("【请求成功】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", new Object[]{statusCode, requestUrl, responseBodyStrFormat});
            return new HttpResponse(statusCode, requestUrl, responseBodyObj);
        } catch (IOException var7) {
            this.logger.error("sendRequestHandlerWithBean IOException", ExceptionUtils.getFullStackTrace(var7));
            return null;
        }
    }

    public HttpResponse sendRequestHandlerWithByte(Call<ResponseBody> call) {
        try {
            Response<ResponseBody> response = call.execute();
            int statusCode = response.raw().code();
            String requestUrl = ChineseUtil.decodeToUtf8(response.raw().request().url().toString());
            byte[] responseBodyObj = ((ResponseBody)response.body()).bytes();
            if (response != null && !response.isSuccessful() && response.errorBody() != null) {
                this.logger.error("【请求失败】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", statusCode, requestUrl);
            }

            this.logger.info("【请求成功】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", statusCode, requestUrl);
            ((ResponseBody)response.body()).close();
            return new HttpResponse(statusCode, requestUrl, responseBodyObj);
        } catch (IOException var6) {
            this.logger.error("sendRequestHandlerWithByte IOException", ExceptionUtils.getFullStackTrace(var6));
            return null;
        }
    }

    /** @deprecated */
    @Deprecated
    public HttpResponse sendRequestHandlerWithResponseBody(Call<ResponseBody> call) {
        try {
            Response<ResponseBody> response = call.execute();
            int statusCode = response.raw().code();
            String requestUrl = ChineseUtil.decodeToUtf8(response.raw().request().url().toString());
            ResponseBody responseBody = (ResponseBody)response.body();
            String responseBodyStr = responseBody.string();
            String responseBodyStrFormat = JsonUtil.formatJson(responseBodyStr);
            if (response != null && !response.isSuccessful() && response.errorBody() != null) {
                this.logger.error("【请求失败】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", new Object[]{statusCode, requestUrl, responseBodyStrFormat});
            }

            this.logger.info("【请求成功】statusCode:{} \n【请求Url】:{}\n【响应报文】ResponseBody:\n {}", new Object[]{statusCode, requestUrl, responseBodyStrFormat});
            ((ResponseBody)response.body()).close();
            return new HttpResponse(statusCode, requestUrl, responseBodyStr);
        } catch (IOException var8) {
            this.logger.error("sendRequestHandlerWithResponseBody IOException", ExceptionUtils.getFullStackTrace(var8));
            return null;
        }
    }
}
