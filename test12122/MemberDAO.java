package test12122;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() { // 생성자
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers(MemberVO memberVO) {
		List membersList = new ArrayList();
		String _name = memberVO.getName();
		
		try {
			con = dataFactory.getConnection(); // DataSource를이용해데이터베이스에연결한다.
			String query = " select * from T_MEMBER ";
	         if((_name != null && _name.length()!=0)) {
	            query += " where name= ? ;";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _name);
			}else {
				pstmt = con.prepareStatement(query);
			}
			
			System.out.println("preparedStatement:" + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) // next를이용어레이안의다음객체를확인
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd"); // 조회된레코드의각칼럼값을받아온다
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO(); // 각칼럼값을다시memverVO객체의속성에설정한다.
				vo.setId(id);
				vo.setPwd(pwd); // 즉받아온칼럼을자바프로그램특성에맞게
				vo.setName(name); // vo객체에넣어서다시이런저런작업을한후최후에는
				vo.setEmail(email); // vo에입력된애들을다시html버전으로바꿔준뒤출력하는식이
				vo.setJoinDate(joinDate);

				membersList.add(vo); // 설정된memberVO객체를다시ArrayList에저장한다
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

}
