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
		//1. 사용자가 입력한 값 받아오기(name,msg)
		String name = req.getParameter("name");
		String msg = req.getParameter("msg");
		
		//2. 유효성 체크 => null이거나 빈 문자열이면 memo/index.html로 페이지 이동시키기
		out.println(name+"/"+msg);
		if(name==null||msg==null||name.trim().isEmpty()||msg.trim().isEmpty()) {
			res.sendRedirect("memo/input.html");
			return;
		}
		//3. 1번에 받아온 값을 MemoVO객체 생성해서 담아주기
		MemoVO memo=new MemoVO(0, name, msg, null);
		
		//4. MemoDAO객체 생성해서 insertMemo()호출하기
		MemoDAO dao=new MemoDAO();
		try {
			int n = dao.insertMemo(memo);
			String str =(n>0)? "메모 등록 성공":"메모 등록 실패";
			String loc =(n>0)? "MemoList":"memo/input.html";
			
			//out.println("<h2>"+str+"</h2>");
			//메시지 보여주고 목록 페이지로 이동하자
			out.println("<script>");
			
			out.println("alert('"+str+"')");
			out.println("location.href='"+loc+"'");
			
			out.println("</script>");
			
		}catch(SQLException e) {
			out.println("<h2>Error: "+e.getMessage()+"</h2>");
			e.printStackTrace();
		}
		//5. 그 결과 값에 따라 메시지 처리 (등록 성공/실패)
		out.close();
	}

}
