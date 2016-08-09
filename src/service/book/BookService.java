package service.book;

import java.util.ArrayList;

import dao.book.BookDAO;
import entity.book.BookEntity;

public class BookService {
	
	public BookService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<BookEntity> search (String keyword){
		
		BookDAO dao = new BookDAO();
		ArrayList<BookEntity> result = dao.search(keyword);
		return result;
	}
	
	public ArrayList<BookEntity> listCart(String[] list) {
		// TODO Auto-generated method stub
		
		BookDAO dao = new BookDAO();
		ArrayList<BookEntity> result = dao.isbnSearch(list);
		
		return result;
	}
}
