package org.zongf.auto.generator.athm.generator;

import org.zongf.auto.generator.athm.config.ProjectConfig;
import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.auto.generator.athm.utils.CodeGenerateUtil;

/** Athm base-model 模块儿代码生成器
 * @author zongf
 * @date 2019-11-30
 */
public class AthmModelCodeGenerator extends AbsAthmCodeGenerator{

    public AthmModelCodeGenerator(ProjectConfig projectConfig, String schemaName, String tableName) {
        super(projectConfig, schemaName, tableName);
    }

    /** 生成Dto
     * @author zongf
     * @date 2019-12-13
     */
    public void generateDto(){
        this.generateCodeFile(FtlPathConstants.FTL_MODEL_DTO, this.projectConfig.getModelConfig().getDtoPackage(), "", "Dto.java");
    }

    /** 生成Query
     * @author zongf
     * @date 2019-12-13
     */
    public void generateQuery(){
        this.generateCodeFile(FtlPathConstants.FTL_MODEL_QUERY, this.projectConfig.getModelConfig().getQueryPackage(), "", "Query.java");
    }

    /** 生成代码
     * @param ftlName 模板
     * @param packageName 包名
     * @param fileNamePrefix  生成文件前缀
     * @param fileNameSuffix  生成文件后缀
     * @author zongf
     * @date 2019-12-14
     */
    private void generateCodeFile(String ftlName, String packageName, String fileNamePrefix, String fileNameSuffix){

        // 拼接文件路径
        StringBuffer filePathSb = new StringBuffer();

        // 拼接项目路径和模块儿路径
        filePathSb.append(this.projectConfig.getProjectDir())
                .append("/").append(this.projectConfig.getProjectName())
                .append("/").append(this.projectConfig.getModelConfig().getModuleName())
                .append("/src/main/java")
                .append("/").append(packageName.replace(".", "/"))
                .append("/").append(fileNamePrefix)
                .append(this.metaInfo.getName())
                .append(fileNameSuffix);

        // 生成代码
        CodeGenerateUtil.generateCode(projectConfig, this.metaInfo, ftlName, filePathSb.toString());
    }

}
