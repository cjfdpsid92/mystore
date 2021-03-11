package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BDao;
import com.company.dto.BDto;
import com.google.gson.Gson;


public class BListActioin implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		BDao dao = new BDao();
		Map<String, Object> result = new HashMap<String, Object>();
		
		int pageTotal = dao.listcnt(); System.out.println("1. 전체게시판 (레코드)갯수" + pageTotal);
		int onepageLimit = 10; System.out.println("2. 한 페이지당 보여주는 (레코드)갯수" + onepageLimit);
		int pageAll = (int)Math.ceil(pageTotal/(float)onepageLimit); System.out.println("3. 전체페이지 : " + pageAll);
		
		int pstartno = 0;
		if(request.getParameter("pstartno")!=null) { pstartno = Integer.parseInt(request.getParameter("pstartno")); }
		System.out.println("4-1. db에서 가져올 번호 : " + pstartno);
		ArrayList<BDto> list = dao.list10(pstartno);
		System.out.println(list);
		result.put("paginglist", list);
		System.out.println("4-2. db에서 가져온 리스트 : " + pstartno);
		
		int bottomList = 10; System.out.println("5. 하단페이지네비 : " + bottomList);
		int current = (int)Math.ceil((pstartno+1)/(float)onepageLimit); System.out.println("6. 하단네비 현재페이지 : " + current);
		
		int start = (int)Math.floor((current-1)/(float)bottomList)*bottomList+1; System.out.println("7. 하단네비 시작페이지 : " + start);
		
		int end = start+bottomList-1; System.out.println("8. 하단네비 끝페이지 : " + end);
		if(pageAll<end) {end=pageAll;}
		
		result.put("pageTotal", pageTotal);
		result.put("onepageLimit", onepageLimit);
		result.put("pageAll", pageAll);
		result.put("bottomList", bottomList);
		result.put("current", current);
		result.put("start", start);
		result.put("end", end);
//		request.setAttribute("pageTotal", pageTotal);
//		request.setAttribute("onepageLimit", onepageLimit);
//		request.setAttribute("pageAll", pageAll);
//		request.setAttribute("bottomList", bottomList);
//		request.setAttribute("current", current);
//		request.setAttribute("start", start);
//		request.setAttribute("end", end);
//		request.setAttribute("paginglist", list);
		Gson gson = new Gson();
		String json = gson.toJson(result);
		System.out.println(json);
		out.println(json);
		
	}

}
