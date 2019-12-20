package org.zongf.db.meta.mysql.utils;

import org.zongf.db.meta.mysql.config.DbConfig;
import org.zongf.db.meta.mysql.exception.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 数据库连接工具类
 * @author zongf
 * @date 2019-11-30
 */
public class DbUtil {


	/** 获取数据库连接
	 * @return Connection
	 * @author zongf
	 * @date 2019-11-30
	 */
	public static Connection openConnection(){
		DbConfig dbConfig = DbConfig.getInstance();

		StringBuffer jdbcUrlSb = new StringBuffer();
		jdbcUrlSb.append("jdbc:mysql://")
				.append(dbConfig.getHost())
				.append(":")
				.append(dbConfig.getPort())
				.append("?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(jdbcUrlSb.toString(), dbConfig.getUsername(), dbConfig.getPassword());
		}catch(Exception ex){
			throw new DbException("获取数据库连接失败", ex);
		}
	}


	/** 关闭数据库连接
	 * @param connection 数据库连接
	 * @author zongf
	 * @date 2019-11-30
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	/** 数据库查询
	 * @param conn 数据库链接
	 * @param sql 查询sql
	 * @param params 参数
	 * @return ResultSet
	 * @author zongf
	 * @date 2019-11-30
	 */
	public static ResultSet excuteQuery(Connection conn, String sql , Object... params){
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			return pstmt.executeQuery();
		} catch (SQLException e) {
			throw new DbException("数据库查询失败", e);
		}
	}
	
	/**
	 * 查询一个字段
	 * @param sql 查询sql语句
	 * @param params 参数 
	 * @return List<String>
	 */
	public static List<String> queryList(Connection connection, String sql , Object... params){
		try {
			ResultSet rs = excuteQuery(connection, sql, params);
			List<String> rsList = new ArrayList<String>();
			while (rs.next()) {
				rsList.add(rs.getString(1));
			}
			return rsList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
