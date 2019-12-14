package ${config.fieldEnumPackage};

/** Java实体属性与表字段名映射, 表:${meta.tableName}
* @author zongf
* @date${createDate}
*/
public enum ${meta.name}FieldEnum {
<#list meta.fields as field>

    /** ${field.comment} */
    ${field.name}("${field.columnName}")<#if field_index != meta.fields?size-1>, <#else>;</#if>
</#list>

    private String fieldName;

    ${meta.name}FieldEnum(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return fieldName;
    }

}