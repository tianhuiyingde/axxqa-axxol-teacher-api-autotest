package com.axxqa.axxol.teacher;


import com.axxqa.axxol.teacher.courseDetail.CourseDetailResponse;
import com.axxqa.axxol.teacher.courseDetail.GreyConfigResponse;
import com.axxqa.axxol.teacher.homePage.CoursePageResponse;
import com.axxqa.axxol.teacher.login.LoginResponse;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author tianhuiying on 2020/7/29.
 * @version 1.0
 */
public interface HttpServiceApi {

      /**
       * 登录获取pubkey接口
       * @return
       */
      @POST("live/auth/key")
      Call<ResponseBase> Auth_Key();


      /**
       * 登录接口
       * @param body
       * @return
       */
      @POST("live/auth/login")
      @Headers("Content-Type: application/json;charset=UTF-8")
      Call<ResponseBase<LoginResponse>> Auth_Login(@Body RequestBody body);

      /**
       * 判断小时包是否足够接口
       * @param body
       * @return
       */
      @POST("live/teacher/qualification/needWarnHourNotEnough")
      Call<ResponseBase> HourEnough(@Body RequestBody body);

      /**
       * 首页获取课程默认状态接口
       * @param body
       * @return
       */
      @POST("live/teacher/course/condition")
      Call<ResponseBase> Condition(@Body RequestBody body);

      /**
       * 首页课程列表接口分页
       * @param body
       * @return
       */
      @POST("live/teacher/course/page")
      Call<ResponseBase<CoursePageResponse>> CoursePage(@Body RequestBody body);

      /**
       * 课程详情接口（讲次列表）
       * @param body
       * @return
       */
      @POST("live/teacher/course/detail")
      Call<ResponseBase<CourseDetailResponse>> CourseDetail(@Body RequestBody body);

      /**
       * 获取灰度配置接口
       * @param body
       * @return
       */
      @POST("live/teacher/grey/config")
      Call<ResponseBase<GreyConfigResponse>> GreyConfig(@Body RequestBody body);

      /**
       *    搜索问题接口，get请求
       * @param jql
       * @return
       */
      @GET("/rest/api/2/search")
      @Headers({ "Content-Type: application/json;charset=UTF-8"})
      Call<ResponseBase> JIRA_PROJECTS_CALL(@Query("jql") String jql);

      /**
       *    搜索问题接口，post请求
       * @param body
       * @return
       */
      @POST("/rest/api/2/search")
      @Headers({ "Content-Type: application/json;charset=UTF-8"})
      Call<ResponseBase> JIRA_PROJECTS_POST_CALL(@Body RequestBody body);

      /**
       *    获取问题详情接口
       * @param proId
       * @return
       */
      @GET("/rest/api/2/issue/{proId}")
      Call<ResponseBase> JIRA_ISSUE_CALL(@Path("proId") String proId);
}
