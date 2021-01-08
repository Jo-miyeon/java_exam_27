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

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); //문자 인코딩 utf-8로 설정
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//브라우저에 출력해줌
		
		out.println("Hello");
		out.println("안녕하삼");
		String num= request.getParameter("num");
		System.out.println(num);
		String loginId = request.getParameter("loginId");
		System.out.println(loginId);
		String name = "";
		
		if(loginId.equals("miyeon")) {
			name="미연";
		}else if(loginId.equals("jo")) {
			name="조조";
		}
		out.println(name+"님 안녕하세요!");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
