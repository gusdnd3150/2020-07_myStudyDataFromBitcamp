package customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CustomerDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	public CustomerDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addCustomer(CustomerVO vo) {
		try {
			con = dataFactory.getConnection();
			System.out.println("add");
			String cust_id = vo.getCust_id();
			String cust_name = vo.getCust_name();
			String cust_address = vo.getCust_address();
			String cust_city = vo.getCust_city();
			String cust_state = vo.getCust_state();
			String cust_zip = vo.getCust_zip();
			String cust_country = vo.getCust_country();
			String cust_contact = vo.getCust_contact();
			String cust_email = vo.getCust_email();
			String query = "insert into customers";
			query += "(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email)";
			query += " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println("prepareStatement: "+query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_name);
			pstmt.setString(3, cust_address);
			pstmt.setString(4, cust_city);
			pstmt.setString(5, cust_state);
			pstmt.setString(6, cust_zip);
			pstmt.setString(7, cust_country);
			pstmt.setString(8, cust_contact);
			pstmt.setString(9, cust_email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editCustomer(String _cust_id, String _cust_name, CustomerVO vo) {
		try {
			con = dataFactory.getConnection();
			System.out.println("add");
			String cust_id = vo.getCust_id();
			String cust_name = vo.getCust_name();
			String cust_address = vo.getCust_address();
			String cust_city = vo.getCust_city();
			String cust_state = vo.getCust_state();
			String cust_zip = vo.getCust_zip();
			String cust_country = vo.getCust_country();
			String cust_contact = vo.getCust_contact();
			String cust_email = vo.getCust_email();
			String query = "update customers ";
			query += "set cust_id=?, cust_name=?, cust_address=?, cust_city=?, "
					+ "cust_state=?, cust_zip=?, cust_country=?, cust_contact=?, cust_email=? "
					+ "where cust_id='"+_cust_id+"' and cust_name='"+_cust_name+"'";
			System.out.println("prepareStatement: "+query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_name);
			pstmt.setString(3, cust_address);
			pstmt.setString(4, cust_city);
			pstmt.setString(5, cust_state);
			pstmt.setString(6, cust_zip);
			pstmt.setString(7, cust_country);
			pstmt.setString(8, cust_contact);
			pstmt.setString(9, cust_email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CustomerVO> listCustomer(){
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from customers";
			System.out.println("prepareStatement: "+query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String cust_id = rs.getString("cust_id");
				String cust_name = rs.getString("cust_name");
				String cust_address = rs.getString("cust_address");
				String cust_city = rs.getString("cust_city");
				String cust_state = rs.getString("cust_state");
				String cust_zip = rs.getString("cust_zip");
				String cust_country = rs.getString("cust_country");
				String cust_contact = rs.getString("cust_contact");
				String cust_email = rs.getString("cust_email");
				CustomerVO vo = new CustomerVO(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email);
				list.add(vo);
			}
			rs.close();		// 반드시 닫아야한다.
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<CustomerVO> listCustomer(String _cust_id){
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from customers";
				query += " where cust_id like '%"+_cust_id+"%'";
			System.out.println("prepareStatement: "+query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String cust_id = rs.getString("cust_id");
				String cust_name = rs.getString("cust_name");
				String cust_address = rs.getString("cust_address");
				String cust_city = rs.getString("cust_city");
				String cust_state = rs.getString("cust_state");
				String cust_zip = rs.getString("cust_zip");
				String cust_country = rs.getString("cust_country");
				String cust_contact = rs.getString("cust_contact");
				String cust_email = rs.getString("cust_email");
				CustomerVO vo = new CustomerVO(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email);
				list.add(vo);
			}
			rs.close();		// 반드시 닫아야한다.
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	public void delCustomer(String id) {
//		try {
//			con = dataFactory.getConnection();
//			String query = "delete from products"+" where prod_id='"+id+"'";
//			System.out.println("prepareStatement: "+query);
//			pstmt = con.prepareStatement(query);
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
