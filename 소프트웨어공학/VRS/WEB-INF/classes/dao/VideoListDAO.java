package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.VideoListDTO;

public class VideoListDAO {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="vrs";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://172.20.10.8:3306/"+db+ST;
	
	//본인 mysql ID,PW로 수정해야됨
	String ID = "root";
	String PW = "root";
	String sql = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//목록화면
	public ArrayList<VideoListDTO> list(){
		ArrayList<VideoListDTO> list = new ArrayList<VideoListDTO>();
		ConnectDB();
		
		try {
			sql = "select * from videolist";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String vlistnum = rs.getString("vlistnum");
				String vname = rs.getString("vname");
				String vrelease = rs.getString("vrelease");
				String vprice = rs.getString("vprice");
				String vdirector = rs.getString("vdirector");
				
				VideoListDTO data = new VideoListDTO();
				data.setVlistnum(vlistnum);
				data.setVname(vname);
				data.setVrelease(vrelease);
				data.setVprice(vprice);
				data.setVdirector(vdirector);
				list.add(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return list;
	}
	//insert
	public void insert(String vlistnum, String vname, String vrelease, String vprice, String vdirector) {
		
		ConnectDB();
		
		try {
			sql = "insert into videolist(vlistnum, vname, vrelease, vprice, vdirector) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vlistnum);
			pstmt.setString(2, vname);
			pstmt.setString(3, vrelease);
			pstmt.setString(4, vprice);
			pstmt.setString(5, vdirector);
			int n = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
	}
	//delete
	public void delete(String vlistnum) {
		
		ConnectDB();
		
		try {
			sql="delete from videolist where vlistnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vlistnum);
			int n = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		
	}
	//updateView
	public VideoListDTO update(String vlistnum) {
		
		VideoListDTO data = new VideoListDTO();
		ConnectDB();
		
		try {
			sql="select * from videolist where vlistnum=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vlistnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data.setVlistnum(rs.getString("vlistnum"));
				data.setVname(rs.getString("vname"));
				data.setVrelease(rs.getString("vrelease"));
				data.setVprice(rs.getString("vprice"));
				data.setVdirector(rs.getString("vdirector"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}	
		return data;
	}
	//updateSave
	public void updateSave(String vlistnum, String vname, String vdirector, String vrelease, String vprice) {
		ConnectDB();
		try {
			sql = "update videolist set vname=?, "
					+ "vdirector=?, vrelease=?, vprice=? where vlistnum=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vname);
			pstmt.setString(2, vdirector);
			pstmt.setString(3, vrelease);
			pstmt.setString(4, vprice);
			pstmt.setString(5, vlistnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
	}
	//retrieve
	public ArrayList<VideoListDTO> retrieve(String searchVideoList, String searchValue) {
		ArrayList<VideoListDTO> list = new ArrayList<VideoListDTO>();
		ConnectDB();
		
		try {
			sql = "select * from videolist where ";
			
			if(searchVideoList.equals("vname")) {
				sql+="vname like '%"+searchValue+"%'";
			}else {
				sql+="vdirector like '%"+searchValue+"%'";
			}
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VideoListDTO data = new VideoListDTO();
				data.setVlistnum(rs.getString("vlistnum"));
				data.setVname(rs.getString("vname"));
				data.setVrelease(rs.getString("vrelease"));
				data.setVprice(rs.getString("vprice"));
				data.setVdirector(rs.getString("vdirector"));
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
