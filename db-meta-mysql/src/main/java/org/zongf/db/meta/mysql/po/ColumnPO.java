package org.zongf.db.meta.mysql.po;

import org.zongf.db.meta.mysql.enums.JavaMappingType;
import org.zongf.db.meta.mysql.enums.MysqlDataType;

/** 表字段信息
 * @author zongf
 * @date 2019-11-30
 */
public class ColumnPO {

    // 字段名
    private String columnName;

    // 创建表时, 声明的类型
    private String colunmType;

    // 数据类型
    private MysqlDataType dataType;
    
    // java类型
    private JavaMappingType javaType;

    // 列索引
    private int position;

    // 字符串最大个数,不区分中英文
    private long maxCharLength;

    // 整数最大位数
    private int maxIntDigits;

    // 小数最大位数
    private int maxDecimalDigits;

    // 是否可为空
    private boolean isNullAble;

    // 是否是主键列, 不代表是唯一主键, 可能是联合主键
    private boolean isPKColumn;
    
    // 是否自增
    private boolean isAutoIncrement;
    
    // 列注释
    private String comment;
    
    // 默认值
    private String defaultValue;

	public ColumnPO() {
        super();
    }

	public ColumnPO(String columnName, String colunmType, MysqlDataType dataType, JavaMappingType javaType, int position, long maxCharLength, int maxIntDigits, int maxDecimalDigits, boolean isNullAble, boolean isPKColumn, boolean isAutoIncrement, String comment, String defaultValue) {
        super();
		this.columnName = columnName;
		this.colunmType = colunmType;
		this.dataType = dataType;
		this.javaType = javaType;
		this.position = position;
		this.maxCharLength = maxCharLength;
		this.maxIntDigits = maxIntDigits;
		this.maxDecimalDigits = maxDecimalDigits;
		this.isNullAble = isNullAble;
		this.isPKColumn = isPKColumn;
		this.isAutoIncrement = isAutoIncrement;
		this.comment = comment;
		this.defaultValue = defaultValue;
    }

    public void setColumnName(String columnName){
		this.columnName=columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

    public void setColunmType(String colunmType){
		this.colunmType=colunmType;
	}

	public String getColunmType(){
		return this.colunmType;
	}

    public void setDataType(MysqlDataType dataType){
		this.dataType=dataType;
	}

	public MysqlDataType getDataType(){
		return this.dataType;
	}

    public void setJavaType(JavaMappingType javaType){
		this.javaType=javaType;
	}

	public JavaMappingType getJavaType(){
		return this.javaType;
	}

    public void setPosition(int position){
		this.position=position;
	}

	public int getPosition(){
		return this.position;
	}

    public void setMaxCharLength(long maxCharLength){
		this.maxCharLength=maxCharLength;
	}

	public long getMaxCharLength(){
		return this.maxCharLength;
	}

    public void setMaxIntDigits(int maxIntDigits){
		this.maxIntDigits=maxIntDigits;
	}

	public int getMaxIntDigits(){
		return this.maxIntDigits;
	}

    public void setMaxDecimalDigits(int maxDecimalDigits){
		this.maxDecimalDigits=maxDecimalDigits;
	}

	public int getMaxDecimalDigits(){
		return this.maxDecimalDigits;
	}

    public void setIsNullAble(boolean isNullAble){
		this.isNullAble=isNullAble;
	}

	public boolean isIsNullAble(){
		return this.isNullAble;
	}

    public void setIsPKColumn(boolean isPKColumn){
		this.isPKColumn=isPKColumn;
	}

	public boolean isIsPKColumn(){
		return this.isPKColumn;
	}

    public void setIsAutoIncrement(boolean isAutoIncrement){
		this.isAutoIncrement=isAutoIncrement;
	}

	public boolean isIsAutoIncrement(){
		return this.isAutoIncrement;
	}

    public void setComment(String comment){
		this.comment=comment;
	}

	public String getComment(){
		return this.comment;
	}

    public void setDefaultValue(String defaultValue){
		this.defaultValue=defaultValue;
	}

	public String getDefaultValue(){
		return this.defaultValue;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {columnName:" + columnName + ", colunmType:" + colunmType + ", dataType:" + dataType + ", javaType:" + javaType + ", position:" + position + ", maxCharLength:" + maxCharLength + ", maxIntDigits:" + maxIntDigits + ", maxDecimalDigits:" + maxDecimalDigits + ", isNullAble:" + isNullAble + ", isPKColumn:" + isPKColumn + ", isAutoIncrement:" + isAutoIncrement + ", comment:" + comment + ", defaultValue:" + defaultValue  + "}";
	}

}
