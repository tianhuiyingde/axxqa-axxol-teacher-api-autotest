package com.axxqa.axxol.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tianhuiying on 2020/7/26.
 * @version 1.0
 */
public class DateTimeUtil {
//    public final static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    /***
     * @Description: 获取当前日期，返回格式：yyyyMMdd
     ***/
    public static String getCurrentDateyyyyMMdd() {
        //设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前日期，返回格式：yyyy-MM-dd
     ***/
    public static String getCurrentDateyyyy_MM_dd() {
        //设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取N天后的日期，返回格式：yyyyMMdd
     ***/
    public static String getDateAfterDaysyyyyMMdd(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /***
     * @Description: 获取N天后的日期，返回格式：yyyy-MM-dd
     ***/
    public static String getDateAfterDaysyyyy_MM_dd(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /***
     * @Description: 日期格式转换：yyyyMMdd 转换为 yyyy-MM-dd
     */
    public static String convertDateyyyyMMddToyyyy_MM_dd(String yyyyMMdd) {
        SimpleDateFormat sdf_from = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf_to = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf_from.parse(yyyyMMdd);
            return sdf_to.format(date);
        } catch (ParseException e) {
            return "";
        }
    }

    /***
     * @Description: 日期格式转换：yyyy-MM-dd 转换为 yyyyMMdd
     ***/
    public static String convertDateyyyy_MM_ddToyyyyMMdd(String yyyy_MM_dd) {
        SimpleDateFormat sdf_from = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf_to = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = sdf_from.parse(yyyy_MM_dd);
            return sdf_to.format(date);
        } catch (ParseException e) {
            return "";
        }
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyyMMdd HH:mm
     ***/
    public static String getCurrentDateTimeyyyyMMdd_HHmm() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyyMMdd HH:mm:ss
     ***/
    public static String getCurrentDateTimeyyyyMMdd_HHmmss() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyyMMddHHmmss
     ***/
    public static String getCurrentDateTimeyyyyMMddHHmmss() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return (sdf.format(new Date()));
    }


    /***
     * @Description: 获取当前时间，返回格式：yyyyMMdd HH:mm:ss:SSS
     ***/
    public static String getCurrentDateTimeyyyyMMdd_HHmmssSSS() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyy-MM-dd HH:mm
     ***/
    public static String getCurrentDateTimeyyyy_MM_dd_HHmm() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyy-MM-dd HH:mm:ss
     ***/
    public static String getCurrentDateTimeyyyy_MM_dd_HHmmss() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取当前时间，返回格式：yyyy-MM-dd HH:mm:ss:SSS
     ***/
    public static String getCurrentDateTimeyyyy_MM_dd_HHmmssSSS() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return (sdf.format(new Date()));
    }

    /***
     * @Description: 获取N天后的时间，返回格式：yyyyMMdd HH:mm
     ***/
    public static String getDateTimeAfterDaysyyyyMMddHHmm(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /***
     * @Description: 获取N天后的时间，返回格式：yyyyMMdd HH:mm:ss
     ***/
    public static String getDateTimeAfterDaysyyyyMMddHHmmss(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /***
     * @Description: 获取N天后的时间，返回格式：yyyy-MM-dd HH:mm
     ***/
    public static String getDateTimeAfterDaysyyyy_MM_ddHHmm(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /***
     * @Description: 获取N天后的时间，返回格式：yyyy-MM-dd HH:mm:ss
     ***/
    public static String getDateTimeAfterDaysyyyy_MM_ddHHmmss(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return sdf.format(date);
    }

    public static Long stringToLong(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
            return date.getTime();
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳,截取到秒
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期格式字符串转换成时间戳,截取到毫秒
     * @param date_str
     * @param format
     * @return
     * @throws ParseException
     */
    public static String date2TimeStampMS(String date_str,String format) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        if(date_str !=null){
            Date date = simpleDateFormat.parse(date_str);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        }else {
            return null;

        }
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }

}
