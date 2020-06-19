package sequence;

import java.util.Scanner;

public class Gugudan2 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		for(int i=1; i<10 ;i++) {          //열
			for(int j=2; j<6 ;j++) {      // 행
				System.out.printf("%d * %d  = %d\t",j,i,j*i);
			}
			System.out.println();
		}
		for (int i=1; i<10 ;i++) {
			for(int j=6; j<10 ;j++) {
				System.out.printf("%d * %d  = %d\t",j,i,j*i);
			}
			System.out.println();
		}
	}

}
