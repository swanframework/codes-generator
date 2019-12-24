package ${config.controllerPackage};

import com.autohome.travelplat.framework.bean.BaseResponsePage;
import com.autohome.travelplat.framework.bean.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${config.entityPackage}.${meta.name};
import ${config.serviceApiPackage}.I${meta.name}Service;

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

    @ApiOperation(value = "1.保存接口", notes = "Author:zongf")
    @DeleteMapping("/")
    public ResponseResult save(@ApiParam("${meta.comment}") @RequestBody ${meta.name} ${meta.name?uncap_first}){

        return ResponseResult.success();
    }

    @ApiOperation(value = "2.删除接口", notes = "Author:zongf")
    @DeleteMapping("/{id}")
    public ResponseResult delete(@ApiParam("主键ID") @PathVariable("id") Long id){

        return ResponseResult.success();
    }

    @ApiOperation(value = "3.更新接口", notes = "Author:zongf")
    @PostMapping("/{id}")
    public ResponseResult update(@PathVariable("id")Long id, @RequestBody ${meta.name} ${meta.name?uncap_first}){

        return ResponseResult.success();
    }

    @ApiOperation(value = "4.查询详情接口", notes = "Author:zongf")
    @GetMapping("/{id}")
    public ResponseResult<${meta.name}> queryById(@ApiParam("主键ID") @PathVariable("id") Long id){

        return ResponseResult.success();
    }

    @ApiOperation(value = "4.查询列表", notes = "Author:zongf")
    @GetMapping("/list")
    public ResponseResult<List<${meta.name}>> queryById(@ApiParam("主键ID") Object query){

        return ResponseResult.success();
    }

    @ApiOperation(value = "5.分页查询接口", notes = "Author:zongf")
    @PostMapping("/pager/{page}/{pageSize}")
    public ResponseResult<BaseResponsePage<${meta.name}>> queryPager(
        @ApiParam("页码") @PathVariable("page") int page,
        @ApiParam("每页数量") @PathVariable("pageSize") int pageSize,
        @ApiParam("查询条件") @RequestBody Object query){

        return ResponseResult.success();
    }

}
