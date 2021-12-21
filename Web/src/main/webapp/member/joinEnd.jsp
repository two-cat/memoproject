<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*"  %>
<%@ page errorPage="/example/myerror.jsp" %>  
<% 
	request.setCharacterEncoding("utf-8");
%>  
<jsp:useBean id="user" class="user.model.MemberVO" scope="page" />
<jsp:setProperty  name="user" property="*" />
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>

<%-- 
<jsp:setProperty name="user" property="name" param="name"/>
<jsp:setProperty name="user" property="userid" param="userid"/>
 --%>
<%-- 
	MemberVO user = new MemberVO();  와 동일
	user.setName(request.getParameter("name"));와 동일
	
	id : 참조변수명을 지정
	class: 클래스명
	scope: 객체가 살아있는 유효범위 (page< request< session< application)
	#setProperty액션
	property : MemberVO빈의 멤버변수명
	param : html의 input name을 지정
 --%>
<!-- html의 input name과 VO객체의 멤버변수(property)의 이름이 같아야 편리함 -->
<% 
	if(user.getName()==null||user.getUserid()==null
	||user.getName().trim().isEmpty()
	||user.getUserid().trim().isEmpty()){
		response.sendRedirect("join.jsp");
		return;
	}  

	int n = userDao.insertMember(user);
	
	String msg=(n>0)?"회원가입 처리 완료":"회원가입 실패";
	String loc=(n>0)?"list.jsp":"javascript:history.back()";
%>  

<script>
	alert('<%=msg%>');
	location.href='<%=loc%>';
</script>




