package evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DatabaseUtil;

public class EvaluationDAO {
   private Connection conn;
   private ResultSet rs;
   private PreparedStatement pstmt;
   
   public EvaluationDAO() {
      try {

         String dbURL = "jdbc:mysql://localhost:3306/mylocaltrip";

         String dbID = "root";
         String dbPassword = "kyeonggu9625";

         Class.forName("com.mysql.jdbc.Driver");

         conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

      } catch (Exception e) {

         e.printStackTrace();

      }

   }

   public int write(EvaluationDTO evaluationDTO) {
      String SQL="INSERT INTO EVALUATION VALUES (NULL,?,?,?,?,?,?,?,0,?)";
      try{
         conn=DatabaseUtil.getConnection();
         pstmt=conn.prepareStatement(SQL);
         pstmt.setString(1,evaluationDTO.getUserID());
         pstmt.setString(2,evaluationDTO.getAge());
         pstmt.setString(3,evaluationDTO.getReviewDivide());
         pstmt.setString(4,evaluationDTO.getEvaluationTitle());
         pstmt.setString(5,evaluationDTO.getEvaluationContent());
         pstmt.setString(6,evaluationDTO.getTotalScore());
         pstmt.setString(7,evaluationDTO.getRecomendScore());
         //pstmt.setInt(8,evaluationDTO.getLikeCount());
         pstmt.setInt(8,evaluationDTO.getcourse_idx());
         return pstmt.executeUpdate();
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try { if(conn!=null) conn.close(); } catch(Exception e) {e.printStackTrace();}
         try { if(pstmt!=null) pstmt.close(); } catch(Exception e) {e.printStackTrace();}
         try { if(rs!=null) rs.close(); } catch(Exception e) {e.printStackTrace();}
      }
      return -1;   //데이터베이스 오류
   }
   
   public int like(String evaluationID) {

   
      try {

         String SQL = "UPDATE EVALUATION SET likeCount = likeCount + 1 WHERE evaluationID = ?";

         pstmt = conn.prepareStatement(SQL);

         pstmt.setInt(1, Integer.parseInt(evaluationID));

         return pstmt.executeUpdate();

      } catch (Exception e) {

         e.printStackTrace();

      } finally {

         try {

            if(pstmt != null) pstmt.close();

            if(conn != null) conn.close();

         } catch (Exception e) {

            e.printStackTrace();

         }

      }

      return -1;

   }

   

   public int delete(String evaluationID) {


      try {

         String SQL = "DELETE FROM EVALUATION WHERE evaluationID = ?";

         pstmt = conn.prepareStatement(SQL);

         pstmt.setInt(1, Integer.parseInt(evaluationID));

         return pstmt.executeUpdate();

      } catch (Exception e) {

         e.printStackTrace();

      } finally {

         try {

            if(pstmt != null) pstmt.close();

            if(conn != null) conn.close();

         } catch (Exception e) {

            e.printStackTrace();

         }

      }

      return -1;

   }

   

   public String getUserID(String evaluationID) {

      

      try {

         String SQL = "SELECT userID FROM EVALUATION WHERE evaluationID = ?";

         pstmt = conn.prepareStatement(SQL);

         pstmt.setInt(1, Integer.parseInt(evaluationID));

         rs = pstmt.executeQuery();

         while(rs.next()) {

            return rs.getString(1);

         }

      } catch (Exception e) {

         e.printStackTrace();

      } finally {

         try {

            if(pstmt != null) pstmt.close();

            if(conn != null) conn.close();

         } catch (Exception e) {

            e.printStackTrace();

         }

      }

      return null;


   }
  
   public ArrayList<EvaluationDTO> evaluationList(){
	   ArrayList<EvaluationDTO> elist = new ArrayList<EvaluationDTO>();
	   Connection conn=null;
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
	   try {
		   conn=DatabaseUtil.getConnection();
		   String sql="select * from evaluation";
		   pstmt=conn.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()) {
			   EvaluationDTO dto = new EvaluationDTO();
			   dto.setAge(rs.getString("age"));
			   dto.setcourse_idx(rs.getInt("course_idx"));
			   dto.setEvaluationContent(rs.getString("evaluationContent"));
			   dto.setEvaluationID(rs.getInt("evaluationID"));
			   dto.setEvaluationTitle(rs.getString("evaluationTitle"));
			   dto.setRecomendScore(rs.getString("recomendScore"));
			   dto.setReviewDivide(rs.getString("reviewDivide"));
			   dto.setTotalScore(rs.getString("totalScore"));
			   dto.setUserID(rs.getString("userID"));
			   
			   elist.add(dto);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally { //result=> statement=> connection
	         
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
	      
	      return elist;

   }

}