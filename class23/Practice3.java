package class23;


import java.util.Scanner;
/*•실습3: 배열원소 이동
- 입력:1~10

- 출력:[2,3,4,5,6,7,1]


Int[] irr = {1,2,3,4,5,6,7};*/ 

public class Practice3 {
	public static void main(String[] args) {

		
		//원하는 숫자항을 맨 앞으로 배치하기 
		Scanner scan = new Scanner(System.in);
		int[] irr = {1,2,3,4,5,6,7}; 
		int temp = 0;
		int n = scan.nextInt();

		for (int i =0; i<=irr.length;i++) {
			irr[i] = i+1;
			temp =irr[i-n];
		}
	}
}
