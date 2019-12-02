package org.zongf.auto.generator.vo;

import java.util.ArrayList;
import java.util.List;

/** 查询条件
 * @author: zongf
 * @date: 2019-12-02
 */
public class SimpleQueryCondition {

    // 条件列表
    private List<ColumnCondition> conditions;

    // 排序规则
    private List<OrderRule> orderRules;

    public SimpleQueryCondition() {
        this.conditions = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    public SimpleQueryCondition and(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public SimpleQueryCondition or(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public SimpleQueryCondition orderBy(String columnName, SortType sortType){
        this.orderRules.add(new OrderRule(columnName, sortType));
        return this;
    }

}

class ColumnCondition{
    
    private RelationType relationType;

    // 字段名称
    private String columnName;

    // 关系
    private OperatorType operatorType;

    // 值
    private Object value;

	public ColumnCondition() {
        super();
    }

	public ColumnCondition(RelationType relationType, String columnName, OperatorType operatorType, Object value) {
        super();
		this.relationType = relationType;
		this.columnName = columnName;
		this.operatorType = operatorType;
		this.value = value;
    }

    public void setRelationType(RelationType relationType){
		this.relationType=relationType;
	}

	public RelationType getRelationType(){
		return this.relationType;
	}

    public void setColumnName(String columnName){
		this.columnName=columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

    public void setOperatorType(OperatorType operatorType){
		this.operatorType=operatorType;
	}

	public OperatorType getOperatorType(){
		return this.operatorType;
	}

    public void setValue(Object value){
		this.value=value;
	}

	public Object getValue(){
		return this.value;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {relationType:" + relationType + ", columnName:" + columnName + ", operatorType:" + operatorType + ", value:" + value  + "}";
	}

}

class OrderRule{
    
    // 排序字段名称
    private String columnName;

    // 排序类型
    private SortType sortType;

	public OrderRule() {
        super();
    }

	public OrderRule(String columnName, SortType sortType) {
        super();
		this.columnName = columnName;
		this.sortType = sortType;
    }

    public void setColumnName(String columnName){
		this.columnName=columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

    public void setSortType(SortType sortType){
		this.sortType=sortType;
	}

	public SortType getSortType(){
		return this.sortType;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {columnName:" + columnName + ", sortType:" + sortType  + "}";
	}

}

enum RelationType{
    AND, OR;
}

enum OperatorType {
    equals("="),
    notEquals("!="),
    greaterThan(">"),
    lessThan("<"),
    notGreaterThan("<="),
    notLessThan(">="),
    igCaseEquals("="),
    igCaseNotEquals("!="),
    isNull("is null"),
    isNotNull("is not null"),
    in("in"),
    like("like");

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }
}

enum SortType {
    DESC, ASC;
}
