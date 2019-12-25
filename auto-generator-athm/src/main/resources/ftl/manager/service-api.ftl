package ${config.managerConfig.serviceApiPackage};


import ${config.modelConfig.dtoPackage}.${meta.name}Dto;
import ${config.modelConfig.queryPackage}.${meta.name}Query;
import ${config.companyBasePackage}.shop.manager.bean.BootstrapPagerResponseResult;

import java.util.List;

/**
* @author zongf
* @date ${createDate}
*/
public interface I${meta.name}Service {

    /** 保存
    * @param ${meta.name?uncap_first}Dto
    * @return boolean
    * @author zongf
    * @date ${createDate}
    */
    boolean save(${meta.name}Dto ${meta.name?uncap_first}Dto);

    /** 批量保存
    * @param ${meta.name?uncap_first}DtoList
    * @return int 成功保存的数量
    * @author zongf
    * @date ${createDate}
    */
    int batchSave(List<${meta.name}Dto> ${meta.name?uncap_first}DtoList);

    /** 根据主键ID 删除记录
    * @param id  主键ID
    * @return boolean 记录不存在返回false
    * @author zongf
    * @date ${createDate}
    */
    boolean deleteById(Integer id);

    /** 根据主键ID列表批量删除
    * @param idList 主键列表，不能为空
    * @return int 成功删除的数量
    * @author zongf
    * @date ${createDate}
    */
    int batchDeleteByIds(List<Integer> idList);

    /** 更新实体, 更新所有字段信息
    * @param ${meta.name?uncap_first}Dto  包含ID属性的实体
    * @return boolean 如果记录不存在, 返回false
    * @author zongf
    * @date ${createDate}
    */
    boolean update(${meta.name}Dto ${meta.name?uncap_first}Dto);

    /** 通过主键ID查询记录, 查询所有字段
    * @param id 主键ID
    * @return ${meta.name}Dto 实体
    * @author zongf
    * @date ${createDate}
    */
    ${meta.name}Dto queryById(Integer id);

    /** 通过主键ID列表查询记录，查询所有字段
    * @param idList 主键ID列表
    * @return List<${meta.name}Dto> 查询为空时, 返回list的size为0，而不会返回null
    * @author zongf
    * @date2019-12-24
    */
    List<${meta.name}Dto> queryListInIds(List<Integer> idList);

    /** 查询列表
    * @param query 查询条件
    * @return List<${meta.name}Dto>
    * @author zongf
    * @date2019-12-24
    */
    List<${meta.name}Dto> queryList(${meta.name}Query query);

    /** 分页查询
    * @param page 页码
    * @param pageSize 分页大小
    * @param query 查询条件
    * @return Page<${meta.name}Dto>
    * @author zongf
    * @date 2019-12-24
    */
    BootstrapPagerResponseResult<${meta.name}Dto> queryPage(int page, int pageSize, ${meta.name}Query query);

}
