package org.zongf.db.meta.mysql.converter;

import org.zongf.db.meta.mysql.enums.JavaMappingType;
import org.zongf.db.meta.mysql.enums.MysqlDataType;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class DefaultTypeConverter {


    /** 获取java 类型
     * @param dataType mysql 字段数据类型
     * @param unsigned 是否是无符号整数
     * @param maxIntDigits  最大长度
     * @return JavaMappingType
     * @since 1.0
     * @author zongf
     * @created 2019-11-30
     */
    public static JavaMappingType getType(MysqlDataType dataType, boolean unsigned, int maxIntDigits) {

        switch (dataType) {
            case BIT:
                return maxIntDigits == 1? JavaMappingType.BOOLEAN : JavaMappingType.STRING;
            case TINYINT:
            case SMALLINT:
            case MEDIUMINT:
            case INT:
                return unsigned ? JavaMappingType.LONG : JavaMappingType.INTEGER;
            case BIGINT:
                return unsigned ? JavaMappingType.BIGINTEGER : JavaMappingType.LONG;
            case FLOAT:
                return JavaMappingType.FLOAT;
            case DOUBLE:
                return JavaMappingType.DOUBLE;
            case DECIMAL:
                return JavaMappingType.BIGDECIMAL;
            case YEAR:
                return JavaMappingType.INTEGER;
            case BINARY:
            case VARBINARY:
            case TINYBLOB:
            case BLOB:
            case MEDIUMBLOB:
            case LONGBLOB:
                return JavaMappingType.BYTEARRAY;
            case CHAR:
            case VARCHAR:
            case TINYTEXT:
            case TEXT:
            case MEDIUMTEXT:
            case LONGTEXT:
                return JavaMappingType.STRING;
            case DATE:
            case DATETIME:
            case TIME:
            case TIMESTAMP:
                return JavaMappingType.DATE;
            default:
                return JavaMappingType.UNSUPPORT;
        }


    }

}
