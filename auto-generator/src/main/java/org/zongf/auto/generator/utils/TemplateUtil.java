package org.zongf.auto.generator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.zongf.db.meta.mysql.utils.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class TemplateUtil {

    // freemarker 模板配置
    private static Configuration cfgConfig;

    // ftl模板文件根目录
    private static final String FTL_ROOT_PATH ="/ftl";

    static {
        try {
            // 模板存放目录
            cfgConfig = new Configuration(Configuration.VERSION_2_3_22);
//            cfgConfig.setDirectoryForTemplateLoading(new File(FTL_ROOT_PATH));
            // 封装为jar包后,需要使用classLoader 方式加载jar包中的目标文件
            cfgConfig.setClassLoaderForTemplateLoading(TemplateUtil.class.getClassLoader(),FTL_ROOT_PATH);
            cfgConfig.setDefaultEncoding("UTF-8");  //设置编码为UTF-8
            cfgConfig.setNumberFormat("####");        //设置数字格式，默认三位数字用,号分割
        } catch (Exception ex) {
            System.out.println("Freemarker 引擎初始化错误  ");
            ex.printStackTrace();
        }
    }

    /**
     * 获取模板内容
     * @param templateRelativePath 模板相对路径
     * @param dataMap              数据map
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    public static String getTemplatContent(String templateRelativePath, Map<String, Object> dataMap) {
        ByteArrayOutputStream bos = null;
        OutputStreamWriter osw = null;
        try {
            // 加载模板
            Template template = cfgConfig.getTemplate(templateRelativePath);

            bos = new ByteArrayOutputStream();
            osw = new OutputStreamWriter(bos);
            template.process(dataMap, osw);
            osw.flush();
            return bos.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.close(bos, osw);
        }
        return null;
    }

}
