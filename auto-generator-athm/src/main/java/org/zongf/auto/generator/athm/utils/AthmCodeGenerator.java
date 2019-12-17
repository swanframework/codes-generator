package org.zongf.auto.generator.athm.utils;

import org.zongf.auto.generator.athm.config.GeneratorConfig;
import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.auto.generator.utils.EntityMetaUtil;
import org.zongf.auto.generator.utils.TemplateUtil;
import org.zongf.auto.generator.vo.EntityMetaInfo;
import org.zongf.db.meta.mysql.utils.DbUtil;
import org.zongf.tools.common.utils.TxtFileUtil;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** Athm 代码生成工具类
 * @author zongf
 * @date 2019-11-30
 */
public class AthmCodeGenerator {

    private final GeneratorConfig generatorConfig;

    public AthmCodeGenerator(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    /** 生成Entity 类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void generateEntityClass(String schemaName, String tableName){
        this.generateCodeFile(schemaName, tableName, FtlPathConstants.FTL_PO, generatorConfig.getEntityPackage(), "", ".java");
    }

    /** 生成mapper 接口
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void generateMapperApiClass(String schemaName, String tableName){
        this.generateCodeFile(schemaName, tableName, FtlPathConstants.FTL_MAPPER_API, generatorConfig.getMapperApiPackage(), "", "Mapper.java");
    }

    /** 生成mapper 映射文件
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void generateMapperXml(String schemaName, String tableName){
        this.generateCodeFile(schemaName, tableName, FtlPathConstants.FTL_MAPPER_IMPL, generatorConfig.getMapperXmlPath(), "", "Mapper.xml");
    }

    /** 生成代码
     * @param schemaName  数据库名称
     * @param tableName 表名
     * @param ftlName 模板
     * @param packageName 包名
     * @param fileNamePrefix  生成文件前缀
     * @param fileNameSuffix  生成文件后缀
     * @author zongf
     * @date 2019-12-14
     */
    private void generateCodeFile(String schemaName, String tableName, String ftlName, String packageName, String fileNamePrefix, String fileNameSuffix){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        EntityMetaInfo metaVO = EntityMetaUtil.queryEntityMetaInfo(connection, schemaName, tableName);

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", metaVO);
        dataMap.put("config", generatorConfig);
        dataMap.put("createDate", getCurrentDate());

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(ftlName, dataMap);

        StringBuffer filePathSb = new StringBuffer(generatorConfig.getProjectPath());

        // 如果不是mapper.xml文件, 则需追加路径
        if(!FtlPathConstants.FTL_MAPPER_IMPL.equals(ftlName)) filePathSb.append("/src/main/java");

        filePathSb.append("/").append(packageName.replace(".", "/"))
                .append("/").append(fileNamePrefix)
                .append(metaVO.getName()).append(fileNameSuffix);

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }

    /** 获取当前日期
     * @return String
     * @author zongf
     * @date 2019-12-14
     */
    private String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

}
