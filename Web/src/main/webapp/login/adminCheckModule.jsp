<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/login/loginCheckModule.jsp" %>    
<!--  adminCheckModule.jsp -->
<!--  1.로그인이 되어 있어야 함 
	  2. 로그인한 회원이 관리자여야 함(admin) 
-->
<%
	if(!member.getUserid().equals("admin")){
		%>
		<script>
			alert('관리자만 이용 가능합니다');
			history.back();
		</script>
		<%
		return;
	}
%>