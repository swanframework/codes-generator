package org.zongf.auto.generator.vo;
import org.zongf.db.meta.mysql.po.vo.FieldVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class ClassMetaVO {
    // 包名称
    private String packageName;

    // 依赖类
    private List<String> imports = new ArrayList<>();

    // po 名称
    private String name;

    // 注释
    private String comment;

    // 字段列表
    private List<FieldVO> columns = new ArrayList<>();

    // 日期
    private String createDate;

	public ClassMetaVO() {
        super();
    }

	public ClassMetaVO(String packageName, List<String> imports, String name, String comment, List<FieldVO> columns, String createDate) {
        super();
		this.packageName = packageName;
		this.imports = imports;
		this.name = name;
		this.comment = comment;
		this.columns = columns;
		this.createDate = createDate;
    }

    public void setPackageName(String packageName){
		this.packageName=packageName;
	}

	public String getPackageName(){
		return this.packageName;
	}

    public void setImports(List<String> imports){
		this.imports=imports;
	}

	public List<String> getImports(){
		return this.imports;
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

    public void setColumns(List<FieldVO> columns){
		this.columns=columns;
	}

	public List<FieldVO> getColumns(){
		return this.columns;
	}

    public void setCreateDate(String createDate){
		this.createDate=createDate;
	}

	public String getCreateDate(){
		return this.createDate;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {packageName:" + packageName + ", imports:" + imports + ", name:" + name + ", comment:" + comment + ", columns:" + columns + ", createDate:" + createDate  + "}";
	}

}
