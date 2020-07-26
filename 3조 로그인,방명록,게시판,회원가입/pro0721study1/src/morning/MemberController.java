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

@WebServlet("/MemberController/*")
public class MemberController extends HttpServlet {
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
		String command = request.getParameter("command");
		
		String nextPage = null;
		String action = request.getPathInfo(); //URL에서 요청명을 가져옴
		System.out.println("action:" + action);
		
		System.out.println("엑션 값"+action);
		System.out.println("커멘드값"+command);

		if ("modify".equals(command)) {                                   //비밀번호 변경~~~~~~~~~~~~~~~~
			HttpSession session = request.getSession();
			System.out.println(dao.listMembers().size());          // 전체회원조회 dao메소드를 재활용하여 

			MemberVO vo = (MemberVO) session.getAttribute("member");   //로그인 후 세션에 등록된 값을 vo객체로 불러온다
			String pwd = request.getParameter("modiPass");             // 새비밀번호 값을 스트링으로 받고
			vo.setPassword(pwd);                                      // set으로 기존값을 새로운 비밀번호로 변경
			dao.modPassward(vo);                                       //변경한 vo객체를 dao매소드로 전달

			//session.invalidate();// 로그아웃시 세션에있는 정보를 삭제 해주어야함
			response.sendRedirect("login2.jsp");
		} else if ("logout".equals(command)) {                           // 로그아웃~~~~~~~~~~~~~~~~~~~~~~~~
			HttpSession session = request.getSession();                // 세션에 있는 회원정보를 가지고옴
			session.invalidate();                                     // 세션 삭제
			
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			dispatch.forward(request, response);
		} else if ("logins".equals(command)) {                              //로그인~~~~~~~~~~~~~~~~~~~~~~~~
			String _id = request.getParameter("_id");                        //값을 스트링으로 받고
			String _pwd = request.getParameter("_pwd");
			List<MemberVO> listMembers = (ArrayList) dao.listMembers();     // list메소드를 통해 아이디비밀번호를 비교해줄 것이다
			String result = "";

			for (int i = 0; i < listMembers.size(); i++) {                //
				System.out.println(listMembers.size());
            System.out.println(listMembers.get(i).toString());           //체크용으로 만들었다
            
				if (listMembers.get(i).getMemberId().equals(_id) && listMembers.get(i).getPassword().equals(_pwd)) {
					 // list안의 회원객체의 id,pwd값과 요청받은값이 같으면 로그인 성공
					System.out.println("listMembers id체크:" + listMembers.get(i).toString());
					HttpSession session = request.getSession();
					session.setAttribute("member", listMembers.get(i)); //세션에 해당 객체를 저장한다
					result = "good";         
				}
			}
			if(result != "good") {
				result ="fail";
			}
			
			System.out.println(result);                  //결과를 체크하기 위해 sout씀
			request.setAttribute("result", result);         //result 결과값을 request에 저장한다
			RequestDispatcher dispatch = request.getRequestDispatcher("Testaddmember.jsp");   
			dispatch.forward(request, response);
			
			
		}else if ("joinForm".equals(command)) {           //mmmmmmmmmmmmmmmm지유정mmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd1");
			MemberVO memberVO = new MemberVO(id, name, pwd);
			//기존에 등록된 아이디가 있는지 찾는다.
			Boolean b_chk = dao.checkId(id);
			
			if(b_chk) {//같은 아이디가 없으면
				System.out.println("아이디 등록 시작");
				dao.addMember(memberVO);
				System.out.println("아이디 등록 완료");
				nextPage = "/pro0721study1/memberCheck.jsp?id="+id; // 원래 화면으로
			}else {//같은 아이디가 있으면
				System.out.println("중복 아이디 있음");
				nextPage = "/pro0721study1/memberForm.jsp?chk=N"; // 원래 화면으로
			}
			response.sendRedirect(nextPage);
			}
		
		else if("enter".equals(command)) {         //로그인체크
			HttpSession session = request.getSession();
			String check;
			
			if(session.isNew()) {
				check ="true";
			}else {
				check ="false";
			}
			System.out.println("체크 값 테스트:"+check);
			request.setAttribute("check", check);
			RequestDispatcher dispatch = request.getRequestDispatcher("Testaddmember.jsp");
			dispatch.forward(request, response);
		} 
	}
}
