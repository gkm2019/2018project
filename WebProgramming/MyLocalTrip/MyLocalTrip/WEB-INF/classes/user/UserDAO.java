package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL="SELECT userPassword FROM USER WHERE userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					System.out.println("로그인연결 성공");
					return 1;	//로그인 성공
				}
				else {
					System.out.println("비밀번호 틀림");
					return 0;	//비밀번호 틀림
				}
			}
			System.out.println("아이디 없음");
			return -1;			//아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return -2;	//데이터베이스 오류
	}
	
	public int Join(UserDTO user) {
		String SQL="INSERT INTO USER VALUES(?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserID());
			pstmt.setString(3,user.getUserPassword());
			pstmt.setString(4,user.getUserEmail());
			System.out.println("회원가입 성공");
			System.out.println("회원ID"+user.getUserID());
			System.out.println("회원PW"+user.getUserPassword());
			return pstmt.executeUpdate();	//성공적인 회원가입이 되면 1명이 추가된 것이기 때문에 1반환
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return -1;	//데이터베이스 오류, 회원가입 실패
	}
	
	public String getUserEmail(String userID) {
		String SQL="SELECT userEmail FROM USER WHERE userID = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return null;	//데이터베이스 오류
	}
	
	
	
	
}
