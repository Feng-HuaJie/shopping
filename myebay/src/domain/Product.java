package domain;
 
public class Product {
 
    private int pid;
    private String name;
    private float price;
	public Product() {
		super();
		
	}
	public Product(int id, String name, float price) {
		super();
		this.pid = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return pid;
	}
	public void setId(int id) {
		this.pid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
    
    
}