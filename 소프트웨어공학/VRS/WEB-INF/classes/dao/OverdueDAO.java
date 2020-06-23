package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.OverdueDTO;

public class OverdueDAO {
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
	
	public ArrayList<OverdueDTO> list(){
		ArrayList<OverdueDTO> list = new ArrayList<OverdueDTO>();
		ConnectDB();
		
		try {
			sql = "select cid, vnum, vname, overdueday "
					+ "from overdue";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cid = rs.getString("cid");
				String vnum = rs.getString("vnum");
				String vname = rs.getString("vname");
				String overdueday = rs.getString("overdueday");
				
				OverdueDTO data = new OverdueDTO();
				data.setCid(cid);
				data.setVnum(vnum);
				data.setVname(vname);
				data.setOverdueday(overdueday);
				list.add(data);
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
