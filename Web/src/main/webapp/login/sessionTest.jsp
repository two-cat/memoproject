<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  sessionTest.jsp -->
<jsp:include page="/top.jsp" />
<div id="content">
	<h1>session에 저장된 모든 정보를 꺼내보자</h1>
	<h2 style="color:red">JSESSIONID:<%= session.getId()%> </h2>
<% 
	 java.util.Enumeration<String> en=session.getAttributeNames();
	//세션의 key값들만 반환함
	while(en.hasMoreElements()){
		String key = en.nextElement();
		Object val = session.getAttribute(key);
		%>
		<h2><%=key %> : <%=val %> </h2>
		<%
	}
%>
	
</div>
<jsp:include page="/foot.jsp" />