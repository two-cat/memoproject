<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*"  errorPage="errorAlert.jsp"  %>
<!-- loginEnd.jsp -->
<%
	//[1] userid, pwd, saveId값 받기
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String saveId = request.getParameter("saveId");
	System.out.println("saveId: "+saveId);
	
	//[2] 유효성 체크 => login.jsp로 보내기
	if(userid==null||pwd==null||userid.trim().isEmpty()||pwd.trim().isEmpty()){
		response.sendRedirect("login.jsp");
		return;
	}
	
	//[3] useBean액션으로 MemberDAO빈 생성
	//    MemberVO loginCheck(userid, pwd)
	//   아이디, 비번이 틀리다면 => 사용자정의 예외를 발생시키자.(NotUserException)
%>
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>
<%
	MemberVO loginUser =userDao.loginCheck(userid, pwd);
	//out.println(loginUser);

	if(loginUser!=null){
		//out.println("<h1>로그인 성공</h1>");
		//세션에 로그인한 회원정보 저장
		session.setAttribute("loginUser",loginUser);
		//session: 내장객체 HttpSession타입
		//서블릿에서 세션을 얻고자할 때는 HttpSession session = request.getSession();
		Cookie ck = new Cookie("uid", loginUser.getUserid());
		if(saveId!=null){
			//아이디 저장에 체크했다면
			ck.setMaxAge(60*60*24*7);
			ck.setPath("/");
		}else{
			//아이디 저장에 체크하지 않았다면=> 쿠키 삭제 (MaxAge를 0으로 준다.)
			ck.setMaxAge(0);
			ck.setPath("/");
		}
		response.addCookie(ck);
		response.sendRedirect("../index.jsp");
	}
%>




