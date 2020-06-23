package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CourseCartDAO;
import model.dto.CourseInfoDO;
import util.TTGetTimeTableSet;
@WebServlet("/GetTimeTableSetServlet")
public class GetTimeTableSetServlet extends HttpServlet{
   private static final long serialVersionUID = 1L;
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      ArrayList<String> cID_List = new ArrayList<String>();
      ArrayList<String> Class_Time_List = new ArrayList<String>();
      
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      HttpSession session = request.getSession();
      String stdID = (String) session.getAttribute("stdID");
      String creditlow = request.getParameter("creditlow");
      String creditupp = request.getParameter("creditupp");
      String numOfday = request.getParameter("numOfday");
      String minclassnum = request.getParameter("minclassnum");
      String essentialList = request.getParameter("essentialList");
      
      
      TTGetTimeTableSet ts = new TTGetTimeTableSet();
      
      CourseCartDAO cartdao = new CourseCartDAO();
      ArrayList<CourseInfoDO> Cart_List = cartdao.getCartList(stdID);
      ArrayList<CourseInfoDO> Essential_Candidate_List = new ArrayList<CourseInfoDO>();
      
      for(CourseInfoDO i : Cart_List) {
         if(i.getcSubDiv().equals("ÀüÇÊ"))
            Essential_Candidate_List.add(i);
      }
      
      ArrayList<String> Essential_Cart_List = new ArrayList<String>();
      
      
        for (int i = 0; i < Essential_Candidate_List.size(); i++) {
            if (!Essential_Cart_List.contains(Essential_Candidate_List.get(i).getcID().substring(0, 7))) {
               Essential_Cart_List.add(Essential_Candidate_List.get(i).getcID().substring(0, 7));
            }
        }   
        
        String[] tmp = essentialList.split(",");
        
        for(int i=0; i<tmp.length; i++)
           Essential_Cart_List.add(tmp[i]);
      
        for (int i = 0; i < Essential_Cart_List.size(); i++) 
           System.out.println(Essential_Cart_List.get(i));
      
      
      boolean[] chk = new boolean[5];
      for(int i=0;i<5;i++)
         chk[i] = false;
      
      cID_List.clear();
      Class_Time_List.clear();
      
      
      
      
      if(creditlow == "" && creditupp == "" && numOfday == "" && minclassnum == "") {
         ts.dfs(Essential_Cart_List, Cart_List, 0, "", "", cID_List, Class_Time_List);
      }   
      
      if(numOfday != "") {
         if(creditlow == "")
            creditlow = "0";
         if(creditupp == "")
            creditupp = "24";
         if(minclassnum == "")
            minclassnum = "0";
         ts.dfs(Essential_Cart_List, Cart_List, 0, "", "", cID_List, Class_Time_List, Integer.parseInt(creditlow), Integer.parseInt(creditupp), Integer.parseInt(numOfday), chk, Integer.parseInt(minclassnum));
      }
      else if(numOfday == "") {
         if(creditlow == "")
            creditlow = "0";
         if(creditupp == "")
            creditupp = "24";
         if(minclassnum == "")
            minclassnum = "0";
         ts.dfs(Essential_Cart_List, Cart_List, 0, "", "", cID_List, Class_Time_List, Integer.parseInt(creditlow), Integer.parseInt(creditupp), Integer.parseInt(minclassnum));
      }

      
      response.getWriter().write(getJSON(cID_List));
   }
   
   public String getJSON(ArrayList<String> cID_List) {
      StringBuffer result = new StringBuffer();
      result.append("{\"result\":[");

      
      for(int i=0;i<cID_List.size();i++) {
         String[] tmp = cID_List.get(i).split(",");
         result.append("[{\"value\": \"" + (i+1) + "\"},");
         result.append("{\"value\": \"" + tmp[tmp.length-3] + "\"},");
         result.append("{\"value\": \"" + tmp[tmp.length-2] + "\"},");
         result.append("{\"value\": \"" + tmp[tmp.length-1] + "\"},");
         for(int j=0;j<tmp.length-4;j++) {
            result.append("{\"value\": \"" + tmp[j] + "\"},");
         }
         result.append("{\"value\": \"" + tmp[tmp.length-4] + "\"}],");

      }
      result.append("]}");
      return result.toString();

   }
   
   
}