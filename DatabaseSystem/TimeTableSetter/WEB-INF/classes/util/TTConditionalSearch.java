package util;

import java.util.ArrayList;

import model.dao.CourseInfoDAO2;
import model.dto.CourseInfoDO;

public class TTConditionalSearch {
   CourseInfoDAO2 cdao = new CourseInfoDAO2();
   ArrayList<CourseInfoDO> Searched_Course_List = null;

   public ArrayList<CourseInfoDO> ConditionalSearch(String cCredit, String cSection, String cDepartment, String cGrade, String cDiv, String cSubDiv, String cName){
      
	   
	   
	   if(cSection.equals("전공")) {

    	  
         // 학과 선택  안하면 에러
         if(cDepartment == "") {
            //에러
         }
         // 학과만 선택
         else if(cCredit == "" && cDepartment != "" && cGrade == "") {
            Searched_Course_List = cdao.SearchCourse(cSection, cDepartment, cName);
         }
         // 학점 + 학과 선택
         else if(cCredit != "" && cDepartment != "" && cGrade == "") {
            Searched_Course_List = cdao.SearchCourse(Integer.parseInt(cCredit), cSection, cDepartment, cName);
         }
         // 학과 + 학년  선택
         else if(cCredit == "" && cDepartment != "" && cGrade != "") {
            Searched_Course_List = cdao.SearchCourse(cSection, cDepartment, Integer.parseInt(cGrade), cName);
         }
         // 학점 + 학과 + 학년 선택
         else if(cCredit != "" && cDepartment != "" && cGrade != "") {
            Searched_Course_List = cdao.SearchCourse(Integer.parseInt(cCredit), cSection, cDepartment, Integer.parseInt(cGrade), cName);
         }

      }

      else if(cSection.equals("교양")) {
         // 구분 선택 안하면 에러
         if(cDiv == "" || cSubDiv == "") {
            //에러
         }
         // 구분만 선택
         else if(cDiv != "" && cSubDiv != "") {
            Searched_Course_List = cdao.SearchCourse(cSection, cDiv, cSubDiv, cName);
         }
         // 학점 + 구분 선택
         else if(cCredit != "" && cDiv != "" && cSubDiv != "") {
            Searched_Course_List = cdao.SearchCourse(Integer.parseInt(cCredit), cSection, cDiv, cSubDiv, cName);
         }
      }

      else {
         // 전공 or 교양 선택 안했는데 이름도 검색 안하면
         if(cName == "%%") {
            //error
         }
         else if(cCredit == "" && cName != "%%") {
            Searched_Course_List = cdao.SearchCourse(cName);
         }
         // 학점 + 이름만 검색
         else if(cCredit != "" && cName != "%%") {
            Searched_Course_List = cdao.SearchCourse(Integer.parseInt(cCredit), cName);
         }
      }
      
      return Searched_Course_List;
   }
}
