package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.SDao;
import com.company.dto.SDto;

public class SearchAction implements DefaultAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("search action 진입");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SDao dao = new SDao(); 
		
		String keyword = request.getParameter("keyword");
		String cnation = request.getParameter("cnation");
		String cbig = request.getParameter("cbig");
		String csmall = request.getParameter("csmall");
		
		ArrayList<SDto> list = dao.search(keyword, cnation, cbig, csmall);
		
		request.setAttribute("list", list);
		
	}

}
