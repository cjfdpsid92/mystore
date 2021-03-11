package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.MDao;
import com.company.dto.MDto;


public class MEdit implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("id")==null) {
			out.println("<script>location.href='"+request.getContextPath()+"'</script>"); }
		
		MDao dao = new MDao();
		MDto dto = new MDto();
		
		String mailselect = request.getParameter("mailselect");
		String memail = null;
		System.out.println("이메일 아이디 : " +  request.getParameter("mail1"));
		if (mailselect.equals("9")) { memail = request.getParameter("email1")+"@"+request.getParameter("memail2");  }
		else { memail=request.getParameter("email1")+"@"+mailselect;  }
		String[] agree = request.getParameterValues("agree");
		System.out.println(Arrays.toString(agree));
		String mail_yes = "N"; String sns = "N"; String sms = "N";
		if (agree!=null){
		for (int i=0; i<agree.length; i++) { 
			if (agree[i].equals("mail")) { mail_yes="Y"; }
			else if (agree[i].equals("sns")) { sns="Y"; }
			else if (agree[i].equals("sms")) { sms="Y"; }
		}
		}
		String usersex = request.getParameter("usersex");
		
		dto.setMid((String)session.getAttribute("id")); dto.setMname(request.getParameter("mname"));
		dto.setMpass(request.getParameter("mpass")); dto.setMemail(memail);
		dto.setMail_yes(mail_yes); dto.setSns(sns); dto.setSms(sms); dto.setUsersex(usersex);
		
		System.out.println("dto : " + dto);
		int result = dao.update_mypage(dto);
		
		if(result>0 ) { 
			out.println("<script>alert('회원정보가 수정되었습니다.'); location.href='"+request.getContextPath()+"/mypage.do'; </script>");
		}
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }
	}

}
