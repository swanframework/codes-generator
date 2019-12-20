package org.zongf.db.meta.mysql.po;

/** 数据库Schema信息
 * @author zongf
 * @date 2019-11-30
 */
public class SchemaPO {

    private String catalogName;
    
    private String schemaName;
    
    private String defaultCharacterName;
    
    private String defaultCollationName;
    
    private String sqlPath;

	public SchemaPO() {
        super();
    }

	public SchemaPO(String catalogName, String schemaName, String defaultCharacterName, String defaultCollationName, String sqlPath) {
        super();
		this.catalogName = catalogName;
		this.schemaName = schemaName;
		this.defaultCharacterName = defaultCharacterName;
		this.defaultCollationName = defaultCollationName;
		this.sqlPath = sqlPath;
    }

    public void setCatalogName(String catalogName){
		this.catalogName=catalogName;
	}

	public String getCatalogName(){
		return this.catalogName;
	}

    public void setSchemaName(String schemaName){
		this.schemaName=schemaName;
	}

	public String getSchemaName(){
		return this.schemaName;
	}

    public void setDefaultCharacterName(String defaultCharacterName){
		this.defaultCharacterName=defaultCharacterName;
	}

	public String getDefaultCharacterName(){
		return this.defaultCharacterName;
	}

    public void setDefaultCollationName(String defaultCollationName){
		this.defaultCollationName=defaultCollationName;
	}

	public String getDefaultCollationName(){
		return this.defaultCollationName;
	}

    public void setSqlPath(String sqlPath){
		this.sqlPath=sqlPath;
	}

	public String getSqlPath(){
		return this.sqlPath;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {catalogName:" + catalogName + ", schemaName:" + schemaName + ", defaultCharacterName:" + defaultCharacterName + ", defaultCollationName:" + defaultCollationName + ", sqlPath:" + sqlPath  + "}";
	}

}
