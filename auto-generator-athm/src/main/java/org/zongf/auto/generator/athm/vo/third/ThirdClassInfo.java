package org.zongf.auto.generator.athm.vo.third;

import java.util.ArrayList;
import java.util.List;

/** 类信息
 * @author zongf
 * @date 2020-01-07
 */
public class ThirdClassInfo {

    // 类名
    private String className;

    // 字段列表
    private List<ThirdFieldInfo> fieldList = new ArrayList<>();

	public ThirdClassInfo() {
        super();
    }

	public ThirdClassInfo(String className, List<ThirdFieldInfo> fieldList) {
        super();
		this.className = className;
		this.fieldList = fieldList;
    }

    public void setClassName(String className){
		this.className=className;
	}

	public String getClassName(){
		return this.className;
	}

    public void setFieldList(List<ThirdFieldInfo> fieldList){
		this.fieldList=fieldList;
	}

	public List<ThirdFieldInfo> getFieldList(){
		return this.fieldList;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {className:" + className + ", fieldList:" + fieldList  + "}";
	}

}
