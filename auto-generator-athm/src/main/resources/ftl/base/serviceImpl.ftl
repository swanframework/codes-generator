package ${config.baseConfig.serviceImplPackage};

import ${config.baseConfig.entityPackage}.${meta.name};
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.baseConfig.mapperApiPackage}.${meta.name}Mapper;
import ${config.baseConfig.serviceApiPackage}.I${meta.name}Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**${meta.comment} 业务操作实现类
* @author zongf
* @date ${createDate}
*/
@Service
public class ${meta.name}ServiceImpl implements I${meta.name}Service {

    @Autowired
    private ${meta.name}Mapper ${meta.name?uncap_first}Mapper;
<#if (config.methodCreateConfig.save?string('true','false'))=="true">

    @Transactional
    @Override
    public boolean save(${meta.name} ${meta.name?uncap_first}) {
        Date currentTime = new Date();
        ${meta.name?uncap_first}.setIsDel(0);
        ${meta.name?uncap_first}.setCreatedStime(currentTime);
        ${meta.name?uncap_first}.setModifiedStime(currentTime);
        return this.${meta.name?uncap_first}Mapper.save(${meta.name?uncap_first});
    }
</#if>
<#if (config.methodCreateConfig.deleteById?string('true','false'))=="true">

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        return this.${meta.name?uncap_first}Mapper.deleteById(id);
    }
</#if>
<#if (config.methodCreateConfig.update?string('true','false'))=="true">

    @Transactional
    @Override
    public boolean update(${meta.name} ${meta.name?uncap_first}) {
        return this.${meta.name?uncap_first}Mapper.update(${meta.name?uncap_first});
    }
</#if>
<#if (config.methodCreateConfig.updateNotNull?string('true','false'))=="true">

    @Transactional
    @Override
    public boolean updateNotNull(${meta.name} ${meta.name?uncap_first}) {
        return this.${meta.name?uncap_first}Mapper.updateNotNull(${meta.name?uncap_first});
    }
</#if>
<#if (config.methodCreateConfig.queryById?string('true','false'))=="true">

    @Override
    public ${meta.name} queryById(Integer id) {
        return this.${meta.name?uncap_first}Mapper.queryById(id);
    }
</#if>
<#if (config.methodCreateConfig.queryListInIds?string('true','false'))=="true">

    @Override
    public List<${meta.name}> queryListInIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}Mapper.queryListInIds(idList);
    }
</#if>
<#if (config.methodCreateConfig.queryList?string('true','false'))=="true">

    @Override
    public List<${meta.name}> queryList(${meta.name}Query query) {
        return this.${meta.name?uncap_first}Mapper.queryList(query);
    }
</#if>
<#if (config.methodCreateConfig.queryPager?string('true','false'))=="true">

    @Override
    public Page<${meta.name}> queryPager(int page, int pageSize, ${meta.name}Query query) {

        Page<${meta.name}> pageResult = PageHelper.startPage(page, pageSize)
            .doSelectPage(() -> this.${meta.name?uncap_first}Mapper.queryList(query));

        return pageResult;
    }
</#if>
<#if (config.methodCreateConfig.batchSave?string('true','false'))=="true">

    @Transactional
    @Override
    public int batchSave(List<${meta.name}> ${meta.name?uncap_first}List) {
        Date currentTime = new Date();
        for (${meta.name} ${meta.name?uncap_first} : ${meta.name?uncap_first}List) {
            ${meta.name?uncap_first}.setIsDel(0);
            ${meta.name?uncap_first}.setCreatedStime(currentTime);
            ${meta.name?uncap_first}.setModifiedStime(currentTime);
        }
        return this.${meta.name?uncap_first}Mapper.batchSave(${meta.name?uncap_first}List);
    }
</#if>
<#if (config.methodCreateConfig.batchDeleteByIds?string('true','false'))=="true">

    @Transactional
    @Override
    public int batchDeleteByIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}Mapper.batchDeleteByIds(idList);
    }
</#if>
}
