package ${config.serviceApiPackage};

import ${config.entityPackage}.${meta.name};

import java.util.List;

/** ${meta.comment} API
* @author zongf
* @date ${createDate}
*/
public interface I${meta.name}Service {


    /** 保存实体
    * @param ${meta.name?uncap_first} 数据库实体
    * @return boolean
    * @author zongf
    * @date ${createDate}
    */
    boolean save(${meta.name} ${meta.name?uncap_first});

    /** 批量保存. 需要注意保存数量, 单条sql长度有限制
    * @param ${meta.name?uncap_first}List 数据库实体列表
    * @return int
    * @author zongf
    * @date ${createDate}
    */
    int batchSave(List<${meta.name}> ${meta.name?uncap_first}List);

    /** 根据主键ID 删除记录
    * @param id  主键ID
    * @return boolean 记录不存在返回false
    * @author zongf
    * @date ${createDate}
    */
    boolean deleteById(Long id);

    /** 根据主键ID列表批量删除
    * @param idList 主键列表，不能为空
    * @return int 成功删除的数量
    * @author zongf
    * @date ${createDate}
    */
    int batchDeleteByIds(List<Long> idList);

    /** 更新实体, 更新所有字段信息
    * @param ${meta.name?uncap_first}  包含ID属性的实体
    * @return boolean 如果记录不存在, 返回false
    * @author zongf
    * @date ${createDate}
    */
    boolean update(${meta.name} ${meta.name?uncap_first});

    /** 更新实体, 只更新所有非null 属性
    * @param ${meta.name?uncap_first}  包含ID属性的实体
    * @return boolean 如果记录不存在, 返回false
    * @author zongf
    * @date ${createDate}
    */
    boolean updateNotNull(${meta.name} ${meta.name?uncap_first});

    /** 通过主键ID查询记录, 查询所有字段
    * @param id 主键ID
    * @return ${meta.name} 实体
    * @author zongf
    * @date ${createDate}
    */
    ${meta.name} queryById(Long id);

    /** 通过主键ID列表查询记录，查询所有字段
    * @param idList 主键ID列表
    * @return List<${meta.name}> 查询为空时, 返回list的size为0，而不会返回null
    * @author zongf
    * @date2019-12-24
    */
    List<${meta.name}> queryListInIds(List<Long> idList);

    /** 通过主键ID列表查询记录，查询指定的字段列表
    * @return List<${meta.name}>
    * @author zongf
    * @date2019-12-24
    */
    List<${meta.name}> queryList();

}
