package org.zongf.db.meta.mysql.dao.api;

import org.zongf.db.meta.mysql.po.po.ColumnPO;
import org.zongf.db.meta.mysql.po.po.SchemaPO;
import org.zongf.db.meta.mysql.po.po.TablePO;

import java.sql.Connection;
import java.util.List;

/** 数据库元数据查询
 * @author zongf
 * @date 2019-11-30
 */
public interface IMetaDao {

    /** 数据库schemas 查询
     * @param connection 数据库连接
     * @return List<SchemaPO>
     * @author zongf
     * @date 2019-11-30
     */
    public List<SchemaPO> querySchemas(Connection connection);


    /** 数据库表信息查询
     * @param connection 数据库连接
     * @param schemas 数据库名
     * @return List<TablePO>
     * @since 1.0
     * @author zongf
     * @created 2019-11-30
     */
    public List<TablePO> queryTables(Connection connection, String schemas);

    /** 数据库表信息查询
     * @param connection 数据库连接
     * @param schemaName 数据库名
     * @return List<TablePO>
     * @since 1.0
     * @author zongf
     * @created 2019-11-30
     */
    public TablePO queryTable(Connection connection, String schemaName, String tableName);

    /** 查询表字段信息
     * @param connection 数据库连接
     * @param schemaName 数据库名
     * @param tableName 表名
     * @return List<ColumnPO>
     * @author zongf
     * @date 2019-11-30
     * @company autohome
     */
    public List<ColumnPO> queryColumns(Connection connection, String schemaName, String tableName);

}
