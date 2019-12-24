package ${config.serviceImplPackage};

import ${config.entityPackage}.${meta.name};
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
        return this.${meta.name?uncap_first}Mapper.save(${meta.name?uncap_first});
    }

    @Transactional
    @Override
    public int batchSave(List<${meta.name}> ${meta.name?uncap_first}List) {
        return this.${meta.name?uncap_first}Mapper.batchSave(${meta.name?uncap_first}List);
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        return this.${meta.name?uncap_first}Mapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<Long> idList) {
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
    public ${meta.name} queryById(Long id) {
        return this.${meta.name?uncap_first}Mapper.queryById(id);
    }

    @Override
    public List<${meta.name}> queryListInIds(List<Long> idList) {
        return this.${meta.name?uncap_first}Mapper.queryListInIds(idList);
    }

    @Override
    public List<${meta.name}> queryList() {
        return this.${meta.name?uncap_first}Mapper.queryList();
    }

}
