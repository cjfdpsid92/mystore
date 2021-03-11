package com.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.MDao;
import com.company.dto.MDto;

public class MMypageAction implements DefaultAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		MDao dao = new MDao();
		
		System.out.println("SESSION : " + (String)session.getAttribute("id"));
		
		MDto dto = dao.mypage((String)session.getAttribute("id"));
		System.out.println(dto);
		
		String mail_yes = (dto.getMail_yes().trim().toLowerCase().equals("y"))? "예" : "아니오"; 
		String sns = (dto.getSns().trim().toLowerCase().equals("y"))? "예" : "아니오"; 
		String sms = (dto.getSms().trim().toLowerCase().equals("y"))? "예" : "아니오"; 
		String usersex = (dto.getUsersex().trim().toLowerCase().equals("f"))? "여성" : (dto.getUsersex().trim().toLowerCase().equals("m"))? "남성" : "기타";
		dto.setMail_yes(mail_yes); dto.setSns(sns); dto.setSms(sms); dto.setUsersex(usersex);
		
		request.setAttribute("dto", dto);

	}

}
