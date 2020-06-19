package sequence;

import java.util.Scanner;

// 5명의 심사위원의 점수중에서 0~100점 만점에서
// 최고점과 최하점을 제외한 3명 점수평균구하기

public class FigureScore {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[5];
		int max=0, min=100;          
		int sum =0 ;
		
		for (int i =0; i <5 ;i++) {
			System.out.println("학생 점수");
			arr[i] = scan.nextInt();
			sum += arr[i];
			if (max < arr[i]) max = arr[i];
			if (min > arr[i]) min = arr[i];
		}
		//System.out.println("sum = " +sum ); 합계
		
        // 비교할 대상이 없어서 최대값과 최저값을 구할수가 없다
		// 만든 이유는 어레이 안에서 값은 입력되었지
		sum -= max;        //(sum = sum - max와 같은말)
		sum -= min;
		System.out.println("평균 : " + sum/3);
		
		
		
	}

}
