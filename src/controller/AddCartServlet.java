package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF8");
		String[] list = request.getParameterValues("checkBook");
		// 이 배열안에 현재 선택한 책의 ISBN 번호가 들어가 있다
		// 3. 서비스를 만들어서 로지거리를 한다.
		// session을 이용해서 이 안에 사용자가 선택한 책의 정보를 저장
		// session은 sevlet에서만 사용 할 수 있다
		// 그래서 결국 이 안에서 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("Cart", list);
		response.sendRedirect(cart);
	}

}
