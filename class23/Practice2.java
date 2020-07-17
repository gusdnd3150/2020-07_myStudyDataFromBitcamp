package class23;

import java.util.Scanner;

/*실습2: 급여계산하기
- 입력:기본급, 직책(사원/대리/과장/부장)
- 출력:실수령액 =xxx원

* 계산식은 다음과 같다
- 실수령액 = 기본급 +직책수당 – 세금

-세금 = 기본급의 10%
* 직책 수당표
- 과장: 200,000
- 부장: 500,000*/
/*
일반적으로 퍼센트 구하는 공식은 다음과 같습니다.
예 : 1000에서 100은 몇 %인가?
공식 : (일부값 ÷ 전체값) ×100.
풀이 : (100 ÷1000) ×100 = 10%
이것을 자바프로그래밍에 도입해봤을 때는 int 값으로 계산하겠죠*/

class Calculate {
	static double salary,tax;
	static String position;
	
	
	
	
	public static void wage () {
		tax = salary*0.1;
		System.out.println("세전:"+salary+"세후:" +(salary-tax));
	}
}

class Position1 extends Calculate{
	static String position = "과장";
	
	public static void wage () {
		tax = salary*0.1;
		salary = salary +200000;
		System.out.println("세전:"+salary+"세후:" +(salary-tax));
	}
}


class Position2 extends Position1{
static String position = "부장";
	
	public static void wage () {
		tax = salary*0.1;
		salary = salary +500000;
		System.out.println("세전:"+salary+"세후:" +(salary-tax));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	}
	
}


public class Practice2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calculate calculate = null;
		Position1 position1= null;
		Position2 position2 = null;
		
		while(true) {
			System.out.println("본인의 직책을 선택해 주세요");
			System.out.println("1.일반 2.과장 3.부장");
			switch (scan.nextInt()) {
			case 1:
				calculate =  new Calculate();
				System.out.println("월급을 입력해 주세요");
				calculate.salary = scan.nextInt();
				calculate.wage();
				break;
			case 2:
				position1 = new Position1();
				System.out.println("월급을 입력해 주세요");
				position1.salary = scan.nextDouble();
				position1.wage();
				break;
			case 3:
				position2 = new Position2();
				System.out.println("월급을 입력해 주세요");
				position2.salary = scan.nextDouble();
				position2.wage();
				break;

			default:System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
}
