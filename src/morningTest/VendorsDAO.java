package morningTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class VendorsDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;

	public VendorsDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addVendor(VendorsVO vendorsVO) {
		
		try {
			con = dataFactory.getConnection();
			String vend_id = vendorsVO.getVend_id();
			String vend_name = vendorsVO.getVend_name();
			String vend_address = vendorsVO.getVend_address();
			String vend_city = vendorsVO.getVend_city();
			String vend_sate = vendorsVO.getVend_state();
			String vend_zip = vendorsVO.getVend_zip();
			String vend_country = vendorsVO.getVend_country();
			
			
			String query = "insert into vendors ";
			query += "(prod_id,prod_name,prod_price,prod_desc,vend_id)";
			query += "values(?,?,?,?,?,?,?)";
			
			System.out.println("prepareStatement:" + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vend_id);
			pstmt.setString(2, vend_name);
			pstmt.setString(3, vend_address);
			pstmt.setString(4, vend_city);
			pstmt.setString(5, vend_sate);
			pstmt.setString(6, vend_zip);
			pstmt.setString(7, vend_country);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<VendorsVO> search (String _vend_name) {
		List<VendorsVO> list = new ArrayList<VendorsVO>();
		try {
			con = dataFactory.getConnection();
			String query = " select * from vendors ";
			query += " where vend_name = '%"+ _vend_name +"%' ";
			System.out.println("prepareStatement:" + query);

			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String vend_id = rs.getString("vend_id");
				String vend_name = rs.getString("vend_name");
				String vend_address = rs.getString("vend_address");
				String vend_city = rs.getString("vend_city");
				String vend_sate = rs.getString("vend_sate");
				String vend_zip = rs.getString("vend_zip");
				String vend_country = rs.getString("vend_country");
				VendorsVO vo = new VendorsVO(vend_id, vend_name, vend_address, vend_city, vend_sate,vend_zip,vend_country);
				list.add(vo);
				
				
			}
			rs.close();// 반드시닫아야한다.
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delVendor(String id) {
		try {
			con = dataFactory.getConnection();
			String query = " delete from vendors" + " where vend_id ='" + id + "' ";
			System.out.println("prepareStatement:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}