package morning;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ArticleController
 */
@WebServlet("*.article")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ArticleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String temp[] = request.getRequestURI().split("/");
		String command = temp[temp.length - 1].split("\\.")[0];
		String nextPage = "";
		ArticleDAO dao = new ArticleDAO();
		PostCommentDAO pdao = new PostCommentDAO();
		
		
		//유성호
		if(command.equals("search")) {
			
			List<ArticleVO> articleList = dao.list();
			List<postCommentVO> commentList = pdao.list();
			Paging paging = new Paging(10);
			int nowPage = 1;
			try{
				nowPage = Integer.parseInt(request.getParameter("nowPage"));
			}catch(Exception e) {
			}
			
			paging.setMaxPage(articleList.size());
			paging.setNowPage(nowPage);
			paging.setBound();
			request.setAttribute("nowPage", nowPage);
			request.setAttribute("refresh", "1");
			request.setAttribute("paging", paging);
			request.setAttribute("articleList", articleList);
			request.setAttribute("commentList", commentList);
			nextPage = "boardModule.jsp";
			
		}else if(command.equals("write")) {
			nextPage = "write.jsp";
		}else if(command.equals("post")) {
			
			String encoding = "utf-8";
			File currentDirPath = new File("C:\\file_repo");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			factory.setRepository(currentDirPath); // 임시 Directory
			factory.setSizeThreshold(1024 * 1024); // 최대 메모리에 Upload 가능한 size, 단위 byte
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			MultipartRequest mr = new MultipartRequest(request, "C:\\file_repo", 1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			Enumeration<String> files = mr.getFileNames();
			String fileNames = files.nextElement();
			String getfileName = mr.getFilesystemName(fileNames);
			
			System.out.println(getfileName);
			String title = mr.getParameter("title");
			String password = mr.getParameter("password");
			String articleContent = mr.getParameter("content");
			dao.insertArticle(title, password, articleContent, getfileName);
			nextPage = "search.article";
			
			
		}else if(command.equals("read")) {
			
			HttpSession session = request.getSession();
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			ArticleContentVO content = dao.showContents(articleNo);
			ArticleVO article = dao.getArticle(articleNo);
			int readCnt = article.getReadCnt();
			dao.addCnt(readCnt, articleNo);
			
			List<postCommentVO> list = pdao.list();
			List<postCommentVO> commentList = new ArrayList<postCommentVO>();
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getArticleNo()==articleNo) {
					commentList.add(list.get(i));
				}
			}
			
			session.setAttribute("commentList", commentList);
			request.setAttribute("content", content);
			request.setAttribute("article", article);
			nextPage = "article.jsp";
			
		}else if(command.equals("delete")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			String password = request.getParameter("password");
			if(password.equals(dao.getArticle(articleNo).getPassword())) {
				dao.deleteArticle(articleNo);
				List<postCommentVO> list = pdao.list();
				for(postCommentVO data : list) {
					if(data.getArticleNo()==articleNo) {
						pdao.deleteComment(data.getPostCommentNo());
					}
				}
			}else {
				System.out.println("비밀번호 틀림");
			}
			nextPage = "search.article";
		}else if(command.equals("deleteComment")) {
			int commentNo = Integer.parseInt(request.getParameter("commentNo"));
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			request.setAttribute("articleNo", articleNo);
			pdao.deleteComment(commentNo);
			nextPage = "read.article";
		}else if(command.equals("mod")) {
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			String password = request.getParameter("password");
			String re = null;
			re = request.getParameter("re");
			nextPage = "search.article";
			if(re!=null) {
				String content = request.getParameter("content");
				String title = request.getParameter("title");
				dao.updateArticle(title, password, content, articleNo);
			}else if(password.equals(dao.getArticle(articleNo).getPassword())) {
				ArticleVO article = dao.getArticle(articleNo);
				ArticleContentVO articleCo = dao.showContents(articleNo);
				request.setAttribute("article", article);
				request.setAttribute("articleCo", articleCo);
				request.setAttribute("rewrite", "rewrite");
				nextPage = "write.jsp";
			}else {
				System.out.println("비밀번호 틀림");
			}
		}else if(command.equals("writeComment")) {
			String comment = request.getParameter("postComment");
			int articleNo = Integer.parseInt(request.getParameter("articleNo"));
			pdao.insertComment(comment, articleNo);
			nextPage = "read.article?articleNo="+articleNo;
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
		
	}

}













