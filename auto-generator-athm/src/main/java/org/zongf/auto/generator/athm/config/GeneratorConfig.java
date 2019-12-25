package org.zongf.auto.generator.athm.config;

/**
 * @author zongf
 * @date 2019-12-13
 */
public class GeneratorConfig {

    // 项目根路径
    private String projectDir;

    // 项目名称
    private String projectName;

    // entity 包名
    private String entityPackage;

    // 字段信息包名
    private String fieldEnumPackage;

    // vo 包名
    private String dtoPackage;

    // service 接口包名
    private String serviceApiPackage;

    // service 实现类包名
    private String serviceImplPackage;

    // mapper 接口包名
    private String mapperApiPackage;

    // mapper xml 路径
    private String mapperXmlPath;

    // controller 路径
    private String controllerPackage;
    
    // 查询条件类
    private String queryPackage;

    // 公司基本包名称
    private String companyBasePackage;

	public GeneratorConfig() {
        super();
    }

	public GeneratorConfig(String projectDir, String projectName, String entityPackage, String fieldEnumPackage, String dtoPackage, String serviceApiPackage, String serviceImplPackage, String mapperApiPackage, String mapperXmlPath, String controllerPackage, String queryPackage, String companyBasePackage) {
        super();
		this.projectDir = projectDir;
		this.projectName = projectName;
		this.entityPackage = entityPackage;
		this.fieldEnumPackage = fieldEnumPackage;
		this.dtoPackage = dtoPackage;
		this.serviceApiPackage = serviceApiPackage;
		this.serviceImplPackage = serviceImplPackage;
		this.mapperApiPackage = mapperApiPackage;
		this.mapperXmlPath = mapperXmlPath;
		this.controllerPackage = controllerPackage;
		this.queryPackage = queryPackage;
		this.companyBasePackage = companyBasePackage;
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

    public void setEntityPackage(String entityPackage){
		this.entityPackage=entityPackage;
	}

	public String getEntityPackage(){
		return this.entityPackage;
	}

    public void setFieldEnumPackage(String fieldEnumPackage){
		this.fieldEnumPackage=fieldEnumPackage;
	}

	public String getFieldEnumPackage(){
		return this.fieldEnumPackage;
	}

    public void setDtoPackage(String dtoPackage){
		this.dtoPackage=dtoPackage;
	}

	public String getDtoPackage(){
		return this.dtoPackage;
	}

    public void setServiceApiPackage(String serviceApiPackage){
		this.serviceApiPackage=serviceApiPackage;
	}

	public String getServiceApiPackage(){
		return this.serviceApiPackage;
	}

    public void setServiceImplPackage(String serviceImplPackage){
		this.serviceImplPackage=serviceImplPackage;
	}

	public String getServiceImplPackage(){
		return this.serviceImplPackage;
	}

    public void setMapperApiPackage(String mapperApiPackage){
		this.mapperApiPackage=mapperApiPackage;
	}

	public String getMapperApiPackage(){
		return this.mapperApiPackage;
	}

    public void setMapperXmlPath(String mapperXmlPath){
		this.mapperXmlPath=mapperXmlPath;
	}

	public String getMapperXmlPath(){
		return this.mapperXmlPath;
	}

    public void setControllerPackage(String controllerPackage){
		this.controllerPackage=controllerPackage;
	}

	public String getControllerPackage(){
		return this.controllerPackage;
	}

    public void setQueryPackage(String queryPackage){
		this.queryPackage=queryPackage;
	}

	public String getQueryPackage(){
		return this.queryPackage;
	}

    public void setCompanyBasePackage(String companyBasePackage){
		this.companyBasePackage=companyBasePackage;
	}

	public String getCompanyBasePackage(){
		return this.companyBasePackage;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {projectDir:" + projectDir + ", projectName:" + projectName + ", entityPackage:" + entityPackage + ", fieldEnumPackage:" + fieldEnumPackage + ", dtoPackage:" + dtoPackage + ", serviceApiPackage:" + serviceApiPackage + ", serviceImplPackage:" + serviceImplPackage + ", mapperApiPackage:" + mapperApiPackage + ", mapperXmlPath:" + mapperXmlPath + ", controllerPackage:" + controllerPackage + ", queryPackage:" + queryPackage + ", companyBasePackage:" + companyBasePackage  + "}";
	}

}
