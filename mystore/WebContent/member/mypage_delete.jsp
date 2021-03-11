<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<div class = "container">
	<h3>회원 탈퇴</h3>
	<form action="${pageContext.request.contextPath}/member_delete_com.do" method="post" id="delete">
		<div class="form-group">
			<label for="mpass">비밀번호</label>
			<input type="password" name="mpass" id="mpass" class="form-control">
			<span>(*) 탈퇴하려면 비밀번호를 입력해주세요.</span>
		</div>
		<div class="form-group">
			<input type="submit" value="확인" class="btn btn-danger"/>
			<input type="reset" onclick="history.go(-1);" value="취소" class="btn btn-info" />
		</div>
	</form>

</div>
<script>
	jQuery(document).ready(function(){
		jQuery("#delete").submit(function(){
			if($("#mpass").val()==""){ alert("비밀번호를 입력해주세요."); $("#mpass").focus(); return false; }
		});
	});
</script>
<%@ include file = "/inc/footer.jsp"%>