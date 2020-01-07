
import lombok.Getter;
import lombok.Setter;

/**
* @author zongf
* @date ${createDate}
*/
@Setter @Getter
public class ${classInfo.className} {
<#list classInfo.fieldList as field>

    /** ${field.comment}<#if field.required =="true" >, 必传</#if> */
    private ${field.fieldType} ${field.fieldName};
</#list>

}