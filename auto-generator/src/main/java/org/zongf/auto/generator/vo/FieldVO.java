package org.zongf.auto.generator.vo;

/** java 属性
 * @author zongf
 * @date 2019-11-30
 */
public class FieldVO {

    // 名称
    private String name;

    // 类型
    private String type;

    // 注释
    private String comment;

    // 导入依赖
    private String importType;
    
    // 列名
    private String columnName;

	// jdbc类型
	private String jdbcType;

    // 是否是主键列
    private boolean pkColumn;

	public FieldVO() {
        super();
    }

	public FieldVO(String name, String type, String jdbcType, String comment, String importType, String columnName, boolean pkColumn) {
        super();
		this.name = name;
		this.type = type;
		this.jdbcType = jdbcType;
		this.comment = comment;
		this.importType = importType;
		this.columnName = columnName;
		this.pkColumn = pkColumn;
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

    public void setJdbcType(String jdbcType){
		this.jdbcType=jdbcType;
	}

	public String getJdbcType(){
		return this.jdbcType;
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

    public void setColumnName(String columnName){
		this.columnName=columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

    public void setPkColumn(boolean pkColumn){
		this.pkColumn=pkColumn;
	}

	public boolean isPkColumn(){
		return this.pkColumn;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {name:" + name + ", type:" + type + ", jdbcType:" + jdbcType + ", comment:" + comment + ", importType:" + importType + ", columnName:" + columnName + ", pkColumn:" + pkColumn  + "}";
	}

}
