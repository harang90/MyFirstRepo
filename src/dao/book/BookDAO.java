package dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.book.BookEntity;

public class BookDAO {
	
	public ArrayList<BookEntity> search (String keyword){
		ArrayList<BookEntity> result = new ArrayList<BookEntity>();
		
		Connection con = common.DBTemplate.getConnection();
		
		String sql = "SELECT * FROM books WHERE btitle LIKE ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BookEntity entity = new BookEntity();
				entity.setBimgurl(rs.getString("bimgurl"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBprice(rs.getInt("bprice"));
				result.add(entity);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<BookEntity> isbnSearch(String[] list) {
		// TODO Auto-generated method stub
		ArrayList<BookEntity> result = new ArrayList<BookEntity>();
		
		Connection con = common.DBTemplate.getConnection();
		
		int i=0;
		String isbn;
		
		String sql = "select * from books where bisbn = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			while(!(list[i].isEmpty())){
				isbn = list[i];	
				pstmt.setString(1, isbn);
				ResultSet rs = pstmt.executeQuery();	
				BookEntity entity = new BookEntity();
				entity.setBimgurl(rs.getString("bimgurl"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBprice(rs.getInt("bprice"));
				result.add(entity);
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return result;
	}
}