package project.E_P002_D003.vo;

import org.springframework.stereotype.Component;

@Component
public class E_P002_D003ProductsVO {
	
    private String prodNum;
    private String pCatgNum;
    private String prodName;
    private String prodPrice ; 
    private String prodContent;    
    private String prodQuantity;   
    private String prodType;
    private String prodJoindate;   
    private String prodModdate;
    
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getpCatgNum() {
		return pCatgNum;
	}
	public void setpCatgNum(String pCatgNum) {
		this.pCatgNum = pCatgNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public String getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(String prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdJoindate() {
		return prodJoindate;
	}
	public void setProdJoindate(String prodJoindate) {
		this.prodJoindate = prodJoindate;
	}
	public String getProdModdate() {
		return prodModdate;
	}
	public void setProdModdate(String prodModdate) {
		this.prodModdate = prodModdate;
	}
    

}
