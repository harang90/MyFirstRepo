package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoardEntity;
import service.BoardService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/writer")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		// 1. 입력을 받는다.
		// 클라이언트로부터 입력받은 한글이 정상적으로 처리되기 위해서 한글처리를 해 주어요.
		
		request.setCharacterEncoding("UTF8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		// 2. 데이터를 입력받으면 이 데이터를 service 객체에게 넘겨줘서 로직처리를 해야 한다.
		// 이 데이터를 개별적으로 전달하는게 아니라 객체화 시켜서 전달.
		// DTO(Data Transfer Object)
		
		BoardEntity entity = new BoardEntity();
		entity.setArticleTitle(title);
		entity.setArticleWriter(author);
		entity.setArticleContent(content);
		entity.setArticleDate((new Date()).toLocaleString());
		
		// 3. 이렇게 만든 entity 객체를 이용해서 service 객체의 method를 호출
		BoardService service = new BoardService();
		
		boolean result = service.registerArticle(entity);
		
		// 4. 출력처리를 해야 합니다. html / jsp 이용가능
		
		// HTML은 고정된 내용으로 출력하고자 할 때
		// JSP는 결과에 따라 다른 내용을 출력하고자 할 때
		//성공일 경우 success.html 을 전달
		//실패일 경우 fail.html 을 전달
		
		if(result) {
			response.sendRedirect("success.html");
		} else
			response.sendRedirect("failure.html");
	}
}
