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

/**
 * @author zongf
 * @date ${createDate}
 */
@Slf4j
@Service
public class ${meta.name}ServiceImpl implements I${meta.name}Service {

    @Autowired
    private I${meta.name}RemoteService ${meta.name?uncap_first}RemoteService;

    @Override
    public boolean save(${meta.name}Dto ${meta.name?uncap_first}Dto) {
        return this.${meta.name?uncap_first}RemoteService.save(${meta.name?uncap_first}Dto);
    }

    @Override
    public int batchSave(List<${meta.name}Dto> ${meta.name?uncap_first}DtoList) {
        return this.${meta.name?uncap_first}RemoteService.batchSave(${meta.name?uncap_first}DtoList);
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.${meta.name?uncap_first}RemoteService.deleteById(id);
    }

    @Override
    public int batchDeleteByIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}RemoteService.batchDeleteByIds(idList);
    }

    @Override
    public boolean update(${meta.name}Dto ${meta.name?uncap_first}Dto) {
        return this.${meta.name?uncap_first}RemoteService.update(${meta.name?uncap_first}Dto);
    }

    @Override
    public ${meta.name}Dto queryById(Integer id) {
        return this.${meta.name?uncap_first}RemoteService.queryById(id);
    }

    @Override
    public List<${meta.name}Dto> queryListInIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}RemoteService.queryListInIds(idList);
    }

    @Override
    public List<${meta.name}Dto> queryList(${meta.name}Query query) {
        return this.${meta.name?uncap_first}RemoteService.queryList(query);
    }

    @Override
    public BootstrapPagerResponseResult<${meta.name}Dto> queryPage(int page, int pageSize, ${meta.name}Query query) {
        return this.${meta.name?uncap_first}RemoteService.queryPage(page, pageSize, query);
    }


}