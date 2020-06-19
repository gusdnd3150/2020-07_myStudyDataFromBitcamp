package member;

public class MemberServiceImpl implements MemberService{
	private Member[] members; 
	private int count;
	
	public MemberServiceImpl() {
		members  = new Member[3];
		count = 0;
	}
	// 1. 회원가입
	@Override
	public void join(Member member) {
		members[count] = member;
		count++;
	}
	
	// 2. 로그인
	@Override
	public String login(Member member) {
		String result = "FAIL";
		for(int i=0;i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				result = "SUCCESS";
				break;
			}
		}
		return result;
	}
	// 3. 회원목록
	@Override
	public Member[] list() {
		return members;
	}
	// 4. 아이디 중복체크
	@Override
	public String existId(String id) {
		String result = "중복없음";
		for(int i=0; i< count; i++) {
			if(id.equals(members[i].getUserid())) {
				result ="중복된 아이디";
			}
		}
		return result;
	}
	// 5. 비번 수정
	@Override
	public String changePassword(Member member) {
		String result = "FAIL";
		for(int i=0;i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				result ="SUCCESS";
				break;
			}
		}
		return result;
	}
		
	// 6. 회원탈퇴
	@Override
	public String withdrawal(Member member) {
		String sdsd = null;
		
		for(int i=0;i< count; i++) {
			if(sdsd.equals("y")) {
				members[i].toString();break;
			}
			
		}
		return sdsd ;
	}
	// 7. 아이디검색
	@Override
	public Member idfind(String id) {
		Member member = new Member();
		for(int i =0; i<members.length;i++) {
			if(id.equals(members[i].getUserid())) {
				member = members[i] ;
				break;
			}
		}
		return member;
	}
	// 8. 이름 검색(동명이인 처리필요)
	@Override
	public Member[] namefind(String name) {
		int cnt = 0; // 동명이인의 수
		
		Member[] temp = new Member[cnt];
		return null;
	}
	// 9. 전체 회원수
	@Override
	public int count() {
		return 0;
	}
}