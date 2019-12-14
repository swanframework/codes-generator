package ${config.controllerPackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zongf.helper.mybatis.pager.PageBounds;
import org.zongf.helper.mybatis.pager.PageResult;
import org.zongf.helper.spring.dto.BaseQuery;
import org.zongf.helper.spring.dto.BaseRequest;
import org.zongf.helper.spring.dto.BaseResponse;
import ${config.entityPackage}.${meta.name}Entity;
import ${config.serviceApiPackage}.I${meta.name}Service;
import java.util.List;

/**
 * @author zongf
 * @date 2019-12-14
 */
@RestController
@RequestMapping("/${meta.name?uncap_first}")
public class ${meta.name}Controller {

    @Autowired
    private I${meta.name}Service ${meta.name?uncap_first}Service;

    /** 保存 */
    @PutMapping("/")
    public BaseResponse<Boolean> save(@RequestBody BaseRequest<${meta.name}Entity> request){

        boolean isSuccess = this.${meta.name?uncap_first}Service.save(request.getBody());

        return BaseResponse.success(isSuccess);
    }

    /** 删除 */
    @DeleteMapping("/{id}")
    public BaseResponse<Boolean> delete(@PathVariable("id") Long id){

        boolean isSuccess = this.${meta.name?uncap_first}Service.deleteById(id);

        return BaseResponse.success(isSuccess);
    }

    /** 修改 */
    @PostMapping("/{id}")
    public BaseResponse<Integer> update(@PathVariable("id")Long id,  BaseRequest<${meta.name}Entity> request){

        this.${meta.name?uncap_first}Service.updateNotNull(request.getBody());

        return BaseResponse.success();
    }

    /** 查询详情 */
    @GetMapping("/{id}")
    public BaseResponse<${meta.name}Entity> queryById(@PathVariable("id")Long id){

        ${meta.name}Entity entity = this.${meta.name?uncap_first}Service.queryById(id);

        return BaseResponse.success(entity);
    }

    /** 查询列表 */
    @GetMapping("/list")
    public BaseResponse<List<${meta.name}Entity>> queryList(@RequestBody BaseRequest<BaseQuery> request){

        List<${meta.name}Entity> ${meta.name?uncap_first}List = this.${meta.name?uncap_first}Service.queryList(request.getBody());

        return BaseResponse.success(${meta.name?uncap_first}List);
    }

    /** 分页查询 */
    @GetMapping("/pager/{pageNo}/{pageSize}")
    public BaseResponse<PageResult<${meta.name}Entity>> queryPage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize, @RequestBody BaseRequest<BaseQuery> request){

        PageResult<${meta.name}Entity> pageResult = this.${meta.name?uncap_first}Service.queryPager(request.getBody(), PageBounds.of(pageNo, pageSize));

        return BaseResponse.success(pageResult);
    }

    /** 批量保存 */
    @PutMapping("/batch")
    public BaseResponse<Integer> batchSave(@RequestBody BaseRequest<List<${meta.name}Entity>> request){

        int saveNum = this.${meta.name?uncap_first}Service.batchSave(request.getBody());

        return BaseResponse.success(saveNum);
    }

    /** 批量删除 */
    @DeleteMapping("/batch")
    public BaseResponse<Integer> batchDelete(@RequestBody BaseRequest<List<Long>> request){

        int delNum = this.${meta.name?uncap_first}Service.batchDeleteByIds(request.getBody());

        return BaseResponse.success(delNum);
    }

}