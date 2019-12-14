package ${config.entityPackage};

<#list meta.imports as import>
import ${import};
</#list>

/** ${meta.comment}, 映射表:${meta.tableName}
* @author zongf
* @date${createDate}
*/
public class ${meta.name}Entity {
<#list meta.fields as field>

    // ${field.comment}
    private ${field.type} ${field.name};
</#list>

    public ${meta.name}Entity() {
        super();
    }

<#list meta.fields as field>
    public void set${field.name?cap_first}(${field.type} ${field.name}){
        this.${field.name}=${field.name};
    }

    <#if field.type == 'Boolean' || field.type == 'boolean' >
    public ${field.type} is${field.name?cap_first}(){
    <#else>
    public ${field.type} get${field.name?cap_first}(){
    </#if>
        return this.${field.name};
    }

</#list>
    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() <#if (meta.fields?size > 0)>+ ": {<#list meta.fields as field>${field.name}:" + ${field.name} <#if field_index != meta.fields?size-1>+ ", </#if></#list></#if> + "}";
    }

}