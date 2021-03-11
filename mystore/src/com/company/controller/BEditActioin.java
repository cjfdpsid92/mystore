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

public class BEditActioin implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		String path = "/upload";
		path = request.getServletContext().getRealPath(path);
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		
		String file = multi.getFilesystemName("bimg");
		if (file==null) { System.out.println("file 비었어요! : " + multi.getParameter("prev_img")); file=multi.getParameter("prev_img"); }
		System.out.println("bimg : " + file);
		dto.setBimg(file);
		
		dto.setBno(Integer.parseInt(multi.getParameter("bno")));  dto.setBpass(multi.getParameter("bpass")); 
		dto.setBtitle(multi.getParameter("btitle")); dto.setBcontent(multi.getParameter("bcontent"));
		System.out.println(dto.getBimg());
		int result = dao.update(dto);
		request.setAttribute("update", result );
		
		if(result>0 ) { out.println("<script>alert('수정에 성공했습니다.'); location.href='"+request.getContextPath()+"//detail.do?bno="+dto.getBno()+"';</script>"); }
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }
	}

}
