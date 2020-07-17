package study06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String input_prod=request.getParameter("prod_id");
		String input_vend=request.getParameter("vend_id");
		String command=request.getParameter("command");
		
		ProductsDAO dao = new ProductsDAO();
		
		if(command!=null && command.equals("delProd")) {
			String del_id=request.getParameter("del_id");
			dao.delProd(del_id);
		}else if(command!=null && command.equals("inputProd")) {
			String prod_name=request.getParameter("prod_name");
			String prod_price=request.getParameter("prod_price");
			String prod_desc=request.getParameter("prod_desc");
			
			ProductsVO inputVO = new ProductsVO();
			
			inputVO.setProd_id(input_prod);
			inputVO.setProd_name(prod_name);
			inputVO.setProd_price(prod_price);
			inputVO.setProd_desc(prod_desc);
			inputVO.setVend_id(input_vend);
			
			dao.addProd(inputVO);
		}

		out.print("<html><body>");
		List<ProductsVO> list = dao.listProd(input_prod, input_vend);//listCust()메서드로 회원 정보를 조회합니다.	
		if(list.isEmpty()) {
			out.print("고객정보가 존재하지 않습니다.");
		}else {
			out.print("<table border=1><tr align='center' bgcolor='DodgerBlue'>");
			out.print("<td>제품번호</td><td>제품명</td><td>제품가격</td><td>제품설명</td><td>공급업체명</td><td>삭제</td></tr>");
			for(int i=0; i<list.size();i++) {//조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력합니다.
				ProductsVO prodVO = list.get(i);
				String prod_id=prodVO.getProd_id();
				String prod_name=prodVO.getProd_name();
				String prod_price=prodVO.getProd_price();
				String prod_desc=prodVO.getProd_desc();
				String vend_id=prodVO.getVend_id();
	
				out.print("<tr><td>"+prod_id+"</td><td>"+prod_name+"</td><td>"+prod_price
						+"</td><td>"+prod_desc+"</td><td>"+vend_id+"</td>"
						+"<td><a href='/WebStudy/products?command=delProd&del_id="+prod_id+"&prod_id="+input_prod+"&vend_id="+input_vend+"'>삭제</a></td></tr>");
			}
			out.print("</table>");
		}
		out.print("</body></html>");
		out.print("<a href='/WebStudy/study06/products.html'>다시 조회하기</a>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
