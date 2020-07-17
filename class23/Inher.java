package class23;

import java.util.Scanner;



class Member {
	protected String name;
	protected int grade;


	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	
	
	public void hello() {
		System.out.printf("안녕하세요 %s 입니다",name);
	}
}

class SpecialMember extends  Member{
	protected int specialPoint ;
	
	@Override
	public void hello() {
		System.out.printf("안녕하세요 스페셜멤버 %s 입니다",name);
	}
}

public class Inher {
	public static void main(String[] args) {
		
		Member member = new Member();
		Member member1 = new SpecialMember();
		SpecialMember specialMember = new SpecialMember();
		
		member.name ="김길동";
		member.grade = 1;
		member.hello();
		
		specialMember.setName("홍길동");
		specialMember.specialPoint = 100;
		specialMember.hello();
		
	}
}
