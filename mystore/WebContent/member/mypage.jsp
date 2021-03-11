<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class = "container">
		<h3 class = "panel-heading">MY PAGE</h3>
		<table class = "table table-striped">
		<caption>회원정보</caption>
		<tbody>
			<c:set var="dto" value="${dto}" scope="request" /> 
			<tr><th scope="row">아이디</th>	<td>${dto.mid}</td></tr>
			<tr><th scope="row">이름</th>		<td>${dto.mname}</td></tr>
			<tr><th scope="row">성별</th>		<td>${dto.usersex}</td></tr>
			<tr><th scope="row">이메일</th>	<td>${dto.memail}</td></tr>
			<tr><th scope="row">이메일 수신동의</th>	<td>${dto.mail_yes}</td></tr>
			<tr><th scope="row">SNS 수신동의</th>	<td>${dto.sns}</td></tr>
			<tr><th scope="row">sms 문자 수신동의</th>	<td>${dto.sms}</td></tr>
			<tr><th scope="row">가입날짜</th>	<td>${dto.mdate}</td></tr>
		</tbody>
		</table>
		<div class = "text-center">
			<a href = "${pageContext.request.contextPath}/member_edit.do" class = "btn">회원정보 수정</a>
			<a href = "${pageContext.request.contextPath}/member_pass.do" class = "btn">비밀번호 수정</a>
			<a href = "${pageContext.request.contextPath}/member_delete.do" class = "btn" id="delete">탈퇴</a>
		</div>
	</div>
<%@ include file = "/inc/footer.jsp"%>