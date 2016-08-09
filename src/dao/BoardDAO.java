package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.BoardEntity;

public class BoardDAO {
	
	public boolean select(String id, String pw){
		
		boolean result = false;
		
		try {
			
			Connection con = common.DBTemplate.getConnection();
			String sql = "select * from board_user where uId = ? and uPw = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = true;
			} else{
				result = false;
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return result;
	}

	public boolean delete(BoardEntity entity){
		
		boolean result = false;
		int number;
		
		try {
			Connection con = common.DBTemplate.getConnection();
			
			String sql = "delete from board where articleNum = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			number = entity.getArticleNum();
			pstmt.setInt(1, number);
			
			int count = pstmt.executeUpdate();
			if(count > 0){
				result = true;
			} else {
				result = false;
			}
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	
	public ArrayList<BoardEntity> select(){
		
		ArrayList<BoardEntity> result = new ArrayList<BoardEntity>();
		
		try {
			Connection con = common.DBTemplate.getConnection();
			
			String sql = "select * from board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 결과처리
			
			while(rs.next()){
				BoardEntity entity = new BoardEntity();
				entity.setArticleNum(rs.getInt("articleNum"));
				entity.setArticleTitle(rs.getString("articleTitle"));
				entity.setArticleWriter(rs.getString("articleWriter"));
				entity.setArticleDate(rs.getString("articleDate"));
				result.add(entity);
			}
			
			// 6. 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	
	// Database Table에 글 내용을 입력하는 method
	
	public boolean insert(BoardEntity entity){
		boolean result = false;
		
		// Database처리를 위해 JDBC code가 나오게 된다.
		// 기본적으로 JDBC를 사용하기 위해서는
		// 사용하려는 Database에 맞는 Driver class가 필요.
		
		try {
			Connection con = common.DBTemplate.getConnection();
			
			String sql = "select MAX(articleNum) from board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int num = rs.getInt(1) + 1;
			
			sql = "insert into board values (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, entity.getArticleTitle());
			pstmt.setString(3, entity.getArticleContent());
			pstmt.setString(4, entity.getArticleWriter());
			pstmt.setString(5, entity.getArticleDate());
			
			int count = pstmt.executeUpdate();
			if(count == 1){
				result = true;
				con.commit();
			} else {
				result = false;
				con.rollback();
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return result;
	}
}
