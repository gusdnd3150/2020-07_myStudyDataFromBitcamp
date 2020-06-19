package matrix;




public class MatrixBasic {
	public static void main(String[] args) {

		int[][] mtx = new int[3][5];     //행렬  요소가 모여 객체가 되었다
		for(int i =0; i<mtx.length ;i++) {
			System.out.println("");
			for(int j=0; j<mtx[i].length ;j++) {
				System.out.printf("%d",i);
				mtx[i][j] =5;
			}
		}
		for(int i =0; i<mtx.length ;i++) {
			System.out.println("");
			for(int j=0; j<mtx[i].length ;j++) {    
				System.out.printf(mtx[i][j]+"\t");
				
		}
		}
	}

}
