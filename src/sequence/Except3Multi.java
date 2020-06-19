package sequence;
//3의 배수를 제외한 1 부터 10까지 정수 출력
//[결과] 1 2 4 5 7 8 10

public class Except3Multi {
	public static void main(String[] args) {
		int[] arr = new int[7];
		int j =0;
		for(int i=0; i<10 ;i++) {
			int t = i+1;
			if(t%3 !=0) {
				arr[j] = t;
				j++;
				System.out.printf("%d\t",i);           
			}
		}
		// \t = tap 기능을 추가
		
		for (int i=0; i< arr.length; i++) {
			System.out.printf("%d\t",arr[i]);
		}
		
		

	}

}
