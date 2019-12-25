package org.zongf.auto.generator.athm.config;

/** base model 摸块儿配置
 * @author zongf
 * @date 2019-12-25
 */
public class ModelConfig {

	// 模块儿名称
	private String moduleName;

    // dto 包名
    private String dtoPackage;

    // query 包名
    private String queryPackage;

	public ModelConfig() {
        super();
    }

	public ModelConfig(String moduleName, String dtoPackage, String queryPackage) {
        super();
		this.moduleName = moduleName;
		this.dtoPackage = dtoPackage;
		this.queryPackage = queryPackage;
    }

    public void setModuleName(String moduleName){
		this.moduleName=moduleName;
	}

	public String getModuleName(){
		return this.moduleName;
	}

    public void setDtoPackage(String dtoPackage){
		this.dtoPackage=dtoPackage;
	}

	public String getDtoPackage(){
		return this.dtoPackage;
	}

    public void setQueryPackage(String queryPackage){
		this.queryPackage=queryPackage;
	}

	public String getQueryPackage(){
		return this.queryPackage;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {moduleName:" + moduleName + ", dtoPackage:" + dtoPackage + ", queryPackage:" + queryPackage  + "}";
	}

}
