<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*"  %>
<jsp:include page="/top.jsp" />
<div id="content">
	<h1>쿠키 테스트</h1>
<%-- 
사용자의 간단한 정보들은 쿠키에 저장할 수 있다.
	  이 때 쿠키는 클라이언트 쪽 메모리나 파일로 저장된다.
	  1. 쿠키 저장 단계
	  	[1] 쿠키 생성 단계 (key, value)
	  	[2] 쿠키 속성 설정 단계 (유효시간, 도메인, 경로 등...)
	  	[3] 쿠키 전송 단계 => response에 쿠키를 포함시켜서 클라이언트 쪽으로 전송한다.
	  2. 쿠키 꺼내는 단계
		=> request에 포함되어 있는 쿠키를 꺼내 활용한다.
--%>	
<% 
	//[1] 쿠키 생성 단계 (key, value)
	Cookie ck1 = new Cookie("visitId","swan");//key, value형태로 매핑해서 저장함
	Date d = new Date();
	SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd_hh:mm:ss");
	
	Cookie ck2 = new Cookie("visitTime",sdf.format(d));
	//[2] 쿠키 속성 설정 단계 (expiry-유효시간, domain, path 등))
	ck1.setMaxAge(60*60*24*3);//3일간 유효
	ck2.setMaxAge(60*60*24*7);//7일간 유효	
	//[3] 쿠키 전송 단계
	response.addCookie(ck1);
	response.addCookie(ck2);
%>
<h1>쿠키 저장 완료!!</h1>
<h1><a href="cookieList.jsp">쿠키 목록 보러가기</a></h1>
</div>
<jsp:include page="/foot.jsp" />


