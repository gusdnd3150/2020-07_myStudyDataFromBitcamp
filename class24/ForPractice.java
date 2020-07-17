package class24;

import java.util.Scanner;

public class ForPractice {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int num= 0;
	
	System.out.println("출력할 라인 수 입력");
	num = scan.nextInt();
	
	for(int i =0; i<=num; i++) {
		for(int j =0; j< i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	}
}
