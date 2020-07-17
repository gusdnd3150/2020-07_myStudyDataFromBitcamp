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
 * Servlet implementation class EditVend
 */
@WebServlet("/edit")
public class EditVend extends HttpServlet {

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
		String command = request.getParameter("command");
		
	
		if(command != null && command.equals("editVend")) {
		
			String searchId = request.getParameter("searchId");

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String country = request.getParameter("country");
			
			out.print("<html><body><form name='frmedit' method='get' action='/WebStudy/vend' encType='UTF-8'>");
			out.print("공급업체 번호 : <input type='text' name='vend_id' value=" + id + "><br>");
			out.print("공급업체 이름 : <input type='text' name='vend_name' value=" + name + "><br>");
			out.print("공급업체 주소 : <input type='text' name='vend_address' value=" + address + "><br>");
			out.print("공급업체 시 : <input type='text' name='vend_city' value=" + city + "><br>");
			out.print("공급업체 주 : <input type='text' name='vend_state' value=" + state + "><br>");
			out.print("공급업체 우편번호 : <input type='text' name='vend_zip' value=" + zip + "><br>");
			out.print("공급업체 국가 : <input type='text' name='vend_country' value=" + country + "><br>");
			out.print("<input type='submit' value='수정'>");
			out.print("<input type='reset' value='다시입력'>");
			out.print("<input type='hidden' name='searchId' value='" + searchId + "'>");
			out.print("<input type='hidden' name='editId' value='" + id + "'>");
			out.print("<input type='hidden' name='command' value='getVend'>");
			out.print("</form></body></html>");
		}
	}
}
