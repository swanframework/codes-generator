package ${pakageName};

<#list importList as name>
import ${name};
</#list>

/**
 * ${tablePO.tableComment}
 * 表名称：${tablePO.tableName}
 */
 
public interface I${tablePO.javaName?cap_first}Service {

	/** 增：向数据库中新增一条记录   */
	public void save(${poName?cap_first} ${poName?uncap_first});
	
	/** 删：根据id 从数据库删除一条记录  */
	public void delete(Integer id);
	
	/** 改：更新数据库中的一条记录   1. 更新所有属性   2. 主键id不能为空  */
	public void update(${poName?cap_first} ${poName?uncap_first});
	
	/** 改：更新数据库中的一条记录  1. 更新所有不为null的属性  2. 主键id不能为空 */
	public void updateNotNull(${poName?cap_first} ${poName?uncap_first});
	
	/** 查：通过id从数据库中查询记录,如果不存在返回null */
	public ${poName?cap_first} find(Integer id);
	
	/** 查询：从数据库中查询表中所有记录  */
	public List<${poName?cap_first}> queryList();
	
	/** 查-分页： 从数据库查询一页记录  */
	public PageList<${poName?cap_first}> queryList(PageBounds pageBounds, BaseQuery query);
	
}