package 방명록;

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

@WebServlet("/json3")
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
		PrintWriter writer = response.getWriter();    //클라이언트로 텍스트값을 보내면 JSON이 인식하여 데이터로 들어감
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");             //넘긴 아이디를 받음

		System.out.println(id);

		JSONObject memberInfo = new JSONObject();   // dao메소드를 통해 전달받은 값을 여기에 담는다
		JSONArray membersArray = new JSONArray();   // 담은 memberInfo내용을 다시 arrayJSON객체에 담고
		JSONObject totaObject = new JSONObject();   // 최종적으로 totaObect에 담는다
		
		MemberVO vo = dao.listMembers(id);      //결과값을 vo객체로 담기위해 선언
		
		memberInfo.put("id", vo.getId());          // key,value값으로  값으로는 vo객체를 담는다
		memberInfo.put("pwd",vo.getPwd());
		memberInfo.put("name",vo.getName());
		memberInfo.put("email",vo.getEmail());
		memberInfo.put("joinDate",vo.getJoinDate());
		
		membersArray.add(memberInfo);      //담은 정보를 다시 어레이JSON에 담고
		
		totaObject.put("member", membersArray); //최종적으로 담는다 하나의 배열이 되었음
		String jsonInfo = totaObject.toJSONString(); //담은 제이슨 문자열은 다시 string으로 초기화한다
		System.out.print(jsonInfo);             
		writer.print(jsonInfo);  //이렇게 보내진 값은 view에서 data객체로 이동된다
	}

}