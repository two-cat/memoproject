package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * method방식이 get방식일 때는 doGet()을 오버라이드 해야 한다.
	 * [1] get방식은 사용자가 입력한 값들을 요청url에 쿼리스트링(query string)으로 포함시켜 전송한다
	 *     ...?파라미터명=값&파라미터명=값&파라미터명=값 ...
	 * [2] 비번,주민번호...등이 있을 때는 post방식으로 전송해야 한다.
	 * [3] get방식은 요청라인에 데이터를 포함시키기 때문에 적은양의 데이터만 전송가능..512byte정도
	 *     따라서 파일업로드 등이 필요하면 post방식을 사용해야 한다.    
	 * */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		 res.setContentType("text/html; charset=UTF-8");
		 //[1] 사용자가 입력한 값을 받아오자. ==> req를 이용해서 받는다
		 //String getParameter("파라미터명")
		 String uid = req.getParameter("userid");
		 String upw = req.getParameter("pwd");
		 
		 //[2] 유효성 체크----
		 if(uid==null|| upw == null || uid.trim().isEmpty()|| upw.trim().isEmpty()) {
			 //올바른 경로 통해 들어오도록 유도한다.
			 res.sendRedirect("index.html");
			 //sendRedirect() => 매개변수로 지정된 페이지로 이동을 시킨다.
			 //					페이지 이동을 해도 아래 로직을 계속 수행한다.
			 return;
		 }
		 System.out.println("여기를 수행할까요???");
		 
		 //[3] 로직 처리
		 PrintWriter pw = res.getWriter();
		 
		 pw.println("<h1>Get Test</h1>");
		 pw.println("<h2>아이디: "+uid+"</h2>");
		 pw.println("<h2>비밀번호: "+upw+"</h2>");
		 pw.println("");
		 
		 pw.close();
	}

}




