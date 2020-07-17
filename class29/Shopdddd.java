package class29;

import java.util.Scanner;

class User {
	protected String id, password, name; // 아이디 비번 이름
	public static String usertype = "일반"; // 유저타입

	User() {
	}

	User(String id, String password, String name, String usertype) { // 생성자를 통하여 매개변수 초기화
		this.id = id;
		this.password = password;
		this.name = name;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String UserInfo() {
		return "아이디 : " + id + "비밀번호 : " + password + "이름 : " + name + "등급" + usertype;
	}

}

class VipUser extends User {
	public static String discountRate = "10%";
	public static String usertype = "VIP";

	VipUser() {
	}

	VipUser(String id, String password, String name, String usertype, String discountRate) {
		super.id = id;
		super.password = password;
		super.name = name;
		this.discountRate = discountRate; // 등급에 따른 할인률 10%
	}

	public String UserInfo() {
		return "아이디 : " + super.id + "비밀번호 : " + super.password + "이름 : " + super.name + "등급" + usertype + "등급할인률"
				+ this.discountRate;
	}
}


class Funtion { 
	Scanner scan = new Scanner(System.in);

	User user; // 유저 인스턴스
	VipUser vipUser; // vip 인스턴스
	User[] users = new User[100]; // 회원 배열
	VipUser[] vipUsers = new VipUser[100]; // vip배열
	int useridx = 0; // 회원수 카운트
	int vipidx = 0; // vip회원수 카운트
	boolean check = false;

	public void join() { // 회원가입
		user = new User();

		do {
			System.out.println("아이디 입력해주세요");
			user.setId(scan.next());

			for (int i = 0; i < users.length; i++) {
				if (users[i] != null && users[i].getId() == (users[i].getId())) {
					System.out.println("아이디가 중복됩니다.");
					check = true;
				} else {
					check = false;
				}
			}
		} while (check);
		System.out.println("비밀번호를 입력해 주세요");
		user.setPassword(scan.next());
		System.out.println("이름을 입력해 주세요");
		user.setName(scan.next());
		users[useridx] = user;
		useridx++;
		user.UserInfo();
	}

	public void login() { // 로그인
		user = new User();

		do {
			System.out.println("아이디 입력");
			user.setId(scan.next());
			System.out.println("비밀번호 입력");
			user.setPassword(scan.next());

			for (int i = 0; i < users.length; i++) { // users[i] == null if의 이부분을 넣기전에 nullpoint떳음 user전체룹을 돌리면서 null값을
														// 잡아줘야하나봄
				if (users[i] == null) { // 큰개념을 먼저??? 맨처음 아래 else부분에 이 코드를 넣었는데 조건이 적용되지 않은 느낌이었음 위로 올려보니 작동
					System.out.println("없는 아이디 입니다.");
					break;
				} else if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
					System.out.println("로그인 성공");
					check = false;
					return;
				} else {
					System.out.println("다시 입력해 주세요");
				}
			}
		} while (check);

	}

	public void changePassword() { // 비밀번호수정
		user = new User();
		do {
			System.out.println("변경하실 아이디를 입력해 주세요");
			user.setId(scan.next());
			System.out.println("비밀번호를 입력해 주세요");
			user.setPassword(scan.next());

			for (int i = 0; i < users.length; i++) {
				if (users[i] == null) {
					System.out.println("없는 아이디 입니다.");
					break;

				} else if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
					System.out.println("변경하실 비밀번호를 입력해주세요");
					user.setPassword(scan.next());
					users[i].setPassword(user.getPassword());
					check = false;
					break;

				} else {
					System.out.println("비밀번호를 다시 입력해 주세요");
					check = true;
				}
			}

		} while (check);
		return;
	}

	public void withdrawal() { // 회원 탈퇴
		user = new User();

		System.out.println("탈퇴하실 아이디와 비밀번호를 입력해 주세요");
		System.out.println("아이디");
		user.setId(scan.next());
		System.out.println("비밀번호");
		user.setPassword(scan.next());

		for (int i = 0; i < users.length; i++) {
			if(users[i] == null) {
				System.out.println("없는 아이디입니다.");
				break;
			}
			else if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
				users[useridx - 1] = null; // 인덱스를빼면 그공안은 없는 빈 공간이기때문에 null로 잡아준다???
				useridx--; // 설명을 못하겠
				return;
			}
			System.out.println("메뉴로 돌아갑니다.");
			return;
		}
	}

	public void MyPage() { // 조회 마이페이지???
		user = new User();

		System.out.println("마이페이지 (자기정보 조회)");
		System.out.println("아이디");
		user.setId(scan.next());
		System.out.println("비밀번호");
		user.setPassword(scan.next());

		for (int i = 0; i < users.length; i++) {
			if (users[i] == null) {
				System.out.println("없는 아이디 입니다.");
				break;
			}
			else if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
				System.out.println(users[i].UserInfo());
				return;
			} else if (users[i] == null) {
				System.out.println("메뉴로 돌아갑니다.");
				return;
			}
		}

	}

}

public class Shopdddd {
	public static void main(String[] args) {
		Funtion funtion = new Funtion();
		Scanner scan = new Scanner(System.in);

		int i = 0;

		while (true) {
			System.out.println("1.가입 2.로그인 3.탈퇴 4.마이페이지 5.비밀번호 변경");
			i = scan.nextInt();

			switch (i) {
			case 1:
				funtion.join();
				break;
			case 2:
				funtion.login();
				;
				break;
			case 3:
				funtion.withdrawal();
				break;
			case 4:
				funtion.MyPage();
				break;
			case 5:
				funtion.changePassword();
				break;

			default:
				break;
			}
		}

	}

}





