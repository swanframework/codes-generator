package org.zongf.auto.generator.athm.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.auto.generator.athm.vo.third.ThirdClassInfo;
import org.zongf.auto.generator.athm.vo.third.ThirdFieldInfo;
import org.zongf.auto.generator.utils.TemplateUtil;
import org.zongf.tools.common.utils.TxtFileUtil;

import java.util.*;

/** 第三方请求响应类工具
 * @author zongf
 * @date 2020-01-07
 */
public class ThirdBeansUtil {

    /** 解析文件
     * @param excelFilePath
     * @param targetDir 生成目录
     * @author zongf
     * @date 2020-01-07
     */
    public static void parse(String excelFilePath, String targetDir) {
        // 创建excel 工作簿对象
        Workbook workbook = PoiUtil.getWorkBook(excelFilePath);

        // 获取sheet页, 一个Excel 工作簿可以包含多个sheet页
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();

        // 解析sheet页为bean 信息
        List<ThirdClassInfo> thirdClassInfoList = new ArrayList<>();
        sheetIterator.forEachRemaining(sheet -> thirdClassInfoList.add(parseClassInfo(sheet)));

        // 生成代码
        for (ThirdClassInfo classInfo : thirdClassInfoList) {
            String code = getTemplateCode(classInfo, FtlPathConstants.FTL_THIRD_BEAN);

            TxtFileUtil.writeFile(Arrays.asList(code), targetDir + "/" + classInfo.getClassName() + ".java");
        }
    }

    /** 将excel sheet页解析为第三方Bean信息
     * @param sheet excel sheet页面
     * @return ThirdClassInfo
     * @author zongf
     * @date 2020-01-07
     */
    private static ThirdClassInfo parseClassInfo(Sheet sheet) {
        ThirdClassInfo classInfo = new ThirdClassInfo();

        // 解析类名
        classInfo.setClassName(StringUtil.camelCase(sheet.getSheetName().trim()));

        // 解析字段
        List<String[]> arrayList = parseSheet(sheet);

        for (String[] array : arrayList) {
            // 解析行内容
            ThirdFieldInfo thirdFieldInfo =  parse(array);

            classInfo.getFieldList().add(thirdFieldInfo);
        }
        return classInfo;
    }

    /** 解析excel 行为响应行
     * @param array
     * @return ThirdFieldRequestInfo
     * @author zongf
     * @date 2020-01-07
     */
    private static ThirdFieldInfo parse(String[] array) {
        ThirdFieldInfo thirdFieldInfo = new ThirdFieldInfo();
        thirdFieldInfo.setFieldName(StringUtil.camelCase(array[0].trim()));
        thirdFieldInfo.setFieldType(array[1].trim().replaceAll("_",""));
        thirdFieldInfo.setComment(array[2].trim());
        if (array.length > 3) {
            if ("YES".equalsIgnoreCase(array[3].trim()) || "是".equals(array[3].trim())) {
                thirdFieldInfo.setRequired("true");
            }
        }

        return thirdFieldInfo;
    }


    /** 获取模板代码
     * @param thirdClassInfo 类信息
     * @param templatPath 模板路径
     * @return String
     * @author zongf
     * @date 2020-01-07
     */
    private static String getTemplateCode(ThirdClassInfo thirdClassInfo, String templatPath) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("classInfo", thirdClassInfo);
        map.put("createDate", DateUtil.getCurrentDate());

        return TemplateUtil.getTemplatContent(templatPath, map);
    }

    /** 是否是合并行。 如果返回值为null 则表示为非合并行, 否则表示为合并行
     * @param sheet
     * @param rowNum 行号
     * @return CellRangeAddress
     * @author zongf
     * @date 2020-01-07
     */
    public static CellRangeAddress isMergedRow(Sheet sheet, int rowNum){
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
            if (rowNum == mergedRegion.getFirstRow()) {
                return mergedRegion;
            }
        }
        return null;
    }

    /** 判断第一个单元格是否为空
     * @param row 行
     * @return boolean
     * @author zongf
     * @date 2020-01-07
     */
    public static boolean isFirstColumnNotEmpty(Row row) {
        Cell cell = row.getCell(0);
        if (cell != null) {
            if (null != cell.getStringCellValue() && !"".equals(cell.getStringCellValue())) {
                return true;
            }
        }
        return false;
    }

    /** 解析sheet页面为二维数组
     * @param sheet
     * @return List<String[]>
     * @author zongf
     * @date 2020-01-07
     */
    private static List<String[]> parseSheet(Sheet sheet) {

        List<String[]> arrayList = new ArrayList<>();

        // 解析行
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // 获取行信息
            Row row = sheet.getRow(i);

            // 如果第一列为空, 则跳过循环
            if(row == null || !isFirstColumnNotEmpty(row)) continue;

            // 是否是混合行
            CellRangeAddress mergedRow = isMergedRow(sheet, i);

            String[] array = new String[row.getLastCellNum()];

            // 如果mergedRow 不为空, 则表示为混合行
            if (mergedRow != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    StringBuffer sb = new StringBuffer();
                    for (int k = mergedRow.getFirstRow(); k <= mergedRow.getLastRow(); k++) {
                        sb.append(sheet.getRow(k).getCell(j).getStringCellValue()).append(" ");
                    }
                    array[j] = sb.toString();
                }
                // 修改行号，跳过混合行
                i += mergedRow.getLastRow();
            }else {
                short lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    array[j] = row.getCell(j).getStringCellValue();
                }
            }
            arrayList.add(array);
        }

        return arrayList;
    }


}
