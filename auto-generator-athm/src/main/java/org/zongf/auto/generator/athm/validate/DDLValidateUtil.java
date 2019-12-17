package org.zongf.auto.generator.athm.validate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.zongf.auto.generator.athm.vo.ddl.DDLExcelTitleEnum;

public class DDLValidateUtil {

    public static int title(Row row){
        short startIndex = row.getFirstCellNum();

        for (DDLExcelTitleEnum titleEnum : DDLExcelTitleEnum.values()) {

            Cell cell = row.getCell(startIndex + titleEnum.ordinal());

            if (cell == null || !titleEnum.getText().equals(cell.getStringCellValue())) {

                StringBuffer errorSb = new StringBuffer();

                errorSb.append("Excel 标题行(第1行) 不正确：")
                        .append("第").append(startIndex + titleEnum.ordinal() + 1).append("列, ")
                        .append("期望值:").append(titleEnum.getText())
                        .append("实际值:").append(cell.getStringCellValue());

                throw new RuntimeException(errorSb.toString());
            }

        }
        return startIndex;
    }

}
