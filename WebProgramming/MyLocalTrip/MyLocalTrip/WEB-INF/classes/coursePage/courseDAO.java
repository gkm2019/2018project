package coursePage;

//jdbc import
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class courseDAO {

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
			System.out.println("course db ���� ����");
		}catch(Exception e) {
			//db�����۾��� �ݵ�� �ͼ��� ó��
			System.out.println("db connection fail!!");
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ڽ� ����Ʈ
	public ArrayList<courseDTO> courseList(){
		ArrayList<courseDTO> courselist = new ArrayList<courseDTO>();
		Connection conn=null; //db���� ��ü
		PreparedStatement pstmt = null; //sql���� ��ü
		ResultSet rs = null; //��� ó�� ��ü
		
		try {
			conn=dbConn(); //db����
			String sql = "select * from course_page";
			pstmt = conn.prepareStatement(sql); //sql�����Ű�� ��ü
			rs = pstmt.executeQuery(); //���� �� ��� ����
			
			while(rs.next()) {
				courseDTO dto = new courseDTO();
				dto.setCourseIDX(rs.getInt("course_idx"));
				dto.setCourseImage1(rs.getString("course_image1"));
				dto.setCourseImage2(rs.getString("course_image2"));
				dto.setCourseImage3(rs.getString("course_image3"));
				dto.setCourseName(rs.getString("course_name"));
				dto.setCourseThema(rs.getString("course_thema"));
				dto.setCourseInfo(rs.getString("course_info"));
				dto.setAreaIDX(rs.getInt("area_idx"));
				
				//ArrayList �� �߰�
				courselist.add(dto);
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
		
		return courselist;
	}
	
	
}
