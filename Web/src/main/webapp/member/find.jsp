<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,user.model.*"  %>
<!-- 관리자 체크 모듈 include ------------------ -->
<%@ include file="/login/adminCheckModule.jsp" %>    
<!-- ---------------------------------------- -->     
    
<jsp:include page="/top.jsp" />
<!--  useBean 액션 이용해서 MemberDAO 빈 생성하기. listMember()호출하기 
   반환된 List를 반복문 돌면서 테이블 데이터로 출력하기
-->
<% 
	//검색유형과 검색어 파라미터 받기
	String findType=request.getParameter("findType");
	String findKeyword=request.getParameter("findKeyword");
	if(findType==null||findKeyword==null||findType.trim().isEmpty()){
		%>
		<script>
			alert('검색 유형을 선택하세요');
			location.href='list.jsp';
		</script>
		<%
		return;
	}
%>
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session"/>
<div id="content">
   <h1>User 검색 결과 [검색어: <%=findKeyword%> ]</h1>
   
   <div class="searchFrm">
   	<!--검색 폼--------------------  -->
   	<form name="findF" action="find.jsp" method="get">
   		<table class="table" style="width:70%">
   			<tr>
   				<td style="width:15%">
   					<select name="findType">
   						<option value="">::검색 유형::</option>
   						<option value="1">회원이름</option>
   						<option value="2">아이디</option>
   						<option value="3">연락처</option>
   					</select>
   				</td>
   				<td>
   					<input type="search" name="findKeyword" required
   					 placeholder="검색어를 입력하세요" class="box lg">
   					 <button class="btn">검   색</button>
   				</td>   				
   			</tr>	
   		</table>
   	</form>
   </div>
   
   <table class="table" border="1">
      <tr>
         <th>번호</th>
         <th>이름</th>
         <th>아이디</th>
         <th>연락처</th>
         <th>가입일</th>
         <th>수정|삭제</th> 
      </tr>
      <!-- ----------------------- --> 
      <% 
        List<MemberVO> arr =userDao.findMember(findType, findKeyword); 
        if(arr==null||arr.size()==0){
           out.println("<tr><td colspan='6'>데이터가 없습니다.</td></tr>"); 
        }else{
           for (MemberVO vo : arr) {
      %>
            <tr>
               <td><%=vo.getIdx()%></td>
               <td><%=vo.getName()%></td>
               <td><%=vo.getUserid()%></td>
               <td><%=vo.getAllHp()%></td>
               <td><%=vo.getIndate()%></td>
               <td>
               <a href="javascript:goEdit('<%=vo.getIdx()%>')">수정</a>|
               <a href="#" onclick="goDel('<%=vo.getIdx()%>')">삭제</a>
               </td>
            </tr>
      <%
           }//for----
        }//else----------------
      %>
      <!-- ----------------------- -->
   </table>
   <!--  삭제 또는 수정 form ---------- -->
   <form name="f">
   		<input type="hidden" name="idx">
   </form>
   <!-- ---------------------------- -->
</div>
<script>
	function goEdit(num){
		f.idx.value = num;
		f.action="update.jsp";
		f.method="post";
		f.submit();
	}//-------------------
	function goDel(num){
		let yn = confirm(num+"번 회원정보를 정말 삭제할까요?");
		if(yn){
			f.idx.value=num;
			f.action="delete.jsp";
			f.method="post";
			f.submit();
		}
	}//----------------
</script>
<jsp:include page="/foot.jsp" />


