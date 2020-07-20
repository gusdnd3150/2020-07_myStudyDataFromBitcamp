package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")             이 멥핑주소로 다시 요청이 실행
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();

      out.println("<html><body>");
      out.println("location 실습");
      out.println("</body></html>");
   }
}