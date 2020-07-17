package class22;

import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	//총점 , 평균
	//국어 영어 수학
	int kor,eng,math;
	
	System.out.println("국어");
	kor =scan.nextInt();
	System.out.println("영어");
	eng = scan.nextInt();
	System.out.println("수학");
	math = scan.nextInt();

	int sum = (kor+eng+math);
	float avg = sum/3.0f;
	
	System.out.println("총점 =" + sum + "평균"+ avg);
	
	if (avg > 90) {
		System.out.println("A");
	}else if (avg <= 90 && avg > 80 ) {
		System.out.println("B");
	}else if (avg <= 80 && avg > 70) {
		System.out.println("C");
	}else if (avg <= 70 && avg > 60) {
		System.out.println("D");
	}else {
		System.out.println("E");
		}
	
	
	}
	
	

}
