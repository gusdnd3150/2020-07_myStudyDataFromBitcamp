package morning;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");           커맨드 받아옴 

		if ("modify".equals(command)) {
			HttpSession session = request.getSession();       modify 시 이룹을 진행한다   
			System.out.println(dao.listMembers().size());         listMembers를 재사용해서 입력받은 값과 비교를 할 것임

			MemberVO vo = (MemberVO) session.getAttribute("member");      세션에 객체로 저장했기때문에 객체로 다시 꺼내왔다
			String pwd = request.getParameter("modiPass");             
			vo.setPassword(pwd);                                         vo객체의 setpass를 사용자 입력값으로 다시 셋해주었다
			dao.modPassward(vo);                                          dao의 수정 sql로 비밀번호를 수정

			session.invalidate();// 로그아웃시 세션에있는 정보를 삭제 해주어야함 
			response.sendRedirect("mainlogin.jsp");
		} else if ("logout".equals(command)) {
			HttpSession session = request.getSession();                 로그아웃 시 세션에 있는 정보를 삭제 후 메인으로 다시 페이지 이동
			session.invalidate();
			RequestDispatcher dispatch = request.getRequestDispatcher("mainlogin.jsp");
			dispatch.forward(request, response);
		}

		else if ("join".equals(command)) {
			String joinid = request.getParameter("joinid");
			String joinname = request.getParameter("joinname");
			String joinpwd = request.getParameter("joinpwd");
			String joinrepwd = request.getParameter("joinrepwd");
			List<MemberVO> listMembers = (ArrayList) dao.listMembers();
			String result = "";

			for (int i = 0; i < listMembers.size(); i++) {
				System.out.println(listMembers.size());

				if (listMembers.get(i).getMemberId().equals(joinid)) {
					System.out.println("listMembers id체크:" + listMembers.get(i).toString());
					result = "dup";
				} else if (!joinpwd.equals(joinrepwd)) {
					result = "pwd";
				} else if (joinname.equals("") && joinname.equals("") && joinpwd.equals("")) {
					result = "empty";
				}
			}

			System.out.println(result);
			if (result == "") {
				MemberVO vo = new MemberVO(joinid, joinname, joinpwd);
				dao.addMember(vo);
			}
			request.setAttribute("result", result);
			RequestDispatcher dispatch = request.getRequestDispatcher("Testaddmember.jsp");
			dispatch.forward(request, response);

		} else if ("logins".equals(command)) {
			String _id = request.getParameter("_id");
			String _pwd = request.getParameter("_pwd");
			List<MemberVO> listMembers = (ArrayList) dao.listMembers();
			String result = "";

			for (int i = 0; i < listMembers.size(); i++) {
				System.out.println(listMembers.size());

				if (listMembers.get(i).getMemberId().equals(_id) && listMembers.get(i).getPassword().equals(_pwd)) {
					System.out.println("listMembers id체크:" + listMembers.get(i).toString());
					HttpSession session = request.getSession();
					session.setAttribute("member", listMembers.get(i));
					result = "good";
				} else if (!listMembers.get(i).getMemberId().equals(_id) && !listMembers.get(i).getPassword().equals(_pwd)){
					result = "fail";
				}
			}
			System.out.println(result);
			request.setAttribute("result", result);
			RequestDispatcher dispatch = request.getRequestDispatcher("Testaddmember.jsp");
			dispatch.forward(request, response);
		}
	}
}
