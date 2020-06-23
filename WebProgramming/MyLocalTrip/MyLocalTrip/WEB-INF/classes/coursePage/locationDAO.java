package coursePage;

//jdbc import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class locationDAO {

	//db����
	public Connection dbConn() {
		Connection conn=null; //db���� ��ü
		
		try {
			//mysql jdbc driver �ε�
			Class.forName("com.mysql.jdbc.Driver");
			
			//db���� ���ڿ� (���� ���)
			String url="jdbc:mysql://localhost:3306/MyLocalTrip";
			String id = "root";
			String pw="kyeonggu9625";
			
			//db����
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("location db ���� ����");
		}catch(Exception e) {
			//db�����۾��� �ݵ�� �ͼ��� ó��
			System.out.println("location db connection fail!!");
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ڽ� ����Ʈ
	public ArrayList<locationDTO> locationList(){
		ArrayList<locationDTO> locationlist = new ArrayList<locationDTO>();
		Connection conn=null; //db���� ��ü
		PreparedStatement pstmt = null; //sql���� ��ü
		ResultSet rs = null; //��� ó�� ��ü
		
		try {
			conn=dbConn(); //db����
			String sql = "select * from course_page_location";
			pstmt = conn.prepareStatement(sql); //sql�����Ű�� ��ü
			rs = pstmt.executeQuery(); //���� �� ��� ����
			
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
				
				//ArrayList �� �߰�
				locationlist.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {  //������ �������� �ݱ��۾�
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
