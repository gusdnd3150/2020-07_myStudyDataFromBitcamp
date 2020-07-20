package study08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext; 
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

public class OrderDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public OrderDAO() { 
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List OrderList(OrderVO ordervo) {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			
			String query = "select oi.order_num, oi.order_item, p.prod_id, p.prod_name, oi.quantity, oi.item_price" + 
					" from orderitems oi, products p" + 
					" where oi.prod_id = p.prod_id";
			
			if(ordervo.getSearchId() != null && ordervo.getSearchId().length() != 0) {
				query += " and oi.order_num like '%" + ordervo.getSearchId() + "%'";
			}
			
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate(); //회원 정보를 테이블에 추가합니다.
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String num = rs.getString("order_num");
				String item = rs.getString("order_item");
				String prodId = rs.getString("prod_id");
				String name = rs.getString("prod_name");
				String quantity = rs.getString("quantity");
				String price = rs.getString("item_price");
				String searchId = ordervo.getSearchId();
			
				OrderVO vo = new OrderVO();
				vo.setNum(num);
				vo.setItem(item);
				vo.setProdId(prodId);
				vo.setName(name);
				vo.setQuantity(quantity);
				vo.setPrice(price);
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
	

	public void editOrder(OrderVO vo) {
		try {
			String num = vo.getNum();
			String item = vo.getItem();
			String prodId = vo.getProdId();
			String quantity = vo.getQuantity();
			String price = vo.getPrice();
			String editId = vo.getEditId();
			String editProdId = vo.getEditProdId();
			
			Connection con = dataFactory.getConnection();

			String query = "update orderitems set order_num='" + num + "', order_item='" + item + "', prod_id='" + prodId + "', quantity='" + quantity + "', item_price='" + price + "' where order_num='" + editId + "' and prod_id='" + editProdId + "'";
			System.out.println("prepareStatement: " + query);

			pstmt = con.prepareStatement(query);

			pstmt.executeUpdate();
			
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delOrder(String id, String prodId) {
		try {
			OrderVO vo = new OrderVO();
			vo.setDelId(id);
			Connection con = dataFactory.getConnection();

			String query = "delete from orderitems where order_num='" + id + "' and prod_id='" + prodId + "'";
			System.out.println("prepareStatement: " + query);

			pstmt = con.prepareStatement(query);
			
			System.out.println(id + ", " + prodId);
			pstmt.executeUpdate();
			
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
