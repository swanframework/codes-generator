package ${config.entityPackage};

<#list meta.imports as import>
import ${import};
</#list>

/** ${meta.comment}, 映射表:${meta.tableName}
* @author zongf
* @date ${meta.createDate}
*/
public class ${meta.name}Entity {
<#list meta.columns as column>

    // ${column.comment}
    private ${column.type} ${column.name};
</#list>

    public ${meta.name}Entity() {
        super();
    }

<#list meta.columns as column>
    public void set${column.name?cap_first}(${column.type} ${column.name}){
        this.${column.name}=${column.name};
    }

    <#if column.type == 'Boolean' || column.type == 'boolean' >
    public ${column.type} is${column.name?cap_first}(){
    <#else>
    public ${column.type} get${column.name?cap_first}(){
    </#if>
        return this.${column.name};
    }

</#list>
    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() <#if (meta.columns?size > 0)>+ ": {<#list meta.columns as column>${column.name}:" + ${column.name} <#if column_index != meta.columns?size-1>+ ", </#if></#list></#if> + "}";
    }

}