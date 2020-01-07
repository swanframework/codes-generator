package org.zongf.auto.generator.athm.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

/** POI 工具类
 * @author zongf
 * @date 2020-01-07
 */
public class PoiUtil {

    /** 获取工作簿
     * @param excelPath excel 路径
     * @return Workbook 工作簿
     * @author zongf
     * @date 2019-12-16
     */
    public static Workbook getWorkBook(String excelPath) {
        try {
            return WorkbookFactory.create(new File(excelPath));
        } catch (Exception ex) {
            throw new RuntimeException("读取文件:" + excelPath + "失败!", ex);
        }
    }
}
