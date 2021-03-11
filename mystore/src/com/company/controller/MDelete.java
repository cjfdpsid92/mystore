package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.MDao;
import com.company.dto.MDto;

public class MDelete implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		MDao dao = new MDao();
		MDto dto = new MDto();
		
		dto.setMid((String)session.getAttribute("id"));
		dto.setMpass(request.getParameter("mpass"));
		int result = dao.delete(dto);
		
		if(result>0) { 
			session.invalidate();
			out.println("<script>alert('탈퇴했습니다.');location.href='"+request.getContextPath()+"/main.do'; </script>"); }
		else { out.println("<script>alert('비밀번호를 확인해주세요.'); history.go(-1);</script>"); }

	}

}
