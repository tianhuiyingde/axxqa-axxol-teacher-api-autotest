package com.axxqa.axxol.utils;

import org.apache.commons.lang.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class SignUtil {
    /**
     * 创建签名
     *
     * @param token  token信息
     * @param timestamp  时间戳
     * @param signKey 签名Key
     * @return 签名字符串
     */
    public static String createSign(String token  , String timestamp, String signKey) {
        String sign="token="+token+"&timestamp="+timestamp+"&key="+signKey;

        sign = md5(sign).toUpperCase();
        return sign;
    }

    public static void main(String[] args) {
   /*     String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxODE1NDUxMjU1NTgxMDQwNjgiLCJidXNpbmVzc1BsYXRmb3JtIjoiYWl4dWV4aV9zdHVkZW50IiwiaXNzIjoicGFzc3BvcnRTZXJ2aWNlIiwiand0X3JlZl90b2tlbl9leHBpcmUiOjE1NzcyNDExNzY4MDUsImV4cCI6MTU3NzI0MTE3NiwiaWF0IjoxNTc3MTU0Nzc2LCJsb2dpblN5c3RlbSI6InB0YXh4eHNhcHAiLCJqdGkiOiI0YmNmZTQ0ZTlhZjY0YWU1OTE0NGY4MTQ5MTY0MGIyNyIsInNJZCI6IjFjZjUxYTk0ODJmZjQ4NjVhMzE2YWEyYWM3NTEyMDkyIn0.E3fezs_iNDr9FqOvkMVNWy0_gvVcOSXvV5wznd015hg";
        String timestamp="1577155091";
        String signKey="3520382f0b4c0923rec52tdc267f6a1k";
        String sign=createSign(token,timestamp,signKey);
        System.out.println(sign);*/

        String  clientId="G20191120102329661";
        String timestamp2="1577245426";
        String signSecret="h3kdxqqqvwyu8luomfv39z1v8z8x215a";

//        855323,callerId:onlineforeign,timestamp:1577251070,sign:b317da1dd48513ceb56caef1ce9314b3de9845b8
        String sign_auth_Str="855323onlineforeign1577251070";
        String sign= SignUtil.sign(sign_auth_Str,signSecret);
        System.out.println(sign);
    }

    public static String md5(String content) {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        try {
            byte[] b = content.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        } catch (Exception e) {
            System.out.println("sign_utils签名错误"+e);
        }
        return null;
    }



        private static final String CONTENT_CHARSET = "UTF-8";

        private static final String HMAC_ALGORITHM = "HmacSHA1";

        /**
         * 签名
         *
         * @param param  签名参数
         * @param secret 秘钥
         * @return
         */
        public static String sign(String param, String secret) {
            StringBuilder sign = new StringBuilder();
            try {
                Mac mac = Mac.getInstance(HMAC_ALGORITHM);
                byte[] hash;

                SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
                mac.init(secretKey);
                hash = mac.doFinal(param.getBytes(CONTENT_CHARSET));
                for (byte b : hash) {
                    String str = Integer.toHexString(((int) b) & 0xff);
                    if (str.length() == 1) {
                        str = "0" + str;
                    }
                    sign.append(str);
                }
            } catch (Exception e) {
//                log.error("[签名异常]", e);
                System.out.println("[签名异常]"+ e);
            }
            return sign.toString();
        }

}
