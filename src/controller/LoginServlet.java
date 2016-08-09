package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user.UserEntity;
import service.user.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		//POST 방식에서만 사용 할 수 있다
		//GET 방식의 경우 프로그램보다 tomcat 환경에서 처리하는게 좋다
		
		// 1.입력 받기
		
		
		String id = request.getParameter("uid");
		String pw = request.getParameter("upw");
		
		// 2. 로직처리 하기	
		// user에 대한 entity를 만들어서 인자로 이용.
		UserEntity entity = new UserEntity();
		entity.setUid(id);
		entity.setUpw(pw);
		
		// 로그인이 성공하면 true 실패하면 false
		UserService service = new UserService();
		boolean result = service.login(entity);
		result = true;
		// 3. 뷰 처리
		RequestDispatcher rd = request.getRequestDispatcher("loginResult.jsp");
		if(result){
			// 로그인에 성공하면
			// 다시 접속하라고 클라이언트에게 응답을 주는 것이다
			
			// 로그인에 성공 햇으니까 해당 클라이언트에게 session 객체를 할 당해요.
			HttpSession session = request.getSession(true);
			// 만약 이전에 사용하던 세션 객체가 존재하면 만들지 말고 그거 들고와.
			session.setAttribute("USERID",id);
			
			//request.setAttribute("msg",id+"님 환영합니다.");
			request.setAttribute("flag",true);
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "로그인에 실패했어요. 다시 로그인 하세요!");
			request.setAttribute("flag",false);
			rd.forward(request, response);
		}
	}
}