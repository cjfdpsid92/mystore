<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>

	<div class = "container">
		<h3 class = "panel-heading">FORM BASIC - JOIN</h3>
		<p>(*)은 필수입력사항입니다.</p>
		<form action = "${pageContext.request.contextPath}/join.do" method = "post" id = "agree" >
			<fieldset class = "form-group">
			<legend>Company 서비스 약관 동의</legend>
			<p class = "text-right"><input type = "checkbox" id="agree1" name="agree1" title="서비스 약관동의 체크박스입니다."/></p>
			<textarea rows="10" class="form-control" title="서비스약관내용입니다."> <%@ include file ="../inc/agree1.txt"%> </textarea>
			</fieldset>
			
			<fieldset class = "form-group">
			<legend>Company 개인정보 수집 및 이용동의</legend>
			<p class = "text-right"><input type = "checkbox" id="agree2" name="agree2" title="개인정보 수집 및 이용동의 체크박스입니다."/></p>
			<textarea rows="10" class="form-control" title="개인정보 수집 및 이용동의 내용입니다."> <%@ include file = "../inc/agree2.txt"%> </textarea>
			</fieldset>
			
			<fieldset class = "form-group text-center">
			<legend class = "myhidden">동의 버튼</legend>
				<div class = "form-group text-center">
				<input type="submit" value="동의하기" class = "btn"/>
				</div>
			</fieldset>
			
		</form>
		<script>
			$(document).ready(function(){
				$("#agree").submit(function(){
					if (!($("#agree1").is(":checked"))) { alert("약관에 동의하셔야합니다."); return false; }
					if (!($("#agree2").is(":checked"))) { alert("개인정보 수집 및 이용에 동의하셔야합니다."); return false; }
				});
			});
		
		</script>
	</div>


<%@ include file = "/inc/footer.jsp"%>