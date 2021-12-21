<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*"  %>
<%@ page errorPage="/example/myerror.jsp" %>    
    
<%
	request.setCharacterEncoding("utf-8");
	// [1] 이름, 아이디, 비밀번호, 연락처, 우편번호, 주소값 받아오기
	String name = request.getParameter("name");
	String id = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String phon1 = request.getParameter("hp1");
	String phon2 = request.getParameter("hp2");
	String phon3 = request.getParameter("hp3");
	String zipcode = request.getParameter("zipcode");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	
	// [2] 이름, 아이디, 비밀번호 => null이거나 빈문자열이면 join.jsp로 redirect이동시키기
	if(name == null || id == null || pwd == null
	|| name.trim().isEmpty() || id.trim().isEmpty() || pwd.trim().isEmpty()) {
			 response.sendRedirect("join.jsp");
			return;
	}
	//out.println(name);
	MemberVO user=new MemberVO(0,name,id,pwd,phon1,phon2,phon3,zipcode, addr1, addr2,null,1000);
	MemberDAO dao = new MemberDAO();
	int n = dao.insertMember(user);
	String msg=(n>0)?"회원가입 처리 완료":"회원가입 실패";
	String loc=(n>0)?"list.jsp":"javascript:history.back()";
%>
<script>
	alert('<%=msg%>');
	location.href='<%=loc%>';
</script>




