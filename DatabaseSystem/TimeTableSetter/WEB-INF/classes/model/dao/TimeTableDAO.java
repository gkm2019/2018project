package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.NumOfCourseDO;
import model.dto.TimeDO;

public class TimeTableDAO {
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


		public ArrayList<String> getTimeTableSetList(String stdID) {
			ConnectDB();
			ArrayList<NumOfCourseDO> NumOfCourseList = new ArrayList<NumOfCourseDO>();
			ArrayList<String> TimeTableSetList = new ArrayList<String>();
			try {
				//臾몄젣 �깮湲곕㈃ �뿬湲곗엫
				sql = "SELECT T.tID, COUNT(*), T.creditSum, T.numOfDay "
						+ "FROM timetable T "
						+ "JOIN student S ON T.stdID = S.stdID " // �씠嫄� 吏��슦硫� �맖
						+ "GROUP BY tID "
						+ "ORDER BY tID+0";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					NumOfCourseDO tmp = new NumOfCourseDO();
					tmp.settID(rs.getString("tID"));
					tmp.setNumOfCourse(rs.getInt("COUNT(*)"));
					tmp.setCreditSum(rs.getInt("creditSum"));
					tmp.setNumOfDay(rs.getInt("numOfDay"));
					NumOfCourseList.add(tmp);
				}
				
				for(int i=0; i<NumOfCourseList.size();i++) {
					sql = "SELECT cID FROM timetable "
							+ "WHERE stdID=? AND tID=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, stdID);
					pstmt.setString(2, NumOfCourseList.get(i).gettID());
					rs = pstmt.executeQuery();
					String tmp = "";
					tmp += NumOfCourseList.get(i).gettID();
					tmp += "," + Integer.toString(NumOfCourseList.get(i).getCreditSum());
					tmp += "," + Integer.toString(NumOfCourseList.get(i).getNumOfDay());
					tmp += ","+ Integer.toString(NumOfCourseList.get(i).getNumOfCourse());
					while(rs.next()) {		
						tmp += "," + rs.getString("cID");
					}
					TimeTableSetList.add(tmp);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				CloseDB();
			}
			
			return TimeTableSetList;
		}

	public ArrayList<TimeDO> getTimeTableSet(String cID) {
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

	public int InsertCartCheck(String stdID, String cList, String tID) {
		ConnectDB();
		ArrayList<NumOfCourseDO> NumOfCourseList = new ArrayList<NumOfCourseDO>();
		try {
			String[] cIDList = cList.split(",");
			sql = "SELECT tID, COUNT(*), creditSum, numOfDay "
					+ "FROM timetable "
					+ "GROUP BY tID "
					+ "ORDER BY tID";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NumOfCourseDO tmp = new NumOfCourseDO();
				tmp.settID(rs.getString("tID"));
				tmp.setNumOfCourse(rs.getInt("COUNT(*)"));
				tmp.setCreditSum(rs.getInt("creditSum"));
				tmp.setNumOfDay(rs.getInt("numOfDay"));
				NumOfCourseList.add(tmp);
			}
			
			for(int i=0; i<NumOfCourseList.size();i++) {
				sql = "SELECT cID FROM timetable "
						+ "WHERE stdID=? AND tID=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stdID);
				pstmt.setString(2, NumOfCourseList.get(i).gettID());
				rs = pstmt.executeQuery();
				String tmp1 = "";
				if(rs.next())
					tmp1 = rs.getString("cID");
				while(rs.next()) {		
					tmp1 += "," + rs.getString("cID");
				}
				if(tmp1.split(",").length == cIDList.length) {
					for(int j=0;j<cIDList.length;j++) {
						if(tmp1.contains(cIDList[j]))
							continue;
						else
							break;
					}
					return 0; //以묐났
				}
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}


	public int InsertCart(String stdID, String cList, String tID, int creditSum, int numOfDay) {
//		if(InsertCartCheck(stdID, cList, tID) == 0)
//			return 0; //�옣諛붽뎄�땲�뿉 �씠誘� 議댁옱�븷 寃쎌슦
		ConnectDB();


		try {	
			String[] tmp = cList.split(",");
			for(int i=0; i<tmp.length; i++) {
				sql = "INSERT INTO TimeTable (stdID, cID, tID, creditSum, numOfDay) "
						+ "VALUES( ?, ?, ?, ?, ? )";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stdID);
				pstmt.setString(2, tmp[i]);
				pstmt.setString(3, tID);
				pstmt.setInt(4, creditSum);
				pstmt.setInt(5, numOfDay);
				int n = pstmt.executeUpdate();
				if(n == 0)
					return 0; //以묐났
			}
			return 1; // �젙�긽�쟻�쑝濡� �뱾�뼱媛�
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}

	public int getLasttID(String stdID) {
		ConnectDB();

		try {	
			sql = "SELECT tID FROM timetable GROUP BY tID ORDER BY tID+0 DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				return Integer.parseInt(rs.getString("tID"));
			else
				return 1; // �옣諛붽뎄�땲 紐⑸줉�씠 �뾾�쓬
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1; // �뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
	
	public int DeleteCart(String stdID, String tID) {
		ConnectDB();
		try {
			sql = "DELETE FROM TimeTable WHERE stdID=? AND tID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdID);
			pstmt.setString(2, tID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return -1;
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
