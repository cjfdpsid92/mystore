package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.SDao;
import com.company.dto.SDto;
import com.google.gson.Gson;

public class SearchDetailAction implements DefaultAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax 진입");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		SDao dao = new SDao(); 
		
		String keyword = request.getParameter("keyword");
		String cnation = request.getParameter("cnation");
		String cbig = request.getParameter("cbig");
		String csmall = request.getParameter("csmall");
		
		ArrayList<SDto> list = dao.search(keyword, cnation, cbig, csmall);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		out.println(json);
		
	}

}
