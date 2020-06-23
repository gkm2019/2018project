package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.StudentDO;

public class StudentDAO {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="TimeTableSetter";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://localhost:3306/"+db+ST;
	
	//본인 mysql ID,PW로 수정해야됨
	String ID = "root";
	String PW = "kyeonggu9625";

	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int Login(String ID, String PW) {
		ConnectDB();
		int check = -1;

		try {
			sql = "SELECT stdPW FROM Student WHERE stdID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				if(rs.getString("stdPW").equals(PW))
					check = 1;
				else
					check = 0;
			}
			else
				check = -1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return check;
	}
	
	public int Join(String ID, String NAME, String PW) {
		ConnectDB();
		int check = -1;

		try {
			sql = "insert into student(stdID, stdName, stdPW) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, NAME);
			pstmt.setString(3,PW);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				if(rs.getString("stdPW").equals(null))
					check = 1;
				else
					check = 0;
			}
			else
				check = -1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return check;
	}

	public ArrayList<StudentDO> StudentList(){
		ConnectDB();

		ArrayList<StudentDO> list = new ArrayList<StudentDO>();

		try {
			sql = "SELECT * FROM Student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				StudentDO tmp = new StudentDO();
				tmp.setStdID(rs.getString("stdID"));
				tmp.setStdName(rs.getString("stdName"));
				tmp.setStdGrade(rs.getInt("stdGrade"));
				tmp.setStdGraduateYear(rs.getInt("stdGraduateYear"));
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
