package my.com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import memo.model.*;
/**
 * Servlet implementation class MemoListServlet
 */
@WebServlet("/MemoList")
public class MemoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *  Web/css/memo.css
	 *  Web/MemoList
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<link rel='stylesheet' type='text/css' href='./css/memo.css'>");
		out.println("<div id='wrap'>");
		out.println("<h1 style='text-align:center'>:::���� �޸��� ���:::</h1>");
		out.println("<table id='memoTable'>");
		out.println("<tr>");
		out.println("<th class='m2' width='10%'>�۹�ȣ</th>");
		out.println("<th class='m2' width='50%'>�۳���</th>");
		out.println("<th class='m2' width='15%'>�ۼ���</th>");
		out.println("<th class='m2' width='15%'>�ۼ���</th>");
		out.println("<th class='m2' width='10%'>����|����</th>");		
		out.println("</tr>");
		//MemoDAO����
		//List<MemoVO> listMemo()ȣ��
		MemoDAO dao=new MemoDAO();
		try {
		List<MemoVO> arr = dao.listMemo();
		if(arr==null||arr.size()==0) {
			out.println("<tr><td colspan='5'><b>���� �����̰ų� �����Ͱ� �����ϴ�");
			out.println("</b></td></tr>");
		}else {
		
			for(MemoVO vo:arr) {
				//�ݺ��� ���鼭 �۹�ȣ/�۳���/�ۼ���/�ۼ��� ���
				out.println("<tr>");
				out.println("<td class='m3'>"+vo.getIdx()+"</td>");
				out.println("<td class='m3'>"+vo.getMsg()+"</td>");
				out.println("<td class='m3'>"+vo.getName()+"</td>");
				out.println("<td class='m3'>"+vo.getWdate()+"</td>");
				out.println("<td class='m3'><a href='MemoEdit?idx="+vo.getIdx()+"'>����</a>|");
				out.println("<a href='MemoDelete?idx="+vo.getIdx()+"'>����</a></td>");
				out.println("</tr>");
			}//for----
		}//else-----------------
		out.println("</table>");
		out.println("</div>");
		out.close();
		}catch(java.sql.SQLException e) {
			e.printStackTrace();
			out.println("<tr>");
			out.println("<td colspan='5'><b>Server Error:"+e.getMessage()+"</b></td>");
			out.println("</tr></table>");
			out.close();
			//return;
		}
	}

}
