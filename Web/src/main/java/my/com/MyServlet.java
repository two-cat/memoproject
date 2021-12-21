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
//[1] HttpServletŬ������ ��ӹ޾ƾ� ��
// ��û��� get���=> doGet()�޼ҵ� �������̵�
//        post���=> doPost()
/*[1] ������ web.xml�� ���
 * Web(Context)/WEB-INF/web.xml
 * ============================
 * 
 * <!-- ���� ��� ========================= -->
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
 * �Ǵ� 
 * [2] @WebServlet()������̼��� �̿��� ���
 * */
public class MyServlet extends  HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		res.setContentType("text/html; charset=UTF-8");
		//���������� ������ ���������� html�� ���� 
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>MyServlet</title></head>");
		pw.println("<body>");
		pw.println("<h1>Hello MyServlet</h1>");
		pw.println("<h2>�ȳ� ���� ����</h2>");
		Date today = new Date();
		pw.println("<h2>"+today.toString()+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

}//////////////////////////////////////////////
