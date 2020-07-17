package class26;

import java.util.Arrays;
import java.util.Scanner;

/*• 실습: 학원시스템                                                     4,5 번외
선택하세요. [0:나가기, 1:학생등록, 2:강사등록, 3. 관련자 조회, 4. 강의등록,5:강의조회]
[학생등록]
학생번호: 100
학생이름: 홍길동

[강사등록]
강사번호: 200
강사이름: 김강사

[관련자조회]
관련자유형(학생(10)/강사(20)): 10
관련자번호: 100
----------------------
학생: 100/홍길동
[강의등록]
강사번호(0:취소): 200
학생번호(0:취소, 1:등록완료): 100
학생번호(0:취소, 1:등록완료): 101
학생번호(0:취소, 1:등록완료): 102
[강의조회]
강의번호: 001
----------------------------
강사번호: 200
학생번호: 100/101/102
=============================================================
* 참조변수 복사 시 발생하는 문제는 무시한다
* 학생등록 시 중복체크
   ‘학생번호가 중복됩니다’
* 강사등록 시 중복체크
   ‘강사번호가 중복됩니다’
* 관련자 조회
  - 검색하려는관련자가 없으면
      ‘존재하지 않은 관련자입니다’
* 강의등록
  - 강사번호, 학생번호는 존재하는 번호를 등록할 때까지
      반복해서 입력요청한다
  - 학생번호는등록완료(1)시까지 반복해서 입력한다
  - 검색하려는강의번호가 없으면
      ‘존재하지 않은 강의번호입니다’
  - 하나의강의에 강사는 한명만*/

class Student {                         //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ학생
	protected String name; // 이름
	protected int num; // 번호

	public String getName() {
		return name;
	} // 겟셋

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "학생이름 : " + this.name + "학생번호" + this.num; // 부모에서 this를 먼저 지정해주지 않으면
	} // 자식toSting에서 super입력시 오류
}

class Teacher extends Student {     //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ선생 정보 (자식클래스) 

	@Override
	public String toString() {
		return "강사이름 : " + super.name + "강사번호" + super.num;   //궁금한점: 만약 자식클래스를한번더 생성하면 
	}                                                                    // 오버라이드 어케함?

}


class Lecture{  //객체배열을 이용해 할수 있을 것 같다
	
	Teacher t;
	Student[] students;
	

	
	@Override
	public String toString() {
		return "Lecture [t=" + t + ", students=" + Arrays.toString(students) + "]";
	}
	
}

class Funtion { //                     ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ실제 기능 함수들집합
	Scanner scan = new Scanner(System.in);
	Student student; // 학생클래스 인스턴스 선언
	Teacher teacher; // 선생클래스 인스턴스

	Student[] studentlist = new Student[100];
	Teacher[] teacherlist = new Teacher[100];
	
	int sidx = 0; // 학생 인덱스
	int tidx = 0; // 선생 인덱스
	boolean input = false; // true일경우 재생되니까 false가 나오면 중복을 탈출하는 식으로?
	boolean check = true; 

	
	
	public void inputStudent() { // 학생정보 입력기능
		student = new Student();

		do {
			System.out.println("학생 번호");
			student.setNum(scan.nextInt());
			System.out.println("학생 이름");
			student.setName(scan.next());

			for (int i = 0; i < studentlist.length; i++) { // 선생님말로는 조건 랭스는 변하면 안되는 값이라고함
				if (studentlist[i] != null && student.getNum() == (studentlist[i].getNum())) {
					System.out.println("학생번호가 중복됩니다.");
					input = true; // true면 참이기때문에 와일룹이 다시 돌아서 위로감
				} else {
					input = false;
				}
			}
		} while (input);
		System.out.println(student.toString());
		studentlist[sidx] = student;
		sidx++;
	}

	public void inputTeacher() { // 강사정보 입력기능
		teacher = new Teacher();
		do {
			System.out.println("강사 번호");
			teacher.setNum(scan.nextInt());
			System.out.println("강사 이름");
			teacher.setName(scan.next());

			for (int i = 0; i < teacherlist.length; i++) { // 선생님말로는 조건 랭스는 변하면 안되는 값이라고함
				if (teacherlist[i] != null && teacher.getNum() == (teacherlist[i].getNum())) {
					System.out.println("강사번호가 중복됩니다.");
					input = true; // true면 참이기때문에 와일룹이 다시 돌아서 위로감
				} else {
					input = false;
				}
			}
		} while (input); // 조건이 false면 조건에 맞지 않기때문에 이룹을 탈출함
		System.out.println(teacher.toString());
		teacherlist[tidx] = teacher;
		tidx++;

	}

	public void search() {              // 관련자 조회기능            작 업 중 
		
		while(true) {
			System.out.println("관련자유형(학생(10)/강사(20)):");
			switch (scan.nextInt()) {
			case 10:
				student = new Student();
				System.out.println("(학생)번호 입력");
				do {
					System.out.println("학생번호");
					student.setNum(scan.nextInt());

					for (int i = 0; i < studentlist.length; i++) { // 선생님말로는 조건 랭스는 변하면 안되는 값이라고함
						if (studentlist[i] != null && student.getNum() == (studentlist[i].getNum())) {
							System.out.println(studentlist[i].getName());
							check = false; // true면 참이기때문에 와일룹이 다시 돌아서 위로감
							break;
						} else {
							System.out.println("없는 학생입니다.");
							check = true;
						}
					}
				} while (check); // 조건이 false면 조건에 맞지 않기때문에 이룹을 탈출함
				break;
			case 20:
				teacher = new Teacher();
				System.out.println("(강사)번호 입력");
				do {
					System.out.println("강사 번호");
					teacher.setNum(scan.nextInt());

					for (int i = 0; i < teacherlist.length; i++) { // 선생님말로는 조건 랭스는 변하면 안되는 값이라고함
						if (teacherlist[i] != null && teacher.getNum() == (teacherlist[i].getNum())) {
							System.out.println(teacherlist[i].getName());
							input = false; // true면 참이기때문에 와일룹이 다시 돌아서 위로감
						} else {
							System.out.println("없는 강사입니다.");
							input = true;
						}
					}
				} while (input); // 조건이 false면 조건에 맞지 않기때문에 이룹을 탈출함
				break;
				
			default:System.out.println("다시 입력해주셍쇼");
				break;
			}
		}
		

	}
}

public class Academic {
	public static void main(String[] args) {     // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ메인메소드
		Scanner scan = new Scanner(System.in);
		
		Funtion funtion = new Funtion();
		Student[] students = new Student[3];     // 강의실 

		while (true) { // 4,5은 번외
			System.out.println("0:나가기, 1:학생등록, 2:강사등록, 3. 관련자 조회, 4. 강의등록,5:강의조회");
			switch (scan.nextInt()) {
			case 0:
				System.out.println("나가기");
				return;
			case 1:
				funtion.inputStudent();
				break;
			case 2:
				funtion.inputTeacher();
				break;
			case 3:
				funtion.search();
				break;
			case 4:
				break; // 강의등록
			case 5:
				break; // 강의 조회

			default:
				System.out.println("다시 입력해 주세요");
				break;
			}
		}
	}

}
