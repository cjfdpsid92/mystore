package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.MDao;

public class MPass implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("id")==null) {
			out.println("<script>location.href='"+request.getContextPath()+"'</script>"); }
		
		MDao dao = new MDao();
		int result = dao.update_pass((String)session.getAttribute("id"), request.getParameter("pass_o"), request.getParameter("pass_n"));
		
		if(result>0 ) { 
			out.println("<script>alert('비밀번호가 수정되었습니다.'); location.href='"+request.getContextPath()+"/mypage.do'; </script>");
		}
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }
	}

}
