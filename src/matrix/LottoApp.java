package matrix;

import java.util.Random;
import java.util.Scanner;

class Lotto{
	private int countLimit,lottoCount;
	private int[] lotto;
	private int[][] lottos;
	
	public void setCountLimit(int countLimit) {
		this.countLimit = countLimit;
	}
	public int getCountLimit() {
		return countLimit;
	}
	public void setLottos() {
		lotto =new int[6];
		lottos = new int [lottoCount] [6];
		for (int i =0; i<lottoCount; i++) {
			for(int j =0; j<6; j++) {
				int num = (int)(Math.random()*45)+1; //클래스에서 직접적으로 접근할경우 메모리를 잡아먹지않는다.
				while (isDuplication(num)) {
					lotto[j]= num;
					break;
				}
			}
			sort(lotto);
			System.arraycopy(lotto, 0, lottos[i],0,lotto.length);
			// array를 matrix에 한줄 씩 입력하는 방법 
		}
		this.lottos = lottos;
	}
	public int[][] getLottos() {
		setLottos();
		return lottos;
	}
	public void sort(int[] arr) {
		for (int i =0; i<arr.length-1 ; i++) {
			for(int j =i+1; j<arr.length ; j++) {
				if (arr[i] > arr[j]) {
					int t =arr[i];
					arr[i] = arr[j];
					arr[j]=t;
				}
			}
		}
		lotto =arr;
	}

	public int lottoCount(int money) { // 생성자를 형성하여 int money값을 어느 클래스에서도 사용할수 있게 만듬
		int lottoCount = 0;
		if(money < 1000) {
			System.out.println("잘못된 값");
		}else {
			if(money > countLimit * 1000) {
				lottoCount = countLimit;
			}else {
				lottoCount = money / 1000;
			}
		}
		this.lottoCount =lottoCount;
		return lottoCount;
	}
	public boolean isDuplication( int num) {
		boolean ok = false;
		for(int i=0; i < lotto.length; i++) {
			if(lotto[i] != num) ok = true;
		}
		return ok;
	}
	/*
	 * public void generate(Random random, int[] lotto, Lotto instance) { for(int
	 * i=0; i< lotto.length; i++) { int temp = random.nextInt(45)+1;
	 * System.out.printf("뽑힌 값: %d\n", temp); if(instance.isDuplication(lotto,
	 * temp)) { i--; continue; } lotto[i] = temp; } }
	 */
	
}

public class LottoApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lotto instance = new Lotto();
		System.out.println("구매한도 설정");
		instance.setCountLimit(scanner.nextInt());
		System.out.printf("설정된 구매한도 %d 장\n", instance.getCountLimit());
		while(true) {
			System.out.println("0.종료 1.로또구입");
			switch(scanner.nextInt()) {
			case 0: System.out.println("종료"); return;
			case 1: System.out.println("로또구입\n");buyLottos(instance,scanner);break;
			}
		}
		//instance.generate(random, lotto, instance);
		/*
		for(int i=0; i< lotto.length; i++) {
			System.out.printf("%d\t", lotto[i]);
		}
		*/
	}
	public static void buyLottos(Lotto instance,Scanner scanner) {
		System.out.println("얼마치를 구입합니까? ");
		System.out.printf("로또 %d장을 발급합니다\n", 
				instance.lottoCount(scanner.nextInt()));
		int[][] lottos = instance.getLottos();
		for (int i =0; i < lottos.length ; i++) {
			for (int j =0; j < lottos[i].length ; j++) {
				System.out.println(lottos[i][j]+"\n");
			}
			System.out.println();
		}
	}
}

/*
 * int a = 1; int b = 2; int c = 3; int [] arr =new int [3]; arr[0] =a;
 */