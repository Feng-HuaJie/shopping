package domain;

public class Order {
	 
    int oid;
    User user;
	public Order() {
		super();
		
	}
	public Order(int oid, User user) {
		super();
		this.oid = oid;
		this.user = user;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
    
}
