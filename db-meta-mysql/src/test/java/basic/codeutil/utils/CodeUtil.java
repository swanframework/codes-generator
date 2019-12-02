package basic.codeutil.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import basic.codeutil.config.DefaultConfig;
import basic.codeutil.dao.TableDao;
import basic.codeutil.po.ColumnPO;
import basic.codeutil.po.TablePO;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * POJO 工具类
 * @Description 
 * @author tiansn
 * @date 2016年3月28日  下午2:41:35
 */
public class CodeUtil {
	
	// freemarker 模板配置 
	private static Configuration cfgConfig;
	
	// 模板存放目录
	private static String TEMPLATEFILENAME = DefaultConfig.FTL_PATH;
	
	// 生成vo 的模板
	private static Template voTemplate;
	
	// 生成PO 的模板
	private static Template poTemplate;
	
	// 生成dao 模板
	private static Template mapperJavaTemplate;

	// 升成xml 配置文件
	private static Template mapperXmlTemplate;

	// 生成service 接口模板
	private static Template iServiceTemplate;
	
	// 生成service 实现类
	private static Template serviceTemplate;

	// 生成Controller 模板类
	private static Template controllerTemplate;

	
	static{
		try{
			Configuration cfgConfig = new Configuration(Configuration.VERSION_2_3_22);  
			cfgConfig.setDirectoryForTemplateLoading(new File(TEMPLATEFILENAME));  
			cfgConfig.setDefaultEncoding("UTF-8");  //设置编码为UTF-8
			cfgConfig.setNumberFormat("####");		//设置数字格式，默认三位数字用,号分割
			poTemplate = cfgConfig.getTemplate("po.ftl");
			mapperJavaTemplate = cfgConfig.getTemplate("mapperJava.ftl");
			mapperXmlTemplate = cfgConfig.getTemplate("mapperXml.ftl");
			iServiceTemplate = cfgConfig.getTemplate("iService.ftl");
			serviceTemplate = cfgConfig.getTemplate("service.ftl");
			controllerTemplate = cfgConfig.getTemplate("controller.ftl");
			
			}catch(Exception ex){
				System.out.println("Freemarker 引擎初始化错误  ");
				ex.printStackTrace();
		}
	}
	
	/**
	 * 生成文件
	 */
	private static void write2File(Template template, Map<String, Object> root,  String fileAbsName){
		try{
			//首字母大写
			File file = new File(fileAbsName);
			
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");		
			template.process(root, osw);
			
			osw.flush();
			osw.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 生成PO
	 */
	private static void createPO(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		List<String> importList = new ArrayList<>();
		for(ColumnPO column:columnPOs){
			if("Date".equals(column.getJavaType())){
				if(!importList.contains("java.util.Date")){
					importList.add("java.util.Date");
				}
			}else if("BigDecimal".equals(column.getJavaType())){
				if(!importList.contains("java.math.BigDecimal")){
					importList.add("java.math.BigDecimal");
				}
			}
		}
		
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + "PO";
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("importList", importList);
		root.put("pakageName", DefaultConfig.PACKAGE_PO);
		root.put("poName", poName);
		root.put("hasToString", DefaultConfig.HAS_TOSTRING);
		
		//首字母大写
		String fileAbsName = folder + "/" + poName + ".java";
		write2File(poTemplate, root, fileAbsName);
		
		System.out.println("success: " + poName + ".java 生成成功！");
	}

	/***
	 * 生成dao
	 */
	private static void createMapperJava(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		String daoName = StringUtils.upperFirst(tablePO.getJavaName()) + DefaultConfig.MAPPER_SUFFIX;
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + DefaultConfig.PO_SUFFIX;

		// 1. 引入jar包
		Set<String> importSet = new HashSet<String>();
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageBounds");
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageList");
		importSet.add("org.apache.ibatis.annotations.Mapper");
		importSet.add("java.util.List");
		importSet.add(DefaultConfig.CLASS_BASEQUERY);

		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_PO)){
			importSet.add(DefaultConfig.PACKAGE_PO + "." + poName);
		}

		List<String> importList = new ArrayList<>(importSet);
		//排序
		Collections.sort(importList);

		//2. 构建map
		Map<String,Object> root  = new HashMap<>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("importList", importList);
		root.put("pakageName", DefaultConfig.PACKAGE_MAPPERJAVA);
		root.put("daoName", daoName);
		root.put("poName", poName);

		//首字母大写
		String fileAbsName = folder + "/" + daoName + ".java";
		write2File(mapperJavaTemplate, root, fileAbsName);

		System.out.println("success: " + daoName + ".java 生成成功！");
	}

