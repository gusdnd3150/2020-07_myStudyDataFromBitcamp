package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
/*@WebServlet("/login")*/
public class SessionTest4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id"); //요청값 가져옴
		String user_pw = request.getParameter("user_pw");
		
		if (session.isNew()){                    최초 요청시 수행     
			if(user_id != null){
				session.setAttribute("user_id", user_id);           로그인창에서 서블릿으로 요청햇다면
				out.println("<a href='login'>로그인 상태 확인</a>");        id가 null이 아니므로 세션에 정보바인딩
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}else{
			user_id = (String) session.getAttribute("user_id");         재요청시 세션에서 id를 가져와 이전에 로그인했는지확인
			if (user_id != null && user_id.length() != 0) {              
				out.print("안녕하세요 " + user_id + "님!!!");
			} else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}

}