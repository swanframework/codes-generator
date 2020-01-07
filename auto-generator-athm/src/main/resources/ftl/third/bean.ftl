
import lombok.Getter;
import lombok.Setter;

/**
* @author zongf
* @date ${createDate}
*/
@Setter @Getter
public class ${classInfo.className} {
<#list classInfo.fieldList as field>

    /**<#if field.required =="true" > 必传:</#if> ${field.comment} */
    private ${field.fieldType} ${field.fieldName?uncap_first};
</#list>

}