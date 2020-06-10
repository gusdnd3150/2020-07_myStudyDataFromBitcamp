package test;

import java.util.Scanner;


public class Shop{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//이름은 a~b, 폰가격 티비 가격 컴퓨터 가격
		// 배열을 사용할것임
		
		ShopApp[] shopapp = new ShopApp[3];
		
		for(int i =0; i <3 ; i++) {
			ShopApp shopapps = new ShopApp();
			
			System.out.println("이름");
			shopapps.setName(scan.next());
			
			System.out.println("폰값");
			shopapps.setPhone(scan.nextInt());
			
			System.out.println("티비값");
			shopapps.setTv(scan.nextInt());
			
			System.out.println("컴퓨터값");
			shopapps.setCompuer(scan.nextInt());

			shopapps.getSum()
			
			shopapp[i] = shopapps;
			
			
		}
		for (int i =0; i <3 ;i++) {
			shopapp[i].result();
		}
	
	}
}

