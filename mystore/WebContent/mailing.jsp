<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp"/>

<div class="container paenl">
	<h3 class="panel-heading">관리자에게</h3>
	<script src="//cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
	<script>
			$(function(){
            	CKEDITOR.replace( 'content' );
			});
    </script>
    <form action="${pageContext.request.contextPath}/mail_send.do" method = "post">
    	<fieldset>
    	<legend>관리자에게 메일보내기</legend>
    	<table class = "table">
    		<caption class="myhidden"></caption>
    		<tbody>
    		<tr><th scope="row"><label for="subject">제목</label></th>
			<td><input type="text" id="subject" name="subject" placeholder="제목을 적어주세요" class="form-control"></td></tr>
			
			<tr><th scope="row"><label for="content">내용</label></th>
			<td><textarea id="content" name="content" placeholder="내용을 적어주세요" class="form-control"></textarea></td></tr>
			
			<tr><td colspan="2"><input type="submit" value="전송" class="btn btn-warning"></td>
			<td><a href="javascript:history.go(-1);"   class="btn btn-default"   >뒤로가기</a></td></tr>
    		</tbody>
    	</table>  	
    	</fieldset>
    </form>
</div>

<jsp:include page="/inc/footer.jsp"/>