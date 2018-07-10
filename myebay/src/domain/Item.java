package domain;

public class Item {
	 
	private int olid;
    private Product product;
    private int num;
    private Order order;
	public Item() {
		super();
		
	}
	public Item(int olid, Product product, int num, Order order) {
		super();
		this.olid = olid;
		this.product = product;
		this.num = num;
		this.order = order;
	}
	public int getOlid() {
		return olid;
	}
	public void setOlid(int olid) {
		this.olid = olid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
    
}