package class25;

import java.util.Scanner;
/*• 실습: 차량판매시스템
선택하세요. [0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매]
[차량등록]
차량번호: 111
차량크기(소형(1)/중형(2)/대형(3)): 2        //class 차, 고객  상속을써야되나?
차량타입(세단(1)/SUV(2)): 1               // 차   = 타입,크기,차번호
[고객등록]                               // 고객 = 이름,고객번호, 
고객번호: 122                             // 차를담을 배열 과 고객 담을 배열?
고객명: 홍길동
[차량조회]
차량번호: 111
차량크기(소형(1)/중형(2)/대형(3)): 2          // 뭘로만들지?
차량타입(세단(1)/SUV(2)): 1
--------------
[고객조회]
고객번호: 111
고객명: 홍길동
-------------
[차량판매]                      <- 할 수 있으면 도전
고객번호를 등록하세요[0:취소]: 122
차량번호를 등록하세요[0:취소]: 111
====================================================================
* 차량등록 시 중복체크
   ‘차량번호가 중복됩니다’
*/

class Customer {// 고객= 이름 name, 고객번호 customerNum
	private String name;
	private int customerNum;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public void customerinfo() {
		System.out.println("고객" + name + "고객번호" + customerNum);
	}
}

// 고객(부모클래스)를 상속받아 해보려고 했지만 개념상 맞지않다고하여 자식클래스에서 일반 클래스로 분류하기로 결정
// 상속은 일반화된 특징을 확장하는 개념 고객이 차가될 수 없기 때문이다.
class Car { // 차= 타입 carType,크기 size,차번호 carNum
	private int carNum, carType;
	private int size;

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	public void carinfo() {
		System.out.println("자동차 타입-세단(1)/SUV(2)" + carType + "자동차 크기-소형(1)/중형(2)/대형(3)" + size + "자동차번호" + carNum);
	}
}

public class CarSalse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Customer customer = new Customer(); // 고객 클래스
		Car car = new Car();
		Customer[] customoerlist = new Customer[10];
		Car[] carlist = new Car[10]; // 자동차 리스트 (배열을 선언할때 왜 Car클래스를 바탕으로 쓸까?)
		int count = 0;          // 총 자동차 수 (배열과는 관계없이 등록한 수에 대해서만 뽑기위해)
		int cnt =0;            //총 사람 
		
		while (true) {
			System.out.println("0:나가기, 1:차량등록, 2:고객등록, 3. 차량조회, 4: 고객조회, 5:차량판매");
			switch (scan.nextInt()) {
			case 0:// 0:나가기
				System.out.println("나가기");
				return;
			case 1:// 1:차량등록
				System.out.println("자동차 타입을 결정해 주세요");
				System.out.println("세단(1)/SUV(2)");
				car.setCarType(scan.nextInt());
				System.out.println("자동차 크기 소형(1)/중형(2)/대형(3)");
				car.setSize(scan.nextInt());
				System.out.println("자동차 번호 입력");
				car.setCarNum(scan.nextInt());

				  // 카 랭스를 null로 잡아볼까??지금 상태는 값이 없는상태잖아?
				// 최초에 배열의 getCarNum과 입력된 getCarNum만 비교했었는데 아래처럼 바꾼뒤 작용됨
				for (int i = 0; i < count; i++) {  //carlist만큼 돌리는것도 좋지만
					                                //이경우 불필요한 공간수만큼 또 돌려야하기 때문에 
					                                //count된 수만큼 돌리는게 효율적이다
					if (carlist[i] != null && carlist[i].getCarNum() == car.getCarNum()) {
						System.out.println("중복된 차량 번호입니다.");
						break;
					} else {
						carlist[count] = car; 
						carlist[count].carinfo();
						System.out.println("등록 완료");
						break;
					}
				}
				count++; // 위 과정이 다 통과 되었을 시 count 추가
				break;
			case 2:// 2:고객등록,
				System.out.println("이름");
				customer.setName(scan.next());
				System.out.println("고객번호");
				customer.setCustomerNum(scan.nextInt());

				for (int i = 0; i < customoerlist.length; i++) {  // null을 조건에 넣은 이유는 최초에 배열안에는 값이 없기때문
					if (customoerlist[i] != null &&              // 이 조건이 없을경우 에러발생
							customoerlist[i].getCustomerNum() == customer.getCustomerNum()) {
						System.out.println("중복번호입니다.");
						break;
					} else {
						customoerlist[count] = customer;
						System.out.println("고객등록 완료");
						customoerlist[i].customerinfo();      // 리턴값에 프린틀이 있기땜에 적어줄 필요없음
						break;
					}
				}
				break;
			case 3:// 차량 조회
				int find = 0;
				System.out.println("찾으시는 차량 번호 입력");
				car.setCarNum(scan.nextInt());
				
				for(int i =0; i<carlist.length ; i++) {
					if(carlist[i] != null && carlist[i].getCarNum() == car.getCarNum() ) {
						System.out.println("찾으시는 차량은 아래와 같습니다."); 
						carlist[i].carinfo(); break;
					}else {
						System.out.println("찾으시는 차량이 없습니다.");break;
					}
				}
				break;
			case 4://고객조회
				System.out.println("찾으시는 고객 번호를 입력해주세요");
			
				break;
			case 5:
				break;

			default:
				System.out.println("다시 선택해 주세요");
				break;
			}

		}

	}
}
