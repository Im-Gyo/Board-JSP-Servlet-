package com.Board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.Board.dto.BDto;

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
		
		try {	// ������ ����
			con = DriverManager.getConnection(url, user, pw);
			String query = "insert into mvc_Board2 (bName, bTitle, bContent, bHit, bStep, bIndent) values (?,?,?,0,0,0)"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int n = pstmt.executeUpdate();
				// �����ͻ���
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
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pw);
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bStep, bIndent, bStep asc";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

}
