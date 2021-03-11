package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.MDao;
import com.company.dto.MDto;

public class MLoginAction implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		MDao dao = new MDao();
		MDto dto = new MDto();
		
		dto.setMid(request.getParameter("id")); dto.setMpass(request.getParameter("pass"));
		
		MDto dto2 = dao.read(dto);
		
		String remember = request.getParameter("remember");
		if (remember!=null && remember.equals("on")) { 
			Cookie cookie = new Cookie("id", dto2.getMid()); cookie.setMaxAge(60*60*24*30);  response.addCookie(cookie); }
		else { 
			String cookie = request.getHeader("Cookie");
			if (cookie!=null) {
				Cookie[] cookies = request.getCookies();
				for(int i=0; i<cookies.length; i++) {
					if (cookies[i].getName().equals("id")) { cookies[i].setMaxAge(0); response.addCookie(cookies[i]); }
				} } }
		
		System.out.println("LoginAction : " + dto2);
		session.setAttribute("id", dto2.getMid());
		session.setMaxInactiveInterval(60*10);
		
		if(dto2.getMno()!=0) { out.println("<script> location.href='"+request.getContextPath()+"/mypage.do';</script>"); }
		else { out.println("<script> alert('아이디와 비밀번호를 확인해주세요.'); history.go(-1); </script>"); }
		
	}

}
