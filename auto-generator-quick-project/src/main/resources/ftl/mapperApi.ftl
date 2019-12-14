package ${meta.packageName};

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.zongf.helper.mybatis.condition.DeleteStrategy;
import org.zongf.helper.mybatis.condition.QueryStrategy;
import org.zongf.helper.mybatis.condition.UpdateStrategy;
import org.zongf.helper.mybatis.pager.PageBounds;
import org.zongf.helper.mybatis.pager.PageResult;

<#list meta.imports as import>
import ${import};
</#list>

import java.util.List;
import java.util.Map;

/** 数据库表[${meta.tableName}]通用操作API
 * @author zongf
 * @date ${meta.createDate}
 */
@Mapper
public interface ${meta.name}Mapper {

    /** 保存实体
     * @param entity 数据库实体
     * @return boolean
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean save(${meta.name}Entity entity);

    /** 批量保存. 需要注意保存数量, 单条sql长度有限制
     * @param entityList 实体列表
     * @return int
     * @author zongf
     * @date ${meta.createDate}
     */
    int batchSave(List<${meta.name}Entity> entityList);

    /** 根据主键ID 删除记录
     * @param id  主键ID
     * @return boolean 记录不存在返回false
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean deleteById(Long id);


    /** 根据主键ID列表批量删除
     * @param idList 主键列表，不能为空
     * @return int 成功删除的数量
     * @author zongf
     * @date ${meta.createDate}
     */
    int batchDeleteByIds(List<Long> idList);

    /** 根据实体批量删除
     * @param entityList 实体列表
     * @return int 成功删除的数量
     * @author zongf
     * @date ${meta.createDate}
     */
    int batchDelete(List<${meta.name}Entity> entityList);


    /** 根据条件批量删除
     * @param deleteStrategy 条件类
     * @return int
     * @author zongf
     * @date ${meta.createDate}
     */
    int batchDeleteOnStrategy(DeleteStrategy deleteStrategy);

    /** 更新实体, 更新所有字段信息
     * @param entity  包含ID属性的实体
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean update(${meta.name}Entity entity);


    /** 更新实体, 只更新所有非null 属性
     * @param entity  包含ID属性的实体
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean updateNotNull(${meta.name}Entity entity);


    /** 更新实体, 只更新指定的字段
     * @param entity  包含ID属性的实体
     * @param fieldList 需要更新的字段列表
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean updateFields(${meta.name}Entity entity, List<${meta.name}FieldEnum> fieldList);


    /** 批量更新记录
     * @param updateStrategy 更新条件
     * @return int 更新的记录数
     * @author zongf
     * @date ${meta.createDate}
     */
    int batchUpdateOnStrategy(UpdateStrategy<${meta.name}FieldEnum> updateStrategy);

    /** 查询记录总数量
     * @return int 总数量
     * @author zongf
     * @date ${meta.createDate}
     */
    int queryTotalCount();

    /** 查询满足条件的记录总数
     * @param conditionStrategy 查询条件
     * @return int 记录总数
     * @author zongf
     * @date ${meta.createDate}
     */
    int queryCountOnStrategy(QueryStrategy<${meta.name}FieldEnum> conditionStrategy);

    /** 通过主键ID查询记录, 查询所有字段
     * @param id 主键ID
     * @return ${meta.name}Entity 实体
     * @author zongf
     * @date ${meta.createDate}
     */
    ${meta.name}Entity queryById(Long id);


    /** 通过主键ID查询记录, 指定查询的字段
     * @param id 主键ID
     * @param fieldList 字段列表
     * @return ${meta.name}Entity
     * @author zongf
     * @date ${meta.createDate}
     */
    ${meta.name}Entity queryByIdIncludeFields(Long id, List<${meta.name}FieldEnum> fieldList);

    /** 通过主键ID列表查询记录，查询所有字段
     * @param idList 主键ID列表
     * @return List<${meta.name}Entity> 查询为空时, 返回list的size为0，而不会返回null
     * @author zongf
     * @date ${meta.createDate}
     */
    List<${meta.name}Entity> queryListInIds(List<Long> idList);

    /** 通过主键ID列表查询记录，查询指定的字段列表
     * @param idList 主键ID列表
     * @param fieldList 需要查询的字段列表
     * @return List<${meta.name}Entity>
     * @author zongf
     * @date ${meta.createDate}
     */
    List<${meta.name}Entity> queryListInIdsIncludeFields(List<Long> idList, List<${meta.name}FieldEnum> fieldList);

    /** 通过主键ID列表查询, 返回主键和实体的映射关系表
     * @param idList 主键ID列表
     * @return Map<Long,${meta.name}Entity> 不会返回null, 查询不到时返回size为0
     * @author zongf
     */
    @MapKey("id")
    Map<Long, ${meta.name}Entity> queryMapInIds(List<Long> idList);

    /** 通过主键ID列表查询, 返回主键和实体的映射关系表，指定查询的字段
     * @param idList 主键ID列表
     * @param fieldList 需要返回的字段列表
     * @return Map<Long,${meta.name}Entity> 不会返回null, 查询不到时返回size为0
     * @author zongf
     * @date ${meta.createDate}
     */
    @MapKey("id")
    Map<Long, ${meta.name}Entity> queryMapInIdsIncludeFields(List<Long> idList, List<${meta.name}FieldEnum> fieldList);

    /** 查询列表，条件为空时，查询所有
     * @param queryStrategy 查询条件
     * @return List<${meta.name}Entity>
     * @author zongf
     * @date ${meta.createDate}
     */
    List<${meta.name}Entity> queryListOnStrategy(QueryStrategy<${meta.name}FieldEnum> queryStrategy);

    /** 分页查询, 条件为空时, 查询所有
     * @param queryCondition 查询条件
     * @param pageBounds 分页参数
     * @return PageResult<${meta.name}Entity>
     * @author zongf
     * @date ${meta.createDate}
     */
    PageResult<${meta.name}Entity> queryPagerOnStrategy(QueryStrategy<${meta.name}FieldEnum> queryCondition, PageBounds pageBounds);

    /** 通过主键ID查询, 返回列名和值组成的map
     * @param id 主键id
     * @return Map<String,Object> 不会返回null, 查询不到时返回size为0
     * @author zongf
     * @date ${meta.createDate}
     */
    Map<String, Object> queryColumnMapById(Long id);

    /** 通过主键ID列表查询, 返回列名和值组成的map的集合
     * @param idList 主键ID列表
     * @return List<Map<String,Object>> 不会返回null, 查询不到时返回size为0
     * @author zongf
     * @date ${meta.createDate}
     */
    List<Map<String, Object>> queryColumnMapListInIds(List<Long> idList);

    /** 清空表和自增索引, 测试时用
     * @author zongf
     * @date ${meta.createDate}
     */
    void truncate();
}