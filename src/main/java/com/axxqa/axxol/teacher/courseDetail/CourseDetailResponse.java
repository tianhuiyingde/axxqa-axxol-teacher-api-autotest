package com.axxqa.axxol.teacher.courseDetail;

import lombok.Data;

import java.util.List;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
@Data
public class CourseDetailResponse {

    /**
     * id : 453349
     * name : 【爱学习在线】拓课测试破(人教版)-备授课升级测试
     * classId : 6287784
     * teacherCount : 1
     * knowledgeList :
     * axgTeacherId : 61019
     * institutionId : 2607
     */

    private int id;
    private String name;
    private String classId;
    private int teacherCount;
    private int axgTeacherId;
    private int institutionId;
    private List<KnowledgeBean> knowledgeList;

}
