package domain;
/**
 * 。
 * @author Fenghuajie
 *
 */
public class User {
	private int uid;
    private String uname;
    private String password;
	public User() {
		super();
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}