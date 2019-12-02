package basic.codeutil.po;

import basic.codeutil.config.DefaultConfig;
import basic.codeutil.utils.StringUtils;

/**
 * 数据库表
 * 
 * @author tiansn
 * @time 2016年4月18日-下午3:32:51
 */
public class TablePO {

	// 表名称
	private String tableName;

	// 表注释
	private String tableComment;

	// 映射JavaPo名称
	private String javaName;

	public TablePO() {
		super();
	}

	public TablePO(String tableName, String tableComment) {
		super();
		this.tableName = tableName;
		this.tableComment = tableComment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}


	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		javaName = StringUtils.substringAfter(javaName, DefaultConfig.TABLENAME_PREFIX);
		String[] array = javaName.split("_");
		if(array.length > 1){
			StringBuffer sb = new StringBuffer();
			sb.append(array[0].toLowerCase());
			for(int i=1; i<array.length; i++){
				sb.append(StringUtils.upperFirst(array[i].toLowerCase()));
			}
			this.javaName = sb.toString();
		}else{
			this.javaName = array[0].toLowerCase();
		}
	}

	@Override
	public String toString() {
		return "TablePO [tableName=" + tableName + ", tableComment="
				+ tableComment + ", javaName=" + javaName + "]";
	}

}
