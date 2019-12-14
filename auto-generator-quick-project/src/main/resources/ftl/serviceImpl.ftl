package ${config.serviceImplPackage};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zongf.helper.mybatis.pager.PageBounds;
import org.zongf.helper.mybatis.pager.PageResult;
import org.zongf.helper.spring.dto.BaseQuery;
import ${config.entityPackage}.${meta.name}Entity;
import ${config.mapperApiPackage}.${meta.name}Mapper;
import ${config.serviceApiPackage}.I${meta.name}Service;

import java.util.List;

/**
 * @author zongf
 * @date${createDate}
 */
@Service
public class ${meta.name}Service implements I${meta.name}Service {

    private static Logger log = LoggerFactory.getLogger(I${meta.name}Service.class);

    @Autowired
    private ${meta.name}Mapper ${meta.name?uncap_first}Mapper;

    @Transactional
    @Override
    public boolean save(${meta.name}Entity entity) {
        return this.${meta.name?uncap_first}Mapper.save(entity);
    }

    @Transactional
    @Override
    public int batchSave(List<${meta.name}Entity> entityList) {
        return this.${meta.name?uncap_first}Mapper.batchSave(entityList);
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
    public boolean updateNotNull(${meta.name}Entity entity) {
        return this.${meta.name?uncap_first}Mapper.updateNotNull(entity);
    }

    @Override
    public ${meta.name}Entity queryById(Long id) {
        return this.${meta.name?uncap_first}Mapper.queryById(id);
    }

    @Override
    public List<${meta.name}Entity> queryList(BaseQuery query) {
        List<${meta.name}Entity> entityList = null;

        if(query == null){
            entityList = this.${meta.name?uncap_first}Mapper.queryListOnStrategy(null);
        }else {
            //TODO
        }

        return entityList;
    }

    @Override
    public PageResult<${meta.name}Entity> queryPager(BaseQuery query, PageBounds pageBounds) {
        PageResult<${meta.name}Entity> entityList = null;

        if(query == null){
            entityList = this.${meta.name?uncap_first}Mapper.queryPagerOnStrategy(null, pageBounds);
        }else {
            //TODO
        }
        return entityList;
    }
}