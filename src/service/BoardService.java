package service;

import java.util.ArrayList;

import dao.BoardDAO;
import entity.BoardEntity;

public class BoardService {
	
	public BoardService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean login(String id,String pw){
		boolean result = false;
		
		BoardDAO dao = new BoardDAO();
		result = dao.select(id,pw);
		
		return result;
	}
	
	public boolean delete(BoardEntity entity){
		boolean result = false;
		
		BoardDAO dao = new BoardDAO();
		result = dao.delete(entity);
		
		return result;
	}
	
	public boolean registerArticle(BoardEntity entity) {
		
		//로직처리 (데이터베이스에 글을 등록)
		//정상처리 되었으면 true return
		boolean result = false;
		// 지금 우리 코드는 별다른 로직이 없고 DB처리만 있다.
		// Database 처리를 해야 하는데 DAO를 이용해서 처리.
		// DAO를 만들기 위해서 DAO class를 작성
		BoardDAO dao = new BoardDAO();
		result = dao.insert(entity);
		
		return result;
	}
	
	
	// 글 목록에 대한 ArrayList를 가져오는 business method
	public ArrayList<BoardEntity> list(){
		
		//로직처리
		
		//DB처리
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardEntity> result = dao.select();
		
		return result;
	}
}
