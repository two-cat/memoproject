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
	 * method����� get����� ���� doGet()�� �������̵� �ؾ� �Ѵ�.
	 * [1] get����� ����ڰ� �Է��� ������ ��ûurl�� ������Ʈ��(query string)���� ���Խ��� �����Ѵ�
	 *     ...?�Ķ���͸�=��&�Ķ���͸�=��&�Ķ���͸�=�� ...
	 * [2] ���,�ֹι�ȣ...���� ���� ���� post������� �����ؾ� �Ѵ�.
	 * [3] get����� ��û���ο� �����͸� ���Խ�Ű�� ������ �������� �����͸� ���۰���..512byte����
	 *     ���� ���Ͼ��ε� ���� �ʿ��ϸ� post����� ����ؾ� �Ѵ�.    
	 * */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		 res.setContentType("text/html; charset=UTF-8");
		 //[1] ����ڰ� �Է��� ���� �޾ƿ���. ==> req�� �̿��ؼ� �޴´�
		 //String getParameter("�Ķ���͸�")
		 String uid = req.getParameter("userid");
		 String upw = req.getParameter("pwd");
		 
		 //[2] ��ȿ�� üũ----
		 if(uid==null|| upw == null || uid.trim().isEmpty()|| upw.trim().isEmpty()) {
			 //�ùٸ� ��� ���� �������� �����Ѵ�.
			 res.sendRedirect("index.html");
			 //sendRedirect() => �Ű������� ������ �������� �̵��� ��Ų��.
			 //					������ �̵��� �ص� �Ʒ� ������ ��� �����Ѵ�.
			 return;
		 }
		 System.out.println("���⸦ �����ұ��???");
		 
		 //[3] ���� ó��
		 PrintWriter pw = res.getWriter();
		 
		 pw.println("<h1>Get Test</h1>");
		 pw.println("<h2>���̵�: "+uid+"</h2>");
		 pw.println("<h2>��й�ȣ: "+upw+"</h2>");
		 pw.println("");
		 
		 pw.close();
	}

}




