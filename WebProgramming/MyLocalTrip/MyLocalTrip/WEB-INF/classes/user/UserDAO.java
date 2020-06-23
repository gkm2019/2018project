package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL="SELECT userPassword FROM USER WHERE userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					System.out.println("�α��ο��� ����");
					return 1;	//�α��� ����
				}
				else {
					System.out.println("��й�ȣ Ʋ��");
					return 0;	//��й�ȣ Ʋ��
				}
			}
			System.out.println("���̵� ����");
			return -1;			//���̵� ����
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return -2;	//�����ͺ��̽� ����
	}
	
	public int Join(UserDTO user) {
		String SQL="INSERT INTO USER VALUES(?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserID());
			pstmt.setString(3,user.getUserPassword());
			pstmt.setString(4,user.getUserEmail());
			System.out.println("ȸ������ ����");
			System.out.println("ȸ��ID"+user.getUserID());
			System.out.println("ȸ��PW"+user.getUserPassword());
			return pstmt.executeUpdate();	//�������� ȸ�������� �Ǹ� 1���� �߰��� ���̱� ������ 1��ȯ
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return -1;	//�����ͺ��̽� ����, ȸ������ ����
	}
	
	public String getUserEmail(String userID) {
		String SQL="SELECT userEmail FROM USER WHERE userID = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
			try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
		}
		return null;	//�����ͺ��̽� ����
	}
	
	
	
	
}
