package org.zongf.auto.generator.quick;

import org.junit.Before;
import org.junit.Test;
import org.zongf.auto.generator.quick.config.GeneratorConfig;
import org.zongf.auto.generator.quick.utils.CodeGenerator;
import org.zongf.db.meta.mysql.config.DbConfig;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class AutoCodeTest {

    private GeneratorConfig generatorConfig;

    private CodeGenerator codeCreator;


    @Before
    public void setUp(){
        // 初始化数据库配置
        DbConfig dbConfig = DbConfig.getInstance();
        dbConfig.setHost("localhost");
        dbConfig.setPort(3306);
        dbConfig.setUsername("root");
        dbConfig.setPassword("root");

        // 初始化项目配置
        generatorConfig = new GeneratorConfig();
        generatorConfig.setProjectPath("/workspace/zongf/test-zongf-helper/test-mybatis-helper");
        generatorConfig.setEntityPackage("org.zongf.test.helper.mybatis.persistence.entity");
        generatorConfig.setFieldEnumPackage("org.zongf.test.helper.mybatis.persistence.enums");
        generatorConfig.setMapperApiPackage("org.zongf.test.helper.mybatis.persistence.mapper");
        generatorConfig.setMapperXmlPath("src/main/resources/mappers");
        generatorConfig.setServiceApiPackage("org.zongf.test.helper.mybatis.service.api");
        generatorConfig.setServiceImplPackage("org.zongf.test.helper.mybatis.service.impl");
        generatorConfig.setControllerPackage("org.zongf.test.helper.mybatis.controller");

        // 创建代码生成器
        codeCreator = new CodeGenerator(generatorConfig);
    }


    @Test
    public void createAll(){
        String schemaName = "";
        String tableName = "";

        this.codeCreator.generateEntityClass(schemaName, tableName);
        this.codeCreator.generateFieldEnumClass(schemaName, tableName);
        this.codeCreator.generateMapperApiClass(schemaName, tableName);
        this.codeCreator.generateMapperXml(schemaName, tableName);
        this.codeCreator.generateServiceApiClass(schemaName, tableName);
        this.codeCreator.generateServiceImplClass(schemaName, tableName);
        this.codeCreator.generateControllerClass(schemaName, tableName);
    }

    @Test
    public void createEntity(){
        codeCreator.generateEntityClass("codes-generator", "user");
    }

    @Test
    public void createFieldEnum(){
        codeCreator.generateFieldEnumClass("codes-generator", "user");
    }

    @Test
    public void createMapper(){
        codeCreator.generateMapperApiClass("codes-generator", "user");
    }

    @Test
    public void createXml(){
        codeCreator.generateMapperXml("codes-generator", "user");
    }

    @Test
    public void createServiceApi(){
        codeCreator.generateServiceApiClass("codes-generator", "user");
    }

    @Test
    public void createServiceImpl(){
        codeCreator.generateServiceImplClass("codes-generator", "user");
    }

    @Test
    public void createController(){
        codeCreator.generateControllerClass("codes-generator", "user");
    }


}
