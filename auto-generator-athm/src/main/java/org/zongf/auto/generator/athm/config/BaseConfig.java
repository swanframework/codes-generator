package org.zongf.auto.generator.athm.config;

/** base service 模块儿配置
 * @author zongf
 * @date 2019-12-25
 */
public class BaseConfig {

	// 模块儿名称
	private String moduleName;

    // entity 包名
    private String entityPackage;

    // mapper 接口包名
    private String mapperApiPackage;

    // mapper xml 路径
    private String mapperXmlPath;

    // service 接口包名
    private String serviceApiPackage;

    // service 实现类包名
    private String serviceImplPackage;

    // controller 路径
    private String controllerPackage;

	public BaseConfig() {
        super();
    }

	public BaseConfig(String moduleName, String entityPackage, String mapperApiPackage, String mapperXmlPath, String serviceApiPackage, String serviceImplPackage, String controllerPackage) {
        super();
		this.moduleName = moduleName;
		this.entityPackage = entityPackage;
		this.mapperApiPackage = mapperApiPackage;
		this.mapperXmlPath = mapperXmlPath;
		this.serviceApiPackage = serviceApiPackage;
		this.serviceImplPackage = serviceImplPackage;
		this.controllerPackage = controllerPackage;
    }

    public void setModuleName(String moduleName){
		this.moduleName=moduleName;
	}

	public String getModuleName(){
		return this.moduleName;
	}

    public void setEntityPackage(String entityPackage){
		this.entityPackage=entityPackage;
	}

	public String getEntityPackage(){
		return this.entityPackage;
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

    public void setControllerPackage(String controllerPackage){
		this.controllerPackage=controllerPackage;
	}

	public String getControllerPackage(){
		return this.controllerPackage;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {moduleName:" + moduleName + ", entityPackage:" + entityPackage + ", mapperApiPackage:" + mapperApiPackage + ", mapperXmlPath:" + mapperXmlPath + ", serviceApiPackage:" + serviceApiPackage + ", serviceImplPackage:" + serviceImplPackage + ", controllerPackage:" + controllerPackage  + "}";
	}

}
