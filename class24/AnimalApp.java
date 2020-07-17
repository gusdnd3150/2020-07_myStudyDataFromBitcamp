package class24;

import java.util.Scanner;

class Animal12{
	String name,type;
	int age;
	static int count;
	
	
	Animal12(){                        //기본 디폴트생성자를 생성해줘야 함 습관화 들이자
	}
	Animal12(Animal12 animal){            //나 자신의 값을 비교하려면 나 자신의 이름을 변수로 지정한 값을 만들어야한다.
		this.name = animal.name;
		this.type = animal.type;
		this.age = animal.age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public void bark (int bark) {  //static의경우 고정된 변수이기때문에 비교대상이 될수 없다
		for (int i=0; i<5;i++) {
			if (type.equals("멍멍이")) {          // 클래스매소드가 아닌  인스턴스매소드로 해결하는것이 좋다.
				System.out.println("멍멍");
			}else if(type.equals("고양이")){
				System.out.println("야옹");
			}else {System.out.println("멍멍이와 고양이중 선택");}
		}
	}

	@Override
	public boolean equals(Object obj) {            //여기서 재정의를 해준것
		if(obj != null && obj instanceof Animal12) {
			return this.type == ((Animal12)obj).type && this.name == ((Animal12)obj).name;
		}else {
			return	false;
		}
	}
	@Override
	public String toString() {
		return String.format("나는 %s이고 이름은 %s입니다.",this.type,this.name);
	}
	
	public static void count() {
		count++;
	}
	
	public static String totalCount() {
		return	"동물수 "+count;
	}
	
}

public class AnimalApp {
public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
	   Animal12 animal = new Animal12();
	
	animal.setName("루시");
	animal.setType("멍멍이");
	System.out.println(animal.toString());
	animal.bark(5);
	
	Animal12 anima2 = new Animal12(animal);
	
	if (anima2.equals(animal)) {
		System.out.println("같은 강아지입니다.");
		
		Animal12.count();
		
		System.out.println(Animal12.totalCount());
	}
	
}
	
}



