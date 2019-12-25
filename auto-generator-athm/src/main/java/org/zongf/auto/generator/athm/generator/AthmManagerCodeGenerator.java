package org.zongf.auto.generator.athm.generator;

import org.zongf.auto.generator.athm.config.ProjectConfig;
import org.zongf.auto.generator.athm.constants.FtlPathConstants;
import org.zongf.auto.generator.athm.utils.CodeGenerateUtil;

/** Athm manager 代码生成器
 * @author zongf
 * @date 2019-11-30
 */
public class AthmManagerCodeGenerator extends AbsAthmCodeGenerator{

    public AthmManagerCodeGenerator(ProjectConfig projectConfig, String schemaName, String tableName) {
       super(projectConfig, schemaName, tableName);
    }

    /** 生成controller 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateController(){
        this.generateCodeFile(FtlPathConstants.FTL_MANAGER_CONTROLLER, this.projectConfig.getManagerConfig().getControllerPackage(), "", "Controller.java");
    }

    /** 生成service 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateServiceApi(){
        this.generateCodeFile(FtlPathConstants.FTL_MANAGER_SERVICE_API, this.projectConfig.getManagerConfig().getServiceApiPackage(), "I", "Service.java");
    }

    /** 生成service 实现类
     * @author zongf
     * @date 2019-12-13
     */
    public void generateServiceImpl(){
        this.generateCodeFile(FtlPathConstants.FTL_MANAGER_SERVICE_IMPL, this.projectConfig.getManagerConfig().getServiceImplPackage(), "", "ServiceImpl.java");
    }

    /** 生成remote service 接口
     * @author zongf
     * @date 2019-12-13
     */
    public void generateRemoteServiceApi(){
        this.generateCodeFile(FtlPathConstants.FTL_MANAGER_REMOTE_SERVICE_API, this.projectConfig.getManagerConfig().getRemoteServiceApiPackage(), "I", "RemoteService.java");
    }

    /** 生成remote service 实现类
     * @author zongf
     * @date 2019-12-13
     */
    public void generateRemoteServiceImpl(){
        this.generateCodeFile(FtlPathConstants.FTL_MANAGER_REMOTE_SERVICE_IMPL, this.projectConfig.getManagerConfig().getRemoteServiceImplPackage(), "", "RemoteServiceImpl.java");
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
                .append("/").append(this.projectConfig.getManagerConfig().getModuleName())
                .append("/src/main/java")
                .append("/").append(packageName.replace(".", "/"))
                .append("/").append(fileNamePrefix)
                .append(this.metaInfo.getName())
                .append(fileNameSuffix);

        // 生成代码
        CodeGenerateUtil.generateCode(projectConfig, this.metaInfo, ftlName, filePathSb.toString());
    }

}
