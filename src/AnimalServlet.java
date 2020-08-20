

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/AnimalServlet")
public class AnimalServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
		 PrintWriter out = response.getWriter();
		 String food = request.getParameter("food");
		 HttpSession session = request.getSession();
		 session.setAttribute("food", food);
		 out.println("<html>");
		 out.println("<head><title>성격 테스트</title></head>");
		 out.println("<body>");
		 out.println("<h3>좋아하는 동물은?</h3>");
		 out.println("<form action='ResultServlet'>");
		 out.println("<input type='text' name='animal'>");
		 out.println("<input type='submit' value= '확인'>");
		 out.println("</form>");
		 out.println("</body>");
		 out.println("</html>");
	}

}
