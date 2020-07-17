package class22;

public class Dog {   // 객체
	String name;
	String height;

	public static void main(String[] args) {
		
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";
		dog1.height = "120";
		
		Dog[] myDogs = new Dog[3];
		myDogs[0] = new Dog();     //배열에 이름을 넣어줌
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		myDogs[0].name = "Fred";  // 배열에 할당된 애들을 이름을 지정해주고 있음
		myDogs[1].name = "Marge";
		
		
		System.out.println("마지막 개의 이름: ");
		System.out.println(myDogs[2].name);
		
		int x = 0;
		while (x < myDogs.length) {
			myDogs[x].bark();
			x = x+1;
		}
	}
	public void bark() {
		//this.name = "";
		System.out.println(name +" 이 왈! 하고 짖습니다.");
	}
	public void eat() {
		System.out.println();
	}
	public void chaseCat() {
	}
}


