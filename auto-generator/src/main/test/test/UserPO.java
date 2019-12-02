package service.impl;

/**
 * @author: zongf
 * @created: 2019-12-02
 * @since 1.0
 */
public class UserPO {
    
    private Integer id;
    
    private String username;
    
    private String password;

	public UserPO() {
        super();
    }

	public UserPO(Integer id, String username, String password) {
        super();
		this.id = id;
		this.username = username;
		this.password = password;
    }

    public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

    public void setUsername(String username){
		this.username=username;
	}

	public String getUsername(){
		return this.username;
	}

    public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return this.password;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {id:" + id + ", username:" + username + ", password:" + password  + "}";
	}

}
