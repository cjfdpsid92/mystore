<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/inc/header.jsp"/>
<!--  END HEADER -->
<!--  END HEADER -->


<script>


</script>
<div class="container"   style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD</h3>
	<div class=" r1">
	<table  class="table table-striped">
		<caption>MULTIBOARD - MVC1</caption>
		<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			      <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
		</tbody>
		<tfoot>
			<tr><td colspan="5" class="text-center">
				<ul class="pagination">
				<!-- <c:if test="${start>=bottomList}">
					<li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(start-2)*onepagelimit}">이전</a></li>
				</c:if>
					<c:forEach var="footer" begin="${start}" end="${end}" >
						<li 
						<c:if test="${current==footer}">class="active"</c:if>
						class="${now}"><a href="${pageContext.request.contextPath}/list.do?pstartno=${(footer-1)*onepageLimit}">${footer}</a></li>
					</c:forEach>
					<c:if test="${end<pageAll}">
						<li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(end)*onepageLimit}">다음</a></li>
					</c:if> -->
				</ul>
			</td></tr>
			</tfoot>
	</table>
	</div>
	<p  class="text-right"><a href="${pageContext.request.contextPath}/write_view.do"   class="btn btn-danger">글쓰기</a></p>
</div>
<script>
	function pagebar(n,start,a,temp,end,prev,next){
			console.log("n : " + n)
			if(n=start) { $(".r1 ul").append(prev); }
			var li = $(a).html(temp);
			$(".r1 ul").append(li);
			if(n=end) { $(".r1 ul").append(next); }
	}
	
	function list(){
		$(".r1 tbody").html("");
		$(".r1 ul").html("");
		$.ajax({
			url:"${pageContext.request.contextPath}/list_view.do",
			type:"get",
			data:{"psartno":null},
			dataType:"json",
			success:function(data){ 
				console.log(data);
				
				var current = data.current;
				var pageTotal = data.pageTotal;
				var onepageLimit = data.onepageLimit;
				var pageAll = data.pageAll;
				var start = data.start;
				var end = data.end;
				var bottomList = data.bottomList;
				var paginglist = data.paginglist;
				
				for(var i=0; i<paginglist.length; i++) {
					var td1 = $("<td>").html(pageTotal-((current-1)*onepageLimit)-i);
					var td2 = $("<td>").html("<a href='${pageContext.request.contextPath}/detail.do?bno="+paginglist[i].bno+"'>"+paginglist[i].btitle+"</a>");
					var td3 = $("<td>").html(paginglist[i].bname);
					var td4 = $("<td>").html(paginglist[i].bdate);
					var td5 = $("<td>").html(paginglist[i].bhit);
					$(".r1 tbody").append($("<tr>").append(td1).append(td2).append(td3).append(td4).append(td5));
				}
				
				var prev = '';
				var next = '';
				if (start>=bottomList) {prev=$("<li>").html("<a href='#' onclick='+list_paging("+(start-2)*onepagelimit+") return false;>이전</a>");}
				if (end<pageAll) {next=$("<li>").html("<a href='#' onclick='+list_paging("+(end)*onepageLimit+") return false;>다음</a>");}
				for(var footer=start; footer<=end; footer++) {
					var temp = '';
					var a = "<li>";
					temp = "<a href='#' onclick='list_paging("+(footer-1)*onepageLimit+")'>"+footer+"</a>";
					if (current==footer) {a="<li class='active'>"; } console.log(a);
					console.log(temp)
					console.log("footer : " + footer + "/ bottomList : " + bottomList + "/ end : " + end);
					pagebar(footer,start,a,temp,end,prev,next);
				}
			},
			error:function(xhr, textStatus, errorThrown){
				$(".r1 tbody").html(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
			}
		});
	}
	
	function list_paging(pstartno){
		$(".r1 tbody").html("");
		$(".r1 ul").html("");
		$.ajax({
			url:"${pageContext.request.contextPath}/list_view.do",
			type:"get",
			data:{"pstartno":pstartno},
			dataType:"json",
			success:function(data){ 
				console.log(data);
				
				var current = data.current;
				var pageTotal = data.pageTotal;
				var onepageLimit = data.onepageLimit;
				var pageAll = data.pageAll;
				var start = data.start;
				var end = data.end;
				var bottomList = data.bottomList;
				var paginglist = data.paginglist;
				
				for(var i=0; i<paginglist.length; i++) {
					var td1 = $("<td>").html(pageTotal-((current-1)*onepageLimit)-i);
					var td2 = $("<td>").html("<a href='${pageContext.request.contextPath}/detail.do?bno="+paginglist[i].bno+"'>"+paginglist[i].btitle+"</a>");
					var td3 = $("<td>").html(paginglist[i].bname);
					var td4 = $("<td>").html(paginglist[i].bdate);
					var td5 = $("<td>").html(paginglist[i].bhit);
					$(".r1 tbody").append($("<tr>").append(td1).append(td2).append(td3).append(td4).append(td5));
				}
				
				var prev = '';
				var next = '';
				if (start>=bottomList) {prev=$("<li>").html("<a href='#' onclick='+list_paging("+(start-2)*onepagelimit+") return false;>이전</a>");}
				if (end<pageAll) {next=$("<li>").html("<a href='#' onclick='+list_paging("+(end)*onepageLimit+") return false;>다음</a>");}
				for(var footer=start; footer<=end; footer++) {
					var temp = '';
					var a = "<li>";
					temp = "<a href='#' onclick='list_paging("+(footer-1)*onepageLimit+")'>"+footer+"</a>";
					if (current==footer) {a="<li class='active'>"; } console.log(a);
					console.log(temp)
					console.log("footer : " + footer + "/ bottomList : " + bottomList + "/ end : " + end);
					pagebar(footer,start,a,temp,end,prev,next);
				}
			},
			error:function(xhr, textStatus, errorThrown){
				$(".r1 tbody").html(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
			}
		});
	}
	
	$(document).ready(list()); 
	
</script>

<!-- END FOOTER -->
<!-- END FOOTER -->
<jsp:include page="/inc/footer.jsp"/>