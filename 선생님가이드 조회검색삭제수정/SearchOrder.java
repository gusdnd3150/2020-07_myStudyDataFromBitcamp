package study08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchOrder
 */
@WebServlet("/searchOrder")
public class SearchOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		OrderVO vo = new OrderVO();
		OrderDAO dao = new OrderDAO();
		String command = request.getParameter("command");
		List list = null;
		
		String _searchId = request.getParameter("searchId");
		vo.setSearchId(_searchId);

		
		if(command != null && command.equals("delOrder")) {
			String _num = request.getParameter("num");
			String _prodId = request.getParameter("prodId");
			dao.delOrder(_num, _prodId);
			vo = new OrderVO();
		} else if (command != null && command.equals("editOrder")){ //조회 테이블에서 수정버튼
			
			String _num = request.getParameter("order_num");
			String _prodId = request.getParameter("prod_id");
			String _item = request.getParameter("order_item");
			String _quantity = request.getParameter("quantity");
			String _price = request.getParameter("item_price");

			vo.setNum(_num);
			vo.setProdId(_prodId);
			vo.setItem(_item);
			vo.setQuantity(_quantity);
			vo.setPrice(_price);
			
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/study08/edit.jsp");
			dispatcher.forward(request, response);
			return;
		} else if(command != null && command.equals("edit")){ //수정할 값을 넣고 수정버튼
			String _editId = request.getParameter("order_num");
			String _editProdId = request.getParameter("prod_id");
			String _editItem = request.getParameter("order_item");
			String _editQuantity = request.getParameter("quantity");
			String _editPrice = request.getParameter("item_price");
			String _id = request.getParameter("editId"); //수정할 order_num
			String _prodId = request.getParameter("editProdId"); //수정할 prod_id
			
			vo.setNum(_editId);
			vo.setProdId(_editProdId);
			vo.setItem(_editItem);
			vo.setQuantity(_editQuantity);
			vo.setPrice(_editPrice);
			vo.setEditId(_id);
			vo.setEditProdId(_prodId);

			dao.editOrder(vo);
			vo = new OrderVO();
		}
		
		list = dao.OrderList(vo);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study08/look.jsp");
		dispatcher.forward(request, response);
	}
}
