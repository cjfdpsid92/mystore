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

public class BReplyAction implements DefaultAction {

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
		
		System.out.println("bgroup : " + multi.getParameter("bgroup"));
		int bgroup = Integer.parseInt(multi.getParameter("bgroup"));
		int bstep = Integer.parseInt(multi.getParameter("bstep"));
		System.out.println("BSTEP : " + bstep);
		int bindent = Integer.parseInt(multi.getParameter("bindent"));
		
		dto.setBstep(bstep);
		dao.update_re1(dto);
		
		dto.setBname(multi.getParameter("bname"));
		dto.setBpass(multi.getParameter("bpass"));
		dto.setBtitle(multi.getParameter("btitle")); 
		dto.setBcontent(multi.getParameter("bcontent"));
		dto.setBimg(multi.getFilesystemName("bimg"));
		dto.setBgroup(bgroup);
		dto.setBstep(bstep-1);
		dto.setBindent(bindent+1);
		int result = dao.create(dto);
		
		if(result>0 ) { out.println("<script>alert('글쓰기에 성공했습니다.'); location.href='"+request.getContextPath()+"/list.do';</script>"); }
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }

	}

}
