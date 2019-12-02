package org.zongf.db.meta.mysql.po.po;

import java.util.Date;

/** 数据库表信息
 * @author zongf
 * @date 2019-11-30
 */
public class TablePO {

    // 表名
    private String tableName;

    // 注释
    private String comment;

    // 存储引擎
    private String engine;

    // 创建时间
    private Date createTime;

	public TablePO() {
        super();
    }

	public TablePO(String tableName, String comment, String engine, Date createTime) {
        super();
		this.tableName = tableName;
		this.comment = comment;
		this.engine = engine;
		this.createTime = createTime;
    }

    public void setTableName(String tableName){
		this.tableName=tableName;
	}

	public String getTableName(){
		return this.tableName;
	}

    public void setComment(String comment){
		this.comment=comment;
	}

	public String getComment(){
		return this.comment;
	}

    public void setEngine(String engine){
		this.engine=engine;
	}

	public String getEngine(){
		return this.engine;
	}

    public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {tableName:" + tableName + ", comment:" + comment + ", engine:" + engine + ", createTime:" + createTime  + "}";
	}

}
