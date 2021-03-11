package com.company.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KakaoLogin implements DefaultAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("KAKAO LOGIN : " + request.getParameter("code"));
		
		String client_id = "e7fa7107591e2df70ae8c0f5861f3141";
		String redirect_uri = "http://localhost:8181/mystore/KakaoLogin.do";
//		String redirect_uri = "http://cjfdpsin92.cafe24.com/mystore/KakaoLogin.do";
		String code = request.getParameter("code");
		String url = "https://kauth.kakao.com/oauth/token?"
				+ "grant_type=authorization_code"
				+ "&client_id=" + client_id	+ "&redirect_uri=" + redirect_uri + "&code=" + code;
		URL kakaourl = null;
		HttpURLConnection conn = null;
		try {
			kakaourl = new URL(url);
			conn = (HttpURLConnection) kakaourl.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		} catch(Exception e) { e.printStackTrace(); }
		
		int responseCode = conn.getResponseCode(); String readLine = "";
		BufferedReader br = null; StringBuffer buffer = new StringBuffer(); String result = "";
		try {
			if(responseCode == 200) { br = new BufferedReader(new InputStreamReader(conn.getInputStream())); }
			else { br = new BufferedReader(new InputStreamReader(conn.getErrorStream())); }
			while((readLine = br.readLine()) != null) { buffer.append(readLine); }
			br.close();
			result = buffer.toString(); System.out.println(result);
		} catch (Exception e) { e.printStackTrace(); }
		
		String access_token = "";
		if(responseCode == 200) {
			JsonParser parser = new JsonParser();
			JsonObject job = (JsonObject) parser.parse(result);
			access_token = job.get("access_token").getAsString();
			session.setAttribute("access_token", access_token);
			System.out.println("access : " + access_token);
		}
		
		String userapi = "https://kapi.kakao.com/v2/user/me";
		URL userurl = null; HttpURLConnection userconn = null;
		try {
			userurl = new URL(userapi);
			userconn = (HttpURLConnection)userurl.openConnection();
			userconn.setRequestMethod("GET");
			userconn.setRequestProperty("Authorization", "Bearer " + access_token);
		} catch (Exception e) { e.printStackTrace(); }
		
		responseCode = userconn.getResponseCode();
		System.out.println("responseCode : " + responseCode);
		if(responseCode == 200) { br = new BufferedReader(new InputStreamReader(userconn.getInputStream())); }
		else { br = new BufferedReader(new InputStreamReader(userconn.getErrorStream())); }
		
		String userLine = "";
		StringBuffer userbuffer = new StringBuffer();
		while((userLine = br.readLine()) != null) { userbuffer.append(userLine); }
		System.out.println(userbuffer);
		String id = "";
		String nickname = "", timg = "";
		if (responseCode == 200) {
			JsonParser parser = new JsonParser();
			JsonObject job1 = (JsonObject) parser.parse(userbuffer.toString());
			id = job1.get("id").getAsString();
			JsonObject job2 = (JsonObject) job1.get("properties");
			nickname = job2.get("nickname").getAsString();
			timg = job2.get("thumbnail_image").getAsString();
			System.out.println(id);
			System.out.println(nickname + "/" + timg);
			session.setAttribute("id", "kakao_"+id);
			session.setMaxInactiveInterval(60*10);
		}
		
		

	}

}
