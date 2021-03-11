<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "container panel panel-info">
	<h3 class = "panel-heading">JOIN-회원가입 완료</h3>
	<table class = "table table-striped">
		<caption>회원가입을 축하합니다.</caption>
		<tbody>
			<c:set var="dto2" value="${dto2}" scope="request" /> 
			<tr><th scope="row">아이디</th>	<td>${dto2.mid}</td></tr>
			<tr><th scope="row">이름</th>		<td>${dto2.mname}</td></tr>
			<tr><th scope="row">성별</th>		<td>${dto2.usersex}</td></tr>
			<tr><th scope="row">이메일</th>	<td>${dto2.memail}</td></tr>
			<tr><th scope="row">이메일 수신동의</th>	<td>${dto2.mail_yes}</td></tr>
			<tr><th scope="row">SNS 수신동의</th>	<td>${dto2.sns}</td></tr>
			<tr><th scope="row">sms 문자 수신동의</th>	<td>${dto2.sms}</td></tr>
			<tr><th scope="row">가입날짜</th>	<td>${dto2.mdate}</td></tr>
		</tbody>
	</table>
	<div class = " text-right">
	<a href="${pageContext.request.contextPath}/main.do" class = "btn btn-danger">LOGIN</a>
	</div>
</div>

<%@ include file = "/inc/footer.jsp"%>