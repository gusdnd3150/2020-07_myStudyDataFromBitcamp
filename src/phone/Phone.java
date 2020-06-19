package phone;

import java.util.Scanner;

/**
 * @author user
 * @since 2020.06.18
 * @param  kind 폰종류   company 제조사 call 통화내역
*/
 class BelPhone{                                     //부모 클래스
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
		return String.format("%s %s을 사용해서 %s중에 %s을한다.",company,KIND,move,search);
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
		return String.format("%s %s을 사용해서,%s %s 한다",company,KIND,move,pay);
	}
}

 
public class Phone {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		//BelPhone phone = new BelPhone();   //BelPhone 인스턴스하여 호출함(복사)
		BelPhone[] arr = new BelPhone[1];
		BelPhone phone = null;        
		CelPhone cel = null;           //형태만 있는상태 아무것도 없는상태이다
		Iphone iphone= null;
		GalPhone galPhone = null;
		
		while(true) {
			System.out.println("0. 종료 1. 전화걸기  2. 전화받기 3. 휴대폰 "
					+ "4. 아이폰 서치 5. 삼성페이결제" );
			switch (scan.nextInt()) {
			case 1:
			phone = new BelPhone();     //위에 형태만 잡아준애를 여기서 호출하여 사용
			phone.setKind("집전화");
			phone.setCompany("금성사");
			phone.setCall("안녕하세요");
			arr[0] = phone;
			break;
			case 2: 
				System.out.println(arr[0].toString());
				break;
			case 3: 
			cel = new CelPhone();
			cel.setCompany("노키아");
			cel.setPortable(true);
			cel.setCall("이동중에 통화하고 있다.");
			arr[0]=cel;
			break;
			case 4: 
			iphone = new Iphone();
			iphone.setCompany("apple");
			iphone.setSearch("뉴스 검색");
			iphone.setPortable(true);
			arr[0]=iphone;
			break;
			case 5:
				galPhone = new GalPhone();
				galPhone.setCompany("삼성");
				galPhone.setPortable(true);
				galPhone.setPay("삼성페이결제");
				arr[0] = galPhone;
				break;
			case 0:System.out.println("종료");
				return;
			default:System.out.println("잘못된값");
				break;
			}
			
		}
		
	}

}
