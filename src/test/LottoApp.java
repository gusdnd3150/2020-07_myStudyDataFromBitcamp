package test;

import java.util.Scanner;
class Lotto{
	////리밋트를 클래스 안에준 이유는 관리가가 필요한 기능이기때문 메인창에는 필요가 없다.
	private int limit;                     
	public void setLimit(int limit) {this.limit = limit;}
	public int getLimit() {return limit;}
	                            // 메인메소드에서 계산알고리즘을 리펙토링하여 이쪽클래스로 갖다놓음
	public int buy(int money) {// 이과정은 메인메소드의 로직량을 줄이기 위해 실행한것
		int count = 0;
		if(money < 1000) {
			System.out.println("잘못된 금액");
		} else {
			if(limit > money /1000 ) {   //관리자가 설정한 리밋트가  돈에서1000나눈 몫(횟수) 
				count = money / 1000;    //카운트는 하나로 인정됨
				
			}else {
				count = limit;         //카운트는 곧 리밋트값? 
			}
			// count = (limit > money /1000 ) ? money / 1000: limit;
			// 삼항을 이용하여 표현한 것 나중 교육때 공부해보자
		}
		return count;
	}
}
public class LottoApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구매제한량설정");
		Lotto lot = new Lotto();
		lot.setLimit(scanner.nextInt()); // 고객입장에서는 입장시 구매제한의 문구를 본다 가정
		                                
		while(true) {
			System.out.println("0.종료 1.로또구입");
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료");return;
			case 1: buy(scanner, lot);
			break;
			default:
				break;
			}
		}
	}

	public static void buy(Scanner scanner, Lotto lot) {
		System.out.println("구입");
		System.out.println("입금액: ");
		System.out.printf("구입 로또 %d 장\n", lot.buy(scanner.nextInt()));
	}
}