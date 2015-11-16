package org.lzh.framework.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 字符串工具处理类
 * @author: lizhaohua
 * @date: 15/11/16 下午5:14
 * @version: V1.0
 */
public class StringUtils {

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String dateFormat(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);

        return sdf.format(date);
    }

    /**
     * 日期默认格式化 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String dateFormat(Date date){
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }
}
