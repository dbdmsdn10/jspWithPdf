package book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(value = { "/book.list", "/book.insert", "/book.delete", "/book.update", "/book.read", "/book/cart" })
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
			response.sendRedirect("book.list");
			break;
		case "/book/cart":
			 dis=request.getRequestDispatcher("listCart.jsp");
			 dis.forward(request, response);
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
			vo.setCode(request.getParameter("code"));
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			String price = request.getParameter("price");
			vo.setPrice(price);
			dao.insert(vo);
			break;
		case "/book.update":
			vo.setCode(request.getParameter("code"));
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			price = request.getParameter("price");
			vo.setPrice(price);
			dao.update(vo);
			break;
		case "/book/cart":
			 String code=request.getParameter("code");
			 vo=dao.read(code);
			 CartVO cartVO=new CartVO();
			 cartVO.setCode(vo.getCode());
			 cartVO.setTitle(vo.getTitle());
			 cartVO.setPrice(vo.getPrice());
			 cartVO.setWriter(vo.getWriter());
			 cartVO.setNumber(1);
			 HttpSession session=request.getSession();
			 ArrayList<CartVO> listCart=(ArrayList<CartVO>)session.getAttribute("listCart");
			 //세션에 listCart가 존재하는 경우
			 if(listCart!=null) {
			 boolean find=false;
			 for(CartVO cart:listCart) {
			 //listCart에서 code값이 일치하는 경우 수량을 1증가
			 if(cart.getCode().equals(code)) {
			 cart.setNumber(cart.getNumber() + 1);
			find=true;
			 }
			 }
			 //listCart에 code값이 없는 경우
			 if(find==false) {
			 listCart.add(cartVO);
			 }
			 //세션에 listCart가 존재하지 않는 경우
			 }else {
			 listCart=new ArrayList<CartVO>();
			 listCart.add(cartVO);
			 }
			 session.setAttribute("listCart", listCart);
			 break;
		}
		response.sendRedirect("book.list");
	}
}