package org.zongf.auto.generator.quick.persistence.entity;

import java.math.BigInteger;

/** 用户表, 映射表:user
* @author zongf
* @date 2019-12-13
*/
public class UserEntity {

    // 主键ID
    private Long id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 邮箱
    private String email;

    // 
    private String nickName;

    public UserEntity() {
        super();
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(Integer age){
        this.age=age;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setNickName(String nickName){
        this.nickName=nickName;
    }

    public String getNickName(){
        return this.nickName;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() + ": {id:" + id + ", name:" + name + ", age:" + age + ", email:" + email + ", nickName:" + nickName  + "}";
    }

}
