package org.zognf.auto.generator.athm;

import org.junit.Test;
import org.zongf.auto.generator.athm.utils.AthmDDLUtil;
import org.zongf.auto.generator.athm.vo.ddl.ColumnDefineInfo;
import org.zongf.auto.generator.athm.vo.ddl.TableDefineVO;
import org.zongf.auto.generator.utils.TemplateUtil;
import org.zongf.tools.common.utils.TxtFileUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 自动生成建表语句
 * @author zongf
 * @date 2019-11-30
 */
public class AutoDDLTest {

    // excel 表路径
    private String ddlExcelPath = "/home/zongf/Desktop/订单设计/订单表设计.xlsx";

    /** 解析excel 文件 */
    @Test
    public void parseExcel(){

        List<TableDefineVO> tableInfoList = AthmDDLUtil.parseTables(ddlExcelPath);

        for (TableDefineVO info : tableInfoList) {
            System.out.println(info.getName() + " : " + info.getComment());
            for (ColumnDefineInfo columnInfo : info.getColumnInfoList()) {
                System.out.println("\t" + columnInfo);
            }
        }
    }

    /** 生成ddl 建表语句 */
    @Test
    public void createDDL(){

        List<TableDefineVO> tableInfoList = AthmDDLUtil.parseTables(ddlExcelPath);

        Map<String, Object> map = new HashMap<>();
        map.put("tableInfoList", tableInfoList);

        String ddl = TemplateUtil.getTemplatContent("table-ddl.ftl", map);

        TxtFileUtil.writeFile(Arrays.asList(ddl), "target/order.sql");

    }
}