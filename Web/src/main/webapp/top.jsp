<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<% 
	//컨텍스트명 얻어오기
	String myctx = request.getContextPath();
// "/Web"
%>    
    <link rel="stylesheet" href="<%=myctx%>/css/layout_flex.css" type="text/css">

</head>
<body>
<% 
	MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

	boolean isLogin=false;
	if(loginUser!=null){
		isLogin=true;
	}
%>
    <div id="wrap">
        <header class="header">
            <a class="logo" href="#home"><img src="<%=myctx%>/images/logo3.png"></a>
            <nav>
              <!-- nav영역 -->
            <ul class="nav-items">
              <li><a href="<%=myctx%>/index.jsp">Home</a></li>
              <li><a href="<%=myctx%>/member/join.jsp">Signup</a></li>
              <li><a href="<%=myctx%>/member/list.jsp">Users</a></li>
              <% if(isLogin){ %>
              <li><a href="<%=myctx%>/login/logout.jsp">Logout</a></li>
              <% }else{%>
              <li><a href="<%=myctx%>/login/login.jsp">Login</a></li>
              <% }%>
            </ul>
          </nav>
        </header>    
        <div id="content-wrap">
          <aside>
            <h1>Aside</h1>
            <ul>
            <% if(isLogin){ %>
              <li><a href="#" class="active">
            	<%=loginUser.getUserid()%>님 로그인 중... </a></li>
            <% }%>
              
              <li><a href="<%=myctx%>/login/sessionTest.jsp">세션테스트</a></li>
              <li><a href="<%=myctx%>/login/memberTest.jsp">회원인증페이지</a></li>
              <li><a href="<%=myctx%>/login/cookieTest.jsp">쿠키테스트</a></li>
              <li><a href="#">Newyork</a></li>
            </ul>
          </aside>
          <section class="section">