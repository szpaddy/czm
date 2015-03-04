package com.czmen.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间调用常量类。
 * 
 * @author YANGYONG
 *
 */
public final class DateTimeUtils{
    /**
     * 标准日期时间格式
     */
    public final static SimpleDateFormat Date_Time_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    
    /**
     * 输出系统时间
     */
    public static String currentDateTime() {
        Date myDate = new Date();
        return Date_Time_Format.format(myDate);
    }
}