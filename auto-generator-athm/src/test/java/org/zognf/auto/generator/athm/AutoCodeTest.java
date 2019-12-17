package org.zognf.auto.generator.athm;

import org.junit.Before;
import org.junit.Test;
import org.zongf.auto.generator.athm.config.GeneratorConfig;
import org.zongf.auto.generator.athm.utils.AthmCodeGenerator;
import org.zongf.db.meta.mysql.config.DbConfig;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class AutoCodeTest {

    private GeneratorConfig generatorConfig;

    private AthmCodeGenerator codeCreator;


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
        generatorConfig.setProjectPath("/workspace/zongf/codes-generator/auto-generator-athm");
        generatorConfig.setEntityPackage("org.zongf.auto.generator.athm.auto");
        generatorConfig.setMapperApiPackage("org.zongf.auto.generator.athm.auto");
        generatorConfig.setMapperXmlPath("src/main/resources/mappers");

        // 创建代码生成器
        codeCreator = new AthmCodeGenerator(generatorConfig);
    }


    @Test
    public void createAll(){
        String schemaName = "codes-generator";
        String tableName = "user";

        this.codeCreator.generateEntityClass(schemaName, tableName);
        this.codeCreator.generateMapperApiClass(schemaName, tableName);
        this.codeCreator.generateMapperXml(schemaName, tableName);
    }

    @Test
    public void createEntity(){
        codeCreator.generateEntityClass("codes-generator", "user");
    }


    @Test
    public void createMapper(){
        codeCreator.generateMapperApiClass("codes-generator", "user");
    }

    @Test
    public void createXml(){
        codeCreator.generateMapperXml("codes-generator", "user");
    }


}
