package study05;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


//prepareStatement
public class SearchDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public SearchDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List searchMember(String id) {
		List list = new ArrayList();
		try {
			Connection con = dataFactory.getConnection();
			
			String query = "select cust_id, cust_name, cust_address"
					+ " from customers"
					+ " where cust_id like '%" + id + "%'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate(); //회원 정보를 테이블에 추가합니다.
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String id2 = rs.getString("cust_id");
				String name = rs.getString("cust_name");
				String address = rs.getString("cust_address");
				SearchVO vo = new SearchVO();
				vo.setId(id2);
				vo.setName(name);
				vo.setAddress(address);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void delMember(String id) {
		try {
			SearchVO vo = new SearchVO();
			vo.setDelId(id);
			Connection con = dataFactory.getConnection();

			String query = "delete from customers where cust_id='" + id + "'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List searchOrder(String id) {
		List list = new ArrayList();
		try {
			Connection con = dataFactory.getConnection();
			
			String query = "select oi.order_num, p.prod_id, p.prod_name, oi.quantity, oi.item_price" + 
					" from products p, orderitems oi, orders o, customers c" + 
					" where p.prod_id = oi.prod_id" + 
					" and oi.order_num = o.order_num" + 
					" and o.cust_id = c.cust_id" + 
					" and c.cust_id = ?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String num = rs.getString("order_num");
				String id2 = rs.getString("prod_id");
				String name = rs.getString("prod_name");
				String quantity = rs.getString("quantity");
				String price = rs.getString("item_price");
				SearchVO vo = new SearchVO();
				vo.setOrder_num(num);
				vo.setProd_id(id2);
				vo.setProd_name(name);
				vo.setQuantity(quantity);
				vo.setPrice(price);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void delOrder(String order_num, String prod_id) {
		try {
			Connection con = dataFactory.getConnection();

			String query = "delete from orderitems where order_num='" + order_num + "' and prod_id='" + prod_id + "'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, order_num);
//			pstmt.setString(2, prod_name);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
