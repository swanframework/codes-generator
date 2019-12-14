package ${config.fieldEnumPackage};

/** Java实体属性与表字段名映射, 表:${meta.tableName}
* @author zongf
* @date ${meta.createDate}
*/
public enum ${meta.name}FieldEnum {
<#list meta.columns as column>

    /** ${column.comment} */
    ${column.name}("${column.columnName}")<#if column_index != meta.columns?size-1>, <#else>;</#if>
</#list>

    private String columnName;

    ${meta.name}FieldEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}