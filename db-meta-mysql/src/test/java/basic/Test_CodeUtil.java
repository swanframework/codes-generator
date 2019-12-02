package basic;

import java.io.File;
import java.util.List;

import org.junit.Test;

import basic.codeutil.dao.TableDao;
import basic.codeutil.po.TablePO;
import basic.codeutil.utils.CodeUtil;
import basic.codeutil.config.DefaultConfig;
/**
 * 自动生成代码工具类
 */
public class Test_CodeUtil {
	
	/** 打印数据库中所有的表名   */
	@Test
	public void printTableNames(){
		String dbName = DefaultConfig.SERVER_DBNAME;
		TableDao tableDao = new TableDao();
		List<TablePO> tableList = tableDao.queryAllTables(dbName);
		for (TablePO tablePO : tableList) {
			System.out.print("\"" + tablePO.getTableName() + "\",");
		}
	}
	
	/** 自动生成代码测试   */
	@Test
	public void test_createCode(){
		DefaultConfig.IS_CREATE_CONTROLLER=false;
		String[] tableNames = new String[]{"coffee_comment"};
		CodeUtil.createCode(tableNames);
	}
	
	/** 清空文件夹 */
	@Test
	public void clearFolder(){
		File poDir = new File(DefaultConfig.CODEDIR_PO);
		File daoDir = new File(DefaultConfig.CODEDIR_MAPPERJAVA);
		File iServiceDir = new File(DefaultConfig.CODEDIR_ISERVICE);
		File serviceDir = new File(DefaultConfig.CODEDIR_SERVICE);
		
//		try {
//			FileUtils.cleanDirectory(poDir);
//			FileUtils.cleanDirectory(daoDir);
//			FileUtils.cleanDirectory(iServiceDir);
//			FileUtils.cleanDirectory(serviceDir);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("清空成功,请刷新包： " + DefaultConfig.CODEDIR_BASE.replace("/", "."));
	}
}
