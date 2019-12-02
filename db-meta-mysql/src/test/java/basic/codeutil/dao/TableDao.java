package basic.codeutil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import basic.codeutil.po.ColumnPO;
import basic.codeutil.po.TablePO;
import basic.codeutil.utils.DbUtil;
import basic.codeutil.config.DefaultConfig;
import basic.codeutil.utils.TypeOrmUtil;
/**
 * 数据库相关的查询
 * @author tiansn
 * @time 2016年4月18日-下午6:39:13
 */
public class TableDao {
	
	/**
	 * 查询数据库下所有的表
	 * @param dbName 数据库名称
	 * @return List<TablePO>
	 */
	public List<TablePO> queryAllTables(String dbName){
		List<TablePO> tableList = new ArrayList<TablePO>();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("select t.TABLE_NAME,t.TABLE_COMMENT ");
		sb.append("from information_schema.TABLES t ");
		sb.append("where t.TABLE_SCHEMA = ?");
		
		ResultSet rs = DbUtil.excuteQuery(sb.toString(), dbName);
		
		try {
			while(rs.next()){
				TablePO tablePO = new TablePO();
				tablePO.setJavaName(rs.getString(1));
				tablePO.setTableName(rs.getString(1));
				tablePO.setTableComment(rs.getString(2));
				tableList.add(tablePO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
	
	/***
	 * 查询表中所有的字段详情
	 * @param tableName 表名称
	 * @return List<ColumnPO>
	 */
	public List<ColumnPO> queryColumns(String tableName){
		List<ColumnPO> columnPOs = new ArrayList<ColumnPO>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT t.COLUMN_NAME, t.COLUMN_TYPE,t.NUMERIC_PRECISION,t.NUMERIC_SCALE,t.CHARACTER_MAXIMUM_LENGTH,t.IS_NULLABLE, t.COLUMN_COMMENT ");
		sb.append("from information_schema.COLUMNS t ");
		sb.append("where t.TABLE_SCHEMA = ? ");
		sb.append("and t.TABLE_NAME = ?");
		
		ResultSet rs = DbUtil.excuteQuery(sb.toString(), DefaultConfig.SERVER_DBNAME, tableName);
		
		try{
			while (rs.next()) {
				ColumnPO columnPO = new ColumnPO();
				columnPO.setColumnName(rs.getString("COLUMN_NAME"));
				columnPO.setColumnType(rs.getString("COLUMN_TYPE"));
				columnPO.setIntegerLength(rs.getInt("NUMERIC_PRECISION"));
				columnPO.setDecimalLength(rs.getInt("NUMERIC_SCALE"));
				columnPO.setCharacterLength(rs.getInt("CHARACTER_MAXIMUM_LENGTH"));
				columnPO.setComment(rs.getString("COLUMN_COMMENT"));
				columnPO.setJavaType(TypeOrmUtil.getJavaType(columnPO.getColumnType()));
				
				if("YES".equals(rs.getString("IS_NULLABLE"))){
					columnPO.setNullAble(true);
				}
				
				columnPOs.add(columnPO);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return columnPOs;
	}
	
	
	
	public static void main(String[] args) {
		String[] tableNames = new String[]{"user","type"};
		List<TablePO> tables = new TableDao().queryTablesInNames(tableNames);
		for (TablePO tablePO : tables) {
			System.out.println(tablePO);
		}
	}

	/**
	 * 查询指定表对象
	 */
	public List<TablePO> queryTablesInNames(String[] tableNames) {
		List<TablePO> allTableList = queryAllTables(DefaultConfig.SERVER_DBNAME);
		
		Map<String, TablePO> map = new HashMap<String, TablePO>();
		for (TablePO tablePO : allTableList) {
			map.put(tablePO.getTableName(), tablePO);
		}
		
		List<TablePO> tableList = new ArrayList<TablePO>();
		for(String tableName : tableNames){
			TablePO tablePO = map.get(tableName.toLowerCase());
			if(tablePO == null){
				System.out.println("error: 表" + tableName + " 不存在 ！！！！！！");
				continue;
			}
			tableList.add(tablePO);
		}
		return tableList;
	}

}
