

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdderServlet
 */
@WebServlet("/AdderServlet")
public class AdderServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String str1=request.getParameter("num1");
		String str2=request.getParameter("num2");
		int num1=Integer.parseInt(str1);
		int num2=Integer.parseInt(str2);
		int sum=num1+num2;
		out.println("<html>");
		out.println("<head>덧셈프로그램-결과화면</title></head>");
		out.println("<body>");
		out.printf("%d+%d=%d",num1,num2,num1+num2);
		out.println("</body>");
		out.println("</html>");
	}


}
