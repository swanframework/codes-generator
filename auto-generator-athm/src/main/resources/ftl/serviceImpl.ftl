package ${config.serviceImplPackage};

import ${config.entityPackage}.${meta.name};
import ${config.queryPackage}.${meta.name}Query;
import ${config.mapperApiPackage}.${meta.name}Mapper;
import ${config.serviceApiPackage}.I${meta.name}Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @author zongf
* @date ${createDate}
*/
@Service
public class ${meta.name}ServiceImpl implements I${meta.name}Service {

    @Autowired
    private ${meta.name}Mapper ${meta.name?uncap_first}Mapper;


    @Transactional
    @Override
    public boolean save(${meta.name} ${meta.name?uncap_first}) {
        Date currentTime = new Date();
        ${meta.name?uncap_first}.setIsDel(0);
        ${meta.name?uncap_first}.setCreatedStime(currentTime);
        ${meta.name?uncap_first}.setModifiedStime(currentTime);
        return this.${meta.name?uncap_first}Mapper.save(${meta.name?uncap_first});
    }

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

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        return this.${meta.name?uncap_first}Mapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}Mapper.batchDeleteByIds(idList);
    }

    @Transactional
    @Override
    public boolean update(${meta.name} ${meta.name?uncap_first}) {
        return this.${meta.name?uncap_first}Mapper.update(${meta.name?uncap_first});
    }

    @Transactional
    @Override
    public boolean updateNotNull(${meta.name} ${meta.name?uncap_first}) {
        return this.${meta.name?uncap_first}Mapper.updateNotNull(${meta.name?uncap_first});
    }

    @Override
    public ${meta.name} queryById(Integer id) {
        return this.${meta.name?uncap_first}Mapper.queryById(id);
    }

    @Override
    public List<${meta.name}> queryListInIds(List<Integer> idList) {
        return this.${meta.name?uncap_first}Mapper.queryListInIds(idList);
    }

    @Override
    public List<${meta.name}> queryList(${meta.name}Query query) {
        return this.${meta.name?uncap_first}Mapper.queryList(query);
    }

    @Override
    public Page<${meta.name}> queryPage(int page, int pageSize, ${meta.name}Query query) {

        Page<${meta.name}> pageResult = PageHelper.startPage(page, pageSize)
            .doSelectPage(() -> this.${meta.name?uncap_first}Mapper.queryList(query));

        return pageResult;
    }

}
