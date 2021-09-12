package com.axxqa.axxol.teacher.login;

import lombok.Data;

import java.util.List;
@Data
public class LoginResponse {

        /**
         * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTk1MDgyMDkyMzgxODgxMzciLCJidXNpbmVzc1BsYXRmb3JtIjoiYWl4dWV4aSIsImlzcyI6InBhc3Nwb3J0U2VydmljZSIsImp3dF9yZWZfdG9rZW5fZXhwaXJlIjoxNjAzNjMzNzE0MzYzLCJleHAiOjE2MDM2MzM3MTQsImlhdCI6MTYwMzU0NzMxNCwibG9naW5TeXN0ZW0iOiJwdGF4eHp4emJ0cGMiLCJqdGkiOiI0MDJlYTYzZDUwNTk0ZjA2YmNhZDA2ZTNiNDYyOTBmOSIsInNJZCI6IjZjOThiNmJiZTRhMDQ3MmY5ZjJiYjMyNTkzYTkwMmMzIn0.NGT-dtr1MCeHi6BaoxHKEkwXIqXHZy-UpouRaAaijjE
         * userInfo : {"id":1046481,"roles":["role_teacher"],"name":"田惠颖","type":0,"institutionId":2607,"institutionName":"","insName":"","teacherId":12216,"passportRoleList":["manage","teacher","jiaowu","admissions_officer","kefu","teacher_print","sx_trainer","diy_instructor","dt_assistant"]}
         */

        private String token;
        private UserInfoBean userInfo;

}
