package ${config.serviceApiPackage};

import org.zongf.helper.mybatis.pager.PageBounds;
import org.zongf.helper.mybatis.pager.PageResult;
import org.zongf.helper.spring.dto.BaseQuery;
import ${config.entityPackage}.${meta.name}Entity;

import java.util.List;

public interface I${meta.name}Service {

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

    /** 更新实体, 只更新所有非null 属性
     * @param entity  包含ID属性的实体
     * @return boolean 如果记录不存在, 返回false
     * @author zongf
     * @date ${meta.createDate}
     */
    boolean updateNotNull(${meta.name}Entity entity);

    /** 通过主键ID查询记录, 查询所有字段
     * @param id 主键ID
     * @return ${meta.name}Entity 实体
     * @author zongf
     * @date ${meta.createDate}
     */
    ${meta.name}Entity queryById(Long id);


    /** 查询列表
     * @param query 请求对象
     * @return List<${meta.name}Entity>
     * @author zongf
     * @date ${meta.createDate}
     * @company autohome
     */
    List<${meta.name}Entity> queryList(BaseQuery query);

    /** 分页查询列表
     * @param query 请求对象
     * @param pageBounds 分页对象
     * @return PageResult<${meta.name}Entity>
     * @author zongf
     * @date ${meta.createDate}
     */
    PageResult<${meta.name}Entity> queryPager(BaseQuery query, PageBounds pageBounds);
}