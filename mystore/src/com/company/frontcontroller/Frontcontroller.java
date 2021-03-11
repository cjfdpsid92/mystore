package com.company.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.controller.DefaultAction;
import com.company.controller.KakaoLogin;
import com.company.controller.BDeleteActioin;
import com.company.controller.BDetailActioin;
import com.company.controller.BEditActioin;
import com.company.controller.BEditViewAction;
import com.company.controller.BListActioin;
import com.company.controller.BReplyAction;
import com.company.controller.BReplyViewAction;
import com.company.controller.BWriteActioin;
import com.company.controller.MDelete;
import com.company.controller.MEdit;
import com.company.controller.MJoinAction;
import com.company.controller.MLoginAction;
import com.company.controller.MMypageAction;
import com.company.controller.MPass;
import com.company.controller.Mailing;
import com.company.controller.SearchAction;

/**
 * Servlet implementation class FrontcontrollerBasic
 */

@WebServlet("*.do")
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Frontcontroller() { super();  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}

	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String view = "/board/list.jsp";
		////////////////////////////////////////////
//		out.println(request.getRequestURI() + "<br/>");
//		out.println(request.getRequestURL() + "<br/>");
//		out.println(request.getServletPath() + "<br/>");
//		out.println(request.getServletContext() + "<br/>");
		////////////////////////////////////////////
		//q1) http://localhost:8080/mvc4_1/werite.test 접속시 => 글쓰기 페이지로 이동해주세요!
		//String path = request.getServletPath();
		String path = request.getRequestURI().substring(request.getContextPath().length());
		DefaultAction comm = null;
		System.out.println(path);
		if(path.equals("/intro.do")) {
			view = "/intro.jsp";
		}
		else if(path.equals("/list.do")) { 
//			comm = new BListActioin(); comm.execute(request, response);
//			out.println("get-list페이지로 이동"); 
			view = "/board/list.jsp";
		}
		else if(path.equals("/list_view.do")) {  
			comm = new BListActioin(); comm.execute(request, response);
			return;
		}
		else if(path.equals("/write_view.do")) { 
//			out.println("get-write 폼페이지로 이동"); 
			view = "/board/write.jsp";
		}
		else if(path.equals("/write.do")) { 
//			out.println("post - 글쓰기 기능 이동"); 
			comm = new BWriteActioin(); comm.execute(request, response);
			view = "/list.do";
			return;
		}
		else if(path.equals("/detail.do")) { 
//			out.println("get-상세페이지로 이동"); 
			comm = new BDetailActioin(); comm.execute(request, response);
			view = "/board/detail.jsp";	}
		else if(path.equals("/edit_view.do")) { 
//			out.println("get-edit-view 수정폼페이지로 이동"); 
		comm = new BEditViewAction(); comm.execute(request, response);
			view = "/board/edit.jsp";
		}
		else if(path.equals("/edit.do")) { 
//			out.println("post-수정기능으로 이동"); 
			comm = new BEditActioin(); comm.execute(request, response);
			view = "/detail.do";
			return;
		}
		else if(path.equals("/delete_view.do")) { 
//			out.println("get-삭제폼페이지로 이동"); 
			view = "/board/delete.jsp";	}
		else if(path.equals("/delete.do")) { 
//			out.println("get-삭제기능으로 이동"); 
			comm = new BDeleteActioin(); comm.execute(request, response);
			view = "/list.do";
			return;
			}
		else if (path.equals("/main.do")) {
			if(session.getAttribute("id")==null) { view="/member/login.jsp"; }
			else { view="/mypage.do"; }
		}
		else if (path.equals("/login.do")) {
			comm = new MLoginAction(); comm.execute(request, response);
			view="/mypage.do";
			return;
		}
		else if (path.equals("/KakaoLogin.do")) {
			comm = new KakaoLogin(); comm.execute(request, response);
			view="/mypage_k.do";
		}
		else if (path.equals("/Join_com.do")) {
			comm = new MJoinAction(); comm.execute(request, response);
			view="/mypage.do";
			return;
		}
		else if (path.equals("/agree.do")) {
			view="/member/join_agree.jsp";
		}
		else if (path.equals("/join.do")) {
			view="/member/join.jsp";
		}
		else if (path.equals("/mypage.do")) {
			comm = new MMypageAction(); comm.execute(request, response);
			view="/member/mypage.jsp";
		}
		else if (path.equals("/mypage_k.do")) {
			if(session.getAttribute("id")==null) { view="/member/login.jsp"; }
			else { view="/member/mypage_k.jsp"; }
		}
		else if (path.equals("/member_edit.do")) {
			comm = new MMypageAction(); comm.execute(request, response);
			view="/member/mypage_edit.jsp";
		}
		else if (path.equals("/member_edit_com.do")) {
			comm = new MEdit(); comm.execute(request, response);
			view="/mypage.do";
		}
		else if (path.equals("/member_pass.do")) {
			view="/member/mypage_pass.jsp";
		}
		else if (path.equals("/member_pass_com.do")) {
			comm = new MPass(); comm.execute(request, response);
			view="/mypage.do";
			return;
		}
		else if (path.equals("/member_delete.do")) {
			view="/member/mypage_delete.jsp";
		}
		else if (path.equals("/member_delete_com.do")) {
			comm = new MDelete(); comm.execute(request, response);
			view="/mypage_delete.jsp";
			return;
		}
		else if (path.equals("/logout.do")) {
			session.invalidate();
			view="/member/login.jsp";
		}
		else if (path.equals("/mailing.do")) {
			view = "/mailing.jsp";
		}
		else if (path.equals("/mail_send.do")) {
			comm = new Mailing(); comm.execute(request, response);
			view = "/mailing.do";
			return;
		}
		else if(path.equals("/reply_view.do")) {
			comm = new BReplyViewAction(); comm.execute(request, response);
			view = "/board/reply.jsp";
			System.out.println("reply view로 이동");
		}
		else if(path.equals("/reply.do")) {
			comm = new BReplyAction(); comm.execute(request, response);
			view = "/detail.re";
			System.out.println("reply 컨트롤러로 이동");
			return;
		}
		else if(path.equals("/search.do")) {
			comm = new SearchAction(); comm.execute(request, response);
			view = "/search/result.jsp";
			System.out.println("search 컨트롤러로 이동");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}
