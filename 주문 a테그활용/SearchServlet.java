package study05;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/study05/search")
public class SearchServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SearchDAO dao = new SearchDAO();
		String command = request.getParameter("command");
		
		List list = null;
			
		if(command != null && command.equals("delMember")) {
			String id = request.getParameter("delid");
			dao.delMember(id);
		}
		
		String id2 = request.getParameter("searchid");
		list = dao.searchMember(id2);
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightyellow'>");
		out.print("<td>고객번호</td><td>고객이름</td><td>고객주소</td><td>주문조회</td><td>삭제</td></tr>");
		
		for(int i=0;i<list.size();i++) {
			SearchVO searchVO = (SearchVO)list.get(i);
			String id = searchVO.getId();
			String name = searchVO.getName();
			String address = searchVO.getAddress();
			out.print("<tr><td>" + id + "</td><td>" + name + "</td><td>" + address + "</td><td>" + "<a href='/WebStudy/study05/search2?command=searchOrder&searchid=" + id + "'> 주문조회 </a></td>" + "<td><a href='/practice/search?command=delMember&delid=" + id + "&searchid=" + id2 + "'> 삭제 </a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.print("<a href='/WebStudy/study05/search.html'>새로운 고객 조회하기</a>");
	}

}
