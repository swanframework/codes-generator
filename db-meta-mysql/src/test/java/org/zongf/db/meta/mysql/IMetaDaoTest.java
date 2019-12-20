package org.zongf.db.meta.mysql;

import org.junit.Before;
import org.junit.Test;
import org.zongf.db.meta.mysql.dao.api.IMetaDao;
import org.zongf.db.meta.mysql.dao.impl.MetaDao;
import org.zongf.db.meta.mysql.enums.JavaMappingType;
import org.zongf.db.meta.mysql.po.po.ColumnPO;
import org.zongf.db.meta.mysql.po.po.SchemaPO;
import org.zongf.db.meta.mysql.po.po.TablePO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @author zongf
 * @date 2019-11-30
 * @company autohome
 */
public class IMetaDaoTest {

    private IMetaDao metaDao = new MetaDao();

    private Connection connection;

    private static final String SCHEMA_NAME = "codes-generator";

    /** 查询数据库列表 */
    @Test
    public void querySchemas(){
        List<SchemaPO> schemaPOList = this.metaDao.querySchemas(connection);
        schemaPOList.forEach(System.out::println);
    }

    /** 查询数据库下所有表 */
    @Test
    public void queryTables(){
        List<TablePO> tablePOS = this.metaDao.queryTables(connection, SCHEMA_NAME);
        tablePOS.forEach(System.out::println);
    }

    /** 查询表中所有字段 */
    @Test
    public void queryColumns(){
        List<ColumnPO> columnPOList = this.metaDao.queryColumns(connection, SCHEMA_NAME, "user");
        columnPOList.forEach(System.out::println);
    }

    /** 查询表的主键列名 */
    @Test
    public void queryPrimaryKeys(){
        List<String> pkList = this.metaDao.queryPrimaryKeys(connection, SCHEMA_NAME, "user");
        pkList.forEach(System.out::println);
    }

    @Before
    public void setUp(){
        String host = "127.0.0.1";
        int port = 3306;
        String username = "root";
        String password = "root";

        String url = "jdbc:mysql://" + host + ":" + port + "?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
