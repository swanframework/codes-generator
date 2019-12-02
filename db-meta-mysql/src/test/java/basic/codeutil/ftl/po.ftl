package ${pakageName};

<#list importList as name>
import ${name};
</#list>

/**
 * ${tablePO.tableComment}
 * 表名称：${tablePO.tableName}
 */
public class ${poName?cap_first} {
	<#list columnPOList as columnPO>
	
	// ${columnPO.comment}
	private ${columnPO.javaType} ${columnPO.columnName?uncap_first};
	</#list>
	
	public ${poName?cap_first}(){
	
	}
	
	<#-- setter/getter 方法 -->
	<#list columnPOList as columnPO>
	public ${columnPO.javaType} get${columnPO.columnName?cap_first}() {
		return this.${columnPO.columnName?uncap_first};
	}
		
	public void set${columnPO.columnName?cap_first}(${columnPO.javaType} ${columnPO.columnName?uncap_first}) {
		this.${columnPO.columnName} = ${columnPO.columnName?uncap_first};
	}
		
	</#list>
	<#if hasToString>
	<#-- 自动生成toString()方法  -->
	@Override
	public String toString() {
		return "${poName?cap_first}[<#list columnPOList as columnPO><#if columnPO_index = 0>${columnPO.columnName?uncap_first}=" + this.${columnPO.columnName?uncap_first}<#elseif columnPO_index < columnPO?size>+ ", ${columnPO.columnName?uncap_first}=" + this.${columnPO.columnName?uncap_first}<#else> + ", ${columnPO.columnName?uncap_first}=" + this.${columnPO.columnName?uncap_first}</#if></#list>+ "]";
	}
	</#if>
	
}

