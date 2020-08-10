package miniproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter(); // 클라이언트로 텍스트값을 보내면 JSON이 인식하여 데이터로 들어감
		JSONObject memberInfo = new JSONObject(); 
		JSONArray membersArray = new JSONArray(); 
		JSONObject totaObject = new JSONObject(); 
		MemberDAO dao = new MemberDAO();
		String command = request.getParameter("command");
		
		if (command!=null&&command.equals("save")) {
			String addId = request.getParameter("cust_id"); 
			String addPwd = request.getParameter("pwd");
			String addName = request.getParameter("name");
			System.out.println("아이디값 잘넘어옴(서블릿)"+addPwd);
			
			MemberVO vo2 = new MemberVO(addId, addPwd, addName); // 회원가입 로직
			System.out.println(vo2.toString());
			dao.addMember(vo2);
			
		}else if(command!=null&&command.equals("search")) {
			String id = request.getParameter("id"); 
			MemberVO vo = dao.listMembers(id); 
			memberInfo.put("id", vo.getId());
			memberInfo.put("pwd", vo.getPwd());
			memberInfo.put("name", vo.getName());
			membersArray.add(memberInfo); // 담은 정보를 다시 어레이JSON에 담고
			totaObject.put("member", membersArray); // 최종적으로 담는다 하나의 배열이 되었음
			String jsonInfo = totaObject.toJSONString(); // 담은 제이슨 문자열은 다시 string으로 초기화한다
			System.out.print(jsonInfo);
			writer.print(jsonInfo); // 이렇게 보내진 값은 view에서 data객체로 이동된다
			
		}else if (command!=null&&command.equals("before")) {
			String id = request.getParameter("id");
			List<MemberVO> list = (ArrayList)dao.totallist();
			
			for (int i =0; i<list.size();i++) {
				if (id.equals(list.get(i).getId())) {
					memberInfo.put("id", list.get(i-1).getId());
					memberInfo.put("pwd", list.get(i-1).getPwd());
					memberInfo.put("name", list.get(i-1).getName());
					membersArray.add(memberInfo); 
					totaObject.put("member", membersArray);
					String jsonInfo = totaObject.toJSONString();
					System.out.print(jsonInfo);
					writer.print(jsonInfo); 
					break;
				}
			}
		}else if (command!=null&&command.equals("after")) {
			String id = request.getParameter("id");
			List<MemberVO> list = (ArrayList)dao.totallist();
			
			for (int i =0; i<list.size();i++) {
				if (id.equals(list.get(i).getId())) {
					memberInfo.put("id", list.get(i+1).getId());
					memberInfo.put("pwd", list.get(i+1).getPwd());
					memberInfo.put("name", list.get(i+1).getName());
					membersArray.add(memberInfo); 
					totaObject.put("member", membersArray);
					String jsonInfo = totaObject.toJSONString();
					System.out.print(jsonInfo);
					writer.print(jsonInfo); 
					break;
				}
			}
		}
	}
}









