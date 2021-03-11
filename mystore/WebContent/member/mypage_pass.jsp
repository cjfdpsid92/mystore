<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
	<div class = "container">
		<h3 class = "panel-heading">MY PAGE</h3>
		<form action = "${pageContext.request.contextPath}/member_pass_com.do" method="post" id ="mypass_form">
		<fieldset class = "form-gruop">
		<legend>회원정보 수정</legend>
		<table class = "table table-striped">
		<caption>비밀번호 수정</caption>
		<tbody>
			<tr><th scope="row">
			<label for = "pass_o">이전 비밀번호</label></th>	<td>
			<input type = "password" id="pass_o" class="form-control" name = "pass_o"/>
			</td></tr>
			
			<tr><th scope="row">
			<label for = "pass_n">새 비밀번호</label></th>	<td>
			<input type = "password" id="pass_n" class="form-control" name = "pass_n"/>
			</td></tr>
			
			<tr><th scope="row">
			<label for = "pass_n_re">새 비밀번호확인</label></th>	<td>
			<input type = "password" id="pass_n_re" class="form-control"/>
			</td></tr>
			
		</tbody>
		</table>
		<div class = "text-center">
			<a href = "javascript:history.go(-1)" class = "btn">이전</a>
			<input type="submit" value="비밀번호 수정하러가기" title="비밀번호를 수정하는 버튼입니다." class="btn"/>
		</div>
		</fieldset>
		</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#mypass_form").submit(function(){
			if($("#pass_o").val()=="") { alert("비밀번호를 입력해주세요."); $("#pass_o").focus; return false; }
			if($("#pass_n").val()=="") { alert("새 비밀번호를 입력해주세요."); $("#pass_n").focus; return false; }
			if($("#pass_n_re").val()=="") { alert("새 비밀번호확인을 입력해주세요."); $("#pass_n_re").focus; return false; }
			if($("#pass_n").val()!=$("#pass_n_re").val()) { alert("바꿀 비밀번호가 틀립니다.\n확인해주세요."); $("#pass_n_re").focus; return false; }
			if($("#pass_o").val()==$("#pass_n").val()) { alert("기존 비밀번호와 바꿀 비밀번호가 같습니다."); $("#pass_n").focus; return false; }	
		});
	});
	
	</script>
<%@ include file = "/inc/footer.jsp"%>