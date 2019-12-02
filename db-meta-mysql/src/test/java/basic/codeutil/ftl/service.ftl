package ${pakageName};

<#list importList as name>
import ${name};
</#list>

/**
* ${tablePO.tableComment}
* 表名称：${tablePO.tableName}
*/
@Service
public class ${tablePO.javaName?cap_first}Service implements I${tablePO.javaName?cap_first}Service {

	@Autowired
	private ${tablePO.javaName?cap_first}Mapper ${tablePO.javaName?uncap_first}Mapper;

	@Transactional
	@Override
	public void save(${poName?cap_first} ${poName?uncap_first}) {
		this.${tablePO.javaName?uncap_first}Mapper.save(${poName?uncap_first});
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		this.${tablePO.javaName?uncap_first}Mapper.delete(id);
	}

	@Transactional
	@Override
	public void update(${poName?cap_first} ${poName?uncap_first}) {
		this.${tablePO.javaName?uncap_first}Mapper.update(${poName?uncap_first});
	}

	@Transactional
	@Override
	public void updateNotNull(${poName?cap_first} ${poName?uncap_first}) {
		this.${tablePO.javaName?uncap_first}Mapper.updateNotNull(${poName?uncap_first});
	}

	@Override
	public ${poName?cap_first} find(Integer id) {
		return this.${tablePO.javaName?uncap_first}Mapper.find(id);
	}

	@Override
	public List<${poName?cap_first}> queryList() {
		return this.${tablePO.javaName?uncap_first}Mapper.queryList();
	}

	@Override
	public PageList<${poName?cap_first}> queryList(PageBounds pageBounds, BaseQuery query) {
		return this.${tablePO.javaName?uncap_first}Mapper.queryList(pageBounds, query);
	}
}
