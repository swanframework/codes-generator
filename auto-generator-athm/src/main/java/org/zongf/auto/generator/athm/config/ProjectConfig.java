package org.zongf.auto.generator.athm.config;

/** 项目配置
 * @author zongf
 * @date 2019-12-25
 */
public class ProjectConfig {

    // 项目目录
    private String projectDir;

    // 项目名称
    private String projectName;

    // 公司框架包名称
    private String companyBasePackage;

    // base-model 配置
    private ModelConfig modelConfig = new ModelConfig();

    // base-service 配置
    private BaseConfig baseConfig = new BaseConfig();

    // open-service 配置
    private OpenConfig openConfig = new OpenConfig();

    // manager-service 配置
    private ManagerConfig managerConfig = new ManagerConfig();

	public ProjectConfig() {
        super();
    }

	public ProjectConfig(String projectDir, String projectName, String companyBasePackage, ModelConfig modelConfig, BaseConfig baseConfig, OpenConfig openConfig, ManagerConfig managerConfig) {
        super();
		this.projectDir = projectDir;
		this.projectName = projectName;
		this.companyBasePackage = companyBasePackage;
		this.modelConfig = modelConfig;
		this.baseConfig = baseConfig;
		this.openConfig = openConfig;
		this.managerConfig = managerConfig;
    }

    public void setProjectDir(String projectDir){
		this.projectDir=projectDir;
	}

	public String getProjectDir(){
		return this.projectDir;
	}

    public void setProjectName(String projectName){
		this.projectName=projectName;
	}

	public String getProjectName(){
		return this.projectName;
	}

    public void setCompanyBasePackage(String companyBasePackage){
		this.companyBasePackage=companyBasePackage;
	}

	public String getCompanyBasePackage(){
		return this.companyBasePackage;
	}

    public void setModelConfig(ModelConfig modelConfig){
		this.modelConfig=modelConfig;
	}

	public ModelConfig getModelConfig(){
		return this.modelConfig;
	}

    public void setBaseConfig(BaseConfig baseConfig){
		this.baseConfig=baseConfig;
	}

	public BaseConfig getBaseConfig(){
		return this.baseConfig;
	}

    public void setOpenConfig(OpenConfig openConfig){
		this.openConfig=openConfig;
	}

	public OpenConfig getOpenConfig(){
		return this.openConfig;
	}

    public void setManagerConfig(ManagerConfig managerConfig){
		this.managerConfig=managerConfig;
	}

	public ManagerConfig getManagerConfig(){
		return this.managerConfig;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {projectDir:" + projectDir + ", projectName:" + projectName + ", companyBasePackage:" + companyBasePackage + ", modelConfig:" + modelConfig + ", baseConfig:" + baseConfig + ", openConfig:" + openConfig + ", managerConfig:" + managerConfig  + "}";
	}

}
