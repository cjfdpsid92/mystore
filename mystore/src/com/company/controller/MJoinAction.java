package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.MDao;
import com.company.dto.MDto;

public class MJoinAction implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MDao dao = new MDao();
		MDto dto = new MDto();
		
		String mailselect = request.getParameter("mailselect");
		String memail = null;
		if (mailselect.equals("9")) { memail = request.getParameter("memail1")+"@"+request.getParameter("memail2");  }
		else { memail=request.getParameter("memail1")+"@"+mailselect;  }
		String[] agree = request.getParameterValues("agree");
		String mail_yes = "N"; String sns = "N"; String sms = "N";
		if (agree!=null){
		for (int i=0; i<agree.length; i++) { 
			if (agree[i].equals("mail")) { mail_yes="Y"; }
			else if (agree[i].equals("sns")) { sns="Y"; }
			else if (agree[i].equals("sms")) { sns="Y"; }
		}}
		String usersex = request.getParameter("usersex");
		
		dto.setMid(request.getParameter("mid")); dto.setMname(request.getParameter("mname"));
		dto.setMpass(request.getParameter("mpass")); dto.setMemail(memail);
		dto.setMail_yes(mail_yes); dto.setSns(sns); dto.setSms(sms); dto.setUsersex(usersex);
		dto.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		dto.setAddress1(request.getParameter("address1")); dto.setAddress2(request.getParameter("address2"));
		int result = dao.create(dto);
		
		mail_yes = "아니오"; sns = "아니오"; sms = "아니오";
		if (agree!=null){
			for (int i=0; i<agree.length; i++) { 
				if (agree[i].equals("mail")) { mail_yes="예"; }
				else if (agree[i].equals("sns")) { sns="예"; }
				else if (agree[i].equals("sms")) { sns="예"; }
			}}
		usersex = (usersex.equals("f"))? "여성" : (usersex.equals("m"))? "남성" : "기타";
		MDto dto2 = dao.read(dto); dto2.setMail_yes(mail_yes); dto2.setSns(sns); dto2.setSms(sms); dto2.setUsersex(usersex);
		request.setAttribute("dto2", dto2);
		System.out.println(dto2);
		
		if(result>0 ) { 
			request.getRequestDispatcher("/member/join_com.jsp").forward(request, response);
		}
		else { out.println("<script>alert('관리자에게 문의해주세요!'); history.go(-1);</script>"); }
	}

}
