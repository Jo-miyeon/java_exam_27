/*
package test;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.article.Article;
import board.article.ArticleDao;
import board.member.Member;
import board.member.MemberDao;

@WebServlet("/article")//클래스명과 서블렛명은 달라도된다.
public class ArticleController extends HttpServlet {
//로그인정보 -> request에 저장x session에 저장 	
	ArticleDao dao = new ArticleDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //문자 인코딩 utf-8로 설정
		
		
		
		String action = request.getParameter("action");
		String dest = "";
		if(action.equals("list")) {
			dest = list(request,response); //목적지 
		}else if(action.equals("insert")) {
			dest = insert(request,response);
		}else if(action.equals("update")) {
			dest = update(request,response);
		}else if(action.equals("delete")) {
			dest = delete(request,response);
		}else if(action.equals("detail")) {
			dest = detail(request,response);
		}else if(action.equals("showAdd")) {
			dest = "addForm.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(dest); 
			rd.forward(request, response);
		}else if(action.equals("showUpdate")) {
			dest = showUpdate(request,response);
		}
		if(dest.startsWith("redirect:")) {
			//리다이렉팅 
			String[] bits = dest.split("");
			String url = bits[1];
			response.sendRedirect(url);
		}else {
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher(dest);
			rd.forward(request, response);
		}
	}
	private String showUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);
		request.setAttribute("myData3",article);
		return "updateForm.jsp";
	}
	
	private String detail(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);
		request.setAttribute("myData2",article);
		return "detail.jsp";
	}
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteArticle(id);
		return list(request,response);
	}
	private String update(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int id = Integer.parseInt(request.getParameter("id"));
		
		dao.updateArticle(title, body, id);
		return detail(request,response);
	}
	private String insert(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int mid = Integer.parseInt(request.getParameter("mid"));//게시물 등록할때 
		//Member loginedMember = mdao.getMemberById(mid);
		//request.setAttribute("loginedMember", loginedMember); session을 이용하게 되면은 request에다가 정보를 넣을 필요가 없어진다
		dao.insertArticle(title, body, mid);
		
		return list(request,response);
	}
	public String list(HttpServletRequest request,HttpServletResponse response) {
		ArrayList<Article> articles = dao.getArticles();
		request.setAttribute("myData", articles);
		return "list.jsp";
		
	}

}

*/