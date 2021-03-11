package com.company.idcheck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.MDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mid = request.getParameter("mid");
		System.out.println("id : " + mid);
		int result = new MDao().idCheck(mid);
		String json = "";
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		if(result==0 && mid.length()!=0) {
			jobj.addProperty("result", "ok");
			json = gson.toJson(jobj);
			System.out.println(json);
		}
		else if(mid.length()>0) { 
			jobj.addProperty("result", "");
			json = gson.toJson(jobj);
			System.out.println(json);
		}
		else { 
			jobj.addProperty("result", "false");
			json = gson.toJson(jobj);
			System.out.println(json);
		}
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
