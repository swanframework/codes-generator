package org.zongf.auto.generator.athm.vo;

/** Athm 字段类型
 * @author zongf
 * @date 2019-11-30
 */
public class AthmColumn {

    // 名称
    private String name;

    // 类型
    private String type;

    // 注释
    private String comment;

    // 导入依赖
    private String importType;

	public AthmColumn() {
        super();
    }

	public AthmColumn(String name, String type, String comment, String importType) {
        super();
		this.name = name;
		this.type = type;
		this.comment = comment;
		this.importType = importType;
    }

    public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

    public void setType(String type){
		this.type=type;
	}

	public String getType(){
		return this.type;
	}

    public void setComment(String comment){
		this.comment=comment;
	}

	public String getComment(){
		return this.comment;
	}

    public void setImportType(String importType){
		this.importType=importType;
	}

	public String getImportType(){
		return this.importType;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {name:" + name + ", type:" + type + ", comment:" + comment + ", importType:" + importType  + "}";
	}

}
