package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.CourseInfoDO;
import model.dto.TimeDO;
import util.TTParser;

public class CourseInfoDAO2 {
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String db="TimeTableSetter";
	String ST="?serverTimezone=UTC&useSSL=false";
	String URL="jdbc:mysql://localhost:3306/"+db+ST;
	
	String ID="root";
	String PW="kyeonggu9625";
	
   String sql = null;
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   TimeDAO tdao = new TimeDAO();
   String cTime = "";
   TTParser parser = new TTParser();

   // 전공 수업 검색
   // 학과만 선택
   public ArrayList<CourseInfoDO> SearchCourse(String cSection, String cDepartment, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cDiv=? AND cDepartment=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cSection);
         pstmt.setString(2, cDepartment);
         pstmt.setString(3, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 전공 수업 검색
   // 학점 + 학과 선택
   public ArrayList<CourseInfoDO> SearchCourse(int cCredit, String cSection, String cDepartment, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cCredit=? AND cDiv=? AND cDepartment=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cCredit);
         pstmt.setString(2, cSection);
         pstmt.setString(3, cDepartment);
         pstmt.setString(4, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 전공 수업 검색
   // 학과 + 학년 선택
   public ArrayList<CourseInfoDO> SearchCourse(String cSection, String cDepartment, int cGrade, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cDiv=? AND cDepartment=? AND cGrade=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cSection);
         pstmt.setString(2, cDepartment);
         pstmt.setInt(3, cGrade);
         pstmt.setString(4, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 학과 + 학년 + 학점 검색
   public ArrayList<CourseInfoDO> SearchCourse(int cCredit, String cSection, String cDepartment, int cGrade, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cCredit=? AND cDiv=? AND cDepartment=? AND cGrade=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cCredit);
         pstmt.setString(2, cSection);
         pstmt.setString(3, cDepartment);
         pstmt.setInt(4, cGrade);
         pstmt.setString(5, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 교양 수업 검색
   public ArrayList<CourseInfoDO> SearchCourse(String cSection, String cDiv, String cSubDiv, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cDiv=? AND cDiv=? AND cSubDiv=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cSection);
         pstmt.setString(2, cDiv);
         pstmt.setString(3, cSubDiv);
         pstmt.setString(4, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 교양 수업 + 학점 검색
   public ArrayList<CourseInfoDO> SearchCourse(int cCredit, String cSection, String cDiv, String cSubDiv, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cCredit=? cDiv=? AND cDiv=? AND cSubDiv=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cCredit);
         pstmt.setString(2, cSection);
         pstmt.setString(3, cDiv);
         pstmt.setString(4, cSubDiv);
         pstmt.setString(5, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }


   // 학점만 검색
   public ArrayList<CourseInfoDO> SearchCourse(int cCredit, String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cCredit=? AND cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cCredit);
         pstmt.setString(2, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   // 이름만 검색
   public ArrayList<CourseInfoDO> SearchCourse(String cName){
      ConnectDB();

      ArrayList<CourseInfoDO> Searched_Course_List = new ArrayList<CourseInfoDO>();

      try {
         sql = "SELECT * FROM CourseInfo WHERE cName like ? AND cSemester=2 AND cYear=2018";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cName);

         rs = pstmt.executeQuery();

         while(rs.next()) {
            CourseInfoDO tmp = new CourseInfoDO();
            tmp.setcID(rs.getString("cID"));
            tmp.setcName(rs.getString("cName"));
            tmp.setcProfessor(rs.getString("cProfessor"));            
            tmp.setcGrade(rs.getInt("cGrade"));
            tmp.setcCredit(rs.getInt("cCredit"));
            tmp.setcCredit_sub(rs.getInt("cCredit_sub"));
            tmp.setcDepartment(rs.getString("cDepartment"));
            tmp.setcDiv(rs.getString("cDiv"));
            tmp.setcSubDiv(rs.getString("cSubDiv"));
            tmp.setSection(rs.getString("cSection"));
            tmp.setLimit_per(rs.getString("limit_per"));
            ArrayList<TimeDO> cTimeList = tdao.getCourseTime(tmp.getcID());
            cTime = parser.MakecTime(cTimeList);
            tmp.setcTime(cTime);
            tmp.setTime(parser.MakeTime(cTimeList));
            Searched_Course_List.add(tmp);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         CloseDB();
      }

      return Searched_Course_List;
   }

   /*DB 연결******************************************************************/
   void ConnectDB() {
      try {
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(URL, ID, PW);
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   /*DB 연결 해제******************************************************************/
   void CloseDB() {
      if(pstmt != null)
         try {
            pstmt.close();
         }catch(Exception e) {
            e.printStackTrace();
         }

      if(conn != null)
         try {
            conn.close();
         }catch(Exception e) {
            e.printStackTrace();
         }
   }
}