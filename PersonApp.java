package finalMember;

import java.util.Scanner;

//RFP 요구사항 (기능정의)
// Person(id,pass,name:String) 
//  - Student(ssn주민번호앞:String,score(토익:int)),
//  - Admin(rank:int)
/* <사용자기능> 학생 메뉴
* 1. 회원가입      구현
* 2. 로그인        구현
* 3. 비번 수정
* 4. 회원탈퇴    
* 5. 아이디 존재 체크
* 6. 마이페이지
* 7. 점수 입력
* **********
* <관리자기능>  관리자 메뉴
* 1. 회원목록
* 2. 아이디검색
* 3. 이름검색
* 4. 전체 회원수
* 5. 성적별 현황 (스코어 기준 이름 내림차순 예... 1등 이순신(남/여) 98점, 2등 김유신(남/여))3명 설정
*/


class Person{                                //부모 클래스
	protected String id,name,pass;
	
	
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	public void setId(String id) {this.id = id;}
	public String getId() {return id;}
	public void setName(String name) {this.name = name;}
	public String getName() {return name;}

	
	@Override
	public String toString() {
		return "Person [아이디=" + id+ ", 이름=" + name + ", 비밀번호=" + pass + "]";
	}
}

class Student extends Person{          //학생``````````````````````````
	private int score,ssn,gender;      //토익점수 , 주민번호

	public void setScore(int score) {this.score = score;}
	public int getScore() {return score;}
	public void setSsn(int ssn) {this.ssn = ssn;}
	public int getSsn() {return ssn;}
	@Override
	public String toString() {
		return String.format( "주민번호 %s  토익점수%s" ,ssn,score );
	}
	
	
	
}

class Admin extends Student{     // 관리자`````````````````````````
	private int rank;


	public void setRank(int rank) {this.rank = rank;}
	public int getRank() {return rank;}
	
	@Override
	public String toString() {
		return String.format( "회원목록 %s 아이디검색 이름검색 전체 회원수 " ,rank );
	}
}


public class PersonApp {
	public static void main(String[] args) {
        Scanner	 scan= new Scanner(System.in);
		Person person =null;           //사람하나
		Person[] arr= new Person[3]; // 모인 사람들
		int idx = 0;
		Student student= null;
		while(true) {
			System.out.println("1. 학생 메뉴 2.관리자 메뉴");
			switch (scan.nextInt()) {
			case 1:
				System.out.println(" 1:회원가입  2:로그인 3:비번수정  4:회원탈퇴 5:아이디 존재체크 "
						+ "6:마이페이지  7:점수 입력");
				switch (scan.nextInt()) {
				case 1:
					person = new Person();
					System.out.println("회원가입");
					System.out.println("아이디 입력 :");
					person.setId(scan.next());
					System.out.println("비밀번호 입력");
					person.setPass(scan.next());
					System.out.println("이름 입력");
					person.setName(scan.next());
					arr[idx] =  person ;idx++;
					break;
				case 2:
					person = new Person();
					String result = "";
					System.out.println("로그인");
					System.out.println("아이디 입력");
					person.setId(scan.next());
					System.out.println("비밀번호 입력");
					person.setPass(scan.next());
					for(int i =0; i< arr.length ; i++) {
						if(person.getId().equals(arr[idx].getId())
								&& person.getPass().equals(arr[idx].getPass())) {
							result = "성공";
						}else {result = "실패";
						}
					}
					break;
				case 3:                   // 비번수정
					System.out.println("비번수정");
					break;
				case 4:                  //회원 탈퇴
					System.out.println("회원탈퇴");
					for (int i =0; i <idx; i++) {
						if (person.) {
							
						}
					}
					
					break;
				case 5:                 // 아이디 존재체크
					System.out.println("아이디 존재체크");
					break;
				case 6:                   //마이페이지
					System.out.println("마이페이지");
					break;
				case 7:                    //점수입력
					student = new Student();
					System.out.println("점수입력");
					student.setScore(scan.nextInt());
					System.out.println("주민번호 입력");
					student.setSsn(scan.nextInt());
					System.out.println(student.toString());
					
					break;
				default: break;
				}
				break;
			case 2: //관리자 메뉴
				while(true) {
					System.out.println(" 1:회원목록  2:아이디검색 3:이름검색  4:전체 회원수  ");
					switch (scan.nextInt()) {
					case 1: System.out.println("회원목록"); 
						break;
					case 2: 
						System.out.println("아이디검색");
						break;
					case 3:
						System.out.println("이름검색");
						break;
					case 4:
						System.out.println("전체 회원수");
						break;
					default:System.out.println("잘못된값입니다.");
						break;
					}
					
				}
			default: System.out.println("다시 입력해 주세요");
				break;
			}
			
			
		}
	}
}
