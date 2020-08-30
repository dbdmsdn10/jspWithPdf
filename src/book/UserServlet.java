package book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(value = { "/user.login", "/user.logout", "/user.insert" })
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/user.logout":
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/servletAndroid/index.jsp");
			break;
		case "/user.insert":
			 response.sendRedirect("insert.jsp");
			 break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		switch (request.getServletPath()) {
		case "/user.login":
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			vo = dao.read(id, password);
			JSONObject jObject = new JSONObject();
			jObject.put("id", vo.getId());
			out.println(jObject);
			HttpSession session = request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			break;
		case "/user.insert":
			 vo.setId(request.getParameter("id"));
			 vo.setPassword(request.getParameter("password"));
			 vo.setName(request.getParameter("name"));
			 dao.insert(vo);
			 session=request.getSession();
			 session.setAttribute("id", vo.getId());
			 session.setAttribute("name", vo.getName());
			 break;
		}
		response.sendRedirect("/servletAndroid/index.jsp");
	}

}
