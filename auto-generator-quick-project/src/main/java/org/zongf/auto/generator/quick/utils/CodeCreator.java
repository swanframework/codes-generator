package org.zongf.auto.generator.quick.utils;

import org.zongf.auto.generator.quick.config.GeneratorConfig;
import org.zongf.auto.generator.quick.constants.FtlPathConstants;
import org.zongf.auto.generator.utils.ClassMetaUtil;
import org.zongf.auto.generator.vo.ClassMetaVO;
import org.zongf.db.meta.mysql.utils.DbUtil;
import org.zongf.db.meta.mysql.utils.TemplateUtil;
import org.zongf.tools.common.utils.TxtFileUtil;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Athm 代码生成工具类
 * @author zongf
 * @date 2019-11-30
 */
public class CodeCreator {

    private final GeneratorConfig generatorConfig;

    public CodeCreator(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    /** 生成Entity代码
     * @param schemaName
     * @param tableName
     * @author zongf
     * @date 2019-12-13
     */
    public void createEntity(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getEntityPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_ENTITY, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
            .append("/src/main/java")
            .append("/").append(generatorConfig.getEntityPackage().replace(".", "/"))
            .append("/").append(classMetaVO.getName())
            .append("Entity.java");

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }


    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createFieldEnum(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getFieldEnumPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_FIELD_ENUM, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/src/main/java")
                .append("/").append(generatorConfig.getFieldEnumPackage().replace(".", "/"))
                .append("/").append(classMetaVO.getName())
                .append("FieldEnum.java");

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }

    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createMapperJava(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getMapperApiPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);
        dataMap.put("config", generatorConfig);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_MAPPER_API, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/src/main/java")
                .append("/").append(generatorConfig.getMapperApiPackage().replace(".", "/"))
                .append("/").append(classMetaVO.getName())
                .append("Mapper.java");

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }

    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createMapperXml(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getMapperApiPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);
        dataMap.put("config", generatorConfig);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_MAPPER_XML, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/").append(generatorConfig.getMapperXmlPath().replace(".", "/"))
                .append("/").append(classMetaVO.getName())
                .append("Mapper.xml");

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }


    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createServiceApi(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getServiceApiPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);
        dataMap.put("config", generatorConfig);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_SERVICE_API, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/src/main/java")
                .append("/").append(generatorConfig.getServiceApiPackage().replace(".", "/"))
                .append("/I").append(classMetaVO.getName())
                .append("Service.java");

        System.out.println(codes);

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }

    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createServiceImpl(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getServiceImplPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);
        dataMap.put("config", generatorConfig);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_SERVICE_IMPL, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/src/main/java")
                .append("/").append(generatorConfig.getServiceImplPackage().replace(".", "/"))
                .append("/").append(classMetaVO.getName())
                .append("Service.java");

        System.out.println(codes);

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }


    /** 创建表字段映射类
     * @param schemaName 数据库名
     * @param tableName 表名
     * @author zongf
     * @date 2019-12-13
     */
    public void createController(String schemaName, String tableName){

        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        ClassMetaVO classMetaVO = ClassMetaUtil.getClassMetaVO(connection, schemaName, tableName, generatorConfig.getControllerPackage());

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", classMetaVO);
        dataMap.put("config", generatorConfig);

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(FtlPathConstants.FTL_CONTROLLER, dataMap);

        StringBuffer filePathSb = new StringBuffer();
        filePathSb.append(generatorConfig.getProjectPath())
                .append("/src/main/java")
                .append("/").append(generatorConfig.getControllerPackage().replace(".", "/"))
                .append("/").append(classMetaVO.getName())
                .append("Controller.java");

        System.out.println(codes);

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePathSb.toString());
    }

}
