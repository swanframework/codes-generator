package basic.codeutil.po;

/**
 * 字段类型实体类
 * 
 * @author tiansn
 * @time 2016年4月18日-下午3:34:52
 */
public class ColumnPO {

	// 字段名称
	private String columnName;

	// 字段类型
	private String columnType;

	// 整数部分长度
	private Integer integerLength;

	// 小数部分长度
	private Integer decimalLength;

	// 字符串长度
	private Integer characterLength;

	// 是否可为空
	private boolean nullAble;

	// 字段注释
	private String comment;

	// java类型
	private String javaType;

	public ColumnPO() {
	}

	public ColumnPO(String columnName, String comment, String javaType) {
		super();
		this.columnName = columnName;
		this.comment = comment;
		this.javaType = javaType;
	}

	public ColumnPO(String columnName, String columnType, Integer integerLength, Integer decimalLength, Integer characterLength, boolean nullAble, String comment, String javaType) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
		this.integerLength = integerLength;
		this.decimalLength = decimalLength;
		this.characterLength = characterLength;
		this.nullAble = nullAble;
		this.comment = comment;
		this.javaType = javaType;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public Integer getIntegerLength() {
		return integerLength;
	}

	public void setIntegerLength(Integer integerLength) {
		this.integerLength = integerLength;
	}

	public Integer getDecimalLength() {
		return decimalLength;
	}

	public void setDecimalLength(Integer decimalLength) {
		this.decimalLength = decimalLength;
	}

	public Integer getCharacterLength() {
		return characterLength;
	}

	public void setCharacterLength(Integer characterLength) {
		this.characterLength = characterLength;
	}

	public boolean isNullAble() {
		return nullAble;
	}

	public void setNullAble(boolean nullAble) {
		this.nullAble = nullAble;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	@Override
	public String toString() {
		return "ColumnPO [columnName=" + columnName + ", columnType=" + columnType + ", integerLength=" + integerLength + ", decimalLength=" + decimalLength + ", characterLength=" + characterLength + ", nullAble=" + nullAble + ", comment=" + comment + ", javaType=" + javaType + "]";
	}

}
