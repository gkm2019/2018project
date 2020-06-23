package candidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class areaDAO {

	public Connection dbConn() {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/candidate";
			String id="root";
			String pw="kyeonggu9625";
			
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("db  success");
		}catch(Exception e) {
			System.out.println("=========areaDAO db fail============");
			e.printStackTrace();
		}
		return conn;
	}
	public ArrayList<areaDTO> areaList(){
		ArrayList<areaDTO> arealist = new ArrayList<areaDTO>();
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=dbConn();
			String sql = "select * from area";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				areaDTO dto = new areaDTO();
				dto.setAreaIDX(rs.getInt("area_idx"));
				dto.setAreaName(rs.getString("area_name"));
				dto.setAreaCandiTotal(rs.getInt("candi_total"));
				arealist.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {  //오픈한 역순으로 닫기작업
			//result=> statement=> connection
			
			try {
				if(rs!=null) {rs.close();}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(pstmt!=null) {pstmt.close();}
			}catch(Exception e2) {e2.printStackTrace();}
			
			try {
				if(conn!=null) {conn.close();}
			}catch(Exception e2) {e2.printStackTrace();}
		}
		
		return arealist;
		}
}

