package project.E_P002_D003.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class E_P002_D003PhotoVO {
	
	private String prodNum2;
	private String pPhotoNum;
	//private byte[] pPhotoContent;
	private MultipartFile pPhotoContent1;
	private MultipartFile pPhotoContent2;
	private MultipartFile pPhotoContent3;
	private MultipartFile pPhotoContent4;
	
	
	public MultipartFile getpPhotoContent4() {
		return pPhotoContent4;
	}
	public void setpPhotoContent4(MultipartFile pPhotoContent4) {
		this.pPhotoContent4 = pPhotoContent4;
	}
	public String getProdNum2() {
		return prodNum2;
	}
	public void setProdNum2(String prodNum2) {
		this.prodNum2 = prodNum2;
	}
	public String getpPhotoNum() {
		return pPhotoNum;
	}
	public void setpPhotoNum(String pPhotoNum) {
		this.pPhotoNum = pPhotoNum;
	}
	public MultipartFile getpPhotoContent1() {
		return pPhotoContent1;
	}
	public void setpPhotoContent1(MultipartFile pPhotoContent1) {
		this.pPhotoContent1 = pPhotoContent1;
	}
	public MultipartFile getpPhotoContent2() {
		return pPhotoContent2;
	}
	public void setpPhotoContent2(MultipartFile pPhotoContent2) {
		this.pPhotoContent2 = pPhotoContent2;
	}
	public MultipartFile getpPhotoContent3() {
		return pPhotoContent3;
	}
	public void setpPhotoContent3(MultipartFile pPhotoContent3) {
		this.pPhotoContent3 = pPhotoContent3;
	}
	
	
	

}
