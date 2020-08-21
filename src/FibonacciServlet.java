
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciServlet
 */
@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet {
	private PrintWriter logFile;

	public void init() throws ServletException {
		try {
			logFile = new PrintWriter(new FileWriter("C:\\Users\\dbdms\\Documents\\웹공부\\mine.txt", true));
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String greeting = "안녕하세요," + name + "님.";
		if (logFile != null) {
			Date now = new Date();
			logFile.printf("%TF %TT - %s %n", now, now, name);
		}
		out.println("<html>");
		out.println("<head><title>인사하기</title></head>");
		out.println("<body>");
		out.println(greeting);
		out.println("</body>");
		out.println("</html>");
	}

	public void destroy() {
		if (logFile != null) {
			logFile.close();
		}
	}
}
