package candidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class CandidateDAO {
	
	public Connection dbConn() {
	
		Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/candidate";
		String id= "root";
		String pw="kyeonggu9625";
		
		conn=DriverManager.getConnection(url, id, pw);
		System.out.println("db success");
	}catch(Exception e) {
		System.out.println("db fail");
		e.printStackTrace();
	}
	
	return conn;
}
	public ArrayList<CandidateDTO> candiList(){
		ArrayList<CandidateDTO> candilist = new ArrayList<CandidateDTO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try {
			conn=dbConn();
			String sql = "select * from candi";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CandidateDTO dto = new CandidateDTO();
				dto.setAreaIDX(rs.getInt("area_idx"));
				dto.setCandiIDX(rs.getInt("candi_idx"));
				dto.setCandiImage(rs.getString("candi_image"));
				dto.setCandiName(rs.getString("candi_name"));
				dto.setCandiNum(rs.getInt("candi_num"));
				dto.setCandiBirth(rs.getString("candi_birth"));
				dto.setCandiJD(rs.getString("candi_JD"));
				dto.setCandiCommit(rs.getString("candi_commit"));
				dto.setCandiCommit2(rs.getString("candi_commit2"));
				dto.setCandiCommit3(rs.getString("candi_commit3"));
				dto.setCandiCommit4(rs.getString("candi_commit4"));
				dto.setCandiCommit5(rs.getString("candi_commit5"));
				
				candilist.add(dto); //ArrayList�� �߰�
			}
		}catch(Exception e) {
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
		
		return candilist;
		}
	
	//���ϴ� �����͸� �������� ���� �Լ� (������ �ش��ϴ� �ĺ��ڸ� ���� ����)
	public CandidateDTO getAreaIDX(int area_idx) {
		Connection conn=null;
		ResultSet rs= null;
		
		String sql = "select * from candi where area_idx = ?";
		try {
			conn=dbConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, area_idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				CandidateDTO dto = new CandidateDTO();
				dto.setAreaIDX(rs.getInt("area_idx"));
				dto.setCandiIDX(rs.getInt("candi_idx"));
				dto.setCandiImage(rs.getString("candi_image"));
				dto.setCandiName(rs.getString("candi_name"));
				dto.setCandiNum(rs.getInt("candi_num"));
				dto.setCandiBirth(rs.getString("candi_birth"));
				dto.setCandiJD(rs.getString("candi_JD"));
				dto.setCandiCommit(rs.getString("candi_commit"));
				dto.setCandiCommit2(rs.getString("candi_commit2"));
				dto.setCandiCommit3(rs.getString("candi_commit3"));
				dto.setCandiCommit4(rs.getString("candi_commit4"));
				dto.setCandiCommit5(rs.getString("candi_commit5"));
				return dto;  //���������� �״�� �����´�. (���� ����Ʈ �ҷ������ �޶�!!)
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;  //���н� null��ȯ
	}
	
	
	
}