package org.zongf.auto.generator.utils;

import org.zongf.auto.generator.vo.ClassMetaVO;
import org.zongf.db.meta.mysql.po.vo.FieldVO;
import org.zongf.db.meta.mysql.dao.api.IMetaDao;
import org.zongf.db.meta.mysql.dao.impl.MetaDao;
import org.zongf.db.meta.mysql.enums.JavaMappingType;
import org.zongf.db.meta.mysql.po.po.ColumnPO;
import org.zongf.db.meta.mysql.po.po.TablePO;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class ClassMetaUtil {

    private static IMetaDao metaDao  = new MetaDao();

    /** 获取Athm po 信息
     * @param connection 数据库连接
     * @param schemaName  数据库名称
     * @param tableName  表名
     * @param packageName  包名
     * @return ClassMetaVO
     * @author zongf
     * @date 2019-11-30
     */
    public static ClassMetaVO getClassMetaVO(Connection connection, String schemaName, String tableName, String packageName) {

        // 查询表详情
        TablePO tablePO = metaDao.queryTable(connection, schemaName, tableName);
        List<ColumnPO> columnPOList = metaDao.queryColumns(connection, schemaName, tableName);

        // 处理表基本信息
        ClassMetaVO classMetaVO = new ClassMetaVO();
        classMetaVO.setCreateDate(getToday());
        classMetaVO.setComment(tablePO.getComment());
        classMetaVO.setPackageName(packageName);

        // 处理表名
        handlePOName(classMetaVO, tableName);

        // 处理字段信息
        handleColumns(classMetaVO, columnPOList);

        // 处理依赖包
        handleImports(classMetaVO, columnPOList);

        return classMetaVO;
    }

    /** 处理po 名称
     * @param classMetaVO
     * @param tableName  表名
     * @author zongf
     * @date 2019-11-30
     */
    private static void handlePOName(ClassMetaVO classMetaVO, String tableName) {
        String humpName = toHumpName(tableName);
        classMetaVO.setName(humpName.substring(0, 1).toUpperCase() + humpName.substring(1));
    }

    /** 处理表字段信息
     * @param classMetaVO  po 模型
     * @param columnPOList  字段列表
     * @author zongf
     * @date 2019-11-30
     */
    private static void handleColumns(ClassMetaVO classMetaVO, List<ColumnPO> columnPOList) {
        // 解析字段
        for (ColumnPO columnPO : columnPOList) {
            FieldVO athmColumn = new FieldVO();
            athmColumn.setType(columnPO.getJavaType().toString());
            athmColumn.setComment(columnPO.getComment());
            athmColumn.setName(toHumpName(columnPO.getColumnName()));
            classMetaVO.getColumns().add(athmColumn);
        }
    }

    /** 处理表依赖信息
     * @param classMetaVO po 模型
     * @param columnPOList 字段列表
     * @author zongf
     * @date 2019-11-30
     */
    private static void handleImports(ClassMetaVO classMetaVO, List<ColumnPO> columnPOList) {

        Set<String> importSet = new HashSet<>();

        // 解析字段
        for (ColumnPO columnPO : columnPOList) {
            // 处理导入字段依赖
            String importType = getImportType(columnPO.getJavaType());
            if(importType != null) importSet.add(importType);

            // 对imports 进行排序
            List<String> imports = new ArrayList<>(importSet);
            Collections.sort(imports);
            classMetaVO.setImports(imports);
        }
    }

    /** 将匈牙利命名改为驼峰命名
     * @param hungaryName 匈牙利命名
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    private static String toHumpName(String hungaryName) {

        // 如果字段不包含下划线，则直接返回字段名
        if(!hungaryName.contains("_")) return hungaryName;

        // 包含_, 则转换
        String[] nameArray = hungaryName.split("_");
        StringBuffer nameSb = new StringBuffer(nameArray[0]);
        for (int i = 1; i < nameArray.length; i++) {
            String name = nameArray[i].substring(0, 1).toUpperCase() + nameArray[i].substring(1);
            nameSb.append(name);
        }

        return nameSb.toString();
    }


    /**
     * @param javaMappingType
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    private static String getImportType(JavaMappingType javaMappingType) {
        switch (javaMappingType) {
            case LONG:
                return "java.math.BigInteger";
            case BIGDECIMAL:
                return "java.math.BigDecimal";
            case BIGINTEGER:
                return "java.math.BigInteger";
            case DATE:
                return "java.util.Date";
        }
        return null;
    }

    /** 获取当前日期
     * @return String
     * @author zongf
     * @date 2019-11-30
     */
    private static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
