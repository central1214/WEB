package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.*;

import util.DatabaseUtil;
//Data Access Object
//데이터에 접근하는 객체
public class UserDAO {
	Connection conn = DatabaseUtil.getConnection();
	ResultSet rs;

	public int join(String userID, String userPassword, String email, String nickName) {
		String SQL = "INSERT INTO sys.userTbl VALUES (?,?,?,?)";
		try {
// 각각의 데이터를 실제로 넣어준다. 
			PreparedStatement pstmt = conn.prepareStatement(SQL);
// 쿼리문의 ?안에 각각의 데이터를 넣어준다. 
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, nickName);
			pstmt.setString(4, email);
// 명령어를 수행한 결과 반환, 반환값: insert가 된 데이터의 개수 
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("BBBBBBBBBBBB");
			e.printStackTrace();
		}
		return -1;
	}
	public boolean searchID(String userID) {
		String SQL = "SELECT * FROM sys.userTBl WHERE USERID='"+ userID + "'";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			return rs.next();
		} catch(Exception e) {
			
		}
		return false;
	}
	public boolean loginSign(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM sys.userTBl WHERE USERID='"+ userID + "'";
		try {
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(SQL);
		while(rs.next()) {
			String password = rs.getString(1);
			if(password.equals(userPassword)) {
				return true;
			}
		}
		
		} catch(Exception e) {
			
		}
		return false;
	}
	public void setUserInfo(UserDTO userDTO) {
		String SQL = "SELECT * FROM sys.userTBl WHERE USERID='"+ userDTO.getUserID() + "'";
		try {
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(SQL);
		while(rs.next()) {
			userDTO.setUserPassword(rs.getString(2));
			userDTO.setNickName(rs.getString(3));
			userDTO.setEmail(rs.getString(4));
		}
		
		} catch(Exception e) {
			
		}
		
	}
}

//출처: https://icandooit.tistory.com/104 [i can do "IT"]