package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.user.UserEntity;

public class UserDAO {
	public boolean select(UserEntity entity){
		boolean result = false;
		
		Connection con = common.DBTemplate.getConnection();
		
		String sql = "select uid,upw,uname,email from board_user where uid=? and upw=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = true;
			}
			else{
				result = false;
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
}
