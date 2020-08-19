

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/BBSPostServlet")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		out.println("<html>");
		out.println("<head><title>게시판 글쓰기-결과화면</title></head>");
		out.println("<body>");
		out.printf("이름: %s <br>",name);
		out.printf("제목: %s <br>",title);
		out.println("-------------<br>");
		out.printf("<pre>%s</pre>",content);
		out.println("-------------<br>");
		out.println("저장되었습니다");
		out.println("</body>");
		out.println("</html>");
	}

}
