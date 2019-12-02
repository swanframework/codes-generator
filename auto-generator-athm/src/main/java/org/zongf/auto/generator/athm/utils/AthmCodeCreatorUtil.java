package org.zongf.auto.generator.athm.utils;

import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.db.meta.mysql.utils.DbUtil;
import org.zongf.db.meta.mysql.utils.TemplateUtil;
import org.zongf.auto.generator.athm.vo.AthmPO;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** Athm 代码生成工具类
 * @author zongf
 * @date 2019-11-30
 */
public class AthmCodeCreatorUtil {

    /** 获取po 代码
     * @param schemaName    数据库名称
     * @param packageName   包名
     * @param poName        类名
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    public static String createPOCode(String schemaName, String packageName, String poName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        AthmPO athmPO = AthmMetaUtil.getAthmPO(connection, schemaName, packageName, poName);

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("po", athmPO);
        return TemplateUtil.getTemplatContent(FtlPathConstants.FTL_PO, dataMap);
    }

    /** 获取包含swagger 注释的po
     * @param schemaName    数据库名称
     * @param packageName   包名
     * @param poName        类名
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    public static String createPOSwaggerCode(String schemaName, String packageName, String poName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        AthmPO athmPO = AthmMetaUtil.getAthmPO(connection, schemaName, packageName, poName);

        // 添加swagger 依赖
        athmPO.getImports().add("io.swagger.annotations.ApiModelProperty");

        // 重新排序
        Collections.sort(athmPO.getImports());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("po", athmPO);
        return TemplateUtil.getTemplatContent(FtlPathConstants.FTL_PO_SWAGGER, dataMap);
    }

}
