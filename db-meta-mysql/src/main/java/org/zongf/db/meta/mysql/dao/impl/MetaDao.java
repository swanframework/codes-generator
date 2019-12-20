package org.zongf.db.meta.mysql.dao.impl;

import org.zongf.db.meta.mysql.dao.api.IMetaDao;
import org.zongf.db.meta.mysql.enums.MysqlDataType;
import org.zongf.db.meta.mysql.exception.DbException;
import org.zongf.db.meta.mysql.po.ColumnPO;
import org.zongf.db.meta.mysql.po.SchemaPO;
import org.zongf.db.meta.mysql.po.TablePO;
import org.zongf.db.meta.mysql.utils.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class MetaDao implements IMetaDao {
    @Override
    public List<SchemaPO> querySchemas(Connection connection) {

        String sql = "select * from information_schema.schemata";

        ResultSet rs = DbUtil.excuteQuery(connection, sql);

        try {
            List<SchemaPO> schemaPOList = new ArrayList<>();
            while (rs.next()) {
                SchemaPO schemaPO = new SchemaPO();
                schemaPO.setCatalogName(rs.getString("CATALOG_NAME"));
                schemaPO.setSchemaName(rs.getString("SCHEMA_NAME"));
                schemaPO.setDefaultCharacterName(rs.getString("DEFAULT_CHARACTER_SET_NAME"));
                schemaPO.setDefaultCollationName(rs.getString("DEFAULT_COLLATION_NAME"));
                schemaPO.setSqlPath(rs.getString("SQL_PATH"));
                schemaPOList.add(schemaPO);
            }

            return schemaPOList.size() > 0 ? schemaPOList : null;
        } catch (SQLException ex) {
            throw new DbException("结果集解析异常", ex);
        }
    }

    @Override
    public List<TablePO> queryTables(Connection connection, String schemaName) {

        String sql = "select * from information_schema.tables where table_schema = ?";

        ResultSet rs = DbUtil.excuteQuery(connection, sql, schemaName);

        try {
            List<TablePO> tablePOList = new ArrayList<>();
            while (rs.next()) {
                TablePO tablePO = new TablePO();
                tablePO.setTableName(rs.getString("TABLE_NAME"));
                tablePO.setComment(rs.getString("TABLE_COMMENT"));
                tablePO.setEngine(rs.getString("ENGINE"));
                tablePO.setCreateTime(rs.getTimestamp("CREATE_TIME"));
                tablePOList.add(tablePO);
            }
            return tablePOList.size() > 0 ? tablePOList : null;
        } catch (SQLException ex) {
            throw new DbException("结果集解析异常", ex);
        }
    }

    @Override
    public TablePO queryTable(Connection connection, String schemaName, String tableName) {
        String sql = "select * from information_schema.tables where table_schema = ? and table_name = ?";

        ResultSet rs = DbUtil.excuteQuery(connection, sql, schemaName, tableName);

        try {
            if(rs.next()){
                TablePO tablePO = new TablePO();
                tablePO.setTableName(rs.getString("TABLE_NAME"));
                tablePO.setComment(rs.getString("TABLE_COMMENT"));
                tablePO.setEngine(rs.getString("ENGINE"));
                tablePO.setCreateTime(rs.getTimestamp("CREATE_TIME"));
                return tablePO;
            }
        } catch (SQLException ex) {
            throw new DbException("结果集解析异常", ex);
        }
        return null;
    }

    @Override
    public List<ColumnPO> queryColumns(Connection connection, String schemaName, String tableName) {

        String sql = "select * from information_schema.columns where table_schema = ? and table_name = ?";

        ResultSet rs = DbUtil.excuteQuery(connection, sql, schemaName, tableName);

        try {
            List<ColumnPO> columnPOList = new ArrayList<>();
            while (rs.next()) {
                ColumnPO columnPO = new ColumnPO();
                columnPO.setColumnName(rs.getString("COLUMN_NAME"));
                columnPO.setColunmType(rs.getString("COLUMN_TYPE"));
                columnPO.setDataType(MysqlDataType.valueOf(rs.getString("DATA_TYPE").toUpperCase()));
                columnPO.setPosition(rs.getInt("ORDINAL_POSITION"));
                columnPO.setMaxCharLength(rs.getLong("CHARACTER_MAXIMUM_LENGTH"));
                columnPO.setMaxIntDigits(rs.getInt("NUMERIC_PRECISION"));
                columnPO.setMaxDecimalDigits(rs.getInt("NUMERIC_SCALE"));
                columnPO.setComment(rs.getString("COLUMN_COMMENT"));
                columnPO.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
                columnPO.setIsAutoIncrement("auto_increment".equals(rs.getString("EXTRA")));
                columnPO.setIsNullAble("YES".equals(rs.getString("IS_NULLABLE")));
                columnPO.setIsPKColumn("PRI".equals(rs.getString("COLUMN_KEY")));
                columnPOList.add(columnPO);
            }
            return columnPOList.size() > 0 ? columnPOList : null;
        } catch (SQLException ex) {
            throw new DbException("结果集解析异常", ex);
        }
    }

    @Override
    public List<String> queryPrimaryKeys(Connection connection, String schemaName, String tableName) {

        String sql = "SELECT * FROM information_schema.key_column_usage WHERE constraint_name='PRIMARY' and table_schema = ? and table_name=?";

        ResultSet rs = DbUtil.excuteQuery(connection, sql, schemaName, tableName);

        try {
            List<String> pkList = new ArrayList<>();

            while (rs.next()) {
                String pkName = rs.getString("column_name");
                pkList.add(pkName);
            }

            return pkList.size() > 0 ? pkList : null;
        } catch (SQLException ex) {
            throw new DbException("结果集解析异常", ex);
        }
    }

}
