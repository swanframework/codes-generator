package org.zongf.db.meta.mysql.config;

/**
 * @author zongf
 * @date 2019-11-30
 */
public class DbConfig {

    // 主机地址
    private String host;

    // 端口号
    private int port;

    // 用户名
    private String username;

    // 用户密码
    private String password;

    // 单例变量
    private static final DbConfig DB_CONFIG = new DbConfig();

    private DbConfig(){

    }

    public static DbConfig getInstance() {
        return DB_CONFIG;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
