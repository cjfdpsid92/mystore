<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class = "container">
		<h3 class = "panel-heading">MY PAGE</h3>
		<table class = "table table-striped">
		<caption>회원정보</caption>
		<tbody>
			<tr><td colspan="2">현재 카카오 로그인중입니다.</td></tr>
			<tr><th scope="row">아이디</th>	<td>${sessionScope.id}</td></tr>
		</tbody>
		</table>
	</div>
<%@ include file = "/inc/footer.jsp"%>