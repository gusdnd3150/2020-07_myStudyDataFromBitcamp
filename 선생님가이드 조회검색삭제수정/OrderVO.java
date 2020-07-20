package study08;

public class OrderVO {
	private String num; //주문번호
	private String item; //항목번호
	private String prodId; //제품번호
	private String name; //제품이름
	private String quantity; //공급업체명
	private String price;
	private String searchId;
	private String delId;
	private String editId;
	private String editProdId;
	
	public OrderVO(){
		System.out.println("VO 생성자 호출");
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getEditProdId() {
		return editProdId;
	}

	public void setEditProdId(String editProdId) {
		this.editProdId = editProdId;
	}



}
