<%@page import="com.company.dto.MDto"%>
<%@page import="com.company.dao.MDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.company.dbmanager.DBmanager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko"> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
	<h3 class="panel-heading">MDCP TEST</h3>
	<% 
		DBmanager db = new DBmanager();
		Connection conn = db.connection();
		if (conn!=null) { out.println("DB연동성공"); }
		
	%>
</div>

<div class="container panel panel-info">
	<h3 class="panel-heading">BAO TEST</h3>
	<% 
		//MDao dao = new MDao();
		//out.println("list() : " + dao.list() + "<br/>");
		
		response.sendRedirect(request.getContextPath()+"/main.do");
	%>
</div>

</body>
</html>