package ${config.voPackage};

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
<#list meta.imports as import>
import ${import};
</#list>

/** ${meta.comment}
* @author zongf
* @date ${createDate}
*/
@Getter
@Setter
public class ${meta.name}Request {
<#list meta.fields as field>

    @ApiModelProperty(value = "${field.comment}")
    private ${field.type} ${field.name};
</#list>

}