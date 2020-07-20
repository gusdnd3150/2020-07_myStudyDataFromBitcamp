package one;

import java.util.Scanner;

/**
 * @author user
 * @since 2020.06.18
 * @param  kind 폰종류   company 제조사 call 통화내역
*/

class Product{//부모 클래스
	
	
	
}
class TV extends Product{
	public final static String KIND="텔레비전";
	@Override public String toString() {return String.format("%s",KIND);} 
}
class ColorTv extends TV{
	public final static String KIND="칼라티비";
	@Override public String toString() {return String.format("%s",KIND);}
}
class Computer extends ColorTv{
	public final static String KIND="컴퓨터";
	@Override public String toString() {return String.format("%s",KIND);}
}
class NoteBook extends Computer{
	public final static String KIND="노트북";
	@Override public String toString() {return String.format("%s",KIND);}
}

 class BelPhone extends Product{                                     
	 protected String kind,company,call;

	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}

 }

class CelPhone extends BelPhone {               //자식이된 클래스
	public final static String KIND="휴대폰";
	protected boolean portable;
	protected String move;
	
	public String getMove() {return move;}
	public void setMove(String move) {this.move = move;}
	
	public boolean isPortable() {return portable;}
	public void setPortable(boolean portable) {
		if (portable)
			move =(portable)? "이동중에":"이동불가능" ;
		this.portable = portable;
	}
	
	@Override
	public String toString() {
		return String.format("%s 인 %s 제품을 사용해서 %s 라고%s 통화한다.",
				KIND,super.company,super.call,move);
	}
} 

class Iphone extends CelPhone{                //자식클래스를 하나더 추가하여 위 자식의내용을 상속받았다.
	public final static String KIND="아이폰";
	protected String search;
	
	public String getSearch() {return search;}
	public void setSearch(String search) {this.search = search;}
	//[애플] 아이폰을 사용해서 이동중에 [뉴스 검색]을한다.
	
	@Override
	public String toString() {
		return String.format("%s",KIND);
	}
}

class GalPhone extends Iphone{
	public final static String KIND="갤럭시";
	protected String pay;
	//요구조건 : [삼성] 아이폰을 사용해서,[이동]중에 [삼성페이결제] 한다.
	
	public String getPay() {return pay;}
	public void setPay(String pay) {this.pay = pay;}
	
	@Override
	public String toString() {
		return String.format("%s",KIND);
	}
}



 
public class Etland {
	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		Product[] cart = new Product[5]; 
		Product[] item = null;
		int index = 0;

		while(true) {
			System.out.println("쇼핑목록 : 0. 종료 1. 아이폰  2. 갤럭시 3. 컬러tv "
					+ "4. 컴퓨터 5. 노트북  6. 쇼핑목록보기" );
			switch (scan.nextInt()) {
			case 1:cart[index] = new Iphone();index++; break;
			//      생각해보자 new Iphone();를섰다는것은 외부값을 불왔다는 뜻이다.
			case 2:cart[index] =new GalPhone();index++; break;
			case 3:cart[index] =new TV();index++; break;
			case 4:cart[index] =new Computer();index++; break;
			case 5:cart[index] =new NoteBook();index++; break;
			case 6:
					Iphone   ip= (Iphone)  cart[0];
					//클래수에 이름을 지정 = (Iphone)cart[0] 아이폰클래스가 변수에 담겨있는 의미
					GalPhone gal= (GalPhone)cart[1];
					TV       tv= (TV)       cart[2];
					Computer cp= (Computer)cart[3];
					NoteBook nb= (NoteBook)cart[4];
					for(Product p: cart) {
						System.out.println(p.toString());
					}
					break;
			case 0:System.out.println("종료");
				return;
			default:System.out.println("잘못된값");
				break;
			}
		}
	}
}
