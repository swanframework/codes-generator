package org.zongf.auto.generator.vo;
import org.zongf.db.meta.mysql.po.vo.FieldVO;

import java.util.ArrayList;
import java.util.List;

/** 实体映射信息
 * @author zongf
 * @date 2019-11-30
 */
public class EntityMetaInfo {

	// 类名称
	private String name;

    // 表名称
    private String tableName;

    // 注释
    private String comment;

    // 属性列表
    private List<FieldVO> fields = new ArrayList<>();

	// 依赖类
	private List<String> imports = new ArrayList<>();

	public EntityMetaInfo() {
        super();
    }

	public EntityMetaInfo(List<String> imports, String tableName, String name, String comment, List<FieldVO> fields) {
        super();
		this.imports = imports;
		this.tableName = tableName;
		this.name = name;
		this.comment = comment;
		this.fields = fields;
    }

    public void setImports(List<String> imports){
		this.imports=imports;
	}

	public List<String> getImports(){
		return this.imports;
	}

    public void setTableName(String tableName){
		this.tableName=tableName;
	}

	public String getTableName(){
		return this.tableName;
	}

    public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

    public void setComment(String comment){
		this.comment=comment;
	}

	public String getComment(){
		return this.comment;
	}

    public void setFields(List<FieldVO> fields){
		this.fields=fields;
	}

	public List<FieldVO> getFields(){
		return this.fields;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {imports:" + imports + ", tableName:" + tableName + ", name:" + name + ", comment:" + comment + ", fields:" + fields  + "}";
	}

}
