package test;

import java.util.Scanner;

/* 금액을 입력받은 후 우리나라 화폐종류별로 해당 갯수를 표기하는 프로그램
* [요구사항] 금융업을 하는 고객사로부터 프로그램 개발요청이 들어왔습니다.
* 금액을 입력받은 후 우리나라 화폐종류별로 해당 갯수를 표기하는 프로그램입니다.
* 예를들어, 125,520 원을 입력하면 화면에 이렇게 보이게 하면 됩니다.
* 표시하고 10원미만은 절삭
 ******************************************************
   요청금액 : 126520 원
   5만원 : 2매
   1만원 : 2매
   5천원 : 1매
   1천원 : 1매
   5백원 : 1개
   백원 : 0개
   오십원 : 0개
   십원 : 2개
 ********************************************************/
class Money0{
	
	public String calc(int price) {
		int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] counts = new int[8];
		for(int i=0;i < units.length; i++) {
			counts[i] = price/units[i];
			price = price%units[i];
		}
		return String.format("5만원 : %d개\n1만원 : %d개\n5천원 : %d개\n"
				+ "1천원 : %d개\n5백원 : %d개\n백원 : %d원\n오십원 : %d원\n십원 : %d원\n",
				counts[0], counts[1],counts[2],counts[3],counts[4],counts[5],counts[6],counts[7]);
	}
}

public class MoneyUnit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("0. 종료 1. 입력");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료"); return;
			case 1 :
				System.out.println("금액을 입력해주세요");
				int price = scanner.nextInt();
				System.out.printf("요청 금액 : %d원\n", price);
				Money0 m0 = new Money0();
				System.out.println(m0.calc(price));
			}
		}
	}

}