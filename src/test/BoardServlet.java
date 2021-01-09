package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //문자 인코딩 utf-8로 설정
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//브라우저에 출력해줌
		
		ArticleDao articleDao = new ArticleDao();
		ArrayList<Article> articles = articleDao.getArticles();
		
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("<제목>");
		out.println("</td>");
		out.println("<td>");
		out.println("<작성자>");
		out.println("</td>");
		out.println("<td>");
		out.println("<작성일>");
		out.println("</td>");
		out.println("</tr>");
		
		for(int i=0; i<articles.size(); i++) {
			out.println("<tr>");
			out.println("<td>"+articles.get(i).getTitle()+"</td>");
			out.println("<td>"+articles.get(i).getNickname()+"</td>");
			out.println("<td>"+articles.get(i).getRegDate()+"</td>");
			out.println("</tr>");	
		}
		
		out.println("</table>");
		
		
		for(int i=0; i<articles.size();i++) {
			System.out.println("제목:"+articles.get(i).getTitle());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
