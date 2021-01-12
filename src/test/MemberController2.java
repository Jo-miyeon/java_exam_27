package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.member.Member;
import board.member.MemberDao;

public class MemberController2 {
	MemberDao mdao = new MemberDao();

	String doAction(HttpServletRequest request, HttpServletResponse response){
		String action = request.getParameter("action");
		String dest = "";

		if (action.equals("showLogin")) {
			dest = "loginForm.jsp";
		} else if (action.equals("doLogin")) {
			dest = doLogin(request, response);
		} else if (action.equals("showMember")) {
			dest = "memberForm.jsp";
		} else if (action.equals("doInsertMember")) {
			dest = doInsertMember(request, response);
		} else if (action.equals("error")) {
			dest = "loginFailed.jsp";
		}
		return dest;
	}

	private String doInsertMember(HttpServletRequest request, HttpServletResponse response) {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String nickname = request.getParameter("nickname");
		mdao.insertMember(loginId, loginPw, nickname);
		return "loginForm.jsp";
	}

	private String doLogin(HttpServletRequest request, HttpServletResponse response){
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		Member loginedMember = mdao.getMemberByLoginIdAndLoginPw(loginId, loginPw);
		if (loginedMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedMember", loginedMember);
			return "redirect:http://localhost:8080/web-exam1/article?action=list";
		} else {
			return "loginFailed.jsp";
		}
	}
}
