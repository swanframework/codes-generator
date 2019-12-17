package org.zongf.auto.generator.athm.config;

/**
 * @author zongf
 * @date 2019-12-13
 */
public class GeneratorConfig {

    // 项目根路径
    private String projectPath;

    // entity 包名
    private String entityPackage;

    // 字段信息包名
    private String fieldEnumPackage;

    // vo 包名
    private String voPackage;

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

	public GeneratorConfig() {
        super();
    }

	public GeneratorConfig(String projectPath, String entityPackage, String fieldEnumPackage, String voPackage, String serviceApiPackage, String serviceImplPackage, String mapperApiPackage, String mapperXmlPath, String controllerPackage) {
        super();
		this.projectPath = projectPath;
		this.entityPackage = entityPackage;
		this.fieldEnumPackage = fieldEnumPackage;
		this.voPackage = voPackage;
		this.serviceApiPackage = serviceApiPackage;
		this.serviceImplPackage = serviceImplPackage;
		this.mapperApiPackage = mapperApiPackage;
		this.mapperXmlPath = mapperXmlPath;
		this.controllerPackage = controllerPackage;
    }

    public void setProjectPath(String projectPath){
		this.projectPath=projectPath;
	}

	public String getProjectPath(){
		return this.projectPath;
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

    public void setVoPackage(String voPackage){
		this.voPackage=voPackage;
	}

	public String getVoPackage(){
		return this.voPackage;
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

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {projectPath:" + projectPath + ", entityPackage:" + entityPackage + ", fieldEnumPackage:" + fieldEnumPackage + ", voPackage:" + voPackage + ", serviceApiPackage:" + serviceApiPackage + ", serviceImplPackage:" + serviceImplPackage + ", mapperApiPackage:" + mapperApiPackage + ", mapperXmlPath:" + mapperXmlPath + ", controllerPackage:" + controllerPackage  + "}";
	}

}
