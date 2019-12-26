package ${config.managerConfig.controllerPackage};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSort;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.managerConfig.serviceApiPackage}.I${meta.name}Service;

import ${config.companyBasePackage}.base.shop.model.util.HibernateValidatorUtil;
import ${config.companyBasePackage}.shop.manager.bean.BootstrapPagerResponseResult;
import ${config.companyBasePackage}.framework.bean.ResponseResult;

import java.util.List;

/**
* @author zongf
* @date ${createDate}
*/
@RestController
@RequestMapping("/api/${meta.name?uncap_first}")
@Api(tags = "${meta.comment}接口")
public class ${meta.name}Controller {

    @Autowired
    private I${meta.name}Service ${meta.name?uncap_first}Service;

    @ApiOperationSort(1)
    @ApiOperation(value = "保存接口", notes = "Author:zongf")
    @DeleteMapping("/")
    public ResponseResult<Boolean> save(@ApiParam("${meta.comment}") @RequestBody ${meta.name}Dto ${meta.name?uncap_first}Dto){

        // 校验字段基本信息
        HibernateValidatorUtil.validate(${meta.name?uncap_first}Dto);

        boolean isSuccess = this.${meta.name?uncap_first}Service.save(${meta.name?uncap_first}Dto);

        return ResponseResult.success(isSuccess);
    }

    @ApiOperationSort(2)
    @ApiOperation(value = "删除接口", notes = "Author:zongf")
    @DeleteMapping("/{id}")
    public ResponseResult<Boolean> delete(@ApiParam("主键ID") @PathVariable("id") Integer id){
        boolean isSuccess = this.${meta.name?uncap_first}Service.deleteById(id);
        return ResponseResult.success(isSuccess);
    }

    @ApiOperationSort(3)
    @ApiOperation(value = "更新接口", notes = "Author:zongf")
    @PostMapping("/{id}")
    public ResponseResult<Boolean> update(@PathVariable("id")Integer id, @RequestBody ${meta.name}Dto ${meta.name?uncap_first}Dto){

        ${meta.name?uncap_first}Dto.setId(id);
        boolean isSuccess = this.${meta.name?uncap_first}Service.update(${meta.name?uncap_first}Dto);

        return ResponseResult.success(isSuccess);
    }

    @ApiOperationSort(4)
    @ApiOperation(value = "查询详情接口", notes = "Author:zongf")
    @GetMapping("/{id}")
    public ResponseResult<${meta.name}Dto> queryById(@ApiParam("主键ID") @PathVariable("id") Integer id){
        // 数据库查询实体
        ${meta.name}Dto ${meta.name?uncap_first}Dto = this.${meta.name?uncap_first}Service.queryById(id);

        return ResponseResult.success(${meta.name?uncap_first}Dto);
    }

    @ApiOperationSort(5)
    @ApiOperation(value = "查询列表", notes = "Author:zongf")
    @GetMapping("/list")
    public ResponseResult<List<${meta.name}Dto>> queryById(@ApiParam("主键ID") ${meta.name}Query query){
        // 查询结果集
        List<${meta.name}Dto> ${meta.name?uncap_first}DtoList = this.${meta.name?uncap_first}Service.queryList(query);

        return ResponseResult.success(${meta.name?uncap_first}DtoList);
    }

    @ApiOperationSort(6)
    @ApiOperation(value = "分页查询接口", notes = "Author:zongf")
    @PostMapping("/pager/{page}/{pageSize}")
    public BootstrapPagerResponseResult<${meta.name}Dto> queryPager(
        @ApiParam("页码") @PathVariable("page") int page,
        @ApiParam("每页数量") @PathVariable("pageSize") int pageSize,
        @ApiParam("查询条件") ${meta.name}Query query){

        // 分页查询
        BootstrapPagerResponseResult<${meta.name}Dto> responseResult = this.${meta.name?uncap_first}Service.queryPage(page, pageSize, query);

        return responseResult;
    }

    @ApiOperationSort(7)
    @ApiOperation(value = "批量保存", notes = "Author:zongf")
    @PutMapping("/batch")
    public ResponseResult<Integer> batchSave(@ApiParam("分销渠道商品") @RequestBody List<${meta.name}Dto> ${meta.name?uncap_first}DtoList){

        // 校验字段基本信息
        ${meta.name?uncap_first}DtoList.forEach(HibernateValidatorUtil::validate);

        int saveNum = this.${meta.name?uncap_first}Service.batchSave(${meta.name?uncap_first}DtoList);

        return ResponseResult.success(saveNum);
    }

    @ApiOperationSort(8)
    @ApiOperation(value = "批量删除", notes = "Author:zongf")
    @DeleteMapping("/batch")
    public ResponseResult<Integer> batchDelete(@ApiParam("主键ID列表") @RequestBody List<Integer> idList){
        int delNum = this.${meta.name?uncap_first}Service.batchDeleteByIds(idList);
        return ResponseResult.success(delNum);
    }
}