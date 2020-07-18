package web_0717;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;

	public OrderDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public List<OrderVO> listOrders(String orderNum) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			con = dataFactory.getConnection();
			String query = " SELECT * FROM orderitems ";
			if(!"".equals(orderNum) && orderNum != null) {
				query += "WHERE order_num=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, orderNum);
			} else {
				pstmt = con.prepareStatement(query);
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String order_num = rs.getString("order_num");
				String order_item = rs.getString("order_item");
				String prod_id = rs.getString("prod_id");
				String quantity = rs.getString("quantity");
				String item_price = rs.getString("item_price");
				OrderVO vo = new OrderVO();
				vo.setOrder_num(order_num);
				vo.setOrder_item(order_item);
				vo.setProd_id(prod_id);
				vo.setQuantity(quantity);
				vo.setItem_price(item_price);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) { e.printStackTrace(); }
		return list;
	}
	
	public void delOrder(String order_num, String order_item) {
		try {
			con = dataFactory.getConnection();
			
			String query = " DELETE FROM orderitems WHERE order_num=? ";
			query += "AND order_item=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, order_num);
			pstmt.setString(2, order_item);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public void update(String order_num, String order_item, String prod_id, String quantity, String item_price) {
		try {
			con = dataFactory.getConnection();
			
			String query = " UPDATE orderitems SET prod_id =?";
			query += ",quantity=?,item_price=?";
			query += "WHERE order_num=? AND order_item=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, prod_id);
			pstmt.setString(2, quantity);
			pstmt.setString(3, item_price);
			pstmt.setString(4, order_num);
			pstmt.setString(5, order_item);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) { e.printStackTrace(); }
	}

}
