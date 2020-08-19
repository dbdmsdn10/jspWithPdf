
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneToHundred
 */
@WebServlet("/OneToHundred")
public class OneToHundred extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		int total = 0;
		for (int i = 0; i < 100; i++) {
			total += i;
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>1부터 100까지 더하는 서블랫</title></head>");
		out.println("<body>");
		out.printf("1~100까지의 합=%d",total);
		out.println("</body>");
	}

}
