package ${config.managerConfig.remoteServiceImplPackage};

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import ${config.companyBasePackage}.framework.bean.BaseResponsePage;
import ${config.companyBasePackage}.framework.exception.BusinessException;
import ${config.companyBasePackage}.framework.util.BeanCopyUtils;
import ${config.companyBasePackage}.shop.manager.constants.ShopExceptionConstant;
import ${config.companyBasePackage}.shop.manager.property.ShopProperties;
import ${config.companyBasePackage}.shop.manager.property.ShopServiceApiProperties;
import ${config.managerConfig.remoteServiceApiPackage}.I${meta.name}RemoteService;
import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.companyBasePackage}.framework.bean.ResponseResult;
import ${config.companyBasePackage}.framework.bean.ResponseResult;
import ${config.companyBasePackage}.shop.manager.bean.BootstrapPagerResponseResult;

import java.util.List;

/** ${meta.name} 基础服务调用实现类
 * @author zongf
 * @date ${createDate}
 */
@Slf4j
@Service
public class ${meta.name}RemoteServiceImpl extends BaseAdapterService implements I${meta.name}RemoteService {

    @Autowired
    private ShopProperties shopProperties;

    @Autowired
    private ShopServiceApiProperties shopServiceApiProperties;

    @Override
    protected String authKey() {
        return null;
    }

    @Override
    protected String authValue() {
        return null;
    }

<#if (config.methodCreateConfig.save?string('true','false'))=="true">

    @Override
    public boolean save(${meta.name}Dto ${meta.name?uncap_first}Dto) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}());

            // 发送请求
            ResponseResult<Boolean> responseResult = httpPutObjectRequest(urlPath, null, null, JSON.toJSONString(${meta.name?uncap_first}Dto),
                    new TypeReference<ResponseResult<Boolean>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-保存失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-保存失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.deleteById?string('true','false'))=="true">

    @Override
    public boolean deleteById(Integer id) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/%s", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}(), id);

            // 发送请求
            ResponseResult<Boolean> responseResult = httpDeleteObjectRequest(urlPath, null, null, null,
                    new TypeReference<ResponseResult<Boolean>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-删除失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-删除失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.update?string('true','false'))=="true">

    @Override
    public boolean update(${meta.name}Dto ${meta.name?uncap_first}Dto) {

        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/%s", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}(), ${meta.name?uncap_first}Dto.getId());

            // 发送请求
            ResponseResult<Boolean> responseResult = httpPostObjectRequest(urlPath, null, null, JSON.toJSONString(${meta.name?uncap_first}Dto),
                    new TypeReference<ResponseResult<Boolean>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-更新失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-更新失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.queryById?string('true','false'))=="true">

    @Override
    public ${meta.name}Dto queryById(Integer id) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/%s", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}(), id);

            // 发送请求
            ResponseResult<${meta.name}Dto> responseResult = httpGetObjectRequest(urlPath, null, null, null,
                    new TypeReference<ResponseResult<${meta.name}Dto>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-详情查询失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-详情查询失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.queryListInIds?string('true','false'))=="true">

    @Override
    public List<${meta.name}Dto> queryListInIds(List<Integer> idList) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/list", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}());

            // 发送请求
            ResponseResult<List<${meta.name}Dto>> responseResult = httpPostObjectRequest(urlPath, null, null, JSON.toJSONString(idList),
                    new TypeReference<ResponseResult<List<${meta.name}Dto>>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-列表查询失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-列表查询失败", true);
        }
    }
</#if>

<#if (config.methodCreateConfig.queryList?string('true','false'))=="true">

    @Override
    public List<${meta.name}Dto> queryList(${meta.name}Query query) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/list", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}());

            // 发送请求
            ResponseResult<List<${meta.name}Dto>> responseResult = httpPostObjectRequest(urlPath, null, null, JSON.toJSONString(query),
                    new TypeReference<ResponseResult<List<${meta.name}Dto>>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-列表查询失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-列表查询失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.queryPager?string('true','false'))=="true">

    @Override
    public BootstrapPagerResponseResult<${meta.name}Dto> queryPager(int page, int pageSize, ${meta.name}Query query) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/pager/%d/%d", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}(), page, pageSize);

            // 发送请求
            ResponseResult<BaseResponsePage<${meta.name}Dto>> responseResult = httpPostObjectRequest(urlPath, null, null, JSON.toJSONString(query),
                    new TypeReference<ResponseResult<BaseResponsePage<${meta.name}Dto>>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-分页查询失败", true);
            }

            // 转换响应对象
            BootstrapPagerResponseResult<${meta.name}Dto> bootstrapPager = new BootstrapPagerResponseResult<>();
            BeanCopyUtils.copy(responseResult, bootstrapPager);

            // 设置结果
            BaseResponsePage<${meta.name}Dto> baseResponsePage = responseResult.getData();
            bootstrapPager.setData(baseResponsePage.getList());
            bootstrapPager.setRecordsFiltered(baseResponsePage.getTotal());
            bootstrapPager.setRecordsTotal(baseResponsePage.getTotal());

            return bootstrapPager;
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-分页查询失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.batchSave?string('true','false'))=="true">

    @Override
    public int batchSave(List<${meta.name}Dto> ${meta.name?uncap_first}DtoList) {
        try {

            // 拼接url连接
            String urlPath = String.format("%s/%s/batch", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}());

            // 发送请求
            ResponseResult<Integer> responseResult = httpPutObjectRequest(urlPath, null, null, JSON.toJSONString(${meta.name?uncap_first}DtoList),
                new TypeReference<ResponseResult<Integer>>() {});

            // 校验接口返回值
            if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
                throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-批量保存失败", true);
            }

            return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-批量保存失败", true);
        }
    }
</#if>
<#if (config.methodCreateConfig.batchDeleteByIds?string('true','false'))=="true">

    @Override
    public int batchDeleteByIds(List<Integer> idList) {
        try {

        // 拼接url连接
        String urlPath = String.format("%s/%s/batch", shopProperties.getShopBaseServiceHost(), shopServiceApiProperties.get${meta.name}());

        // 发送请求
        ResponseResult<Integer> responseResult = httpDeleteObjectRequest(urlPath, null, null, JSON.toJSONString(idList),
            new TypeReference<ResponseResult<Integer>>() {});

        // 校验接口返回值
        if (!ShopExceptionConstant.REQUEST_SUCCESS_CODE.equals(responseResult.getReturncode())) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-批量删除失败", true);
        }

        return responseResult.getData();
        } catch (Exception e) {
            throw new BusinessException(ShopExceptionConstant.REQUEST_FAIL_CODE, "${meta.comment}-批量删除失败", true);
        }
    }
</#if>
}