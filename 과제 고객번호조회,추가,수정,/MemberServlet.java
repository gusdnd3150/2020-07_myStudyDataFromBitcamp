package study09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String p_id = request.getParameter("id");
		String p_command = request.getParameter("command");
		
	    MemberDAO dao=new MemberDAO();
	    List membersList;
	    
	    if(p_command != null && p_command.equals("modSearch")) {
	    	String p_mod_id = request.getParameter("mod_id");
	    	membersList = search(p_mod_id);
	    	
	    	MemberVO vo = (MemberVO) membersList.get(0);
	    	
	    	request.setAttribute("command", "modSearch");
			request.setAttribute("vo", vo);
			RequestDispatcher dispatch = request.getRequestDispatcher("/study09/modify.jsp");
			dispatch.forward(request, response);
			
			return;
	    }else if(p_command != null && p_command.equals("addInsert")) {
	    	String u_id = request.getParameter("id");
	    	String u_pwd = request.getParameter("pwd");
	    	String u_name = request.getParameter("name");
	    	String u_email = request.getParameter("email");
	    	
	    	dao.insertMember(u_id, u_pwd, u_name, u_email);
	    	
	    	membersList = search(null);
	    }else if(p_command != null && p_command.equals("modUpdate")) {
	    	String u_id = request.getParameter("id");
	    	String u_pwd = request.getParameter("pwd");
	    	String u_name = request.getParameter("name");
	    	String u_email = request.getParameter("email");
	    	
	    	dao.updateMember(u_id, u_pwd, u_name, u_email);
	    	
	    	membersList = search(null);
	    }else if(p_command != null && p_command.equals("addSearch")) {
	    	
			request.setAttribute("command", "addSearch");
			RequestDispatcher dispatch = request.getRequestDispatcher("/study09/modify.jsp");
			dispatch.forward(request, response);
			
			return;
	    }else {
	    	membersList = search(p_id);
	    }
		
		request.setAttribute("membersList", membersList);
		RequestDispatcher dispatch = request.getRequestDispatcher("/study09/member.jsp");
		dispatch.forward(request, response); 
	}
	
	public List search(String id) {
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
	    memberVO.setId(id);   
	    
	    List membersList = dao.listMembers(memberVO);
	    return membersList;
	}

}
