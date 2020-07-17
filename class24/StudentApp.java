package class24;

import java.util.Scanner;

/*선택하세요. [0:나가기, 1:학생입력, 2:학생수출력  //, 3:학과별 학점평균,4:학생목록출력]
[학생입력]
학번: 111
이름: 홍길동
학과: 수학과
학점: 90
*/


class Student {
	int number,score;       //학번 학점
	String name,sub;        //이름 과목
	int avg;
	int list;
	
	public void setAvg(int avg) { this.avg = avg;}
	public void setList(int list) {this.list = list;}
	public void setNumber(int number) {this.number = number;}
	public void setScore(int score) {this.score = score;}
	public void setName(String name) {this.name = name;}
	public void setSub(String sub) {this.sub = sub;}
	
	public int getAvg() {return avg;}
	public int getList() {return list;}
	public int getNumber() {return number;}
	public int getScore() {return score;}
	public String getName() {return name;}
	public String getSub() {return sub;}
	
	@Override
	public String toString() {
		return "학번 : "+number+ "이름 : "+name+"과목 :"+sub +"학점 :"+score;
	}
	
}


interface StudentSercive {
	public void StudentInput(Student student);  //1:학생입력   //매개변수는 관련 정보를 받을수있는 최초로 선언된곳을 입력 
	public void total();                       //2:학생수출력
	public void TotalAvg(Student student);    //3:과목별 학점평균
	public Student[] StudentList();  //4:학생목록출력
}


class  StudentSerciveImpl implements StudentSercive{

	private Student[] students;      //지역변수 인스턴스변수 등 넓은 범위의 변수들은 예를들어 while for문들 반복문이 끝나고
	static int count;                //메인메소드가 끝나기전까지  변수들은 초기화되지 않는다.즉 값이 유지되며 사용시 쌓임
	
	StudentSerciveImpl(){                //생성자 쓴 이유는 맴버 변수를(인스턴스변수) 용도에 맞게 초기화, 사용하고 싶어서?
		students = new Student[3];
		
	}
	
	@Override
	public void StudentInput(Student student) {
		students[count] = student;
		count++;         //배열에 입력시 인덱스값에 변화를 주지 않으면 (가입시 인원수를 나타냄)
	}                    //다음 배열에 정보등록시 전값에 덮어씌워지기때문에 count++로 추가해줌 (for문대신 사용했음)

	@Override
	public void total() {
		System.out.println("총 회원수"+count);
	}

	@Override                                   //작업중  실패...
	public void TotalAvg(Student student) {
		Scanner scan= new Scanner(System.in);
		float total = 0.0f;
		int cnt = 0;
		System.out.println("과목를 입력하세요: ");
		String sub = scan.next();
		for(Student s: students) {
			if(s != null && sub.equals(s.getSub())) {
				total += s.getScore();
				cnt++;
			}else {
				break;
			}
		}
		System.out.println("평균점수: "+ (total/(float)cnt));
		
		
		
		
		
		
		/*
		 * float sum =0.0f; int avg = 0; for (int i = 0; i< students.length ;i++) { if
		 * (student.getSub().equals(students[count].getSub())) { sum =+
		 * students[count].getScore(); } } avg = (int)sum/count; return avg;
		 */
	}

	@Override                                        // 상당히 어렵다... 이경우 Student[] students 배열을 
	public Student[] StudentList() {                  // 메인App에서도 선언을 해주어야하고(초기화는하지않는상태즉 null상태로)
		return students;                             // 해당 case안에서 생성자호출(배열호출) 초기화하여?
	                                               // for문을 통해 imp클래스의 StudentList에 넣고 toString을 출력해야했다.
	}
}
public class StudentApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student student;
		Student[] students;
		StudentSercive studentSercive = new StudentSerciveImpl();
		
		
		while (true) {  
			System.out.println("0:나가기, 1:학생입력, 2:학생수출력 3:학과별 학점평균,4:학생목록출력");
			switch (scan.nextInt()) {
			case 1: //학번 이름 학과 학점
				student = new Student();
				System.out.println("학번입력:");
				student.number = scan.nextInt();
				System.out.println("이름 :");
				student.name = scan.next();
				System.out.println("과목 :");
				student.sub = scan.next();
				System.out.println("학점 :");
				student.score = scan.nextInt();
				System.out.println(student.toString());
				studentSercive.StudentInput(student);
				break;
			case 2:// 학생수 출력
				studentSercive.total();
				break;
			case 3: 
				student = new Student();
				System.out.println("보고싶은 과목 평균 점수");
				student.sub = scan.next();
				studentSercive.TotalAvg(student);
				break;
			case 4: 
				//App상황에서 회원목록 출력 코드 
				//Student[] students; 가 위에 선언되었다는 가정
				System.out.println("회원목록");
				Student[] StudentList = studentSercive.StudentList();
				for(int i= 0; i < 3 ;i++) {
					System.out.println(StudentList[i].toString());
				}
				break;
				
			case 0:System.out.println("종료");
				return;
			}
			
		}
	}
}