	/***
	 * 生成mapper.xml
	 */
	private static void createMapperXml(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		String daoName = StringUtils.upperFirst(tablePO.getJavaName()) + DefaultConfig.MAPPER_SUFFIX;
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + DefaultConfig.PO_SUFFIX;

		// 1. 引入jar包
		Set<String> importSet = new HashSet<String>();
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageBounds");
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageList");
		importSet.add("org.apache.ibatis.annotations.Mapper");
		importSet.add("java.util.List");

		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_PO)){
			importSet.add(DefaultConfig.PACKAGE_PO + "." + poName);
		}

		List<String> importList = new ArrayList<>(importSet);
		//排序
		Collections.sort(importList);

		//2. 构建map
		Map<String,Object> root  = new HashMap<>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("importList", importList);
		root.put("pakageName", DefaultConfig.PACKAGE_MAPPERJAVA);
		root.put("daoName", daoName);
		root.put("poName", poName);

		//首字母大写
		String fileAbsName = folder + "/" + daoName + ".xml";
		write2File(mapperXmlTemplate, root, fileAbsName);

		System.out.println("success: " + daoName + ".java 生成成功！");
	}


	/***
	 * 生成service 接口
	 */
	private static void createIService(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + "PO";
		
		// 1. 引入jar包
		Set<String> importSet = new HashSet<String>();
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageBounds");
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageList");
		importSet.add("org.apache.ibatis.annotations.Mapper");
		importSet.add("java.util.List");
		importSet.add(DefaultConfig.CLASS_BASEQUERY);
		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_PO)){
			importSet.add(DefaultConfig.PACKAGE_PO + "." + poName);
		}
		List<String> importList = new ArrayList<>(importSet);
		//排序
		Collections.sort(importList);
		
		Map<String,Object> root  = new HashMap<>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("pakageName", DefaultConfig.PACKAGE_ISERVICE);
		root.put("poName", poName);
		root.put("importList", importList);
		
		//首字母大写
		String iServiceName = "I" + StringUtils.upperFirst(tablePO.getJavaName()) + "Service";
		String fileAbsName = folder + "/" + iServiceName + ".java";
		write2File(iServiceTemplate, root, fileAbsName);
		
		System.out.println("success: " + iServiceName + ".java 生成成功！");
		
	}
	
	/***
	 * 生成service实现类
	 */
	private static void createService(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		String daoName = StringUtils.upperFirst(tablePO.getJavaName()) + "Mapper";
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + "PO";
		String iServiceName = "I" + StringUtils.upperFirst(tablePO.getJavaName()) + "Service";
		
		// 1. 引入jar包
		Set<String> importSet = new HashSet<String>();
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageBounds");
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageList");
		importSet.add("org.apache.ibatis.annotations.Mapper");
		importSet.add("org.springframework.stereotype.Service");
		importSet.add("org.springframework.beans.factory.annotation.Autowired");
		importSet.add("org.springframework.transaction.annotation.Transactional");
		importSet.add("java.util.List");
		importSet.add(DefaultConfig.CLASS_BASEQUERY);
		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_PO)){
			importSet.add(DefaultConfig.PACKAGE_PO + "." + poName);
		}
		
		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_MAPPERJAVA)){
			importSet.add(DefaultConfig.PACKAGE_MAPPERJAVA + "." + daoName);
		}
		
		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_ISERVICE)){
			importSet.add(DefaultConfig.PACKAGE_ISERVICE + "." + iServiceName);
		}
		
		List<String> importList = new ArrayList<>(importSet);
		//排序
		Collections.sort(importList);
		
		Map<String,Object> root  = new HashMap<>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("pakageName", DefaultConfig.PACKAGE_SERVICE);
		root.put("importList", importList);
		root.put("poName", poName);
		
		//首字母大写
		String serviceName = StringUtils.upperFirst(tablePO.getJavaName()) + "Service";
		String fileAbsName = folder + "/" + serviceName + ".java";
		write2File(serviceTemplate, root, fileAbsName);
		System.out.println("success: " + serviceName + ".java 生成成功！");
	}


	/***
	 * 生成Controller
	 */
	private static void createController(TablePO tablePO,List<ColumnPO> columnPOs, String folder){
		String daoName = StringUtils.upperFirst(tablePO.getJavaName()) + "Mapper";
		String poName = StringUtils.upperFirst(tablePO.getJavaName()) + "PO";
		String iServiceName = "I" + StringUtils.upperFirst(tablePO.getJavaName()) + "Service";

		// 1. 引入jar包
		Set<String> importSet = new HashSet<String>();
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageBounds");
		importSet.add("com.github.miemiedev.mybatis.paginator.domain.PageList");
		importSet.add("org.springframework.beans.factory.annotation.Autowired");
		importSet.add("org.springframework.transaction.annotation.Transactional");
		importSet.add("org.springframework.web.bind.annotation.PostMapping");
		importSet.add("org.springframework.web.bind.annotation.DeleteMapping");
		importSet.add("org.springframework.web.bind.annotation.PutMapping");
		importSet.add("org.springframework.web.bind.annotation.GetMapping");
		importSet.add("org.springframework.web.bind.annotation.RequestMapping");
		importSet.add("org.springframework.web.bind.annotation.RestController");
		importSet.add("org.springframework.web.bind.annotation.PathVariable");
		importSet.add("org.springframework.stereotype.Service");
		importSet.add("java.util.List");
		importSet.add(DefaultConfig.CLASS_BASEQUERY);


		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_PO)){
			importSet.add(DefaultConfig.PACKAGE_PO + "." + poName);
		}

		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_MAPPERJAVA)){
			importSet.add(DefaultConfig.PACKAGE_MAPPERJAVA + "." + daoName);
		}

		if(!DefaultConfig.PACKAGE_SERVICE.equals(DefaultConfig.PACKAGE_ISERVICE)){
			importSet.add(DefaultConfig.PACKAGE_ISERVICE + "." + iServiceName);
		}

		List<String> importList = new ArrayList<>(importSet);
		//排序
		Collections.sort(importList);

		Map<String,Object> root  = new HashMap<>();
		root.put("tablePO", tablePO);
		root.put("columnPOList", columnPOs);
		root.put("pakageName", DefaultConfig.PACKAGE_CONTROLLER);
		root.put("importList", importList);
		root.put("poName", poName);

		//首字母大写
		String controllerName = StringUtils.upperFirst(tablePO.getJavaName()) + "Controller";
		String fileAbsName = folder + "/" + controllerName + ".java";
		write2File(controllerTemplate, root, fileAbsName);

		System.out.println("success: " + controllerName + ".java 生成成功！");
	}


	/**
	 * 生成代码
	 */
	public static void createCode(String[] tableNames){
		
		TableDao tableDao = new TableDao();

		// 查询表信息
		List<TablePO> selectTables = tableDao.queryTablesInNames(tableNames);

		for (TablePO tablePO : selectTables) {
			System.out.println("**********    开始生成表: " + tablePO.getTableName() + "(" + tablePO.getTableComment() + ") 的相关类  **********");

			// 查询表字段名称
			List<ColumnPO> columnPOs = tableDao.queryColumns(tablePO.getTableName());

			// 生成代码
			if(DefaultConfig.IS_CREATE_PO){
				createPO(tablePO, columnPOs, DefaultConfig.CODEDIR_PO);
			}
			if(DefaultConfig.IS_CREATE_MAPPER){
				createMapperJava(tablePO, columnPOs, DefaultConfig.CODEDIR_MAPPERJAVA);
				createMapperXml(tablePO, columnPOs, DefaultConfig.CODEDIR_MAPPERXML);
			}
			if(DefaultConfig.IS_CREATE_SERVICE){
				createIService(tablePO, columnPOs, DefaultConfig.CODEDIR_ISERVICE);
				createService(tablePO, columnPOs, DefaultConfig.CODEDIR_SERVICE);
			}
			if(DefaultConfig.IS_CREATE_CONTROLLER){
				createController(tablePO, columnPOs, DefaultConfig.CODEDIR_CONTROLLER);
			}

		}
		
		System.out.println("请刷新包：" + DefaultConfig.CODEDIR_BASE.replace("/", "."));
	}
}
