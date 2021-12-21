package my.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.model.MemoDAO;

/**
 * Servlet implementation class MemoDeleteServlet
 */
@WebServlet("/MemoDelete")
public class MemoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		//1. ������ �� ��ȣ �ޱ� (idx)
		String idx=req.getParameter("idx");
		
		//2. ��ȿ�� üũ ==> MemoList�� �������̵���Ű��
		if(idx==null||idx.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		}
		//3. MemoDAO ���� => deleteMemo(�۹�ȣ)ȣ��
		MemoDAO dao=new MemoDAO();
		try {
		int n = dao.deleteMemo(Integer.parseInt(idx));		
		//4. �� ��� �޽��� ó�� (����/����) ==> alert()�� �����ְ�
		//   ������ �̵� MemoList�� �̵�
		String str=(n>0)?"���� ����":"���� ����";
		String loc="MemoList";		
		out.println("<script>");
		out.println("alert('"+str+"')");
		out.println("location.href='"+loc+"'");
		out.println("</script>");
		
		}catch(SQLException e) {
			out.println("<h2>Error: "+e.getMessage()+"</h2>");
			e.printStackTrace();
		}
		out.close();
	}

}
