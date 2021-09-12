package com.axxqa.axxol.teacher.courseDetail;

import lombok.Data;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
@Data
public class KnowledgeBean {
    /**
     * id : 5944312
     * courseId : 453349
     * name : 无讲课无说课
     * teacherId : 12216
     * teacherName : 田惠颖
     * status : 1
     * startTime : 2020-08-21 14:30:00
     * endTime : 2020-08-21 18:30:00
     * createTime : 2020-08-21 14:18:29
     * updateTime : 2020-09-16 23:47:16
     * displayOrder : 1
     * supportPlatform : rtc_talk
     * liveProp : { 					"param":{ 						"channel":{ 							"signalPlatform":"aliyun_mqtt","createTime":"2020-08-21 14:19:40","signalPlatformImplId":7852853,"signalSolution":"mqtt","appId":1000008,"del":false,"id":7861856,"priority":0,"isdf":true,"roomId":7934586,"status":1 						},"room":{ 							"estimatedEndTime":"2020-08-21 20:30:00","flag":"5944312","enableVideo":1,"del":false,"estimatedStartTime":"2020-08-21 14:30:00","mute":0,"version":"3.3.19","mode":0,"createTime":"2020-08-21 14:19:39","appId":1000008,"name":"无讲课无说课","id":7934586,"enableAudio":1,"status":1 						},"live":{ 							"estimatedEndTime":"2020-08-21 20:30:00","flag":"5944312","liveSolution":"realtime_video","del":false,"estimatedStartTime":"2020-08-21 14:30:00","platformImplId":878551,"priority":0,"type":0,"platform":"rtc_talk","roomId":7934586,"createTime":"2020-08-21 14:19:40","appId":1000008,"name":"无讲课无说课","id":7953938,"lastUpdateTime":"2020-08-21 14:19:40","status":1 						}                    },"serverType":"gsl","resourceFlag":"7934586" 				}
     * lessonId : 1127536418
     * debuff : 3
     * liveStatus : 3
     * playBackStatus : 1
     * isWindowRoom : false
     * roomVersion : 3.3.21
     */

    private int id;
    private int courseId;
    private String name;
    private int teacherId;
    private String teacherName;
    private int status;
    private String startTime;
    private String endTime;
    private String createTime;
    private String updateTime;
    private int displayOrder;
    private String supportPlatform;
    private String liveProp;
    private String lessonId;
    private int debuff;
    private int liveStatus;
    private int playBackStatus;
    private boolean isWindowRoom;
    private String roomVersion;

}
