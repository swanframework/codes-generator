package org.zongf.db.meta.mysql.exception;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class DbException extends RuntimeException {

    public DbException() {
        super();
    }

    public DbException(String message) {
        super(message);
    }

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbException(Throwable cause) {
        super(cause);
    }

    protected DbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
