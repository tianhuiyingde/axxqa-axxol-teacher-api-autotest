package com.axxqa.axxol.teacher.homePage;

import lombok.Data;

import java.util.List;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
@Data
public class CoursePageResponse {

    /**
     * pageNum : 1
     * pageSize : 12
     * total : 5
     * pages : 1
     * list : [{"id":436152,"name":"【爱学习在线】学生端测试小数课程thy","status":1,"lastLiveStartTime":"2020-10-27 10:45:00","lastLiveEndTime":"2020-10-27 11:15:00","classId":"6168171","classTypeId":"143193","superVideo":"0"}]
     */

    private int pageNum;
    private int pageSize;
    private int total;
    private int pages;
    private List<CourseBean> list;

}
