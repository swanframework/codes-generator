package ${po.packageName};

<#list po.imports as import>
import ${import};
</#list>

/** ${po.comment}
* @author zongf
* @date ${po.createDate}
*/
@Getter
@Setter
public class ${po.name} {
<#list po.columns as column>

    // ${column.comment}
    private ${column.type} ${column.name};
</#list>

}