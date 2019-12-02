package service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

import java.util.Map;

/**
 * @author: zongf
 * @created: 2019-12-02
 * @since 1.0
 */
public interface UserMapper {

    /*
       1. 单个API 返回布尔类型, 批量api返回int 类型
       2.
     *
     */


    boolean save(UserPO userPO);
    int batchSave(List<UserPO> list);

    boolean deleteById(Integer id);
    int batchDelete(List<UserPO> list);
    int batchDeleteByIds(List<Integer> list);
    int batchDeleteByCondition(SimpleQueryCondition simpleQuery);

    boolean update(UserPO userPO);
    boolean update(UserPO userPO, List<String> fieldNameList);
    boolean updateNotNull(UserPO userPO);

    int batchUpdate(List<UserPO> list);
    int batchUpdate(List<UserPO> list, List<String> fieldNameList);
    int batchUpdateNotNull(List<UserPO> list);
    int batchUpdateByCondition(Map<String, Object> valMap, SimpleQueryCondition simpleQuery);

    UserPO queryById(Integer id);
    List<UserPO> queryByIds(List<Integer> ids);
    List<UserPO> queryList();
    List<UserPO> queryList(SimpleQueryCondition simpleQuery);

    int queryCount();
    int queryCount(SimpleQueryCondition simpleQuery);

    Map<String, Object> queryMapById(Integer id);
    Map<Integer, Object> queryMapByIds(List<Integer> ids);
    List<Map<String, Object>> queryMapsByIds(List<Integer> ids);

    PageList<UserPO> queryPager();
    PageList<UserPO> queryPager(SimpleQueryCondition simpleQuery);

}
