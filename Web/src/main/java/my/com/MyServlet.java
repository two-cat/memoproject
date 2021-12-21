package my.com;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//servlet-api.jar
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet :Server Side Applet
//[1] HttpServlet클래스를 상속받아야 함
// 요청방식 get방식=> doGet()메소드 오버라이드
//        post방식=> doPost()
/*[1] 서블릿을 web.xml에 등록
 * Web(Context)/WEB-INF/web.xml
 * ============================
 * 
 * <!-- 서블릿 등록 ========================= -->
	<servlet>  
	    <servlet-name>MyServlet</servlet-name>
	   <servlet-class>my.com.MyServlet</servlet-class>
	</servlet>
	<servlet-mapping>
	   <servlet-name>MyServlet</servlet-name>
	   <url-pattern>/My</url-pattern>
	</servlet-mapping>
	
===================================
 * 
 * 
 * 
 * 또는 
 * [2] @WebServlet()어노테이션을 이용해 등록
 * */
public class MyServlet extends  HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		res.setContentType("text/html; charset=UTF-8");
		//웹브라우저에 보여줄 문서형식을 html로 지정 
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>MyServlet</title></head>");
		pw.println("<body>");
		pw.println("<h1>Hello MyServlet</h1>");
		pw.println("<h2>안녕 마이 서블릿</h2>");
		Date today = new Date();
		pw.println("<h2>"+today.toString()+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

}//////////////////////////////////////////////
