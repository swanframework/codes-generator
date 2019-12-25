package org.zongf.auto.generator.athm.generator;

import org.zongf.auto.generator.athm.config.ProjectConfig;
import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.auto.generator.athm.utils.CodeGenerateUtil;

/** Athm 代码生成工具类
 * @author zongf
 * @date 2019-11-30
 */
public class AthmBaseCodeGenerator extends AbsAthmCodeGenerator{

    public AthmBaseCodeGenerator(ProjectConfig projectConfig, String schemaName, String tableName) {
       super(projectConfig, schemaName, tableName);
    }

    /** 生成controller 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseController(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_CONTROLLER, this.projectConfig.getBaseConfig().getControllerPackage(), "", "Controller.java");
    }

    /** 生成service 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseServiceApi(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_SERVICE_API, this.projectConfig.getBaseConfig().getServiceApiPackage(), "I", "Service.java");
    }

    /** 生成service 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseServiceImpl(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_SERVICE_IMPL, this.projectConfig.getBaseConfig().getServiceImplPackage(), "", "ServiceImpl.java");
    }

    /** 生成Entity 类
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseEntityClass(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_PO, this.projectConfig.getBaseConfig().getEntityPackage(), "", ".java");
    }

    /** 生成mapper 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseMapperApiClass(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_MAPPER_API, this.projectConfig.getBaseConfig().getMapperApiPackage(), "", "Mapper.java");
    }

    /** 生成mapper 映射文件
     * @author zongf
     * @date 2019-12-13
     */
    public void generateBaseMapperXml(){
        this.generateCodeFile(FtlPathConstants.FTL_BASE_MAPPER_IMPL, this.projectConfig.getBaseConfig().getMapperXmlPath(), "", "Mapper.xml");
    }


    /** 生成代码
     * @param ftlName 模板
     * @param packageName 包名
     * @param fileNamePrefix  生成文件前缀
     * @param fileNameSuffix  生成文件后缀
     * @author zongf
     * @date 2019-12-14
     */
    private void generateCodeFile(String ftlName,String packageName, String fileNamePrefix, String fileNameSuffix){

        // 拼接文件路径
        StringBuffer filePathSb = new StringBuffer();

        // 拼接项目路径和模块儿路径
        filePathSb.append(this.projectConfig.getProjectDir())
                .append("/").append(this.projectConfig.getProjectName())
                .append("/").append(this.projectConfig.getBaseConfig().getModuleName());

        // 如果不是mapper.xml文件, 则需追加路径
        if(!FtlPathConstants.FTL_BASE_MAPPER_IMPL.equals(ftlName)) filePathSb.append("/src/main/java");

        // 拼接文件名
        filePathSb.append("/").append(packageName.replace(".", "/"))
                .append("/").append(fileNamePrefix).append(this.metaInfo.getName()).append(fileNameSuffix);

        // 生成代码
        CodeGenerateUtil.generateCode(projectConfig, this.metaInfo, ftlName, filePathSb.toString());
    }

}
