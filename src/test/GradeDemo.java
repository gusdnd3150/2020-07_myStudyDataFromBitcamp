package test;

import java.util.Scanner;

public class GradeDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
                         //1 등의 점수만 추리기
		int names[] = new int[3];
		
		
		for(int i = 0 ; i<3 ;i++) {
			names[i] = i ;
		

		System.out.println( "점수");
		 names[i] = scan.nextInt();
		}

		
		int result = 0;
		//메소드 내부를 area 라고 하는데, 지연변수는 반드시 초기화 해야한다.
		//클래스 내부를 field라고 하는데, 인스턴스 변수는 반드시 초기화하면 안된다.
		for(int i = 0 ; i<3 ;i++) {
			names[i] = i ;
		

		System.out.println( "점수");
		 names[i] = scan.nextInt();
		
		if ( names[0] >names[1] && names[0]>names[2]) {
			result = names[0];
		} else if(names[0] >names[1] && names[1]>names[2]){
			result = names[1];
		}else {
			result = names[2];
		}
		System.out.println(result);

	}
	}
}
