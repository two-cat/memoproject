package my.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 아이디, 비번 받아서 출력하세요
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=res.getWriter();
		//post방식일 경우 요청 데이터는 요청 메시지의 entity body 부분에 포함되어 전송된다.
		//한글 처리를 별도로 해야 함
		req.setCharacterEncoding("UTF-8");
		
		String uid=req.getParameter("userid");
		String upw=req.getParameter("pwd");
		
		pw.println("<h1>Post Test</h1>");
		pw.println("<h2>아이디: "+uid+"</h2>");
		pw.println("<h2>비밀번호: "+upw+"</h2>");

		pw.close();
	}

}
