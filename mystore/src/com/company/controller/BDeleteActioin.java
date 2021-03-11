package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BDao;
import com.company.dto.BDto;

public class BDeleteActioin implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		BDao dao = new BDao();
		BDto dto = new BDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno"))); dto.setBpass(request.getParameter("bpass"));
		int result = dao.delete(dto);
		System.out.println("result : " + result);
		request.setAttribute("delete", result);
		
		if(result>0 ) { out.println("<script>alert('삭제에 성공했습니다.'); location.href='"+request.getContextPath()+"/list.do';</script>"); }
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }

	}

}
