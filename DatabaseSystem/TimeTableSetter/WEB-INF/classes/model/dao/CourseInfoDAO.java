package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.CourseInfoDTO;

public class CourseInfoDAO {
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
	
	
	public ArrayList<CourseInfoDTO> CourseInfo(){
		ConnectDB();
		ArrayList<CourseInfoDTO> list = new ArrayList<CourseInfoDTO>();
		
		try {
			sql="select * from courseinfo ";
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CourseInfoDTO tmp = new CourseInfoDTO();
				tmp.setcID(rs.getString("cID"));
				tmp.setcName(rs.getString("cName"));
				tmp.setcProfessor(rs.getString("cProfessor"));
				tmp.setcGrade(rs.getInt("cGrade"));
				tmp.setcCredit(rs.getInt("cCredit"));
				tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
				tmp.setLimit_per(rs.getInt("limit_per"));
				tmp.setSection(rs.getString("section"));
				
				list.add(tmp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return list;
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
