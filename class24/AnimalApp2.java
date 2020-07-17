package class24;

public class AnimalApp2 {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		Animal animal2 = new Animal(animal);
		
	}

}


class Animal {
	String name;
	int age;
	String type;
	static int count;
	
	public Animal() {
	}
	
	public Animal(Animal animal) {
		this.name = animal.name;
		this.age = animal.age;
		this.type = animal.type;
	}
	
	public void bark (int cnt) {           // 인스턴스매소드임으로 인스턴스변수를 사용해도 되지만 매개변수를 입력하여 사용가능
		for (int i=0; i<cnt;i++) {
			if (type.equals("Dog")) {
				System.out.println("멍멍");
			}
			if (type.equals("Cat")) {
				System.out.println("야옹");
			}
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Animal) {
			return (this.name == ((Animal)obj).name && this.type == ((Animal)obj).type);
		}else {
			return	false;
		}
	}
	@Override                  // 인스턴스매소드  인스턴스변수(맴버변수)를 바탕으로 출력되는 매소드
	public String toString() {
		return "나는 "+this.type+"이고, 이름은 "+this.name+"입니다.";
	}
	
	public static void count() {
		count++;
	} 
	public  static int totalCount () {
		return count;
	}
	
}