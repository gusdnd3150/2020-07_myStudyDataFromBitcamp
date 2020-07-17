package class24;

public class Array {
	public static void main(String[] args) {
		
		int sum =0;
		float avg =0f;         //평균을 구하기위해 float씀(소수점)
		
		int[] score = {100,88,100,100,90}; 
		//int[] score = new int[]{100,88,100,100,90}; 
		//int[] score = new int[5];
		//score[0]==100; score[1]==100; score[2]==100;score[3]==100; score[4]==100;
		
		
		for (int i=0; i<score.length ;i++) {   //항갯수만큼 for문 돌림
			sum += score[i];             // 인덱스값마다 더해줘서 총점을 구함
		}
		avg =sum / (float)score.length ;       // 계산시 타입이 다르기때문에 강제형변환
		
		System.out.println("총점 : "+ sum);
		System.out.println("평균 : "+ avg);
	}
	

}
