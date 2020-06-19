package item2;

public class Item {
	private String name;
	private int price;	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	
	public String toString() {
		return "[상품명 : "+name+" , 가격: "+price+"]";
	}
		

}
