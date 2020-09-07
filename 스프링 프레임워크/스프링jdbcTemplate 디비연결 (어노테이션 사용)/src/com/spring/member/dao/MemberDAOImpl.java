package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;     
	//필드에있는 JdbcTemplate에 @autowird를 두고 싶을 경우 이에 해당하는 빈이 xml에 등록되어있어야한다
	//(setDataSource소스에보면 set 파라미터로 dataSouce를 받고있기때문)
	// 필드에 @autowired를 주입하면 궂이 setter를 만들 필요는 없다
	
	/*
	 * @Autowired public void setDataSource(DataSource dataSource) {
	 * this.jdbcTemplate = new JdbcTemplate(dataSource); }
	 */

	@Override
	public List selectAllMembers() throws DataAccessException {
		String query = "select id,pwd,name,email,joinDate" + " from t_member " + " order by joinDate desc";
		List membersList = new ArrayList();

		membersList = this.jdbcTemplate.query(query, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				return memberVO;
			}
		});
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		String query = "insert into t_member(id,pwd, name,email) values  ("
		                 + "'" + id + "' ,"
	 	                 + "'" + pwd + "' ,"
		                 + "'" + name + "' ,"
		                 + "'" + email + "') ";
		System.out.println(query);
		int result = jdbcTemplate.update(query);
		System.out.println(result);
		return result;
	}

}