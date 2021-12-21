<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/layout_flex.css">
</head>
<body>
	<% 
		String method = request.getMethod();
		out.println("method="+method);
		//처음에는 get방식으로 들어옴. 아이디 입력한 뒤 submit을 하면?
	//요청방식이 get방식일 경우에는 ID입력 폼을 보여주고,
	// post방식일 때는 아이디 사용 가능 여부를 보여줄 예정
		if(method.equalsIgnoreCase("get")){		
	%>
	<div id="content" style="height:390px">
		<form name="idf" action="idCheck.jsp" method="post">
			<label for="userid">아이디</label>
			<input type="text" name="userid" id="userid"
			 placeholder="User ID" autofocus="autofocus"
			 class="box">
			<button class="btn">확인</button>
		</form>
	</div>
	<%}else{
		//사용자가 입력한 아이디값 받기
		String userid = request.getParameter("userid");
		%>
	<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>
		<%
			boolean isUse = userDao.idCheck(userid);      
			if(isUse){
				//out.println("<h1>사용 가능</h1>");
				%>
				<div id="content" style="height:390px">
					<h3><%=userid %>를 사용할 수 있습니다.</h3>
					<button class="btn" onclick="setId('<%=userid %>')">닫  기</button>
				</div>
				<%
			}else{
				//out.println("<h1>사용 불가능</h1>");
				%>
				<div id="content" style="height:390px">
					<h3><%=userid %>는 이미 사용 중입니다.</h3>
					<form name="idf" action="idCheck.jsp" method="post">
					<label for="userid">아이디</label>
					<input type="text" name="userid" id="userid"
					 placeholder="User ID" autofocus="autofocus"
					 class="box">
					<button class="btn">확  인</button>
					</form>
				</div>
				<%
				
			}
	}
		%>
		<script>
			function setId(uid){
				//alert(uid);
				//uid값을 부모창(join.jsp)의 userid의 value값으로 전달한다.
				//부모창 [opener==> window객체]
				//window > document > form
				opener.document.mf.userid.value = uid;
				
				//팝업창 닫기 [팝업창=> self]
				self.close();
				
			}
		</script>
</body>
</html>