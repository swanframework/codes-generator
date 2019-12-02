package ${pakageName};

<#list importList as name>
import ${name};
</#list>

/**
* ${tablePO.tableComment}
* 表名称：${tablePO.tableName}
*/
@RestController
@RequestMapping("/${tablePO.javaName?uncap_first}")
public class ${tablePO.javaName?cap_first}Controller {

    @Autowired
    private I${tablePO.javaName?cap_first}Service ${tablePO.javaName?uncap_first}Service;

    /** 增： 保存接口   */
    @PostMapping
    public Integer save(${poName?cap_first} ${poName?uncap_first}){
        this.${tablePO.javaName?uncap_first}Service.save(${poName?uncap_first});
        return ${poName?uncap_first}.getId();
    }

    /** 删：根据id 从数据库删除记录  */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        this.${tablePO.javaName?uncap_first}Service.delete(id);
    }

    /** 改：更新数据库信息  */
    @PutMapping
    public void update(${poName?cap_first} ${poName?uncap_first}){
        this.${tablePO.javaName?uncap_first}Service.update(${poName?uncap_first});
    }

    /** 查：通过id从数据库中查询 */
    @GetMapping("/{id}")
    public ${poName?cap_first} findById(@PathVariable Integer id){
        return this.${tablePO.javaName?uncap_first}Service.find(id);
    }

    /** 查询：从数据库中查询表中所有记录  */
    @GetMapping
    public List<${poName?cap_first}> queryAll(){
        return this.${tablePO.javaName?uncap_first}Service.queryList();
    }

    /** 查-分页： 从数据库查询一页记录  */
    @GetMapping("/pages")
    public List<${poName?cap_first}> queryPage(PageBounds pageBounds){
        return this.${tablePO.javaName?uncap_first}Service.queryList(pageBounds);
    }
}
