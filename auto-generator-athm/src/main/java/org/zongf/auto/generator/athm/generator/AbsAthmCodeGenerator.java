package org.zongf.auto.generator.athm.generator;

import org.zongf.auto.generator.athm.config.ProjectConfig;
import org.zongf.auto.generator.utils.EntityMetaUtil;
import org.zongf.auto.generator.vo.EntityMetaInfo;
import org.zongf.db.meta.mysql.utils.DbUtil;

import java.sql.Connection;

/** Athm 代码生成器抽象基类
 * @author zongf
 * @date 2019-11-30
 */
public abstract class AbsAthmCodeGenerator {

    // 项目配置
    protected final ProjectConfig projectConfig;

    // 数据库名
    protected final String schemaName;

    // 表名
    protected final String tableName;

    // 实体信息
    protected EntityMetaInfo metaInfo;

    public AbsAthmCodeGenerator(ProjectConfig projectConfig, String schemaName, String tableName) {
        this.projectConfig = projectConfig;
        this.schemaName = schemaName;
        this.tableName = tableName;

        this.initMetaInfo();
    }

    /** 初始化实体信息 */
    private void initMetaInfo(){
        // 获取数据库连接
        Connection connection = DbUtil.openConnection();

        // 查询表元数据信息
        metaInfo = EntityMetaUtil.queryEntityMetaInfo(connection, schemaName, tableName);

        // 关闭数据库连接
        DbUtil.close(connection);
    }

}
