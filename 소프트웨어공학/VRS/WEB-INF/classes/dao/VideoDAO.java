package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dto.VideoDTO;
import dto.VideoListDTO;

public class VideoDAO {
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

	//목록화면
	public ArrayList<VideoDTO> list(){
		
		ArrayList<VideoDTO> list = new ArrayList<VideoDTO>();
		ConnectDB();
			
		try {
			sql = "select video.vnum, videolist.vname, videolist.vdirector, video.vtag, videolist.vprice " + 
					"from video " + 
					"join videolist on videolist.vlistnum=video.vlistnum";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String vnum = rs.getString("vnum");
				String vname = rs.getString("vname");
				String vdirector = rs.getString("vdirector");
				String vtag = rs.getString("vtag");
				String vprice = rs.getString("vprice");
					
				VideoDTO data = new VideoDTO();
				data.setVnum(vnum);
				data.setVname(vname);
				data.setVdirector(vdirector);
				data.setVtag(vtag);
				data.setVprice(vprice);
				list.add(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
			CloseDB();
		}
		return list;
		}
	
	//insert search  추가하기위해 join쿼리로 vlistnum찾기
	public String insertSearch(String vname, String vdirector) {
		ConnectDB();
		ArrayList<VideoDTO> list = new ArrayList<VideoDTO>();
		String tmp=null;
		try {
			sql = "select videolist.vlistnum " + 
					"from videolist " + 
					"where vname=? and vdirector=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vname);
			pstmt.setString(2, vdirector);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				tmp = rs.getString("vlistnum");
			}
			
			
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
		return tmp;
	}
	
	//insert
	public void insert(String vnum, String vlistnum, String vtag) {
			
		ConnectDB();
		
		try {
			sql = "insert into video(vnum, vlistnum, vtag) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vnum);
			pstmt.setString(2, vlistnum);
			pstmt.setString(3, vtag);
			int n = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
			CloseDB();
		}
	}
   
	//delete
	public void delete(String vnum) {
		ConnectDB();
		try {
			sql="delete from video where vnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vnum);
			int n = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			CloseDB();
		}
	}
	
	//비디오 retrieve
	public ArrayList<VideoDTO> retrieve(String searchVideo, String searchValue) {
		ArrayList<VideoDTO> list = new ArrayList<VideoDTO>();
		ConnectDB();
		
		try {
			sql = "select video.vnum, videolist.vname, videolist.vdirector, video.vtag, videolist.vprice "
					+ "from video "
					+ "join videolist on video.vlistnum=videolist.vlistnum "
					+ "where ";
				
			if(searchVideo.equals("vname")) {
				sql+="vname like '%"+searchValue+"%'";
			}else {
				sql+="vdirector like '%"+searchValue+"%'";
			}
				
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				
			while(rs.next()) {
				VideoDTO data = new VideoDTO();
				data.setVnum(rs.getString("vnum"));
				data.setVname(rs.getString("vname"));
				data.setVdirector(rs.getString("vdirector"));
				
				if(rs.getString("vtag").equals("0")){
					data.setVtag("대여가능");
				}else {
					data.setVtag("대여불가");
				}
				data.setVprice(rs.getString("vprice"));
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
