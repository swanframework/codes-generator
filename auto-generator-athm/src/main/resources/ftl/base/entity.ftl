package ${config.baseConfig.entityPackage};

import lombok.Getter;
import lombok.Setter;
<#list meta.imports as import>
import ${import};
</#list>

/** ${meta.comment}
* @author zongf
* @date ${createDate}
*/
@Getter
@Setter
public class ${meta.name} {
<#list meta.fields as field>

    // ${field.comment}
    private ${field.type} ${field.name};
</#list>

}