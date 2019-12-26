package org.zognf.auto.generator.athm;

import org.junit.Test;
import org.zongf.auto.generator.athm.utils.AthmDDLUtil;
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
public class AthmDDLTest {

    // excel 表路径
    private String ddlExcelPath = ".xlsx";


    /** 生成ddl 建表语句 */
    @Test
    public void createDDL(){

        List<TableDefineVO> tableInfoList = AthmDDLUtil.parseTables(ddlExcelPath);

        Map<String, Object> map = new HashMap<>();
        map.put("tableInfoList", tableInfoList);

        String ddl = TemplateUtil.getTemplatContent("table-ddl.ftl", map);

        TxtFileUtil.writeFile(Arrays.asList(ddl), "tables.sql");

        System.out.println("*********************************************************************************************");
        System.out.println("*                                                                                           *");
        System.out.println("*                            DDL SQL CREATE SUUCESSED                                       *");
        System.out.println("*                                                                                           *");
        System.out.println("*********************************************************************************************");
        System.out.println(ddl);

    }

}
