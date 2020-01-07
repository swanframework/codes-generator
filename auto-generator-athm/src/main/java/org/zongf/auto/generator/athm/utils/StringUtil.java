package org.zongf.auto.generator.athm.utils;

/** 字符串工具类
 * @author zongf
 * @date 2020-01-07
 */
public class StringUtil {

    /** 驼峰命名变量
     * @param str
     * @return String
     * @author zongf
     * @date 2020-01-07
     */
    public static String camelCase(String str) {

        if (str == null || "".equals(str.trim())) {
            return null;
        }

        // 分割字符串
        String[] array = str.split("_");

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            String item = array[i];
            if (item.length() > 1) {
                sb.append(item.substring(0, 1).toUpperCase()).append(item.substring(1));
            }else {
                sb.append(item.toUpperCase());
            }
        }
        return sb.toString();

    }
}
