<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${pakageName}.${daoName?cap_first}">

    <!-- 数据库表${tablePO.tableName}所有字段 -->
    <sql id="full_columns">
        <#list columnPOList as columnPO>${columnPO.columnName}<#if columnPO_index < (columnPOList?size-1)>, </#if></#list>
    </sql>

    <!-- 增：向数据库中新增一条记录   -->
    <insert id="save" parameterType="${poName?cap_first}" keyProperty="id" useGeneratedKeys="true">
        INSERT INTO ${tablePO.tableName}(<include refid="full_columns" />)
        VALUES (null, <#list columnPOList as columnPO><#if columnPO.columnName != "id">${r'#{'}${columnPO.columnName}}<#if columnPO_index < (columnPOList?size-1)>, </#if></#if></#list>)
    </insert>

    <!-- 删：根据id 从数据库删除一条记录  -->
    <delete id="delete">
        DELETE FROM ${tablePO.tableName} WHERE id=${r'#'}{id}
    </delete>

    <!-- 改：更新数据库中的一条记录   1. 更新所有属性   2. 主键id不能为空  -->
    <update id="update" parameterType="${poName?cap_first}">
        update ${tablePO.tableName}
        <set>
        <#list columnPOList as columnPO>
            <#if columnPO.columnName != "id">
                ${columnPO.columnName} = ${r'#'}{${columnPO.columnName}}<#if columnPO_index < (columnPOList?size-1)>, </#if>
            </#if>
        </#list>
        </set>
        where id = ${r'#'}{id}
    </update>

    <!-- 改：更新数据库中的一条记录   1. 更新所有属性   2. 主键id不能为空  -->
    <update id="updateNotNull" parameterType="${poName?cap_first}">
        update ${tablePO.tableName}
        <set>
    <#list columnPOList as columnPO>
        <#if columnPO.columnName != "id">
            <if test="${columnPO.columnName} != null">
                ${columnPO.columnName} = ${r'#'}{${columnPO.columnName}}<#if columnPO_index < (columnPOList?size-1)>, </#if>
            </if>
        </#if>
    </#list>
        </set>
        where id = ${r'#'}{id}
    </update>

    <!-- 查：通过id从数据库中查询记录,如果不存在返回null -->
    <select id="find" resultType="${poName?cap_first}">
        SELECT * FROM ${tablePO.tableName} WHERE id=${r'#'}{id}
    </select>

    <!-- 查询：从数据库中查询表中所有记录  -->
    <select id="queryList" resultType="${poName?cap_first}">
        SELECT * FROM ${tablePO.tableName} WHERE 1=1
    </select>

</mapper>