package study09;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext; 
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
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
		String vid = memberVO.getId();
		System.out.println("id:" + vid);
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member ";
			
			if((vid != null && vid.length()!=0)){
				 query+=" where id = ?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, vid);
			}else {
				pstmt = con.prepareStatement(query);	
			}
			
			
			System.out.println("prepareStatememt: " + query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				membersList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();

			String query = "delete from t_member where id=?";
			System.out.println("prepareStatement: " + query);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void insertMember(String id, String pwd, String name, String email) {
		try {
			con = dataFactory.getConnection();

			String query = "insert into t_member(id, pwd, name, email)";
			query += "      values(?, ?, ?, ?) ";
			System.out.println("prepareStatement: " + query);
			System.out.println("3333333333333333: " + id + "," + pwd + "," + name+ "," + email);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}		
	
	public void updateMember(String id, String pwd, String name, String email) {
		try {
			con = dataFactory.getConnection();

			String query = "update t_member";
			query += " set  pwd = ? ";
			query += "    , name = ? ";
			query += "    , email = ? ";
			query += " where id = ? ";
			System.out.println("prepareStatement: " + query);
			System.out.println("3333333333333333: " + id + "," + pwd + "," + name+ "," + email);

			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
