package org.zongf.auto.generator.quick.config;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/** 内置字段
 * @author zongf
 * @date 2020-02-27
 */
public class BuildInColumnConfig {

    // 物理主键字段名
    private String id;

    // 版本号字段名
    private String version;

    // 创建时间字段名
    private String createdTime;

    // 修改时间字段名
    private String modifiedTime;

	public List<String> getBuildInColumnNames(){
		return Arrays.asList(id, version, createdTime, modifiedTime);
	}

	public BuildInColumnConfig() {
        super();
    }

	public BuildInColumnConfig(String id, String version, String createdTime, String modifiedTime) {
        super();
		this.id = id;
		this.version = version;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
    }

    public void setId(String id){
		this.id=id;
	}

	public String getId(){
		return this.id;
	}

    public void setVersion(String version){
		this.version=version;
	}

	public String getVersion(){
		return this.version;
	}

    public void setCreatedTime(String createdTime){
		this.createdTime=createdTime;
	}

	public String getCreatedTime(){
		return this.createdTime;
	}

    public void setModifiedTime(String modifiedTime){
		this.modifiedTime=modifiedTime;
	}

	public String getModifiedTime(){
		return this.modifiedTime;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {id:" + id + ", version:" + version + ", createdTime:" + createdTime + ", modifiedTime:" + modifiedTime  + "}";
	}

}
