package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet(value = { "/bbs.list", "/bbs.insert", "/bbs.read" })
public class BBSServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dis = null;
		BBSDAO dao = new BBSDAO();
		switch (request.getServletPath()) {
		case "/bbs.list":
			int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int total = dao.total(); // 전체페이지 계산
			int totalPage = total % 5 == 0 ? total / 5 : (total / 5) + 1;
			int start = (page - 1) * 5;
			request.setAttribute("list", dao.list(start));
			request.setAttribute("page", page);
			request.setAttribute("totalPage", totalPage);
			dis = request.getRequestDispatcher("bbs/list.jsp");
			dis.forward(request, response);
			break;
		case "/bbs.insert":
			dis = request.getRequestDispatcher("bbs/insert.jsp");
			dis.forward(request, response);
			break;
		case "/bbs.read":
			String strSeqno = request.getParameter("seqno");
			int seqno = Integer.parseInt(strSeqno);
			request.setAttribute("vo", dao.read(seqno));
			dis = request.getRequestDispatcher("bbs/read.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BBSDAO dao = new BBSDAO();
		BBSVO vo = new BBSVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		switch (request.getServletPath()) {
		case "/bbs.insert":
			dao.insert(vo);
			break;
		}
		response.sendRedirect("list");
	}
}
