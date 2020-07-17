package morningTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vendors
 */
@WebServlet("/vendors")
public class Vendors extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		VendorsDAO dao= new VendorsDAO();
		String command = request.getParameter("command");
		List<VendorsVO> list;
		
		if ("search".equals(command)) {   //검색                                 //조회
			String ve_name  = request.getParameter("vend_name");
			list =dao.search(ve_name);       //업체명을 dao search메소드로 보낸 뒤 dao에서 작업 수행
			
			out.print("<html><body>");
			out.print("<table border=1><tr align='center' bgcolor='lightblue'>");
			out.print("<td>공급업체번호</td><td>공급업체이름</td><td>공급업체주소</td><td>공급업체시"
					+ "</td><td>공급업체주</td><td>공급업체우편번호</td><td>업체 국가</td><td>국가</td><td>삭제</td></tr>");
			for(int i=0; i<list.size(); i++){
				VendorsVO  vo= (VendorsVO) list.get(i);

				String vend_id = vo.getVend_id();
				String vend_address = vo.getVend_id();
				String vend_city = vo.getVend_id();
				String vend_sate = vo.getVend_id();
				String vend_zip = vo.getVend_id();
				String vend_country = vo.getVend_id();
				String vend_name = vo.getVend_id();

			
			out.print("<tr><td>"+vend_id+"</td>");
			out.print("<td>"+vend_name+"</td>");
			out.print("<td>"+vend_address+"</td>");
			out.print("<td>"+vend_city+"</td>");
			out.print("<td>"+vend_sate+"</td>");
			out.print("<td>"+vend_zip+"</td>");
			out.print("<td>"+vend_country+"</td>");
			out.print("<td><ahref='/newTest/Vendors?command=delVendor&id="+vend_id+"'>삭제</a></td></tr>");
			}
			out.print("</table></body></html>");
			out.close();
		}
		else if ("delVendor".equals(command)) {                           //삭제
		String ve_id = request.getParameter("id");
		dao.delVendor(ve_id);
			
		}
		
		


		
	}

}
