package main.sec01.order;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public OrderDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<OrderVO> listOrder(){
        List<OrderVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from orderitems";
            pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<OrderVO> searchByOrderNum(String num){
        List<OrderVO> list = new ArrayList<>();
        try
        {
            con = dataFactory.getConnection();
            String query = "select * from orderitems where order_num like ?";
            pstmt = con.prepareStatement(query);
            String value= "%"+num+"%";
            pstmt.setString(1, value);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void updateOrder(OrderVO vo){
        try{
            con = dataFactory.getConnection();
            String query =
                    "update orderitems set prod_id=?, quantity=?, item_price=? where order_num = ? AND prod_id= ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,vo.getProd_id());
            pstmt.setInt(2, Integer.parseInt(vo.getQuantity()));
            pstmt.setInt(3, Integer.parseInt(vo.getItem_price()));
            pstmt.setInt(4, Integer.parseInt(vo.getOrder_num()));
            pstmt.setString(5,vo.getProd_id());

            pstmt.executeQuery();
            pstmt.close();
            con.close();

            } catch (Exception e){
                e.printStackTrace();
            }
    }
    public void deleteOrder(String id){
        try
        {
            con = dataFactory.getConnection();
            String query = "delete from orderitems where vend_id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeQuery();

            pstmt.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
    }
    }
}
