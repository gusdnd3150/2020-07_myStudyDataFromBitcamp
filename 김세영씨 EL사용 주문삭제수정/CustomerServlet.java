package customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/main")
public class CustomerServlet extends HttpServlet {

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO dao = new CustomerDAO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command = request.getParameter("command");
		System.out.println(command);
		List<CustomerVO> list;
		
		if(command != null && command.equals("search")) {	// 검색
			System.out.println("***");
			String _cust_id = request.getParameter("cust_id");
			list = dao.listCustomer(_cust_id);
		}else{													
			list = dao.listCustomer();
		}
		
		if(command != null && command.equals("edit")) {		// 수정
			System.out.println("edit");
			String _cust_id = request.getParameter("cust_id");	
			String _cust_name = request.getParameter("cust_name");	
			CustomerVO vo = new CustomerVO();
			for(CustomerVO v: list) {
				String voId = v.getCust_id().trim();
				String voName = v.getCust_name().trim();
				if(v != null && _cust_id.equals(voId) && _cust_name.equals(voName)){
					vo = v;
				}
			}
			request.setAttribute("vo", vo);
			RequestDispatcher dis = request.getRequestDispatcher("form.jsp");
			dis.forward(request, response);
			return;
		}else if(command != null && command.equals("add")) {	// 추가
			System.out.println("add");
			String cust_id = request.getParameter("cust_id").trim();
			String cust_name = request.getParameter("cust_name").trim();
			String cust_address = request.getParameter("cust_address").trim();
			String cust_city = request.getParameter("cust_city").trim();
			String cust_state = request.getParameter("cust_state").trim();
			String cust_zip = request.getParameter("cust_zip").trim();
			String cust_country = request.getParameter("cust_country").trim();
			String cust_contact = request.getParameter("cust_contact").trim();
			String cust_email = request.getParameter("cust_email");
			CustomerVO vo = new CustomerVO(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email);
			dao.addCustomer(vo);
		}else if(command != null && command.equals("editCompl")) {
			System.out.println("editCompl");
			String _cust_id = request.getParameter("ori_id").trim();	
			String _cust_name = request.getParameter("ori_name").trim();
			String cust_id = request.getParameter("cust_id").trim();
			String cust_name = request.getParameter("cust_name").trim();
			String cust_address = request.getParameter("cust_address").trim();
			String cust_city = request.getParameter("cust_city").trim();
			String cust_state = request.getParameter("cust_state").trim();
			String cust_zip = request.getParameter("cust_zip").trim();
			String cust_country = request.getParameter("cust_country").trim();
			String cust_contact = request.getParameter("cust_contact").trim();
			String cust_email = request.getParameter("cust_email").trim();
			CustomerVO vo = new CustomerVO(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email);
			dao.editCustomer(_cust_id, _cust_name, vo);
		}
		
		request.setAttribute("list", list); 	// 세션에 list 정보 바인딩.
		// view 뿌리기 
		RequestDispatcher dis = request.getRequestDispatcher("view.jsp");
		dis.forward(request, response);
		
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

}
