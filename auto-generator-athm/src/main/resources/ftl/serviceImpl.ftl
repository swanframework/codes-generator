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


}
