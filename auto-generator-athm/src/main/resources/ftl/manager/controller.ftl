package ${config.managerConfig.controllerPackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.managerConfig.serviceApiPackage}.I${meta.name}Service;

import ${config.companyBasePackage}.base.shop.model.util.HibernateValidatorUtil;
import ${config.companyBasePackage}.shop.manager.bean.BootstrapPagerResponseResult;
import ${config.companyBasePackage}.framework.bean.ResponseResult;

import java.util.List;

/** ${meta.name} 管理API
* @author zongf
* @date ${createDate}
*/
@RestController
@RequestMapping("${config.managerConfig.controllerUrlPrefix}/${meta.name?uncap_first}")
public class ${meta.name}Controller {

    @Autowired
    private I${meta.name}Service ${meta.name?uncap_first}Service;
<#if (config.methodCreateConfig.save?string('true','false'))=="true">

    /** ${meta.comment}-保存接口 */
    @DeleteMapping("/")
    public ResponseResult<Boolean> save(@RequestBody ${meta.name}Dto ${meta.name?uncap_first}Dto){

        // 校验字段基本信息
        HibernateValidatorUtil.validate(${meta.name?uncap_first}Dto);

        boolean isSuccess = this.${meta.name?uncap_first}Service.save(${meta.name?uncap_first}Dto);

        return ResponseResult.success(isSuccess);
    }
</#if>
<#if (config.methodCreateConfig.deleteById?string('true','false'))=="true">

    /** ${meta.comment}-删除接口 */
    @DeleteMapping("/{id}")
    public ResponseResult<Boolean> deleteById(Integer id){
        boolean isSuccess = this.${meta.name?uncap_first}Service.deleteById(id);
        return ResponseResult.success(isSuccess);
    }
</#if>
<#if (config.methodCreateConfig.update?string('true','false'))=="true">

    /** ${meta.comment}-更新接口 */
    @PostMapping("/{id}")
    public ResponseResult<Boolean> update(@PathVariable("id")Integer id, @RequestBody ${meta.name}Dto ${meta.name?uncap_first}Dto){

        ${meta.name?uncap_first}Dto.setId(id);
        boolean isSuccess = this.${meta.name?uncap_first}Service.update(${meta.name?uncap_first}Dto);

        return ResponseResult.success(isSuccess);
    }
</#if>
<#if (config.methodCreateConfig.queryById?string('true','false'))=="true">

    /** ${meta.comment}-查询详情接口 */
    @GetMapping("/{id}")
    public ResponseResult<${meta.name}Dto> queryById(@PathVariable("id") Integer id){
        // 数据库查询实体
        ${meta.name}Dto ${meta.name?uncap_first}Dto = this.${meta.name?uncap_first}Service.queryById(id);

        return ResponseResult.success(${meta.name?uncap_first}Dto);
    }
</#if>
<#if (config.methodCreateConfig.queryList?string('true','false'))=="true">

    /** ${meta.comment}-查询列表接口 */
    @GetMapping("/list")
    public ResponseResult<List<${meta.name}Dto>> queryList(${meta.name}Query query){
        // 查询结果集
        List<${meta.name}Dto> ${meta.name?uncap_first}DtoList = this.${meta.name?uncap_first}Service.queryList(query);

        return ResponseResult.success(${meta.name?uncap_first}DtoList);
    }
</#if>
<#if (config.methodCreateConfig.queryPager?string('true','false'))=="true">

    /** ${meta.comment}-分页查询接口 */
    @PostMapping("/pager")
    public BootstrapPagerResponseResult<${meta.name}Dto> queryPager(Integer page, Integer pageSize, ${meta.name}Query query){

        if(pageSize == null) pageSize = 10;

        // 分页查询
        BootstrapPagerResponseResult<${meta.name}Dto> responseResult = this.${meta.name?uncap_first}Service.queryPager(page, pageSize, query);

        return responseResult;
    }
</#if>
<#if (config.methodCreateConfig.batchSave?string('true','false'))=="true">

    /** ${meta.comment}-批量保存接口 */
    public ResponseResult<Integer> batchSave(@RequestBody List<${meta.name}Dto> ${meta.name?uncap_first}DtoList){

        // 校验字段基本信息
        ${meta.name?uncap_first}DtoList.forEach(HibernateValidatorUtil::validate);

        int saveNum = this.${meta.name?uncap_first}Service.batchSave(${meta.name?uncap_first}DtoList);

        return ResponseResult.success(saveNum);
    }
</#if>
<#if (config.methodCreateConfig.batchDeleteByIds?string('true','false'))=="true">

    /** ${meta.comment}-批量删除接口 */
    @DeleteMapping("/batch")
    public ResponseResult<Integer> batchDeleteByIds(@RequestBody List<Integer> idList){
        int delNum = this.${meta.name?uncap_first}Service.batchDeleteByIds(idList);
        return ResponseResult.success(delNum);
    }
</#if>
}
