<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp"/>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container"  style="margin-top:5%; min-height:500px">

	<h3>고객문의 상세보기</h3> 					
	<div class="panel" >
	  <div  class="panel-body"> 
	  		<span class="glyphicon glyphicon-plus">  조회수</span>
	  		<p>${dto.bhit}</p>
	</div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">  이름</span> 
			<p>${dto.bname}</p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  제목</span> 
	     <p>${dto.btitle}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  내용</span>
	  	<textarea  class="form-control detail_con"  readonly>${dto.bcontent}</textarea>
	  </div> 
	 <c:if test="${not empty dto.bimg}">
	  <div class="panel">
	  	<div class="panel-body">
	  		<span class="glyphicon glyphicon-plus">  첨부사진</span>
	  		<p><img src="${pageContext.request.contextPath}/upload/${dto.bimg}" alt="첨부사진"/></p>
	  	</div>
	  </div>
	 </c:if>
	</div>	
	<div class="text-right"    >
		 <a href="${pageContext.request.contextPath}/edit_view.do?bno=${dto.bno}"  class="btn btn-danger" >수정</a> 
		 <a href="${pageContext.request.contextPath}/delete_view.do?bno=${dto.bno}"  class="btn btn-danger" >삭제</a>
		 <a href="${pageContext.request.contextPath}/reply_view.do?bno=${dto.bno}"  class="btn btn-danger" >답변달기</a>    
		 <a href="${pageContext.request.contextPath}/list.do"  class="btn btn-info" >목록보기</a> 
	</div>						 
</div>	
<jsp:include page="/inc/footer.jsp"/>
