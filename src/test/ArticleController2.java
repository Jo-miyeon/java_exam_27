package test;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;
import board.article.Reply;

public class ArticleController2 {
	ArticleDao dao = new ArticleDao();
	String doAction(HttpServletRequest request,HttpServletResponse response) {
		
		String action = request.getParameter("action");
		String dest = "";
		if(action.equals("list")) {
			dest = list(request,response);  
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
		}else if(action.equals("showUpdate")) {
			dest = showUpdate(request,response);
		}else if(action.equals("doDeleteReply")) {
			dest = deleteReply(request,response);
		}else if(action.equals("doInsertReply")) {
			dest = insertReply(request,response);
		}else if(action.equals("showReplyUpdate")) {
			dest = showReplyUpdate(request,response);
		}else if(action.equals("doUpdateReply")) {
			dest=updateReply(request,response);
		}
		return dest;
	}
	private String updateReply(HttpServletRequest request, HttpServletResponse response) {
		String rbody = request.getParameter("rbody");
		int rid = Integer.parseInt(request.getParameter("rid"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		dao.showReplyUpdate(rbody,rid);
		return "redirect: /web-exam1/article?action=detail&id="+aid;
	}
	private String showReplyUpdate(HttpServletRequest request, HttpServletResponse response) {
		int aid = Integer.parseInt(request.getParameter("aid")); //showReplyUpdate할때 aid를 넘겨줘야한다
		int id = Integer.parseInt(request.getParameter("id")); //요청이 새로 되면서 사라질수있는 데이터를 다시 넣어준다 
		return "redirect: /web-exam1/article?action=detail&id="+aid+"&flag=u&rid="+id; 
	}
	private String insertReply(HttpServletRequest request, HttpServletResponse response) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		String body = request.getParameter("rbody");	
		dao.insertGetReply(aid,body,mid);
		return "redirect: /web-exam1/article?action=detail&id="+aid;
	}
	private String deleteReply(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id")); //지우고 싶은 댓글의 id 
		int aid = Integer.parseInt(request.getParameter("aid"));
		dao.deleteReplyById(id);
		return "redirect: /web-exam1/article?action=detail&id="+aid; //id인지 aid인지 중요함 detail페이지에서 확인해야함 
	}//return 에 id는 상세보기하고싶은 id 
	private String showUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = dao.getArticleById(id);
		request.setAttribute("myData3",article);
		return "updateForm.jsp";
	}
	
	private String detail(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String flag = request.getParameter("flag"); //showReplyUpdate를 거쳤을 때만 나온다 
		Article article = dao.getArticleById(id);
		ArrayList<Reply> replies = dao.getRepliesByArticleId(id);
		
		if(flag != null) {
			int rid = Integer.parseInt(request.getParameter("rid")); 
			request.setAttribute("flag", flag); //flag값이 있다면 detail.jsp에 넘겨준다 
			request.setAttribute("rid", rid);
		}
		request.setAttribute("myData2",article);
		request.setAttribute("replies", replies);
		
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
