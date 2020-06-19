package sequence;

import java.util.Scanner;

public class Guguda1 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);

		for(int i =2; i<10 ; i++) {
			for (int j =1; j<10 ; j++) {
				System.out.printf("%d x %d %d\t",i,j,(i*j));
			}
		}
	}
}
