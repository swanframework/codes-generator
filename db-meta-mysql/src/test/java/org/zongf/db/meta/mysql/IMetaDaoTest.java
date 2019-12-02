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

    @Test
    public void testMetaList(){
        List<SchemaPO> schemaPOList = this.metaDao.querySchemas(connection);
        schemaPOList.forEach(System.out::println);
    }

    @Test
    public void testTables(){
        List<TablePO> tablePOS = this.metaDao.queryTables(connection, "codes-generator");
        tablePOS.forEach(System.out::println);
    }

    @Test
    public void testColumns(){
        List<ColumnPO> columnPOList = this.metaDao.queryColumns(connection, "codes-generator", "t_type");
        for (ColumnPO column : columnPOList) {
            System.out.println(column.getColumnName() + ":" + column.getJavaType() + ":" + column.getColunmType());
        }
        columnPOList.forEach(System.out::println);
    }

    @Test
    public void test(){
    }

}
