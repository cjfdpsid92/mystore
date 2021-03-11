<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "container">
	<div class = "text-center form-group">
		<img src = "${pageContext.request.contextPath}/img/login.png" alt = "welcome! Login">
	</div>
	
	<div class = "text-center">
		<div class = "form-group">
			<button type="button" class="btn info lg" data-toggle="modal" data-target="#modal">회원 로그인</button>
		</div>
		<div class = "form-group">
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=e7fa7107591e2df70ae8c0f5861f3141&redirect_uri=http://localhost:8181/mystore/KakaoLogin.do&response_type=code">
			<!-- <a href="https://kauth.kakao.com/oauth/authorize?client_id=e7fa7107591e2df70ae8c0f5861f3141&redirect_uri=http://cjfdpsin92.cafe24.com/mystore/KakaoLogin.do&response_type=code"> -->
			<img src="${pageContext.request.contextPath}/img/KakaoLogin.png" alt="카카오 로그인"/></a>
		</div>
		
		
		<div class="modal fade" id="modal" role="dialog">
		 	 <div class="modal-dialog">
		
			     <!-- Modal content-->
			     <div class="modal-content">
			     	<div class="modal-header">
			     	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        	<h4 class="modal-title">회원 로그인</h4>
			        </div>
			        <div class="modal-body">
						<form action = "${pageContext.request.contextPath}/login.do" method="post" id="login_form">
							<h3>LOGIN</h3>
							<fieldset class = "form-group">
							<legend>WELCOME! COMPANY</legend>
							
							<div class = "form-group">
								<label for = "id">아이디</label>
								<input type="text" id="id" name = "id" class="form-control" value="${cookie['id'].value}"/>
							</div>
							
							<div class = "form-group">
								<label for = "pass">비밀번호</label>
								<input type="password" id="pass" name = "pass" class="form-control"/>
							</div>
							
							<p>
								<input type = "checkbox" id="remember" name="remember" title="아이디 기억하기입니다." 
								<c:if test="${not empty cookie.id}">checked</c:if>/>
								<label for = "remember">아이디 기억하기</label>
							</p>
							
							<div class = "form-group text-right">
								<input type="submit" title="로그인 버튼입니다." value="LOGIN" class="btn"/>
							</div>
							
							</fieldset>
						</form>
			        </div>
			        <div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        </div>
			     </div>
		    </div>
		  </div>	
	</div>

		<script>
		$(document).ready(function(){
			$("#login_form").submit(function(){
				if($("#id").val()=="") { alert("아이디를 입력해주세요."); $("#id").focus; return false; }
				if($("#pass").val()=="") { alert("비밀번호를 입력해주세요."); $("#pass").focus; return false; }
			});
		});			
	</script>
</div>
<%@ include file = "/inc/footer.jsp"%>