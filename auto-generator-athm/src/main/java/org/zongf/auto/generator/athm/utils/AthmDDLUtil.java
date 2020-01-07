package org.zongf.auto.generator.athm.utils;

import org.apache.poi.ss.usermodel.*;
import org.zongf.auto.generator.athm.validate.DDLValidateUtil;
import org.zongf.auto.generator.athm.vo.ddl.ColumnDefineInfo;
import org.zongf.auto.generator.athm.vo.ddl.DDLExcelTitleEnum;
import org.zongf.auto.generator.athm.vo.ddl.TableDefineVO;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AthmDDLUtil {


    /** 解析表数据
     * @param excelPath excel 文件路径
     * @return List<TableInfo>
     * @author zongf
     * @date 2019-12-16
     */
    public static List<TableDefineVO> parseTables(String excelPath){

        // 创建excel 工作簿对象
        Workbook workbook = PoiUtil.getWorkBook(excelPath);

        // 获取sheet页, 一个Excel 工作簿可以包含多个sheet页
        Sheet sheet1 = workbook.getSheetAt(0);

        // 校验标题格式, 计算开始列的索引号
        int startColIdx = DDLValidateUtil.title(sheet1.getRow(0));

        // 表列表
        List<TableDefineVO> tableInfoList = new ArrayList<TableDefineVO>();

        TableDefineVO tableInfo = null;

        for (int i = 0; i < sheet1.getLastRowNum(); i++) {

            Row row = sheet1.getRow(i);

            // 获取当前行，有数据的列数
            int rowCols = getColNum(row);

            // 如果当前行没有数据, 则继续
            if(rowCols == 0) continue;

            // 第一行
            if (rowCols == 1) {     // 当行只有一列有数据时, 表示为表名
                if (tableInfo != null) {    // 如果tableInfo 不为null, 说明不是本次解析的第一个表.
                    tableInfoList.add(tableInfo);
                }
                tableInfo = new TableDefineVO();
                tableInfo.setColumnInfoList(new ArrayList<ColumnDefineInfo>());
                Cell cell = row.getCell(startColIdx);
                cell.setCellType(CellType.STRING);
                String[] array = cell.getStringCellValue().split(":");
                tableInfo.setComment(array[0].trim());
                tableInfo.setName(array[1].trim());
            }else {
                if (tableInfo != null) {
                    ColumnDefineInfo columnInfo = new ColumnDefineInfo();
                    columnInfo.setName(getStringVal(row, startColIdx + DDLExcelTitleEnum.columnName.ordinal()));
                    columnInfo.setType(handleSign(getStringVal(row, startColIdx + DDLExcelTitleEnum.columnType.ordinal())));
                    columnInfo.setComment(getStringVal(row, startColIdx + DDLExcelTitleEnum.columnDesc.ordinal()));
                    columnInfo.setDefaultValue(getStringVal(row, startColIdx + DDLExcelTitleEnum.defaultVal.ordinal()));
                    columnInfo.setNotNull(getBooleanVal(row, startColIdx + DDLExcelTitleEnum.isNotNull.ordinal()));
                    columnInfo.setUnique(getBooleanVal(row, startColIdx + DDLExcelTitleEnum.isUnique.ordinal()));
                    columnInfo.setPk(getBooleanVal(row, startColIdx + DDLExcelTitleEnum.isPK.ordinal()));
                    columnInfo.setAutoCreate(getBooleanVal(row, startColIdx + DDLExcelTitleEnum.isAutoCreate.ordinal()));
                    tableInfo.getColumnInfoList().add(columnInfo);
                }
            }
        }

        // 处理最后一个元素
        if (tableInfo != null) {
            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

    private static String handleSign(String str){
        return str.replace("（", "(").replace("）", ")");
    }



    /**获取String 型返回值
     * @param row 行
     * @param cellIdx 列序号
     * @return boolean
     * @author zongf
     * @date 2019-12-16
     */
    private static String getStringVal(Row row, int cellIdx) {
        Cell cell = row.getCell(cellIdx);
        if(cell ==null) return null;
        cell.setCellType(CellType.STRING);
        String value = cell.getStringCellValue();

        if(value !=null && !"".equals(value.trim())){
            return value.trim();
        }
        return null;
    }


    /**获取boolean 型返回值
     * @param row 行
     * @param cellIdx 列序号
     * @return boolean
     * @author zongf
     * @date 2019-12-16
     */
    private static boolean getBooleanVal(Row row, int cellIdx) {
        String cellVal = getStringVal(row, cellIdx);
        if (cellVal != null && "Y".equals(cellVal)) {
            return true;
        }
        return false;
    }

    // 获取不为空的列数
    private static int getColNum(Row row) {
        int num = 0;
        if(row == null) return 0;
        Iterator<Cell> iterator = row.iterator();
        while (iterator.hasNext()) {
            Cell cell = iterator.next();
            if (cell != null) {
                cell.setCellType(CellType.STRING);
                if (!"".equals(cell.getStringCellValue().trim())) {
                    num++;
                }
            }
        }
        return num;
    }

}
