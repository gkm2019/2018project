package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.UserListDTO;

public class UserListDAO {

	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="TimeTableSetter";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://localhost:3306/"+db+ST;
	
	String ID="root";
	String PW="kyeonggu9625";
	
	String sql=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	//사용자별 체크리스트 저장
	public void SaveCheckList(String stdID, String ghGraduateYear, String cID) {
		
		ConnectDB();
		
		//string -> int 형변환
		int ghGY = Integer.parseInt(ghGraduateYear);
		System.out.println("UserListDAO  //ghGraduateYear="+ghGraduateYear);
		System.out.println("UserListDAO  //stdID"+stdID);
		System.out.println("UserListDAO  // cID="+cID);
		
		if((cID!=null)&&(stdID!=null)&&(ghGraduateYear!=null))
		try{
				sql="insert into userlist(stdID, ghGraduateYear, cID, whether) "
					+ "values (?, ?, ?, 1);";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,stdID);
			pstmt.setInt(2,ghGY);
			pstmt.setString(1,stdID);
			pstmt.setInt(2, ghGY);
			pstmt.setString(3,cID);
			int n = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserListDAO null 값이 존재합니다.");
		}finally {
				CloseDB();
		}
	}
	
	void ConnectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(URL,ID,PW);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void CloseDB() {
		if(pstmt!=null)
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		if(conn !=null)
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}