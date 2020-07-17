package class25;



class Employee{
	String name;
	int age;
	String title;
	String dept;
	
	public Employee(String name,int age,String title,String dept){
		this.name=name;          //생성자를 만들어서 맴버변수를 초기화해줌
		this.age=age;             // this를 쓴이유는 필드변수와 혼동이 있을 수 있기때문
		this.title=title;
		this.dept=dept;
	}
	public String toString () {
		return "일반사원"+this.name+"입니다";
	}
}


class Manager extends Employee{ // 부모 클래스에서 생성자가 생성되었다는 가정하에
	int titlePay;               //빨간줄 클릭시 자동으로 자식클래스의 생성자 만들수있음
	                       //부모 생성자를 물려받았기때문에 위 변수타입을 적을 필요가 없고
	                      // 부모생성자+자식에서 쓸 변수만 선언해주면 된다.
	
	public Manager(String name, int age, String title, String dept, int titlePay) {
		super(name, age, title, dept); //보기처럼 super를통해 부모것이라는걸 나타내줌
		this.titlePay = titlePay;
		//자동으로 부모생성자의 내용으로 출력되는데 여기서 자식 클래스의 변수를 넣어
		//부모의 내용+ 출력하고자하는 변수타입을 매개변수에 추가해줘야함
	}


	@Override                  
	public String toString() {  //부모생성자+자식생성자의 변수를 토대로 toString에서 출력해줌
		return "매니저"+super.name+"입니다.";
	}

}

public class ConstructPractice {
	public static void main(String[] args) {
		Employee[] employee = new Employee[3];
		Employee e = new Employee("홍길동",29,"대리","인사팀"); //각 생성자의 매개변수타입에 맞게입력
		Employee e1 = new Manager("홍팀장",39,"팀장","인사팀",200000);//20000은 자식에서 추가된 변수임
		                //호출방법은 부모클래스주소를 먼저 접근하여 구하고자하는 클래스의 생성자
		employee[0] =e;
		employee[1] =e1;
		
		for (Employee i :employee ) {
			
			System.out.println(i.toString());//출력시 배열에 입력된 담긴 내용을 바탕으로 알아서 출력해줌
		}                                 //궂이 toString을 두번쓸 필요가 없단 말임
	}
}







