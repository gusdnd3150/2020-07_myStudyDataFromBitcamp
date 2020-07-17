package class26;


class Memner {            // 상속 오버라이드 하기 연습
	protected String name;
	protected String grade;
	
	
	Memner (){}
	Memner (String name,String grade){
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "안녕하세요 " +grade+name+"입니다."; //this는 생략해도 문제 없음
	}
}

class SpecialMember extends Memner{
	public String specialPoint;
	
	
	SpecialMember(){}
	SpecialMember(String name,String grade){
		super.grade= grade;
		super.name = name;
	}
	
	SpecialMember(String specialPoint){
		this.specialPoint=specialPoint;
	}
	
	
	@Override
	public String toString() {
		return "안녕하세요 " +super.grade+super.name+"입니다.";
	}
}


public class Inhertance2 {
	public static void main(String[] args) {

		Memner memner = new Memner();
		SpecialMember specialMember = new SpecialMember();
		SpecialMember specialMember1 = new SpecialMember("테스트");
		
		memner.setName("강현웅");
		memner.setGrade("일반멤버");
		System.out.println(memner.toString());
		
		specialMember.setName("민우");
		specialMember.setGrade("스페셜멤버");
		System.out.println(specialMember.toString());
	
		System.out.println(specialMember1);
	}
}
