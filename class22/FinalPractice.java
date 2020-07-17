
package class22;


public class FinalPractice {
	public static void main(String[] args) {

		int[] score = {79,88,91,33,100,55,95};
		
		int max = 0;
		int min = 0;
		
		for(int i =0; i<score.length ; i++) {
			for (int j=i+1; j <score.length ; j++) {
				if (score[i] > score[j]) {
					max = score[i];
					score[i] = score[j];
					score[j] = max;
				}else if (score[i] < score[j]) {
					min =score[i];
					score[i] =score[j];
					score[j] = min;
				}
				System.out.println("최대 :  " + max + "최소" + min);
			}
		}
	}
}