

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonalInfoServlet
 */
@WebServlet("/PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
//		PrintWriter out=response.getWriter();
//		String name=request.getParameter("name");
//		String id=request.getParameter("id");
//		String password=request.getParameter("password");
//		String gender=request.getParameter("gender");
//		
//		String iNotice=request.getParameter("iNotice");
//		String cNotice=request.getParameter("cNotice");
//		String dNotice=request.getParameter("dNotice");
//		String job=request.getParameter("job");
//		
//		out.println("<html>");
//		out.println("<head><title>개인정보입력-결과화면</title></head>");
//		out.println("<body>");
//		out.println("<h2>개인정보입력</h2>");
//		out.println("이름"+name+"<br>");
//		out.println("아이디"+id+"<br>");
//		out.println("비밀번호"+password+"<br>");
//		out.println("성별"+gender+"<br>");
//		
//		out.println("공지메일"+iNotice+"<br>");
//		out.println("광고메일"+cNotice+"<br>");
//		out.println("배송확인메일"+dNotice+"<br>");
//		out.println("직업"+job+"<br>");
//		out.println("</body>");
//		out.println("</html>");
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");// 이것과 아래것은 이 java에 있는것 출력할때
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");// 이건 서버에 있는값을 가져올때 사용
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		
		String iNotice=request.getParameter("iNotice");
		String cNotice=request.getParameter("cNotice");
		String dNotice=request.getParameter("dNotice");
		String job=request.getParameter("job");
		
		out.println("<html>");
		out.println("<head><title>개인정보입력-결과화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인정보입력</h2>");
		out.println("이름"+name+"<br>");
		out.println("아이디"+id+"<br>");
		out.println("비밀번호"+password+"<br>");
		out.println("성별"+gender+"<br>");
		
		out.println("공지메일"+iNotice+"<br>");
		out.println("광고메일"+cNotice+"<br>");
		out.println("배송확인메일"+dNotice+"<br>");
		out.println("직업"+job+"<br>");
		out.println("</body>");
		out.println("</html>");
	}


}
