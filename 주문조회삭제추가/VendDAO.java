package study07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VendDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public VendDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List VendList(String id) {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			
			String query = "select vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country"
					+ " from vendors"
					+ " where vend_id like '%" + id + "%'";
			
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate(); //회원 정보를 테이블에 추가합니다.
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String id2 = rs.getString("vend_id");
				String name = rs.getString("vend_name");
				String address = rs.getString("vend_address");
				String city = rs.getString("vend_city");
				String state = rs.getString("vend_state");
				String zip = rs.getString("vend_zip");
				String country = rs.getString("vend_country");
				String searchId = id;
				VendVO vo = new VendVO();
				vo.setId(id2);
				vo.setName(name);
				vo.setAddress(address);
				vo.setCity(city);
				vo.setState(state);
				vo.setZip(zip);
				vo.setCountry(country);
				vo.setSearchId(searchId);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void editVend(String id, String name, String address, String city, String state, String zip, String country, String editId) {
		try {
			con = dataFactory.getConnection();
			VendVO vo = new VendVO();
			
//			String query = "update vendors"
//					+ " set vend_id = ?, vend_name = ?, vend_address = ?, vend_city = ?, vend_state = ?, vend_zip = ?, vend_country = ?"
//					+ " where vend_id = '" + editId + "'";
			String query = "update vendors"
					+ " set vend_id='" + id + "', vend_name ='" + name + "', vend_address ='" + address + "', vend_city='" + city + "', vend_state='" + state + "', vend_zip ='" + zip + "', vend_country ='" + country + "'"
					+ " where vend_id = '" + editId + "'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			
//			pstmt.setString(1, id);
//			pstmt.setString(2, name);
//			pstmt.setString(3, address);
//			pstmt.setString(4, city);
//			pstmt.setString(5, state);
//			pstmt.setString(6, zip);
//			pstmt.setString(7, country);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delVend(String id) {
		try {
			VendVO vo = new VendVO();
			vo.setDelId(id);
			Connection con = dataFactory.getConnection();

			String query = "delete from vendors where vend_id=?";
			System.out.println("prepareStatement: " + query);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
