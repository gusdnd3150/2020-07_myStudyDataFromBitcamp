package class22;
// 변수의 종류 실습!!!

public class PassingvalueType {
	public static void main(String[] args) {
		PassingvalueType test= new PassingvalueType();
		int iValue =1; //지역변
		
		System.out.println("test01 before "+ iValue); //1
		test.test01(iValue);
		System.out.println("test01 after."+ iValue); //1
		//call by referance 로 파라미터를 넘기는 언어에서는 2로 값이 변경된다.
		
		Box box = new Box();
		System.out.println("test02 before" + box.x);
		test.test02(box);
		System.out.println("test02" + box.x);
		
		Box box2 = new Box();
		System.out.println("test03 before" + box2.x);
		test.test02(box2);
		System.out.println("test03" + box2.x);
	}
	void test01 (int param) {
		param =2;
	}
	void test02 (Box box) {
		box = new Box();
		box.x =1;
	}
	void test03(Box box) {
		box.x =1;
	}
}

class Box  {
	public int x;
}

