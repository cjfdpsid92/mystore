<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/inc/header.jsp"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	<div class = "container">
		<h3 class = "panel-heading">FORM BASIC - JOIN</h3>
		<p>(*)는 필수입력사항입니다.</p>
			<form action = "${pageContext.request.contextPath}/Join_com.do" method="post" id = "join">
				<fieldset class = "form-group">
				<legend>필수정보입력</legend>
				
				<div class = "form-group">
				<label for = "mid">(*)아이디</label>
				<input type="text" id = "mid" name = "mid" class = "form-control" placeholder="아이디는 영문, 숫자 4~15자리"  />
				</div>
				
				<div class = "form-group text-right">
				<input type="button" value="아이디 중복확인" id="id_check" title="아이디 중복확인 버튼입니다." class = "btn"/>
				<div id="check_result"></div>
				<input type="hidden"  id="id_ok"   <c:if test="${not empty result}"> value="checked"   </c:if>>
				<script>
				$(function(){
					$("#id_check").click(function(){
						if($("#mid").val == "") { alert('아이디를 입력해주세요.'); $("mid").focus(); return false; }
						else {
						$.ajax({
							url:"${pageContext.request.contextPath}/IdCheck",
							type:"get",
							dataType:"json",
							data:{"mid":$("#mid").val()},
							success:function(data){
								var result = data.result;
								console.log(result);
								if(result.length>0 && result=="ok") {
								$("#check_result").html("사용할 수 있는 아이디입니다.").css("color","blue");	
								$("#id_ok").val('checked');
								}
								else if (result.length==0) {
									$("#check_result").html("이미 사용중인 아이디입니다.").css("color","red");
									$("#id_ok").val('');
								}
								else { 
									$("#check_result").html("아이디를 입력해주세요.");
									$("#id_ok").val('');
								}
								},
							error:function(xhr, textStatus, errorThrown){
								$("#check_result").html(textStatus+"(HTTP-"+xhr.status+"/"+errorThrown);
							}
						});
						}
					});
				});
				</script>
				</div>
				
				<div class = "form-group">
				<label for = "mname">(*)이름</label>
				<input type="text" id = "mname" name = "mname" class = "form-control"/>
				</div>
				
				<div class = "form-group">
				<label for = "mpass">(*)비밀번호</label>
				<input type="password" id = "mpass" name = "mpass" class = "form-control"/>
				</div>
				
				<div class = "form-group">
				<label for = "mpass_re">(*)비밀번호 확인</label>
				<input type="password" id = "mpass_re" name = "mpass_re" class = "form-control"/>
				</div>
				
				<div class = "form-group">
				<strong>(*)성별</strong>
					<div>					
					<input type="radio" id = "f" name = "usersex" value="f"/>
					<label for="f">여성</label>				
					<input type="radio" id = "m" name = "usersex" value="m"/>
					<label for="m">남성</label>			
					<input type="radio" id = "e" name = "usersex" value="e"/>
					<label for="e">기타</label>
					</div>
				</div>
				
				<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
					$(function(){
						$("#postcode").click(function(){
							 new daum.Postcode({
							        oncomplete: function(data) {
							           $("#postcode").val(data.zonecode);
							           $("#address1").val(data.roadAddress);
							           $("#address2").focus();
							        }
							    }).open();
						});
						$("#zonecode").click(function(){
							 new daum.Postcode({
							        oncomplete: function(data) {
							           $("#postcode").val(data.zonecode);
							           $("#address1").val(data.roadAddress);
							           $("#address2").focus();
							        }
							    }).open();
						});
					});
				</script>
				<div class="form-group">
				<h5>(*) 주소</h5>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-4">
								<label for="postcode" class="myhidden">우편번호</label>
								<input type="text" id="postcode" name="postcode" placeholder="우편번호" value="" readonly class="form-control"/>
							</div>
							<div class="col-sm-8">
								<input type="button" title="우편번호찾기버튼" value="우편번호찾기" id="zonecode" class="btn btn-info"/>
							</div>
						</div>
					</div>
					<div class="form-group">
					<div class="row">
							<div class="col-sm-6">
								<label for="address1" class="myhidden">상세주소1</label>
								<input type="text" id="address1" name="address1" placeholder="주소" readonly class="form-control"/>
							</div>
							<div class="col-sm-6">
								<label for="address2" class="myhidden">우편번호</label>
								<input type="text" id="address2" name="address2" placeholder="상세주소" class="form-control"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class = "form-group">
				<label for = "memail1">(*)이메일</label>
				<div>
				<input type="text" id = "memail1" name = "memail1"/> @ 
				<input type="text" id = "memail2" name = "memail2" value="" disabled/>
				<select id="mailselect" name="mailselect" onchange="mailselect()">
					<option value="0"> 선택하세요 </option>
					<option value="naver.com"> naver.com </option>
					<option value="hanmail.net"> hanmail.net </option>
					<option value="gmail.com"> gmail.com </option>
					<option value="9"> 직접입력 </option>
				</select>
				</div>
				<script>
					$("#mailselect").change(function(){
						$("#mailselect option:selected").each(function(){
						if($(this).val()=='9') { 
							$("#memail2").attr("disabled",false); $("#memail2").val(""); $("#memail2").focus(); }
						else if($(this).val()!='0') { 
							$("#memail2").attr("disabled",true); $("#memail2").val($(this).text()); }
						});
					});
				</script>
				</div>
				
				
				<div class = "form-group">
					<h5>이벤트성 알림 수신동의</h5>
					<input type="checkbox" id="mail_yes" name ="agree" value="mail"/>
					<label for = "mmail_yes">이메일 수신 동의</label>
					<input type="checkbox" id="sns" name ="agree" value="sns"/>
					<label for = "sns">SNS 수신 동의</label>
					<input type="checkbox" id="sms" name ="agree" value="sms"/>
					<label for = "sms">sms 문자 수신 동의</label>
				</div>
				
				<div class = "form-group text-center">
					<label class = "myhidden">회원가입버튼</label>
					<input type = "submit" value = "회원가입하러가기" title = "회원가입 버튼입니다." class = "btn form-control"/>
				</div>
				
				<div class = "form-group text-center">
					<label class = "myhidden">뒤로가기 버튼</label>
					<a href = "javascript:history.go(-1);" title = "뒤로가기 버튼입니다." class = "btn form-control">이전</a>
				</div>
				</fieldset>
			</form>
			
			<script>
				$(document).ready(function(){
					$("#join").submit(function(){
						if($("#mid").val()=="") { alert("아이디는 반드시 입력해야 합니다."); $("#mid").focus; return false; }
						if($("#id_ok").val()!="checked") { alert("아이디 중복검사를 해주세요."); return false; }
						if($("#mname").val()=="") { alert("이름은 반드시 입력해야 합니다."); $("#mname").focus; return false; }
						if($("#mpass").val()=="") { alert("비밀번호는 반드시 입력해야 합니다."); $("#mpass").focus; return false; }
						if($("#mpass_re").val()=="") { alert("비밀번호 확인은 반드시 입력해야 합니다."); $("#mpass_re").focus; return false; }
						if($("#memail1").val()=="" || $("#memail2").val()=="") { alert("이메일은 반드시 입력해야 합니다."); $("#memail").focus; return false; }
						if($("#mpass").val()!=$("#mpass_re").val()) { alert("비밀번호가 틀립니다.\n확인해주세요."); $("#mpass_re").focus; return false; }
						//if ($(":checkbox[name='agree']:checked").length==0) { alert("최소 하나의 알림 수신에 동의해주세요."); return false; }
						if($(":radio[name='usersex']:checked").length==0){alert('성별은 반드시 입력해야합니다.'); return false;}
					});
				});
			
			
			</script>
	</div>

<%@ include file = "/inc/footer.jsp"%>