package test;


class ShopApp{
	
	private String name;
	private int phone;
	private int tv;
	private int computer;
	
	private int sum;
	
	public void setName(String name) {
		this.name= name;
	}
	public String getName(){
		return this.name;
	}
	
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPhone() {
		return this.phone;
	}
	
	public void setTv(int tv) {
		this.tv=tv;
	}
	public int getTv() {
		return this.getTv();
	}
	
	public void setCompuer(int compuer) {
		this.computer= compuer;
	}
	public int computer(){
		return this.computer;
	}
	
	
	public void setSum(int sum) {
		this.sum=sum;
	}
	public int getSum() {
		return this.sum = this.computer+ this.phone + this.tv ;
		
	}
	

	public void result(){
		System.out.println("�̸� :" + this.name + "����" +this.phone+ "Ƽ�� :" +this.tv+ "���Ͱ� " +this.computer+ "�հ�"+ this.sum  );
		
		
	}
	
	

}