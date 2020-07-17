package class25;

import java.util.Arrays;

class Person{
	String name;
	int age;
	String[] hobbys;
	Person(){}
	
	Person(Person p){            // 자기 자신의 매개변수를   파라미터에 입력?
		this(p.name,p.age,p.hobbys);
	}
	Person(String name,int age,String[] hobby ){
		this.name = name;        //생성자의 변수를 재정의하기위해(가리키기위해) this.을 앞에 붙임
		this.age = age;
		//this.hobby
		this.hobbys = hobby;
	}
	@Override
	public String toString () {
		return "name"+this.name+ "age : "+this.age+
				"hobby:"+Arrays.toString(this.hobbys);
	}
}

public class Thishacking {
	public static void main(String[] args) {      //String의 소스가 어느 주소를타고 오는지를 파악해야함??
		String[] hobbys = {"자전거","등산"};        //String의 주소안에 값이 있는것
		Person p1 = new Person ("홍길동",30,hobbys);   
		System.out.println(hobbys == p1.hobbys);
		
		Person p2 = new Person(p1); 
		//Person p3 = new Person(); 
		
		System.out.println("p1 :"+p1);
		System.out.println("p2 :"+p2);
		
		hobbys[0] = "오토바이";
		System.out.println("p1 :"+p1);
		System.out.println("p2 :"+p2);

	}
	
}




