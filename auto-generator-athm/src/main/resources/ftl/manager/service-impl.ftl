package ${config.managerConfig.serviceImplPackage};

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.autohome.travelplat.framework.bean.BaseResponsePage;
import com.autohome.travelplat.framework.bean.ResponseResult;
import com.autohome.travelplat.framework.exception.BusinessException;
import com.autohome.travelplat.framework.util.BeanCopyUtils;
import com.autohome.travelplat.shop.manager.bean.BootstrapPagerResponseResult;
import com.autohome.travelplat.shop.manager.constants.ShopExceptionConstant;
import com.autohome.travelplat.shop.manager.property.ShopProperties;
import com.autohome.travelplat.shop.manager.property.ShopServiceApiProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${config.managerConfig.remoteServiceApiPackage}.I${meta.name}RemoteService;
import ${config.managerConfig.serviceApiPackage}.I${meta.name}Service;
import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.companyBasePackage}.framework.bean.ResponseResult;
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


}