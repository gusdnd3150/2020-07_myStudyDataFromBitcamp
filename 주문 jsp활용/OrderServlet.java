package main.sec01.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        OrderDAO dao = new OrderDAO();

        String order_num = request.getParameter("order_num");
        String order_item = request.getParameter("order_item");
        String prod_id = request.getParameter("prod_id");
        String quantity = request.getParameter("quantity");
        String item_price = request.getParameter("item_price");

        String command = request.getParameter("command");

        List<OrderVO> list=null;
        if("search".equals(command)){
            list=dao.searchByOrderNum(order_num);

        }else if("delete".equals(command)){
            order_num = (String) session.getAttribute("order_num");
            dao.deleteOrder(order_num);

        }else if("update".equals(command)){
            OrderVO vo = new OrderVO(order_num,order_item,prod_id,quantity,item_price);
            dao.updateOrder(vo);
            list=dao.listOrder();
        }
        request.setAttribute("list",list);

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/order.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e){
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
        rd.forward(request, response);
    }
}
