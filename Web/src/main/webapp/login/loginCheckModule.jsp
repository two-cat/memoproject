<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>
<!-- loginCheckModule.jsp -->
<%-- 로그인 여부를 체크하는 모듈. 회원들만 이용하는 페이지에 이 모듈을 include한다--%>
<%
	MemberVO member = (MemberVO)session.getAttribute("loginUser");
	if(member == null){
		%>
		<script>
			alert('로그인해야 이용할 수 있어요');
			location.href="<%=request.getContextPath()%>/login/login.jsp";
		</script>
		<%
		return;
	}
%>