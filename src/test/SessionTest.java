package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		HttpSession session =  request.getSession();
		if(flag != null && flag.equals("a")) {
			String msg = (String)request.getAttribute("test"); //flag a를 타면 request에 있는 값을 꺼낸다 
			System.out.println(msg);
		}else if(flag != null && flag.equals("b")) {
			String msg = (String)session.getAttribute("test2");
			System.out.println(msg);
		}
		request.setAttribute("test","테스트메세지!!"); //test란 이름으로 문자열 저장 
		session.setAttribute("test2", "테스트 메세지~!");
		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		rd.forward(request, response); //서블릿에서 jsp로 옮기는 방법 
		//요청이 바뀔때마다 유지되어야하는 데이터가 있으면 session에 저장 
	}


}
