package book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(value = { "/book.list", "/book.insert", "/book.delete", "/book.update", "/book.read" })
public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = null;
		BookDAO dao = new BookDAO();
		switch (request.getServletPath()) {
		case "/book.list":
			 String key=request.getParameter("key")==null?"code":request.getParameter("key");
			 String word=request.getParameter("word")==null?"":request.getParameter("word");
			 String strPage=request.getParameter("page")==null?"1":request.getParameter("page");
			 int page=Integer.parseInt(strPage);
			 int count = dao.count(key, word);
			 int totPage=count%5==0?count/5:(count/5)+1;
			 request.setAttribute("count", count);
			 request.setAttribute("totPage", totPage);
			 request.setAttribute("page", page);
			 request.setAttribute("key", key);
			 request.setAttribute("word", word);
			 request.setAttribute("list", dao.list(key, word, page));
			 dis=request.getRequestDispatcher("book/list.jsp");
			 dis.forward(request, response);
			 break;
		case "/book.insert":
			dis = request.getRequestDispatcher("book/insert.jsp");
			dis.forward(request, response);
			break;
		case "/book.read":
			String code = request.getParameter("code");
			BookVO vo = dao.read(code);
			request.setAttribute("vo", vo);
			dis = request.getRequestDispatcher("book/read.jsp");
			dis.forward(request, response);
			break;
		case "/book.delete":
			code = request.getParameter("code");
			dao.delete(code);
			response.sendRedirect("list");
			break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		switch (request.getServletPath()) {
		case "/book.insert":
			dao.insert(vo);
			break;
		case "/book.update":
			vo.setCode(request.getParameter("code"));
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			String price = request.getParameter("price");
			vo.setPrice(price);
			dao.update(vo);
			break;
		}
		response.sendRedirect("list");
	}
}