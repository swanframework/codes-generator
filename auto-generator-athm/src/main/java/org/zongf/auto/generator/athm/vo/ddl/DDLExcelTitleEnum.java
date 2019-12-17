package org.zongf.auto.generator.athm.vo.ddl;

/** excel 标题顺序
 * @author zongf
 * @date 2019-11-30
 */
public enum DDLExcelTitleEnum {

    columnName("字段名"),
    columnType("字段类型"),
    columnDesc("字段描述"),
    defaultVal("默认值"),
    isNotNull("非空"),
    isUnique("唯一"),
    isPK("主键"),
    isAutoCreate("自增");

    private String text;

    DDLExcelTitleEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
