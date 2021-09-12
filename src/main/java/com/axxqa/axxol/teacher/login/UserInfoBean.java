package com.axxqa.axxol.teacher.login;

import lombok.Data;

import java.util.List;

/**
 * @author tianhuiying on 2020/10/25.
 * @version 1.0
 */
@Data
public class UserInfoBean {
    /**
     * id : 1046481
     * roles : ["role_teacher"]
     * name : 田惠颖
     * type : 0
     * institutionId : 2607
     * institutionName :
     * insName :
     * teacherId : 12216
     * passportRoleList : ["manage","teacher","jiaowu","admissions_officer","kefu","teacher_print","sx_trainer","diy_instructor","dt_assistant"]
     */

    private int id;
    private String name;
    private int type;
    private int institutionId;
    private String institutionName;
    private String insName;
    private int teacherId;
    private List<String> roles;
    private List<String> passportRoleList;

}
