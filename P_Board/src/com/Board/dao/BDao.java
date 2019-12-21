package com.Board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BDao {
	/* Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet; */
	
	private String url = "jdbc:mysql://localhost:3306/gyodb?useSSL=false&useUnicode=true&characterEncoding=euckr";
	private String classname = "org.gjt.mm.mysql.Driver";
	private String user = "root";
	private String pw = "1234";
	
	public BDao() {
		try {
			Class.forName(classname);			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void write(String bName, String bTitle, String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {	// µ•¿Ã≈Õ ª¿‘
			con = DriverManager.getConnection(url, user, pw);
			String query = "insert into mvc_Board2 (bName, bTitle, bContent, bHit, bStep, bIndent) values (?,?,?,0,0,0)"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int n = pstmt.executeUpdate();
				// µ•¿Ã≈Õª¿‘
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
