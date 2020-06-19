package test;

import java.util.Scanner;


public class Shop{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//�̸��� a~b, ������ Ƽ�� ���� ��ǻ�� ����
		// �迭�� ����Ұ���
		
		ShopApp[] shopapp = new ShopApp[3];
		
		for(int i =0; i <3 ; i++) {
			ShopApp shopapps = new ShopApp();
			
			System.out.println("�̸�");
			shopapps.setName(scan.next());
			
			System.out.println("����");
			shopapps.setPhone(scan.nextInt());
			
			System.out.println("Ƽ��");
			shopapps.setTv(scan.nextInt());
			
			System.out.println("��ǻ�Ͱ�");
			shopapps.setCompuer(scan.nextInt());

			shopapps.getSum();
			
			shopapp[i] = shopapps;
			
			
		}
		for (int i =0; i <3 ;i++) {
			shopapp[i].result();
		}
	
	}
}

