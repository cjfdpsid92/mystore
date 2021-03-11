package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BDao;
import com.company.dto.BDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BWriteActioin implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int bgroup = -1, bstep = -1, bindent = -1, max = -1;
		BDao dao = new BDao();
		BDto dto = new BDto();
		max = dao.create_max();
		bgroup = (int)(Math.ceil(max/(float)1000))+1;
		bstep = bgroup*1000;
		bindent = 0;
		
		String path = "/upload";
		//path = request.getServletContext().getRealPath(path);
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		
		dto.setBname(multi.getParameter("bname")); dto.setBpass(multi.getParameter("bpass"));
		dto.setBtitle(multi.getParameter("btitle")); dto.setBcontent(multi.getParameter("bcontent"));
		dto.setBimg(multi.getFilesystemName("bimg"));
		System.out.println(multi.getFilesystemName("bimg"));
		dto.setBgroup(bgroup); dto.setBstep(bstep); dto.setBindent(bindent);
		int result = dao.create(dto);
		request.setAttribute("create", result);
		
		if(result>0 ) { out.println("<script>alert('글쓰기에 성공했습니다.'); location.href='"+request.getContextPath()+"/list.do';</script>"); }
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }

	}

}
