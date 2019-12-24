package ${config.controllerPackage};

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSort;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${config.entityPackage}.${meta.name};
import ${config.dtoPackage}.${meta.name}Dto;
import ${config.queryPackage}.${meta.name}Query;
import ${config.serviceApiPackage}.I${meta.name}Service;

import ${config.companyBasePackage}.base.shop.model.util.HibernateValidatorUtil;
import ${config.companyBasePackage}.base.shop.utils.BaseResponsePageUtil;
import ${config.companyBasePackage}.framework.bean.BaseResponsePage;
import ${config.companyBasePackage}.framework.bean.ResponseResult;
import ${config.companyBasePackage}.framework.util.BeanCopyUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @author zongf
* @date ${createDate}
*/
@RestController
@RequestMapping("/api/inner/${meta.name?uncap_first}")
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

        // 复制对象
        ${meta.name} ${meta.name?uncap_first} = new ${meta.name}();
        BeanCopyUtils.copy(${meta.name?uncap_first}Dto, ${meta.name?uncap_first});

        boolean isSuccess = this.${meta.name?uncap_first}Service.save(${meta.name?uncap_first});

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

        // 复制属性
        ${meta.name} ${meta.name?uncap_first} = new ${meta.name}();
        BeanCopyUtils.copy(${meta.name?uncap_first}Dto, ${meta.name?uncap_first});

        ${meta.name?uncap_first}Dto.setId(id);
        boolean isSuccess = this.${meta.name?uncap_first}Service.update(${meta.name?uncap_first});

        return ResponseResult.success(isSuccess);
    }

    @ApiOperationSort(4)
    @ApiOperation(value = "查询详情接口", notes = "Author:zongf")
    @GetMapping("/{id}")
    public ResponseResult<${meta.name}Dto> queryById(@ApiParam("主键ID") @PathVariable("id") Integer id){
        // 数据库查询实体
            ${meta.name} ${meta.name?uncap_first} = this.${meta.name?uncap_first}Service.queryById(id);

        // 查询结果为空, 则直接返回
        if(${meta.name?uncap_first} == null) return ResponseResult.success();

        ${meta.name}Dto ${meta.name?uncap_first}Dto = new ${meta.name}Dto();
        BeanCopyUtils.copy(${meta.name?uncap_first}, ${meta.name?uncap_first}Dto);

        return ResponseResult.success(${meta.name?uncap_first}Dto);
    }

    @ApiOperationSort(5)
    @ApiOperation(value = "查询列表", notes = "Author:zongf")
    @GetMapping("/list")
    public ResponseResult<List<${meta.name}Dto>> queryById(@ApiParam("主键ID") ${meta.name}Query query){
        // 查询结果集
        List<${meta.name}> ${meta.name?uncap_first}s = this.${meta.name?uncap_first}Service.queryList(query);

        if(${meta.name?uncap_first}s == null || ${meta.name?uncap_first}s.size() == 0) return ResponseResult.success();

        List<${meta.name}Dto> ${meta.name?uncap_first}DtoList = new ArrayList<>();
        BeanCopyUtils.copyList(${meta.name?uncap_first}s, ${meta.name?uncap_first}DtoList, ${meta.name}Dto.class);

        return ResponseResult.success(${meta.name?uncap_first}DtoList);
    }

    @ApiOperationSort(6)
    @ApiOperation(value = "分页查询接口", notes = "Author:zongf")
    @PostMapping("/pager/{page}/{pageSize}")
    public ResponseResult<BaseResponsePage<${meta.name}Dto>> queryPager(
        @ApiParam("页码") @PathVariable("page") int page,
        @ApiParam("每页数量") @PathVariable("pageSize") int pageSize,
        @ApiParam("查询条件") @RequestBody ${meta.name}Query query){

        // 分页查询
        Page<${meta.name}> pageResult = this.${meta.name?uncap_first}Service.queryPage(page, pageSize, query);

        // 转换结果集
        BaseResponsePage<${meta.name}Dto> basePage = BaseResponsePageUtil.of(pageResult, ${meta.name}Dto.class);

        return ResponseResult.success(basePage);
    }

    @ApiOperationSort(7)
    @ApiOperation(value = "批量保存", notes = "Author:zongf")
    @PutMapping("/batch")
    public ResponseResult<Integer> batchSave(@ApiParam("分销渠道商品") @RequestBody List<${meta.name}Dto> ${meta.name?uncap_first}DtoList){

        // 校验字段基本信息
        ${meta.name?uncap_first}DtoList.forEach(HibernateValidatorUtil::validate);

        // 数据类型转换
        List<${meta.name}> ${meta.name?uncap_first}List = new ArrayList<>();
        BeanCopyUtils.copyList(${meta.name?uncap_first}DtoList, ${meta.name?uncap_first}List, ${meta.name}Dto.class);

        int saveNum = this.${meta.name?uncap_first}Service.batchSave(${meta.name?uncap_first}List);

        return ResponseResult.success(saveNum);
    }

    @ApiOperationSort(8)
    @ApiOperation(value = "批量删除", notes = "Author:zongf")
    @DeleteMapping("/batch")
    public ResponseResult<Integer> batchDelete(@ApiParam("主键ID列表") List<Integer> idList){
        int delNum = this.${meta.name?uncap_first}Service.batchDeleteByIds(idList);
        return ResponseResult.success(delNum);
    }
}
