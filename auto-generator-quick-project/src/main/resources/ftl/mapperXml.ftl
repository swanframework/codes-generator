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



${r'
    <!-- 表中特定的字段列表 -->
    <sql id="columns_special">
        id <foreach collection="fieldList" item="field"> , ${field.columnName}</foreach>
    </sql>

    <!-- id列表: 方法形参为一个时，内置变量名为list-->
    <sql id="idList">
        <foreach collection="list" open="(" separator="," close=")" item="id">
            #{id}
        </foreach>
    </sql>

    <!-- id列表: 方法形参为多个时，内置变量名为idList-->
    <sql id="condition2_idList">
        <foreach collection="idList" open="(" separator="," close=")" item="id">
            #{id}
        </foreach>
    </sql>

    <!-- 选择字段 -->
    <sql id="condition_select">
        <if test="distinct">distinct </if>
        <if test="fields == null">
            <include refid="columns_all"/>
        </if>
        <if test="fields != null">
            <foreach collection="fields" separator="," item="field">
                ${field.columnName}
            </foreach>
        </if>
    </sql>
'}
    <!-- where条件 -->
    <sql id="condition_where">
        <if test="conditions != null">
            <foreach collection="conditions" item="condition">
                ${r'${condition.relationType}'}
                <if test="condition.caseSensitive">binary</if>
                <if test="condition.operatorType.toString() == 'equals'">
                    ${r'${condition.field.columnName} = #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'notEquals'">
                    ${r'${condition.field.columnName} != #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'greaterhan'">
                    ${r'${condition.field.columnName} &gt; #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'lessThan'">
                    ${r'${condition.field.columnName} &lt; #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'greaterOrEquals'">
                    ${r'${condition.field.columnName} <![CDATA[>=]]> #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'lessOrEqualsThan'">
                    ${r'${condition.field.columnName} <![CDATA[<=]]> #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'isNull'">
                    ${r'${condition.field.columnName} is null'}
                </if>
                <if test="condition.operatorType.toString() == 'isNotNull'">
                    ${r'${condition.field.columnName} is not null'}
                </if>
                <if test="condition.operatorType.toString() == 'in'">
                    <if test="condition.value instanceof java.util.List or condition.value instanceof java.util.Set">
                        ${r'${condition.field.columnName} in'}
                        <foreach collection="condition.value" open="(" separator="," close=")" item="item">
                            ${r'#{item}'}
                        </foreach>
                    </if>
                    <if test="!(condition.value instanceof java.util.List or condition.value instanceof java.util.Set)">
                        ${r'${condition.field.columnName} = #{condition.value}'}
                    </if>
                </if>
                <if test="condition.operatorType.toString() == 'like'">
                    <bind name="pattern" value="'%' + condition.value + '%'"/>

                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'startWith'">
                    <bind name="pattern" value="condition.value + '%'"/>
                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'endWith'">
                    <bind name="pattern" value="'%' + condition.value"/>
                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'contains'">
                    instr( ${r'${condition.field.columnName}, #{condition.value} )>0'}
                </if>
            </foreach>
        </if>
    </sql>
${r'
    <!-- 更新字段 -->
    <sql id="condition_set">
        id = id
        <if test="setMap != null">
            <foreach collection="setMap" index="field" item="value">
                ,${field.columnName} = #{value}
            </foreach>
        </if>
    </sql>

    <!-- 排序 -->
    <sql id="condition_order">
        <if test="orderRules != null">
            order by
            <foreach collection="orderRules" item="rule" separator=",">
                ${rule.field.columnName} ${rule.sortType}
            </foreach>
        </if>
    </sql>

    <!--**************************************** 当参数为多个参数时 ****************************************-->
    <!-- 当参数为多个时，需特殊处理 -->

    <!-- 选择字段 -->
    <sql id="query_condition_select">
        <if test="queryCondition.distinct">distinct </if>
        <if test="queryCondition.fields == null">
            <include refid="columns_all"/>
        </if>
        <if test="queryCondition.fields != null">
            <foreach collection="queryCondition.fields" separator="," item="field">
                ${field.columnName}
            </foreach>
        </if>
    </sql>
'}
    <!-- where条件 -->
    <sql id="query_condition_where">
        <if test="queryCondition.conditions != null">
            <foreach collection="queryCondition.conditions" item="condition">
                ${r'${condition.relationType}'}
                <if test="condition.caseSensitive">binary</if>
                <if test="condition.operatorType.toString() == 'equals'">
                    ${r'${condition.field.columnName} = #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'notEquals'">
                    ${r'${condition.field.columnName} != #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'greaterhan'">
                    ${r'${condition.field.columnName} &gt; #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'lessThan'">
                    ${r'${condition.field.columnName} &lt; #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'greaterOrEquals'">
                    ${r'${condition.field.columnName} <![CDATA[>=]]> #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'lessOrEqualsThan'">
                    ${r'${condition.field.columnName} <![CDATA[<=]]> #{condition.value}'}
                </if>
                <if test="condition.operatorType.toString() == 'isNull'">
                    ${r'${condition.field.columnName} is null'}
                </if>
                <if test="condition.operatorType.toString() == 'isNotNull'">
                    ${r'${condition.field.columnName} is not null'}
                </if>
                <if test="condition.operatorType.toString() == 'in'">
                    <if test="condition.value instanceof java.util.List or condition.value instanceof java.util.Set">
                        ${r'${condition.field.columnName} in'}
                        <foreach collection="condition.value" open="(" separator="," close=")" item="item">
                            ${r'#{item}'}
                        </foreach>
                    </if>
                    <if test="!(condition.value instanceof java.util.List or condition.value instanceof java.util.Set)">
                        ${r'${condition.field.columnName} = #{condition.value}'}
                    </if>
                </if>
                <if test="condition.operatorType.toString() == 'like'">
                    <bind name="pattern" value="'%' + condition.value + '%'"/>

                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'startWith'">
                    <bind name="pattern" value="condition.value + '%'"/>
                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'endWith'">
                    <bind name="pattern" value="'%' + condition.value"/>
                    ${r'${condition.field.columnName} like #{pattern}'}
                </if>
                <if test="condition.operatorType.toString() == 'contains'">
                    instr( ${r'${condition.field.columnName}, #{condition.value} )>0'}
                </if>
            </foreach>
        </if>
    </sql>
${r'
    <!-- 排序 -->
    <sql id="query_condition_order">
        <if test="queryCondition.orderRules != null">
            order by
            <foreach collection="orderRules" item="rule" separator=",">
                ${rule.field.columnName} ${rule.sortType}
            </foreach>
        </if>
    </sql>
'}
    <!--**************************************** save ****************************************-->

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
    <!--**************************************** delete ****************************************-->

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

    <!-- 批量删除: 根据主键id列表  -->
    <delete id="batchDelete">
        delete from <include refid="tableName"/>
        where id in
        <foreach collection="list" open="(" separator="," close=")" item="entity">
            #{entity.id}
        </foreach>
    </delete>

    <delete id="batchDeleteOnStrategy">
        delete from <include refid="tableName"/>
        <where>
            <include refid="condition_where"/>
        </where>
    </delete>
'}
    <!--**************************************** update ****************************************-->

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
${r'
    <!-- 更新指定属性 -->
    <update id="updateFields">
        update <include refid="tableName"/>
        set
            id = #{entity.id}
        <foreach collection="fieldList" item="field">
            , ${field.columnName} = #{entity.${field}}
        </foreach>
        where
            id = #{entity.id}
    </update>

    <update id="batchUpdateOnStrategy">
        update <include refid="tableName"/>
        <set>
            <include refid="condition_set"/>
        </set>
        <where>
            <include refid="condition_where"/>
        </where>
    </update>
 '}
${r'
    <!--**************************************** queryById ****************************************-->
    <!-- 通过主键id 查询实体 -->
    <select id="queryById" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id = #{id}
    </select>

    <!-- 通过主键id 查询实体 -->
    <select id="queryByIdIncludeFields" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_special"/>
        from <include refid="tableName"/>
        where id = #{id}
    </select>

    <!--**************************************** queryListInIds ****************************************-->
    <!-- 通过主键id 查询实体 -->
    <select id="queryListInIds" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id in <include refid="idList"/>
    </select>

    <!-- 通过主键id 查询实体 -->
    <select id="queryListInIdsIncludeFields" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_special"/>
        from <include refid="tableName"/>
        where id in <include refid="condition2_idList"/>
    </select>

    <!--**************************************** queryMapInIds ****************************************-->
    <select id="queryMapInIds" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id in <include refid="idList"/>
    </select>

    <select id="queryMapInIdsIncludeFields" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="columns_special"/>
        from <include refid="tableName"/>
        where id in <include refid="condition2_idList"/>
    </select>

    <!--**************************************** queryMapInIds ****************************************-->
    <select id="queryColumnMapById" resultType="java.util.Map">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id = #{id}
    </select>
    <select id="queryColumnMapListInIds" resultType="java.util.Map">
        select <include refid="columns_all"/>
        from <include refid="tableName"/>
        where id in <include refid="idList"/>
    </select>

    <select id="queryTotalCount" resultType="java.lang.Integer">
        select count(id)
        from <include refid="tableName"/>
    </select>

    <select id="queryCountOnStrategy" resultType="java.lang.Integer">
        select count(*)
        from (
            select <include refid="condition_select"/>
                from <include refid="tableName"/>
            <where>
                <include refid="condition_where"/>
            </where>
            <include refid="condition_order"/>
        ) t
    </select>

    <!--**************************************** queryOnCondition ****************************************-->
    <select id="queryListOnStrategy" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="condition_select"/>
        from <include refid="tableName"/>
        <where>
            <include refid="condition_where"/>
        </where>
        <include refid="condition_order"/>
    </select>

    <select id="queryPagerOnStrategy" resultType="org.zongf.test.helper.mybatis.persistence.entity.UserEntity">
        select <include refid="query_condition_select"/>
        from <include refid="tableName"/>
        <where>
            <include refid="query_condition_where"/>
        </where>
        <include refid="query_condition_order"/>
    </select>

    <!--**************************************** truncate ****************************************-->
    <delete id="truncate">
        truncate <include refid="tableName"/>
    </delete>
</mapper>
'}