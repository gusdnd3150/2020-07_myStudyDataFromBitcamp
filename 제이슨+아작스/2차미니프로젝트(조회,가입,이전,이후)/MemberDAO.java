package miniproject2;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberVO listMembers(String _id) {
		MemberVO vo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from  t_member where id like '%"+_id+"%'";
			pstmt = conn.prepareStatement(query);        //sql문 전달
			ResultSet rs = pstmt.executeQuery();          //sql결과를 가지고옴
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joinDate = rs.getString("joinDate");
				vo = new MemberVO(id, pwd, name,email,joinDate);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("연동실패");
			e.printStackTrace();
		}
		return vo;
	}
	
	public void addMember(MemberVO vo2) {
		try {
			String id = vo2.getId();
			String pwd = vo2.getPwd();
			String name = vo2.getName();
			System.out.println(id);
			System.out.println(pwd);
			System.out.println(name);
			
			conn = dataFactory.getConnection();
			String query = "insert into t_member";
			query += "(id, name, pwd )";
			query += " values(?, ?, ?)";
			//String query = "insert into t_member(id,pwd,name) values (?,?,?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("연동실패");
			e.printStackTrace();
		}
		System.out.println(vo2.getId()+">>>>"+vo2.getName());
		
	}
	
	public List<MemberVO> totallist() {
		List<MemberVO> list = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "select * from  t_member ";
			pstmt = conn.prepareStatement(query);        //sql문 전달
			ResultSet rs = pstmt.executeQuery();          //sql결과를 가지고옴
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String joinDate = rs.getString("joinDate");
				MemberVO vo = new MemberVO(id, pwd, name,email,joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("연동 성공");
		} catch (SQLException e) {
			System.out.println("연동실패");
			e.printStackTrace();
		}
		return list;
		
	}
	
}