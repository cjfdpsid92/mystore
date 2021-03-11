package com.company.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.SDao;
import com.company.dto.SDto;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchDetail
 */
@WebServlet("/SearchDetail")
public class SearchDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
