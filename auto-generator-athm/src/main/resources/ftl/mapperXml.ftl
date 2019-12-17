<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 命名空间使用对应的Mapper类全限定名称 -->
<mapper namespace="${config.mapperApiPackage}.${meta.name}Mapper">

    <!-- 表名 -->
    <sql id="tableName">${meta.tableName}</sql>

    <!-- 表中所有的字段 -->
    <sql id="columns_all">
        <#list meta.fields as field>${field.columnName}<#if field_index != meta.fields?size-1>, </#if></#list>
    </sql>

    <sql id="idList">
        <foreach collection="list" open="(" separator="," close=")" item="id">
            ${r'#{id}'}
        </foreach>
    </sql>

    <!-- 保存单个实体 -->
    <insert id="save" useGeneratedKeys="true" keyProperty="id">
        insert <include refid="tableName"/>(<include refid="columns_all"/>)
        values (<#list meta.fields as field>${r'#{'}${field.name}}<#if field_index != meta.fields?size-1>, </#if></#list>);
    </insert>

    <!-- 保存多个实体 -->
    <insert id="batchSave" useGeneratedKeys="true" keyProperty="id">
        insert <include refid="tableName"/>(<include refid="columns_all"/>)
        values
        <foreach collection="list" separator="," item="entity">
            (<#list meta.fields as field>${r'#{entity.'}${field.name}}<#if field_index != meta.fields?size-1>, </#if></#list>)
        </foreach>
    </insert>
${r'
    <!-- 根据id删除 -->
    <delete id="deleteById">
        delete from <include refid="tableName"/>
        where id = #{id}
    </delete>

    <!-- 批量删除: 根据主键id列表  -->
    <delete id="batchDeleteByIds">
        delete from <include refid="tableName"/>
        where id in <include refid="idList"/>
    </delete>
'}
    <!-- 更新实体 -->
    <update id="update">
        update <include refid="tableName"/>
        set
            <#list meta.fields as field>
            ${field.columnName} = ${r'#{'}${field.name}}<#if field_index != meta.fields?size-1>, </#if>
            </#list>
        where
            ${r'id = #{id}'}
    </update>

    <!-- 更新非空属性 -->
    <update id="updateNotNull">
        update <include refid="tableName"/>
        <set>
            <#list meta.fields as field>
            <if test="${field.name} != null">${field.columnName} = ${r'#{'}${field.name}}<#if field_index != meta.fields?size-1>, </#if></if>
            </#list>
        </set>
        where
            ${r'id = #{id}'}
    </update>

    <!-- 通过主键id 查询实体 -->
    <select id="queryById" resultType="${config.entityPackage}.${meta.name}">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id = ${r'#{id}'}
    </select>

    <!-- 通过主键id 查询实体 -->
    <select id="queryListInIds" resultType="${config.entityPackage}.${meta.name}">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id in <include refid="idList"/>
    </select>

    <!-- 通过主键id 查询实体 -->
    <select id="queryList" resultType="${config.entityPackage}.${meta.name}">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
    </select>

    <select id="queryTotalCount" resultType="java.lang.Integer">
        select count(id)
        from <include refid="tableName"/>
    </select>

</mapper>
