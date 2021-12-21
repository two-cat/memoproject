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
		// ���̵�, ��� �޾Ƽ� ����ϼ���
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter pw=res.getWriter();
		//post����� ��� ��û �����ʹ� ��û �޽����� entity body �κп� ���ԵǾ� ���۵ȴ�.
		//�ѱ� ó���� ������ �ؾ� ��
		req.setCharacterEncoding("UTF-8");
		
		String uid=req.getParameter("userid");
		String upw=req.getParameter("pwd");
		
		pw.println("<h1>Post Test</h1>");
		pw.println("<h2>���̵�: "+uid+"</h2>");
		pw.println("<h2>��й�ȣ: "+upw+"</h2>");

		pw.close();
	}

}
