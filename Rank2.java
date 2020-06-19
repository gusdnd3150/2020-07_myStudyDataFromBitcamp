package matrix;

import java.util.Random;
import java.util.Scanner;

public class Rank2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int[] rank = new int[3];
		int[] score = new int[3];
		
		for(int i =0; i< score.length; i++) {            //점수를 score에 5번식 주기위해 만듦
			score[i] = random.nextInt(100)+1;
		}
		for(int i = 0; i<rank.length ; i++) {           //순위를 배열에 넣기 위함
			rank[i] = i;
		}
		for(int i =0; i< score.length; i++) {            //점수를 비교할 j배열을 추가하여 i항목과 비교
			for(int j = 0; j<rank.length ; j++){        // 그에따른 rank가 하나씩 밀리는것으로 설정
				if(score[i]<score[j]) {
					rank[i] = rank[i]+1;
				}
			}
		}
		for (int i = 0; i<rank.length ; i++) {             //위 값들을 토대로 출력
			System.out.println("점수"+score[i]+"등수"+rank[i] );
		}
		
	}

}
