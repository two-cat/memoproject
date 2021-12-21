<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*"  %>
<jsp:include page="/top.jsp"/>

<script>
   let win;
   function openWin(){
      win=open("idCheck.jsp","idCheck","width=400, height=400, left=100,top=100");
   }//------------------------
   
   function check() {
      if(!mf.name.value){
         alert('이름을 입력하세요');
         mf.name.focus();
         return;
      }
      if(!mf.userid.value){
         alert('아이디를 입력하세요');
         mf.userid.focus();
         return;
      }
      if(!mf.pwd.value){
         alert('비밀번호를 입력하세요');
         mf.pwd.focus();
         return;
      }
      if(mf.pwd.value != mf.pwd2.value){
         alert('비밀번호가 다릅니다.');
         mf.pwd2.select();
         return;
      }
      if(!mf.hp1.value || !mf.hp2.value || !mf.hp2.value){
         alert('전화번호를 입력하세요');
         if(!mf.hp1.value){
         mf.hp1.focus();
            }else if(!mf.hp2.value){
               mf.hp2.focus();
            }else if(!mf.hp3.value){
               mf.hp3.focus();
            }
         return;
         }
      if(!mf.addr1.value){
         alert('주소를 입력하세요');
         mf.addr1.focus();
         return;
      }else if(!mf.addr2.value){
         alert('주소를 입력하세요');
         mf.addr2.focus();
         return;
      }
      mf.submit(); // 서버에 전송
   }
</script>
<% 
	String idx = request.getParameter("idx");
	if(idx==null||idx.trim().isEmpty()){
		response.sendRedirect("list.jsp");
		return;
	}
	//[1] MemberDAO빈 useBean액션으로 생성하기
	//[2] MemberVO selectMemberByIdx(int idx) 호출하기
	//[3] 받아온 VO객체 이용해서 input에 value값으로 출력하기
%>
<jsp:useBean id="userDao" class="user.model.MemberDAO" scope="session" />

<%
	int idx_int = Integer.parseInt(idx.trim());
	MemberVO user = userDao.selectMemberByIdx(idx_int);
	if(user==null){
		%>
		<script>
			alert('해당 회원은 없습니다.');
			history.back();
		</script>
		<%
		return;
	}
%>

<div id = "content">
   <h1>Member Info Edit</h1>
   
   <form name="mf" action="updateEnd.jsp" method="post">
      <table class="table" border="1">
      	 <tr>
            <td class="t1"><b>회원번호</b></td>
            <td class="t2">
            <input type="text" name="idx" value="<%=idx%>" placeholder="Idx" readonly class="box">
            </td>
         </tr>
         <tr>
            <td class="t1"><b>이 름</b></td>
            <td class="t2">
            <input type="text" name="name" value="<%=user.getName()%>" placeholder="Name" class="box">
            </td>
         </tr>
         <tr>
            <td class="t1"><b>아이디</b></td>
            <td class="t2">
            <input type="text" name="userid" value="<%=user.getUserid()%>" placeholder="user ID" class="box" readonly>
            <button type="button" class="btn" onclick="openWin()">중복체크</button>
            </td>
         </tr>
         <tr>
            <td class="t1"><b>비밀번호</b></td>
            <td class="t2">
            <input type="password" name="pwd" placeholder="Password" class="box">
            </td>
         </tr>
         <tr>
            <td class="t1"><b>비밀번호 확인</b></td>
            <td class="t2">
            <input type="password" name="pwd2" placeholder="Password" class="box">
            </td>
         </tr>
         <tr>
            <td class="t1"><b>연락처</b></td>
            <td class="t2">
            <input type="text" name="hp1" value="<%=user.getHp1()%>" required maxlength="3" placeholder="HP1" class="box sm">-
            <input type="text" name="hp2" value="<%=user.getHp2() %>" required maxlength="4" placeholder="HP2" class="box sm">-
            <input type="text" name="hp3" value="<%=user.getHp3() %>" required maxlength="4" placeholder="HP3" class="box sm">
            </td>
         </tr>
         <tr>
            <td class="t1"><b>우편번호</b></td>
            <td class="t2">
            <input type="text" name="zipcode" value="<%=user.getZipcode()%>" maxlength="5" placeholder="Zipcode" class="box">
            <button type="button" class="btn">우편번호 확인</button>
            </td>
         </tr>
         <tr>
            <td class="t1"><b>주소</b></td>
            <td class="t2">
            <input type="text" name="addr1" value="<%=user.getAddr1() %>" placeholder="Address1" class="box lg" style="margin-bottom:5px">
            <br><br>
            <input type="text" name="addr2" value="<%=user.getAddr2() %>" placeholder="Address2" class="box lg">
            </td>
         </tr>
         <tr>
            <td colspan="2" style="text-align:center">
               <button type="button" onclick="check()" class="btn">정보수정</button>
               <button type="reset" class="btn">다시쓰기</button>
            </td>
         </tr>
      </table>
   </form>
</div>

<jsp:include page="/foot.jsp"/>