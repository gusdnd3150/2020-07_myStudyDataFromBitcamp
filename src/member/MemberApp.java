package member;
/*
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 로그인 
 * 3. 비번 수정           //
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 마이페이지
 * **********
 * <관리자기능>
 * 7. 회원목록
 * 8. 아이디검색
 * 9. 이름검색
 * 10. 전체 회원수
 */

import java.util.Scanner;
import race.Player;

public class MemberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = null;
		MemberService memberService = new MemberServiceImpl();
		while (true) {
			System.out.println("메뉴: 0.종료 1.회원가입 2.로그인"
					+ "3. 회원목록 4.아이디존재 5. 비밀번호수정 ");
			switch (scanner.nextInt()) {
			case 0: System.out.println("종료");return;
			case 1: // 1. 회원가입
				member = new Member();
				System.out.println("회원가입");
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				System.out.println("이름: ");
				member.setName(scanner.next());
				memberService.join(member);
				break;
			case 2: // 2. 로그인
				System.out.println("로그인");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("비밀번호: ");
				member.setPassword(scanner.next());
				String result= memberService.login(member);
				System.out.println(result);
				break;
			case 3: // 3. 회원목록
				System.out.println("목록보기");
				Member[] list= memberService.list();
				for(int i=0;i < 3;i++) {
					System.out.println(list[i].toString());
				}
				break;
			case 4: // 4. 아이디 중복체크
				System.out.println("아이디 체크");
				member = new Member();
				System.out.println("아이디: ");
				result= memberService.existId(scanner.next());
				System.out.println(result);
				break;
			case 5: // 5. 비번 수정
				System.out.println("로그인");
				member = new Member();
				System.out.println("아이디: ");
				member.setUserid(scanner.next());
				System.out.println("수정할 비밀번호: ");
				member.setPassword(scanner.next());
				String result1= memberService.changePassword(member);
				System.out.println(result1);
				break;
			case 6: // 6. 회원탈퇴
				memberService.withdrawal(member);
				
				break;
			case 7: // 7. 아이디검색
				System.out.println("찾으시는 아이디를 입력해주세요:");
				memberService.idfind(scanner.next());
				break;
			case 8:	// 8. 이름 검색
				break;
			case 9: // 9. 전체 회원수
				break; 
			default:
				System.out.println("메뉴에 없는 기능입니다.");
				break;
			}
		}

	}
}