package class23;

/*•실습1: 일반화 : Person, Animal
1.Person
-속성: 이름, 성별
-메소드: 말하다
2.Animal
-속성:
-메소드:*/

class Person{
	static String name,gender,kind="사람";
	
	public static void feature () {
		System.out.println("이름 : "+name+"성별"+gender+"종류"+kind );
	}
}

class Animal extends Person {
	static String kind ="강아지";
	public static void feature () {
		System.out.println("이름 : "+name+"성별"+gender+"종류" +kind );
	}
	
}


public class Practice {
	public static void main(String[] args) {
		
		Person person = new Person();
		Animal animal = new Animal();

		person.name ="강현웅";
		person.gender = "남자";
		person.feature();
		
		animal.name = "비비";
		animal.gender = "여자";
		animal.feature();
	}

}
