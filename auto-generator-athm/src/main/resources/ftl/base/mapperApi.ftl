package ${config.baseConfig.mapperApiPackage};

import org.apache.ibatis.annotations.Mapper;
import ${config.baseConfig.entityPackage}.${meta.name};
import ${config.modelConfig.queryPackage}.${meta.name}Query;

import java.util.List;

/** 数据库表[${meta.tableName}]通用操作API
 * @author zongf
 * @date ${createDate}
 */
@Mapper
public interface ${meta.name}Mapper {

<#if (config.methodCreateConfig.save?string('true','false'))=="true">

    /** 保存实体
     * @param entity 数据库实体
     * @return boolean
     * @author zongf
     * @date${createDate}
     */
    boolean save(${meta.name} entity);

</#if>
<#if (config.methodCreateConfig.deleteById?string('true','false'))=="true">

    /** 根据主键ID 删除记录
     * @param id  主键ID
     * @return boolean 记录不存在返回false
     * @author zongf
     * @date${createDate}
     */
    boolean deleteById(Integer id);
</#if>
<#if (config.methodCreateConfig.update?string('true','false'))=="true">

    /** 更新实体, 更新所有字段信息
     * @param entity  包含ID属性的实体
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date${createDate}
     */
    boolean update(${meta.name} entity);
</#if>
<#if (config.methodCreateConfig.updateNotNull?string('true','false'))=="true">

    /** 更新实体, 只更新所有非null 属性
     * @param entity  包含ID属性的实体
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date${createDate}
     */
    boolean updateNotNull(${meta.name} entity);
</#if>
<#if (config.methodCreateConfig.queryById?string('true','false'))=="true">

    /** 通过主键ID查询记录, 查询所有字段
     * @param id 主键ID
     * @return ${meta.name} 实体
     * @author zongf
     * @date${createDate}
     */
    ${meta.name} queryById(Integer id);
</#if>
<#if (config.methodCreateConfig.queryListInIds?string('true','false'))=="true">

    /** 通过主键ID列表查询记录，查询所有字段
     * @param idList 主键ID列表
     * @return List<${meta.name}> 查询为空时, 返回list的size为0，而不会返回null
     * @author zongf
     * @date${createDate}
     */
    List<${meta.name}> queryListInIds(List<Integer> idList);
</#if>
<#if (config.methodCreateConfig.queryList?string('true','false'))=="true">

    /** 通过主键ID列表查询记录，查询指定的字段列表
    * @param query 查询条件
    * @return List<${meta.name}>
    * @author zongf
    * @date${createDate}
    */
    List<${meta.name}> queryList(${meta.name}Query query);
</#if>
<#if (config.methodCreateConfig.batchSave?string('true','false'))=="true">

    /** 批量保存. 需要注意保存数量, 单条sql长度有限制
    * @param entityList 实体列表
    * @return int
    * @author zongf
    * @date${createDate}
    */
    int batchSave(List<${meta.name}> entityList);
</#if>
<#if (config.methodCreateConfig.batchDeleteByIds?string('true','false'))=="true">

    /** 根据主键ID列表批量删除
    * @param idList 主键列表，不能为空
    * @return int 成功删除的数量
    * @author zongf
    * @date${createDate}
    */
    int batchDeleteByIds(List<Integer> idList);
</#if>
}