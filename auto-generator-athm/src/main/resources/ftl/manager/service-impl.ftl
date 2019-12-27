package ${config.managerConfig.serviceImplPackage};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${config.managerConfig.remoteServiceApiPackage}.I${meta.name}RemoteService;
import ${config.managerConfig.serviceApiPackage}.I${meta.name}Service;
import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.companyBasePackage}.shop.manager.bean.BootstrapPagerResponseResult;

import java.util.List;

/**${meta.name} 业务操作实现类
 * @author zongf
 * @date ${createDate}
 */
@Slf4j
@Service
public class ${meta.name}ServiceImpl implements I${meta.name}Service {

    @Autowired
    private I${meta.name}RemoteService ${meta.name?uncap_first}RemoteService;
<#if (config.methodCreateConfig.save?string('true','false'))=="true">

    @Override
    public boolean save(${meta.name}Dto ${meta.name?uncap_first}Dto) {
        return this.${meta.name?uncap_first}RemoteService.save(${meta.name?uncap_first}Dto);
    }
</#if>
<#if (config.methodCreateConfig.deleteById?string('true','false'))=="true">

    @Override
    public boolean deleteById(Integer id) {
        return this.${meta.name?uncap_first}RemoteService.deleteById(id);
    }
</#if>
<#if (config.methodCreateConfig.update?string('true','false'))=="true">

    @Override
    public boolean update(${meta.name}Dto ${meta.name?uncap_first}Dto) {
        return this.${meta.name?uncap_first}RemoteService.update(${meta.name?uncap_first}Dto);
    }
</#if>
<#if (config.methodCreateConfig.queryById?string('true','false'))=="true">

    @Override
    public ${meta.name}Dto queryById(Integer id) {
        return this.${meta.name?uncap_first}RemoteService.queryById(id);
    }
</#if>
<#if (config.methodCreateConfig.queryListInIds?string('true','false'))=="true">

    @Override
    public List<${meta.name}Dto> queryListInIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}RemoteService.queryListInIds(idList);
    }
</#if>
<#if (config.methodCreateConfig.queryList?string('true','false'))=="true">

    @Override
    public List<${meta.name}Dto> queryList(${meta.name}Query query) {
        return this.${meta.name?uncap_first}RemoteService.queryList(query);
    }
</#if>
<#if (config.methodCreateConfig.queryPager?string('true','false'))=="true">

    @Override
    public BootstrapPagerResponseResult<${meta.name}Dto> queryPager(int page, int pageSize, ${meta.name}Query query) {
        return this.${meta.name?uncap_first}RemoteService.queryPager(page, pageSize, query);
    }
</#if>
<#if (config.methodCreateConfig.batchSave?string('true','false'))=="true">

    @Override
    public int batchSave(List<${meta.name}Dto> ${meta.name?uncap_first}DtoList) {
        return this.${meta.name?uncap_first}RemoteService.batchSave(${meta.name?uncap_first}DtoList);
    }
</#if>
<#if (config.methodCreateConfig.batchDeleteByIds?string('true','false'))=="true">

    @Override
    public int batchDeleteByIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}RemoteService.batchDeleteByIds(idList);
    }
</#if>
}