package class23;
class Employee{

	Employee() { // 생략시 자동으로 기본형이 생성된다. Employee(){} ,java.lang.Object 생성
     System.out.println("나는 부모 constuctor");
  }
}
class Manager extends Employee{
    Manager() {
     System.out.println("나는 자식 constuctor");
  }
}
public class TestSuper{
  public static void main(String args[])  {
     Manager m = new Manager();  // constuctor 라인 호출

  }
}