package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/article")//클래스명과 서블렛명은 달라도된다.
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //문자 인코딩 utf-8로 설정
		ArticleDao dao = new ArticleDao();
		ArrayList<Article> articles = dao.getArticles();
		
		String action = request.getParameter("action");
		
		
		//jsp에 articles넘기기
		//1.request객체에 데이터 저장
		
		//2.위에서 저장한 request객체를 이용해서 새로운 jsp 호출요청->목적지 jsp필요
		String dest = "list.jsp";
		if(action.equals("list")) {
			request.setAttribute("myData",articles);//변수와 넘길데이터
			dest = "/list.jsp"; //목적지 jsp
		}else if(action.equals("insert")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			int mid = Integer.parseInt(request.getParameter("mid"));
			
			dao.insertArticle(title, body, mid);
			
		}else if(action.equals("update")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			int id = Integer.parseInt(request.getParameter("id"));
			
			dao.updateArticle(title, body, id);
			
		}else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			dao.deleteArticle(id);
			
		}else if(action.equals("detail")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = dao.getArticleById(id);
			request.setAttribute("myData2",article);
			dest = "detail.jsp";
		}else if(action.equals("showAdd")) {
			dest = "addForm.jsp";
		}else if(action.equals("showUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = dao.getArticleById(id);
			request.setAttribute("myData3",article);
			dest = "updateForm.jsp";
		}
		request.setAttribute("myData", dao.getArticles()); //db 바뀐내용이 적용이 된 내용을 다시 mydata로 변경 그걸 list로 보냄
		//3.요청하기
		RequestDispatcher rd = request.getRequestDispatcher(dest); //디스패처는 적절한 jsp에다가 요청을 알맞게 전달해주는 객체 서비스 요 
		rd.forward(request, response); //forward를 쓰면은 request,response를 인자로 넘긴다.
	}

}
