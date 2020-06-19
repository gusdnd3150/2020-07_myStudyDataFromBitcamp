package item2;

import java.util.Scanner;

import item.Item;

public class ItemApp {
	public static void main(String[] args) {
		Scanner scan = new  Scanner(System.in);
		Item item = null;
		ItemService itemService = new ItemServiceImpl();
		
		System.out.println("1.add  2. 종료  3.list");
		while(true) {
			switch (scan.nextInt()) {
			case 2:System.out.println("종료");return;
			case 1:
			System.out.println("추가");
			item = new Item();
			System.out.println("이름 : ");
			item.setName(scan.next());
			System.out.println("가격");
			item.setPrice(scan.nextInt());
			itemService.addCart(item);
			break;
			
			case 3: System.out.println("list ");
			Item[] list = itemService.list();
			
			for(int i = 0 ; i<list.length ;i++) {
				System.out.println(list[i].toString());
			}
			break;
			
			default:System.out.println("종료");
			break;
			
			}
		}
		
	}

}

