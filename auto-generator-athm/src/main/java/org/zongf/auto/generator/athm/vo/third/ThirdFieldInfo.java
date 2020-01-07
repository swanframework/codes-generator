package org.zongf.auto.generator.athm.vo.third;

/** 第三方字段信息
 * @author zongf
 * @date 2020-01-07
 */
public class ThirdFieldInfo {

    // 字段名
    private String fieldName;

    // 字段类型
    private String fieldType;

    // 字段注释
    private String comment;

	// 是否必需
	private String required = "false";

	public ThirdFieldInfo() {
        super();
    }

	public ThirdFieldInfo(String fieldName, String fieldType, String comment, String required) {
        super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.comment = comment;
		this.required = required;
    }

    public void setFieldName(String fieldName){
		this.fieldName=fieldName;
	}

	public String getFieldName(){
		return this.fieldName;
	}

    public void setFieldType(String fieldType){
		this.fieldType=fieldType;
	}

	public String getFieldType(){
		return this.fieldType;
	}

    public void setComment(String comment){
		this.comment=comment;
	}

	public String getComment(){
		return this.comment;
	}

    public void setRequired(String required){
		this.required=required;
	}

	public String getRequired(){
		return this.required;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {fieldName:" + fieldName + ", fieldType:" + fieldType + ", comment:" + comment + ", required:" + required  + "}";
	}

}
