package domain;

public class Order {
	 
    int id;
    User user;
	public Order() {
		super();
		
	}
	public Order(int id, User user) {
		super();
		this.oid = id;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
    
}
