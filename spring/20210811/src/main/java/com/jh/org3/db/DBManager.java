package com.jh.org3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBManager {
	
	public void test(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 이 클래스 파일이 없으면 catch 구믄으로 진행
			// 이 클래스 파일이 있으면 다음줄 진행
			// port 내선 번호
			// ip 전화 번호
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jh","root","1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!= null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insert(String para1, String para2) {
		String sql = "insert into test values ('"+para1+"','"+para2+"')";
		test(sql);
	}
	public void delete(String para1) {
		String sql = "delete from test where para1='"+para1+"'";
		test(sql);
	}
	public void update(String para1, String para2, String para3) {
		String sql = "UPDATE test SET para1 = '"+para2+"', country = '"+para3+"' WHERE para1='"+para1+"'";
		test(sql);
	}
}
