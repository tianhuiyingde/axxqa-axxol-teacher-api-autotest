package com.axxqa.axxol.teacher;


import com.alibaba.fastjson.JSONObject;
import com.axxqa.axxol.common.RetrofitManager;

import com.axxqa.axxol.teacher.courseDetail.CourseDetailResponse;
import com.axxqa.axxol.teacher.courseDetail.GreyConfigResponse;
import com.axxqa.axxol.teacher.homePage.CoursePageResponse;
import com.axxqa.axxol.teacher.login.LoginResponse;
import com.axxqa.axxol.utils.EncryptUtil;
import com.axxqa.axxol.utils.RSAEncrypt;
import com.axxqa.axxol.utils.RSAUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianhuiying on 2020/7/29.
 * @version 1.0
 */
public class HttpClient extends RetrofitManager {
    private static String baseUrl="https://teachapi.aixuexi.com";
    public static String PUBLICKEY;
    public static int institutionId;
    public static int userId;
    public static String ptaxxzxzbtpc;
    public static int teacherId;
    public static List<Integer> courseIdList=new ArrayList<Integer>();
    public static List<Integer> knowledgeIdList=new ArrayList<Integer>();

    private  HttpServiceApi httpServiceApi=HttpRetrofitManager(baseUrl)
            .create(HttpServiceApi.class);;
    public HttpClient(){

    }

    /**
     * 调用获取publickey接口
     * @return
     * @throws IOException
     */
    public Response<ResponseBase> getPublicKey() throws IOException {
        Call<ResponseBase> auth_key =httpServiceApi.Auth_Key();
        Response<ResponseBase> response=auth_key.execute();
        return response;
    }

    /**
     * 调用登录接口
     * @return
     * @throws IOException
     */
    public Response<ResponseBase<LoginResponse>> login(String username, String password) throws IOException {
        JSONObject params=new JSONObject();

        params.put("username", RSAUtil.encryptedDataOnJava(username,PUBLICKEY));
        params.put("password",RSAUtil.encryptedDataOnJava(password,PUBLICKEY));
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase<LoginResponse>> auth_login=httpServiceApi.Auth_Login(body);
        Response<ResponseBase<LoginResponse>> response =auth_login.execute();
        return response;
    }

    public Response<ResponseBase> hourEnough(int institutionId,int userId) throws IOException {
        JSONObject params=new JSONObject();
        params.put("institutionId",institutionId);
        params.put("userId",userId);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase> hourEnough=httpServiceApi.HourEnough(body);
        Response<ResponseBase> response=hourEnough.execute();
        return response;
    }

    public Response<ResponseBase> condition(int teacherId,int userId) throws IOException {
        JSONObject params=new JSONObject();
        params.put("teacherId",teacherId);
        params.put("userId",userId);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase> condition=httpServiceApi.Condition(body);
        Response<ResponseBase> response=condition.execute();
        return response;
    }

    public Response<ResponseBase<CoursePageResponse>> coursePage(String courseName, int courseProgress, int status, int institutionId,
                                                                 int teacherId, int userId, int pageSize, int pageNum) throws IOException {
        JSONObject params=new JSONObject();
        params.put("courseName",courseName);
        params.put("courseProgress",courseProgress);
        params.put("status",status);
        params.put("institutionId",institutionId);
        params.put("teacherId",teacherId);
        params.put("userId",userId);
        params.put("pageSize",pageSize);
        params.put("pageNum",pageNum);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase<CoursePageResponse>> coursePage=httpServiceApi.CoursePage(body);
        Response<ResponseBase<CoursePageResponse>> response=coursePage.execute();
        return response;

    }

    public Response<ResponseBase<CourseDetailResponse>> courseDetail(int courseId, int institutionId, int teacherId, int userId) throws IOException {
        JSONObject params=new JSONObject();
        params.put("courseId",courseId);
        params.put("institutionId",institutionId);
        params.put("teacherId",teacherId);
        params.put("userId",userId);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase<CourseDetailResponse>> courseDetail=httpServiceApi.CourseDetail(body);
        Response<ResponseBase<CourseDetailResponse>> response=courseDetail.execute();
        return response;

    }

    public Response<ResponseBase<GreyConfigResponse>> greyConfig(int userId,int teacherId,int institutionId,String[] typeList) throws IOException {
        JSONObject params=new JSONObject();
        params.put("userId",userId);
        params.put("teacherId",teacherId);
        params.put("institutionId",institutionId);
        params.put("typeList",typeList);
        String bodyStr=params.toString();
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),bodyStr);

        Call<ResponseBase<GreyConfigResponse>> greyConfig=httpServiceApi.GreyConfig(body);
        Response<ResponseBase<GreyConfigResponse>> response=greyConfig.execute();
        return response;

    }
}
