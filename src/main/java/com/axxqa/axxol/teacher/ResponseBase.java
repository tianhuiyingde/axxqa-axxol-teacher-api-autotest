package com.axxqa.axxol.teacher;

import lombok.Data;

@Data
public class ResponseBase <T>{

    /**
     * data : {"userId":18579,"status":1,"courseProgress":2}
     * timestamp : 2020-10-23 19:15:45
     * code : SUCCESS
     * msg : 成功
     */

    private T data;
    private String timestamp;
    private String code;
    private String msg;

}
