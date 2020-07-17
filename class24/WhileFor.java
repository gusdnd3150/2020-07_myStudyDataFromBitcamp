package class24;

import java.util.Scanner;

public class WhileFor {
	public static void main(String[] args) {
		
		int num;
		int sum =0;
		boolean flag = true;// 와일의 조건식이될 변수
		
		System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
		
		while (flag) { //flag값이 true이므로 참이 된다.
			System.out.println(">>");
			
			Scanner scan = new Scanner(System.in);
			String tmp =scan.nextLine();
			num = Integer.parseInt(tmp);
			
			if (num != 0) {    //num이 0이 아닐때 참 (조건 수행)
				sum+= num;      // num을 하나씩 다 더해준다는 의미
			}else {
				flag = false; //num0일때 불린의 flag를 false로 전환
			}
		}
		System.out.println("합계"+ sum );
	}
}
