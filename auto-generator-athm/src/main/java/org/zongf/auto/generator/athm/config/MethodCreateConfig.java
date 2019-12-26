package org.zongf.auto.generator.athm.config;

/** 生成方法配置
 * @author zongf
 * @date 2019-12-26
 */
public class MethodCreateConfig {

    // 是否生成方法:save
    private boolean save;

    // 是否生成方法:batchSave
    private boolean batchSave;

    // 是否生成方法:deleteById
    private boolean deleteById;

    // 是否生成方法:batchDeleteByIds
    private boolean batchDeleteByIds;

    // 是否生成方法:update
    private boolean update;

    // 是否生成方法:updateNotNull
    private boolean updateNotNull;

    // 是否生成方法:queryById
    private boolean queryById;

    // 是否生成方法:queryListInIds
    private boolean queryListInIds;

    // 是否生成方法:queryList
    private boolean queryList;

    // 是否生成方法:queryPage
    private boolean queryPager;

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public boolean isBatchSave() {
        return batchSave;
    }

    public void setBatchSave(boolean batchSave) {
        this.batchSave = batchSave;
    }

    public boolean isDeleteById() {
        return deleteById;
    }

    public void setDeleteById(boolean deleteById) {
        this.deleteById = deleteById;
    }

    public boolean isBatchDeleteByIds() {
        return batchDeleteByIds;
    }

    public void setBatchDeleteByIds(boolean batchDeleteByIds) {
        this.batchDeleteByIds = batchDeleteByIds;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isUpdateNotNull() {
        return updateNotNull;
    }

    public void setUpdateNotNull(boolean updateNotNull) {
        this.updateNotNull = updateNotNull;
    }

    public boolean isQueryById() {
        return queryById;
    }

    public void setQueryById(boolean queryById) {
        this.queryById = queryById;
    }

    public boolean isQueryListInIds() {
        return queryListInIds;
    }

    public void setQueryListInIds(boolean queryListInIds) {
        this.queryListInIds = queryListInIds;
    }

    public boolean isQueryList() {
        return queryList;
    }

    public void setQueryList(boolean queryList) {
        this.queryList = queryList;
    }

    public boolean isQueryPager() {
        return queryPager;
    }

    public void setQueryPager(boolean queryPager) {
        this.queryPager = queryPager;
    }
}
