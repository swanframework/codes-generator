package org.zongf.auto.generator.athm.utils;

import org.zongf.auto.generator.athm.config.ProjectConfig;
import org.zongf.auto.generator.utils.TemplateUtil;
import org.zongf.auto.generator.vo.EntityMetaInfo;
import org.zongf.tools.common.utils.TxtFileUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 代码自动生成工具类
 * @author zongf
 * @date 2019-12-25
 */
public class CodeGenerateUtil {

    /** 生成代码
     * @param config 配置
     * @param entityMetaInfo 实体信息
     * @param ftlName 模板名称
     * @param filePath 生成文件路径
     * @author zongf
     * @date 2019-12-25
     */
    public static void generateCode(ProjectConfig config, EntityMetaInfo entityMetaInfo, String ftlName, String filePath) {

        // 根据模板生成代码
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("meta", entityMetaInfo);
        dataMap.put("config", config);
        dataMap.put("createDate", DateUtil.getCurrentDate());

        // 生成代码
        String codes = TemplateUtil.getTemplatContent(ftlName, dataMap);

        // 写入文件
        TxtFileUtil.writeFile(Arrays.asList(codes), filePath);

        System.out.println("文件已生成:" + filePath);
    }



}
