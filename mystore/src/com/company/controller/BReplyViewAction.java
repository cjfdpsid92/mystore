package com.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BDao;
import com.company.dto.BDto;

public class BReplyViewAction implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto = dao.read(dto);
		dto.setBtitle("└re: " + dto.getBtitle());
		dto.setBcontent("\n\n\n>" + dto.getBcontent().replaceAll("\n", "\n> "));
		System.out.println(dto.getBtitle());
		System.out.println(dto.getBcontent());
		
		request.setAttribute("dto", dto);

	}

}
