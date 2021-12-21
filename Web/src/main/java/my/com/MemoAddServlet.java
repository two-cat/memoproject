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
import memo.model.MemoVO;


@WebServlet("/MemoAdd")
public class MemoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		//ServletOutputStream os=res.getOutputStream()
		//1. ����ڰ� �Է��� �� �޾ƿ���(name,msg)
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		
		//2. ��ȿ�� üũ => null�̰ų� �� ���ڿ��̸� memo/index.html�� ������ �̵���Ű��
		out.println(name+"/"+msg);
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			res.sendRedirect("memo/input.html");
			return;
		}
		//3. 1���� �޾ƿ� ���� MemoVO��ü �����ؼ� ����ֱ�
		MemoVO memo=new MemoVO(0, name, msg, null);
		
		//4. MemoDAO��ü �����ؼ� insertMemo()ȣ���ϱ�
		MemoDAO dao=new MemoDAO();
		try {
			int n = dao.insertMemo(memo);
			String str =(n>0)? "�޸� ��� ����":"�޸� ��� ����";
			String loc =(n>0)? "MemoList":"memo/input.html";
			
			//out.println("<h2>"+str+"</h2>");
			//�޽��� �����ְ� ��� �������� �̵�����
			out.println("<script>");
			
			out.println("alert('"+str+"')");
			out.println("location.href='"+loc+"'");
			
			out.println("</script>");
			
		}catch(SQLException e) {
			out.println("<h2>Error: "+e.getMessage()+"</h2>");
			e.printStackTrace();
		}
		//5. �� ��� ���� ���� �޽��� ó�� (��� ����/����)
		out.close();
	}

}
