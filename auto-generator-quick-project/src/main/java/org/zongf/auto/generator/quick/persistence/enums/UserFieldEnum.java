package org.zongf.auto.generator.quick.persistence.enums;

/** Java实体属性与表字段名映射, 表:user
* @author zongf
* @date 2019-12-13
*/
public enum UserFieldEnum {

    /** 主键ID */
    id("id"), 

    /** 姓名 */
    name("name"), 

    /** 年龄 */
    age("age"), 

    /** 邮箱 */
    email("email"), 

    /**  */
    nickName("nick_name");

    private String columnName;

    UserFieldEnum(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

}
