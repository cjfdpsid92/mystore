<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/header.jsp"/>

<div class="container panel mymaargin">
	<div class="container">
			<h4 class="panel-heading">상세검색</h4>
				<div class="form-group">
					<div class="form-group">
						<div class="col-sm-10"><input type="text" id="search" class="form-control"/></div>
						<div class="col-sm-2"><input type="button" id="search_go" value="검색" class="form-control btn btn-warning"/></div>
					</div>
					<div class="form-group">
						<table class="table table-striped">
							<caption>카테고리</caption>
								<tbody>
								<tr><td><input type="checkbox" id=cn1/> 국내도서</td>
								<td colspan="3"><input type="checkbox" id=cn2/> 외국도서</td></tr>
								<tr><td><input type="checkbox" id=cB1/> 문학</td>
								<td><input type="checkbox" id=cB2/> 취미/실용</td>
								<td colspan="2"><input type="checkbox" id=cB3/> 예체능</td></tr>
								<tr><td><input type="checkbox" id=cs1/> 수필</td>
								<td><input type="checkbox" id=cs2/> 국내소설</td>
								<td><input type="checkbox" id=cs3/> 외국소설</td>
								<td><input type="checkbox" id=cs4/> 요리</td></tr>
								<tr><td><input type="checkbox" id=cs5/> 생활실용</td>
								<td><input type="checkbox" id=cs6/> 스포츠/레저</td>
								<td><input type="checkbox" id=cs7/> 건강</td>
								<td><input type="checkbox" id=cs8/> 여성실용</td></tr>
								<tr><td><input type="checkbox" id=cs9/> 연극/영화</td>
								<td><input type="checkbox" id=cs10/> 예술일반</td>
								<td><input type="checkbox" id=cs11/> 미술</td>
								<td><input type="checkbox" id=cs12/> 음악</td></tr>
								<tr><td><input type="checkbox" id=cs13/> 악보</td>
								<td><input type="checkbox" id=cs14/> 디자인</td>
								<td colspan="2"><input type="checkbox" id=cs15/> 외국도서</td></tr>
								</tbody>
						</table>
					</div>
					
					<div class="container panel r2">
						<h4 class="panel-heading">검색결과</h4>
						
					</div>
				</div>
	</div>
</div>

<script>
	$(function(){
		$("#search_go").click(seach_view());
	});

	function seach_view(search){
		$.ajax({
			url:"${pageContext.request.contextPath}/SearchDetail",
			type:"get",
			data:{"search":$("#search").val()},
			dataType:"json",
			success:function(data){ 
				console.log(data);  
				
			},
			error:function(xhr, textStatus, errorThrown){
				$(".r2").append(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
			}
		});
	}

	
</script>

<jsp:include page="/inc/footer.jsp"/>