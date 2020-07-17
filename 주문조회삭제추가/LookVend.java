package study07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LookVend
 */
@WebServlet("/vend")
public class LookVend extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Encoding 생략
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		VendDAO dao = new VendDAO();
		String command = request.getParameter("command");
		List list = null;
		
		
		if(command != null && command.equals("delVend")) {
			String id = request.getParameter("id");
			dao.delVend(id);
		}  else if(command != null && command.equals("getVend")) {
			String editId = request.getParameter("editId");
			
			String id = request.getParameter("vend_id");
			String name = request.getParameter("vend_name");
			String address = request.getParameter("vend_address");
			String city = request.getParameter("vend_city");
			String state = request.getParameter("vend_state");
			String zip = request.getParameter("vend_zip");
			String country = request.getParameter("vend_country");
			
			dao.editVend(id, name, address, city, state, zip, country, editId);
		}
		

		String searchId = request.getParameter("searchId");
		list = dao.VendList(searchId);
		VendVO vo = new VendVO();
		vo.setSearchId(searchId);
		

		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightyellow'>");
		out.print("<td>공급업체번호</td><td>공급업체이름</td><td>공급업체주소</td><td>공급업체 시</td><td>공급업체 주</td><td>공급업체 우편번호</td><td>공급업체 국가</td><td>수정</td><td>삭제</td></tr>");
		
		for(int i=0;i<list.size();i++) {
			vo = (VendVO)list.get(i);
			String id = vo.getId();
			String name = vo.getName();
			String address = vo.getAddress();
			String city = vo.getCity();
			String state = vo.getState();
			String zip = vo.getZip();
			String country = vo.getCountry();

			out.print("<tr><td>" + id + "</td><td>" + name + "</td><td>" + address + "</td><td>" + city + "</td><td>" + state + "</td><td>" + zip + "</td><td>" + country + "</td><td>" + "<a href='/WebStudy/edit?command=editVend&searchId=" + searchId + "&id=" + id + "&name=" + name + "&address=" + address + "&city=" + city + "&state=" + state + "&zip=" + zip + "&country=" + country + "'>수정</a></td><td>" + "<a href='/practice/vend?command=delVend&id=" + id + "&searchId=" + searchId + "'> 삭제 </a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.print("<a href='/practice/vend.html'>새로운 공급업체 조회하기</a>");
	}

}
