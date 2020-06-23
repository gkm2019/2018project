package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CourseCartDO;
import model.dto.CourseInfoDO;
import model.dto.TimeDO;
import util.TTParser;

public class CourseCartDAO {
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
	
	TimeDAO tdao = new TimeDAO();
	String cTime = "";
	TTParser parser = new TTParser();

	public int InsertCartCheck(String stdID, String cID) {
		ConnectDB();
		try {
			sql = "Select * FROM CourseCart WHERE stdID=? AND cID=?";
			//sql = "INSERT INTO CourseCart VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdID);
			pstmt.setString(2, cID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 0; //�씠誘� �옣諛붽뎄�땲�뿉 議댁옱
			}
			else {
				return 1; //�옣諛붽뎄�땲�뿉 �젙�긽�쟻�쑝濡� �뱾�뼱媛�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	
	public int InsertCart(String stdID, String cID) {
		if(InsertCartCheck(stdID, cID) == 0)
			return 0; //�옣諛붽뎄�땲�뿉 �씠誘� 議댁옱�븷 寃쎌슦
		ConnectDB();
		try {	
			sql = "INSERT INTO CourseCart (stdID, cID) "
					+ "SELECT ?, ? FROM DUAL "
					+ "WHERE NOT EXISTS(SELECT * FROM CourseCart WHERE stdID=? AND cID=?)";
			
			//sql = "INSERT INTO CourseCart VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdID);
			pstmt.setString(2, cID);
			pstmt.setString(3, stdID);
			pstmt.setString(4, cID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	
	public int DeleteCart(String stdID, String cID) {
		ConnectDB();
		try {
			sql = "DELETE FROM CourseCart WHERE stdID=? AND cID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdID);
			pstmt.setString(2, cID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1;
	}
	
	//�쟾泥� 由ъ뒪�듃 read
		public ArrayList<CourseInfoDO> getCartList(String stdID){
			ConnectDB();

			ArrayList<CourseInfoDO> CartList = new ArrayList<CourseInfoDO>();

			try {
				sql = "SELECT * FROM CourseInfo CI "
						+ "JOIN CourseCart CC ON CI.cID = CC.cID "
						+ "WHERE CC.stdID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stdID);
				ResultSet rs = pstmt.executeQuery();

				while(rs.next()) {
					CourseInfoDO tmp = new CourseInfoDO();
					tmp.setcID(rs.getString("cID"));
					tmp.setcName(rs.getString("cName"));
					tmp.setcProfessor(rs.getString("cProfessor"));				
					tmp.setcGrade(rs.getInt("cGrade"));
					tmp.setcCredit(rs.getInt("cCredit"));
					tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
					tmp.setcDepartment(rs.getString("cDepartment"));
					tmp.setcDiv(rs.getString("cDiv"));
					tmp.setcSubDiv(rs.getString("cSubDiv"));
					tmp.setSection(rs.getString("cSection"));
					tmp.setLimit_per(rs.getString("limit_per"));
					ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
					cTime = parser.MakecTime(cTimeList);
					tmp.setcTime(cTime);
					tmp.setTime(parser.MakeTime(cTimeList));
					CartList.add(tmp);
				}
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				CloseDB();
			}
			return CartList;
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
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
