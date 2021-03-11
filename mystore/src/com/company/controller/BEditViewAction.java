package com.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BDao;
import com.company.dto.BDto;

public class BEditViewAction implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		BDao dao = new BDao();
		BDto dto = new BDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("dto", dao.read(dto));

	}

}
