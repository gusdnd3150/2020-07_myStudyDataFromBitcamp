package item;

import java.util.Scanner;

public class ItemApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Item item = null;
		ItemService itemService = new ItemServiceImpl();
		
		while(true) {
			System.out.println("0 exit,   1 add,   2 List");
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료"); return;
			case 1: 
				System.out.println("add"); 
				item = new Item();
				System.out.println("상품명 : ");
				item.setName(scanner.next());
				System.out.println("가격 : ");
				item.setPrice(scanner.nextInt());
				itemService.addCart(item); break; 
			
			
			case 2: 
				System.out.println("List"); 
				Item[] list = itemService.list();
				for(int i=0; i <list.length; i++) {
					System.out.println(list[i].toString());
				}
			
			
				
			default:
				System.out.println("잘못된 메뉴 번호입니다.");
				break;
			}
		}
		
	   
		
	}

}