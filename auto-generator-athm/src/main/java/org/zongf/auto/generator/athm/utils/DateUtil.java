package org.zongf.auto.generator.athm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zongf
 * @date 2020-01-07
 */
public class DateUtil {

    /** 获取当前日期
     * @return String
     * @author zongf
     * @date 2019-12-14
     */
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

}
