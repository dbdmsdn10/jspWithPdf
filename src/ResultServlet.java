
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String food = (String) session.getAttribute("food");
		String animal = request.getParameter("animal");
		session.invalidate(); // 세션을 종료한다.
		out.println("<head><title>성격 테스트</title></head>");
		out.println("<body>");
		out.println("<h3>성격 테스트</h3>");
		out.printf("당신은 %s와 %s를 좋아하는 성격입니다.", food, animal);
		out.println("</body>");
		out.println("</html>");

	}

}
