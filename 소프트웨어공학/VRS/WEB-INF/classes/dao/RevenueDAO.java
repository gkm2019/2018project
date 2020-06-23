package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RevenueDAO {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="VRS";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://172.20.10.8:3306/"+db+ST;
	
	//본인 mysql ID,PW로 수정해야됨
	String ID = "root";
	String PW = "root";
	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int income() {
		ConnectDB();
		String tmp = null;
		int tmpInt = 0;
		int price = 0;
		
		try {
			sql = "select videolist.vprice "
					+ "from videolist "
					+ "join rent, video "
					+ "where rent.vnum=video.vnum and "
					+ "videolist.vlistnum=video.vlistnum";
		
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tmp = rs.getString("vprice");
				tmpInt = Integer.parseInt(tmp);
				price+=tmpInt;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return price;
	}
	
	public int expenditure() {
		ConnectDB();
		String count = null;
		String price = null;
		int countInt = 0;
		int priceInt = 0;
		int tmp = 0;
		int total = 0;
		
		try {
			sql = "select count, price "
					+ "from ordervideo ";
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				price = rs.getString("price");
				count = rs.getString("count");
				priceInt = Integer.parseInt(price);
				countInt = Integer.parseInt(count);
				tmp = priceInt*countInt;
				total +=tmp;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}

		return total;
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
