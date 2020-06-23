package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.dto.CheckListDTO;
import model.dto.CourseInfoDTO;
import model.dao.CourseInfoDAO;

public class CheckListDAO {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="TimeTableSetter";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://localhost:3306/"+db+ST;
	
	String ID="root";
	String PW="kyeonggu9625";
	
	String sql=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	
	//��ü üũ����Ʈ ��� ��� ���� (��������, ���� ��, ����, ���� ����  | ���� ��, ���� ����)
	public ArrayList<CourseInfoDTO> CheckList(String ghGraduateYear,/*int chk_info,*/String section) {
		
		ConnectDB();
		ArrayList<CourseInfoDTO> list = new ArrayList<CourseInfoDTO>();
		
		//string -> int ����ȯ
		int ghGY = Integer.parseInt(ghGraduateYear);
		
		try {
			sql="select checklist.cID, cName, cCredit, cCredit_sub "+
			 		"from courseinfo "+
			 		"join checklist on courseinfo.cID=checklist.cID " +
			 		"where ghGraduateYear=? and checklist.section=?; ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ghGY);//�����δ� ghGraduateYear�� ����
			pstmt.setString(2, section);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CourseInfoDTO tmp = new CourseInfoDTO();
				tmp.setcID(rs.getString("cID"));
				tmp.setcName(rs.getString("cName"));
				tmp.setcCredit(rs.getInt("cCredit"));
				tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
				list.add(tmp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
		return list;
	}
	
	//����� �� üũ����Ʈ ���
	public ArrayList<CourseInfoDTO> UserCheckList(String ghGraduateYear, String section, String stdID) {
		ConnectDB();
		ArrayList<CourseInfoDTO> list = new ArrayList<CourseInfoDTO>();

			int ghGY = Integer.parseInt(ghGraduateYear);
			
			try {
				sql="select c.cID, c.cName, c.cCredit, c.cCredit_sub "+
				 		"from courseinfo as c "+
						"join userlist as ul on c.cID=ul.cID "+
				 		"join checklist as ch on ul.cID=ch.cID and ch.ghGraduateYear=ul.ghGraduateYear " + 
				 		"where ul.ghGraduateYear=? and ul.stdID=? and ch.section=?; ";

				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ghGY);
				pstmt.setString(2,stdID);
				pstmt.setString(3, section);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					CourseInfoDTO tmp = new CourseInfoDTO();
					tmp.setcID(rs.getString("cID"));
					tmp.setcName(rs.getString("cName"));
					tmp.setcCredit(rs.getInt("cCredit"));
					tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
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
