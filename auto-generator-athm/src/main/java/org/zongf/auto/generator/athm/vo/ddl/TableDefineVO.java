package org.zongf.auto.generator.athm.vo.ddl;

import java.util.List;

/** 表定义信息
 * @author zongf
 * @date 2019-11-30
 */
public class TableDefineVO {

    // 表名
    private String name;

    // 表注释
    private String comment;

    // 存储引擎
    private String engine = "INNODB";

    // 字符集编码
    private String charSet = "UTF8";

    // 字段列表
    private List<ColumnDefineInfo> columnInfoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public List<ColumnDefineInfo> getColumnInfoList() {
        return columnInfoList;
    }

    public void setColumnInfoList(List<ColumnDefineInfo> columnInfoList) {
        this.columnInfoList = columnInfoList;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", engine='" + engine + '\'' +
                ", charSet='" + charSet + '\'' +
                ", columnInfoList=" + columnInfoList +
                '}';
    }
}
