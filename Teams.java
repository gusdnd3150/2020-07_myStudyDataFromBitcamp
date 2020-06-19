package matrix;

public class Teams {
	public static void main(String[] args) {
		
		                 //열
		String[][] teams = {{"길동","순신","영구","철수"},
				{"dl","미루","칼","토니"},
				{"하하","브로","짱구","미미"},
				{"운우","히","잭슨","호영"}};
				
		for(int i =0; i< teams.length ; i++){	
			for(int j =0; j< teams[i].length; j++) {
				System.out.printf("%s\t",teams[i][j]);
			}
			System.out.println();
		}
	}
}
