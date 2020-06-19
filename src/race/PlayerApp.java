package race;

import java.util.Scanner;

public class PlayerApp{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Player[] players = new Player[3];
		
		
		for (int i = 0; i<3 ; i++) {
			Player player = new Player();
			
			System.out.println("이름");
			player.setName(scan.next());
			
			System.out.println("기록");
			player.setRecord(scan.nextInt());
			
			players[i] = player; 
		}
		
		for(int i = 0 ; i <3 ; i++) {
			players[i].result();
		}
		
		Player[] ranking = new Player[3];
		String name = "";
		
		if(players[0].getRecord() > players[1].getRecord() 
				&& players[0].getRecord() > players[2].getRecord()) {
			name = players[0].getName();
			
			}else if(players[0].getRecord() > players[1].getRecord() 
				&& players[1].getRecord() > players[2].getRecord()){
				name = players[1].getName();
				
				}else {
					name = players[2].getName();
				}
		System.out.println("1등은" + name);
		
		
						
			}
          
			
	}
	