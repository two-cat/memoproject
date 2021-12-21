<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--	
	//[1] post방식 한글처리
	//[2] useBean액션 통해 MemberVO빈 생성
	      setProperty액션 통해 모든값(*)을 setting	
	  [3] useBean액션 통해 MemberDAO빈 생성 후
	     int updateMember(MemberVO) 호출
	  [4] 결과 메시지 보여주고 list.jsp로 이동
	  			실패하면 history.back()      
--%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="user" class="user.model.MemberVO" scope="page"/>
<jsp:setProperty property="*" name="user"/>
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>
<%
	if(user.getIdx()==0||user.getName()==null){
		response.sendRedirect("list.jsp");
		return;
	}
	int n = userDao.updateMember(user);
	String msg=(n>0)?"회원정보 수정 완료":"수정 실패";
	String loc=(n>0)?"update.jsp?idx="+user.getIdx():"javascript:history.back()";
%>
<script>
	alert('<%=msg%>');
	location.href='<%=loc%>';
</script>



