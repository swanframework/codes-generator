package org.zongf.auto.generator.athm.config;

/** remote service 特殊配置
 * @author zongf
 * @date 2019-12-27
 */
public class RemoteServiceConfig {

    // 项目核心配置类引用
    private String appProClassRef;

    // 项目核心配置类名
    private String appProClassName;

    // 基础服务主机地址字段名
    private String baseServiceHostFieldName;

    // 基础服务API 配置类引用
    private String baseServiceApiProClassRef;

    // 基础服务API 配置类名
    private String baseServiceApiProClassName;

    // 远程调用地址uri 字段名
    private String remoteUriFieldName;

    public String getAppProClassRef() {
        return appProClassRef;
    }

    public String getAppProClassName() {
        return appProClassName;
    }

    public String getBaseServiceHostFieldName() {
        return baseServiceHostFieldName;
    }

    public String getBaseServiceApiProClassRef() {
        return baseServiceApiProClassRef;
    }

    public String getBaseServiceApiProClassName() {
        return baseServiceApiProClassName;
    }

    public String getRemoteUriFieldName() {
        return remoteUriFieldName;
    }

    public void setBaseServiceHostFieldName(String baseServiceHostFieldName) {
        this.baseServiceHostFieldName = baseServiceHostFieldName;
    }

    public void setRemoteUriFieldName(String remoteUriFieldName) {
        this.remoteUriFieldName = remoteUriFieldName;
    }

    /** 设置项目核心配置类 */
    public void setHostProperties(String hostPropertiesPackage) {
        this.appProClassRef = hostPropertiesPackage;
        int idx = hostPropertiesPackage.lastIndexOf(".");
        this.appProClassName = hostPropertiesPackage.substring(idx+1);
    }

    /** 设置基础服务接口配置类 */
    public void setBaseServiceApiProperties(String baseServiceApiPropertiesPackage) {
        this.baseServiceApiProClassRef = baseServiceApiPropertiesPackage;
        int idx = baseServiceApiPropertiesPackage.lastIndexOf(".");
        this.baseServiceApiProClassName = baseServiceApiPropertiesPackage.substring(idx+1);
    }

}
