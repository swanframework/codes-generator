package basic.codeutil.utils;

import basic.codeutil.config.DefaultConfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * java 类型和 mysql 类型映射工具类
 * @author tiansn
 * @time 2016年4月18日-下午4:01:46
 */
public class TypeOrmUtil {
	
	// 类型映射文件路径 
	private static String typeOrmFilePath = DefaultConfig.TYPEORM_PATH;
	
	// 映射文件
	private static Properties typeOrmProperties;
	
	static{
		File file = new File(typeOrmFilePath);
		try {
			typeOrmProperties = new Properties();
			typeOrmProperties.load(new FileInputStream(file));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过sql 类型获取java 类型
	 * @param sqlType mysql 字段类型
	 * @return java 基本类型
	 */
	public static String getJavaType(String sqlType){
		// int(11),varchar(255) 如果包含() 则 截取 （）之前的 
		if(sqlType.contains("(")){
			int index = sqlType.indexOf("(");
			sqlType = sqlType.substring(0, index);
		}
		return typeOrmProperties.getProperty(sqlType);
	}
	
	public static void main(String[] args) {
		System.out.println(getJavaType("varchar"));
	}
}
