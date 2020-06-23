package coursePage;

//jdbc import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class locationDAO {

	//db접속
	public Connection dbConn() {
		Connection conn=null; //db접속 객체
		
		try {
			//mysql jdbc driver 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//db연결 문자열 (보안 취약)
			String url="jdbc:mysql://localhost:3306/MyLocalTrip";
			String id = "root";
			String pw="kyeonggu9625";
			
			//db접속
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("location db 접속 성공");
		}catch(Exception e) {
			//db관련작업은 반드시 익셉션 처리
			System.out.println("location db connection fail!!");
			e.printStackTrace();
		}
		return conn;
	}
	
	//코스 리스트
	public ArrayList<locationDTO> locationList(){
		ArrayList<locationDTO> locationlist = new ArrayList<locationDTO>();
		Connection conn=null; //db접속 객체
		PreparedStatement pstmt = null; //sql실행 객체
		ResultSet rs = null; //결과 처리 객체
		
		try {
			conn=dbConn(); //db연결
			String sql = "select * from course_page_location";
			pstmt = conn.prepareStatement(sql); //sql실행시키는 객체
			rs = pstmt.executeQuery(); //실행 후 결과 저장
			
			while(rs.next()) {
				locationDTO dto = new locationDTO();
				dto.setCourseIDX(rs.getInt("course_idx"));
				dto.setLocationIDX(rs.getInt("location_idx"));
				dto.setLocationStep(rs.getString("location_step"));
				dto.setLocationImage1(rs.getString("location_image1"));
				dto.setLocationImage2(rs.getString("location_image2"));
				dto.setLocationImage3(rs.getString("location_image3"));
				dto.setLocationName(rs.getString("location_name"));
				dto.setLocationAddr(rs.getString("location_addr"));
				dto.setLocationTel(rs.getString("location_tel"));
				dto.setLocationInfo(rs.getString("location_info"));
				
				//ArrayList 에 추가
				locationlist.add(dto);
			}
		}catch (Exception e) {
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
		
		return locationlist;
	}
	
	
}
