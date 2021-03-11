<%@page import="com.company.dto.MDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div class = "container">
		<h3 class = "panel-heading">MY PAGE</h3>
		<form action = "${pageContext.request.contextPath}/member_edit_com.do" method="post" id ="myedit_form">
		<fieldset class = "form-gruop">
		<legend>회원정보 수정</legend>
		<table class = "table table-striped">
		<caption>비밀번호 수정</caption>
		<tbody>
			<c:set var="dto" value="${dto}" scope="request" /> 
			<c:set var="temp" value="${fn:split(dto.memail,'@')}"/>
			<tr><th scope="row">아이디</th>	<td>${dto.mid}</td></tr>
			
			<tr><th scope="row">
			<label for = "name">이름</label></th>	<td>
			<input type = "text" id="name" class="form-control" name = "mname" value = "${dto.mname}"/>
			</td></tr>
			
			<tr><th scope="row">
			<label for = "usersex">성별</label></th>	<td>
				<input type="radio" id = "f" name = "usersex" value="f" <c:if test="${dto.usersex eq '여성'}">checked</c:if>/>
				<label for="f">여성</label>				
				<input type="radio" id = "m" name = "usersex" value="m" <c:if test="${dto.usersex eq '남성'}">checked</c:if>/>
				<label for="m">남성</label>			
				<input type="radio" id = "e" name = "usersex" value="e" <c:if test="${dto.usersex eq '기타'}">checked</c:if>/>
				<label for="e">기타</label>
			</td></tr>
			
			<tr><th scope="row">
			<label for = "email1">이메일</label></th>	<td>
			<input type="text" id = "email1" name = "email1"  value="${temp[0]}"/> @ 
				<input type="text" id = "email2" name = "email2" value="${temp[1]}" disabled/>
				<select id="mailselect" name="mailselect" onchange="mailselect()">
					<option value="${temp[1]}"> 수정안함 </option>
					<option value="naver.com"> naver.com </option>
					<option value="hanmail.net"> hanmail.net </option>
					<option value="gmail.com"> gmail.com </option>
					<option value="9"> 직접입력 </option>
				</select>
				<script>
					$("#mailselect").change(function(){
						$("#mailselect option:selected").each(function(){
						if($(this).val()=='9') { 
							$("#email2").attr("disabled",false); $("#email2").val(""); $("#email2").focus(); }
						else if($(this).val()!='0') { 
							$("#email2").attr("disabled",true); $("#email2").val($(this).text()); }
						});
					});
				</script>
			</td></tr>
			
			<tr><th scope="row">광고성 메일·SNS 수신동의</th>	<td>
					<input type="checkbox" id="mail_yes" name ="agree" value="mail" <c:if test="${dto.mail_yes eq '예'}"><c:out value="checked"></c:out></c:if>/>
					<label for = "mmail_yes">이메일 수신 동의</label>
					<input type="checkbox" id="sns" name ="agree" value="sns" <c:if test="${dto.sns eq '예'}"><c:out value="checked"></c:out></c:if>/>
					<label for = "sns">SNS 수신 동의</label>
					<input type="checkbox" id="sms" name ="agree" value="sms" <c:if test="${dto.sms eq '예'}"><c:out value="checked"></c:out></c:if>/>
					<label for = "sns">sms 문자 수신 동의</label>
			</td></tr>
			
			<tr><th scope="row">가입날짜</th>	<td>${dto.mdate}</td></tr>
		</tbody>
		</table>
		<div class = "text-center">
			<a href = "javascript:history.go(-1)" class = "btn">이전</a>
			<input type="submit" value="회원정보수정" title="회원정보를 수정하는 버튼입니다." class="btn"/>
		</div>
		</fieldset>
		</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#myedit_form").submit(function(){
			if($("#name").val()=="") { alert("이름을 입력해주세요."); $("#name").focus; return false; }
			if($("#email1").val()=="" || $("#email2").val()=="") { alert("이메일은 반드시 입력해야 합니다."); $("#memail").focus; return false; }
			if($(":radio[name='usersex']:checked").length==0){alert('성별은 반드시 입력해야합니다.'); return false;}
		});
	});
	
	</script>
<%@ include file = "/inc/footer.jsp"%>