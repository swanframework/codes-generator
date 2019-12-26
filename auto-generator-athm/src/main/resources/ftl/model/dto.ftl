package ${config.modelConfig.dtoPackage};

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import com.alibaba.fastjson.annotation.JSONField;

<#list meta.imports as import>
import ${import};
</#list>

/** ${meta.comment}
* @author zongf
* @date ${createDate}
*/
@Getter
@Setter
public class ${meta.name}Dto {
<#list meta.fields as field>

    <#if field.type == 'Date'>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    @ApiModelProperty(value = "${field.comment}")
    private ${field.type} ${field.name};
</#list>

}