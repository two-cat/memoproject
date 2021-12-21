<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 삭제할 회원번호 받기
	String idx = request.getParameter("idx");

	//2. 유효성 체크 => list.jsp로 redirect이동
	if(idx==null||idx.trim().isEmpty()){
		response.sendRedirect("list.jsp");
		return;
	}
	int idx_int = Integer.parseInt(idx.trim());
	//3. useBean액션 통해 MemberDAO빈 생성 ==> int deleteMember(int idx)호출하기	
	//4. 결과에 따라 메시지 보여주고 페이지 이동(list.jsp로 이동)
%>
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>
<%
	int n = userDao.deleteMember(idx_int);
	String msg=(n>0)?"삭제 완료":"삭제 실패";
%>
<script>
	//alert('<%=msg%>');
	location.href='list.jsp';
</script>

