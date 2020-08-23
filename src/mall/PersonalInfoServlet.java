package mall;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mall.PersonalInfoServlet")
public class PersonalInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		 PersonalInfo obj = new PersonalInfo();
		 obj.setName("이정호");
		 obj.setGender('남');
		 obj.setAge(24);
		 request.setAttribute("pinfo", obj);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerViewer.jsp");
		 dispatcher.forward(request, response);
		 }

}
