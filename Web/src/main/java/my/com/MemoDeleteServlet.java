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
		//1. 삭제할 글 번호 받기 (idx)
		String idx=req.getParameter("idx");
		
		//2. 유효성 체크 ==> MemoList로 페이지이동시키기
		if(idx==null||idx.trim().isEmpty()) {
			res.sendRedirect("MemoList");
			return;
		}
		//3. MemoDAO 생성 => deleteMemo(글번호)호출
		MemoDAO dao=new MemoDAO();
		try {
		int n = dao.deleteMemo(Integer.parseInt(idx));		
		//4. 그 결과 메시지 처리 (성공/실패) ==> alert()로 보여주고
		//   페이지 이동 MemoList로 이동
		String str=(n>0)?"삭제 성공":"삭제 실패";
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
