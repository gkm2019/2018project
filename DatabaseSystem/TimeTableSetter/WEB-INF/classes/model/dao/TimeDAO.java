package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.TimeDO;

public class TimeDAO {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="TimeTableSetter";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://localhost:3306/"+db+ST;
	
	//蹂몄씤 mysql ID,PW濡� �닔�젙�빐�빞�맖
	String ID = "root";
	String PW = "kyeonggu9625";

	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<TimeDO> getCourseTime(String cID) {
		ConnectDB();
		ArrayList<TimeDO> courseTime = new ArrayList<TimeDO>();
		try {
			sql = "SELECT T.cID,T.cTime, T.cRoom FROM courseinfo C "
					+ "JOIN coursetime T ON C.cid=T.cID "
					+ "WHERE C.cID=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TimeDO tmp = new TimeDO();
				tmp.setcID(rs.getString("cID"));
				tmp.setcTime(rs.getString("cTime"));
				tmp.setcRoom(rs.getString("cRoom"));
				courseTime.add(tmp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return courseTime;
	}
	
	void ConnectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, ID, PW);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void CloseDB() {
		if(pstmt != null)
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

		if(conn != null)
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}


}
