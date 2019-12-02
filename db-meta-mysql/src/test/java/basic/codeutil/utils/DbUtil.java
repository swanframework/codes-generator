package basic.codeutil.utils;

import basic.codeutil.config.DefaultConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Ojdbc 操作Oracle 工具类简单封装
 * @author tiansn
 * @time 2016年4月12日-下午1:21:25
 */
public class DbUtil {
	
	/** 数据库连接   **/
	private static Connection conn;
	
	
	/***
	 * 连接数据库 
	 * @param ipAddress 数据库IP地址
	 * @param port 端口号
	 * @param dbName 服务名称 
	 * @param username 连接用户名
	 * @param password 连接密码
	 * @return
	 */
	private static void connect(String ipAddress, Integer port, String dbName, String username , String password){
		String url = "jdbc:mysql://" + ipAddress + ":" + port + "/" + dbName + "?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库连接 
	 * */
	private static void closeConnection(Connection conn){
		try {
			if(null != conn){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取查询结果集 
	 * @param sql   查询sql
	 * @param params 入参
	 * @return ResultSet
	 */
	public static ResultSet excuteQuery(String sql , Object... params){
		try{
			if(conn == null || conn.isClosed()){
				connect(DefaultConfig.SERVER_IP, DefaultConfig.SERVER_PORT, DefaultConfig.SERVER_DBNAME, DefaultConfig.SERVER_USERNAME, DefaultConfig.SERVER_PASSWORD);
			}
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int index = 1;
			for (Object param : params) {
				pstmt.setObject(index++, param);
			}
			return pstmt.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询一个字段
	 * @param sql 查询sql语句
	 * @param params 参数 
	 * @return List<String>
	 */
	public static List<String> queryList(String sql , Object... params){
		try {
			ResultSet rs = excuteQuery(sql, params);
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
