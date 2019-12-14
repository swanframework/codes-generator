package org.zongf.auto.generator.quick;

import org.junit.Before;
import org.junit.Test;
import org.zongf.auto.generator.quick.config.GeneratorConfig;
import org.zongf.auto.generator.quick.utils.CodeCreator;
import org.zongf.db.meta.mysql.config.DbConfig;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class AutoCodeTest {

    private GeneratorConfig generatorConfig;

    private CodeCreator codeCreator;


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

        // 创建代码生成器
        codeCreator = new CodeCreator(generatorConfig);
    }

    @Test
    public void createEntity(){
        codeCreator.createEntity("codes-generator", "user");
    }

    @Test
    public void createFieldEnum(){
        codeCreator.createFieldEnum("codes-generator", "user");
    }

    @Test
    public void createMapper(){
        codeCreator.createMapperJava("codes-generator", "user");
    }

    @Test
    public void createXml(){
        codeCreator.createMapperXml("codes-generator", "user");
    }


}
