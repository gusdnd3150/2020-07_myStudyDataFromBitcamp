package class24;

public class ArraySum {
	public static void main(String[] args) {

		// 최대값 최소값
		int[] score = { 78, 88, 91, 33, 100, 55, 95 };
		//    score[i] =78  78  78  78  78  78  78
		int num = 0;

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				score[i] = score[j];
				if (score[i] > score[j]) {
					num = score[i];
					score[i] = score[j];
					score[j] = num;
					if (j==score.length) {
						break;
					}
					System.out.println(num);
					
				}
			}
		}
	}

}
