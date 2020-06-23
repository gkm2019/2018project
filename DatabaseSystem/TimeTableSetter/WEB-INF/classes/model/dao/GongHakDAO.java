package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.CourseInfoDTO;
import model.dto.GongHakDTO;

public class GongHakDAO {
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
	
	public GongHakDTO GongHak(String ghGraduateYear){
		ConnectDB();
		GongHakDTO ghData = new GongHakDTO();
		
		int ghGY = Integer.parseInt(ghGraduateYear);
		
		try {
			sql="select * from GongHak "+
					"where ghGraduateYear=?";
					
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ghGraduateYear);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				ghGY = rs.getInt("ghGraduateYear");
				int ghGeneral = rs.getInt("ghGeneral");
				int ghEssential = rs.getInt("ghEssential");
				int ghEssential_sub = rs.getInt("ghEssential_sub");
				int ghOption = rs.getInt("ghOption");
				int ghOption_sub = rs.getInt("ghOption_sub");
				
				ghData.setGhGeneral(ghGeneral);
				ghData.setGhEssential(ghEssential);
				ghData.setGhEssential_sub(ghEssential_sub);
				ghData.setGhOption(ghOption);
				ghData.setGhOption_sub(ghOption_sub);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return ghData;
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
