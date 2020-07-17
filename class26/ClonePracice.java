package class26;

import java.util.Arrays;

public class ClonePracice {
	public static void main(String[] args) {
		
		int[]arr = {1,2,3,4,5};
		
		// 배열 arr를 복제해서 같은 내용의 새로운 배열을 만든다.
		int[] arrClone = arr.clone();       // arrClone[1,2,3,4,5,]
		arrClone[0]=6;    //arr에는 1~5가 있는데  복제된 배열클론 앞자리를 바꿔주면 값의 앞자리가 바뀐다
		          
		System.out.println(Arrays.toString(arr));  //    Arrays.toString(arr) 배열복제 출력 방법 외우자
		System.out.println(Arrays.toString(arrClone));
	
	}

}
