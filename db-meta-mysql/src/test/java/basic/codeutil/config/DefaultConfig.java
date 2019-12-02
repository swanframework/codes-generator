package basic.codeutil.config;


/**
 * 默认配置类
 * @author tiansn
 * @time 2016年4月11日-上午10:03:16
 */
public class DefaultConfig {

	// 需要修改的变量
	public static String PACKAGE_BASE = "org.zyl.coffee";
	public static String CODEDIR_BASE = "src/main/java/org/zyl/coffee";
	public static String SERVER_DBNAME = "coffee";
	public static String TABLENAME_PREFIX = "flower_";
	public static String CODEDIR_MAPPERXML = "src/main/resources/mapper";
	public static String CLASS_BASEQUERY = "org.zyl.coffee.pojo.vo.BaseQuery";

	// 生成类后缀名
	public static String PO_SUFFIX = "PO";
	public static String MAPPER_SUFFIX = "Mapper";

	// java 字段与数据库字段映射配置文件
	public static String TYPEORM_PATH ="src/test/java/basic/codeutil/config/typeOrm.properties";
	// freemarker FTL配置文件
	public static String FTL_PATH ="src/test/java/basic/codeutil/ftl";

	/** 数据库连接配置 **/
	public static String SERVER_IP = "localhost";
	public static Integer SERVER_PORT = 3306;
	public static String SERVER_USERNAME = "root";
	public static String SERVER_PASSWORD = "root";

	/** povo生成配置： 是否自动生成 toString 方法  */
	public static boolean HAS_TOSTRING = true;
	
	/** povo生成配置： 是否实现 Serializabel 接口  **/
	public static boolean HAS_SERIALIZEABLE = false;
	
	/** 包结构 */
	public static String PACKAGE_PO = PACKAGE_BASE + ".pojo.po";
	public static String PACKAGE_MAPPERJAVA = PACKAGE_BASE + ".mapper";
	public static String PACKAGE_ISERVICE = PACKAGE_BASE + ".service.api";
	public static String PACKAGE_SERVICE = PACKAGE_BASE + ".service.impl";
	public static String PACKAGE_CONTROLLER = PACKAGE_BASE + ".controller.manager";

	/** TOTO 代码生成路径 */
	public static String CODEDIR_PO = CODEDIR_BASE + "/pojo/po";
	public static String CODEDIR_MAPPERJAVA = CODEDIR_BASE + "/mapper";
	public static String CODEDIR_ISERVICE = CODEDIR_BASE + "/service/api";
	public static String CODEDIR_SERVICE = CODEDIR_BASE + "/service/impl";
	public static String CODEDIR_CONTROLLER = CODEDIR_BASE + "/controller/manager";

	/** 生成组件 */
	public static boolean IS_CREATE_PO = true;
	public static boolean IS_CREATE_MAPPER = true;
	public static boolean IS_CREATE_SERVICE = true;
	public static boolean IS_CREATE_CONTROLLER = true;

}
