package org.zongf.auto.generator.athm.vo.ddl;

/** 字段定义信息
 * @author zongf
 * @date 2019-11-30
 */
public class ColumnDefineInfo {

    // 字段名称
    private String name;

    // 字段类型
    private String type;

    // 注释
    private String comment;

    // 默认值
    private String defaultValue;

    // 非空
    private boolean notNull;

    // 是否唯一
    private boolean unique;

    // 是否是主键
    private boolean pk;

    // 是否自增
    private boolean autoCreate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public boolean isAutoCreate() {
        return autoCreate;
    }

    public void setAutoCreate(boolean autoCreate) {
        this.autoCreate = autoCreate;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", notNull=" + notNull +
                ", unique=" + unique +
                ", pk=" + pk +
                ", autoCreate=" + autoCreate +
                '}';
    }
}
