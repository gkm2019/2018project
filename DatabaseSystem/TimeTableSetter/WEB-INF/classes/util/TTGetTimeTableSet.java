package util;

import java.util.ArrayList;

import model.dto.CourseInfoDO;

public class TTGetTimeTableSet {
   int creditSum = 0;
   int cnt = 0;
   int numofclasscnt = 0;

   public void dfs(ArrayList<String> Essential, ArrayList<CourseInfoDO> Cart_List, int currentIndex, String currentCidSum, String currentTime, ArrayList<String> Class_Num_List, ArrayList<String> Class_Time_List) {
      if(currentIndex == Cart_List.size()) return;  //수업목록 범위 초과시 리턴

      //이번 원소를 포함시키지 않고 시도========================================
      dfs(Essential, Cart_List,currentIndex+1,currentCidSum,currentTime,Class_Num_List,Class_Time_List);

      //============================================================
      //이번 원소를 포함시키고 시도===========================================
      //============================================================
      //수업 시간이 겹치면 리턴
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime.contains(Cart_List.get(currentIndex).getTime().get(i))) 
            return;
      }

      //같은 이름의 수업이 있으면 리턴
      if(currentCidSum.contains(Cart_List.get(currentIndex).getcID().substring(0, 7)))
         return;

      int temp = currentTime.length();   
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime == "") 
            currentTime = Cart_List.get(currentIndex).getTime().get(i);
         else 
            currentTime = currentTime + "," + Cart_List.get(currentIndex).getTime().get(i);
      }

      
      int temp2 = currentCidSum.length();
      if(currentCidSum == "") {
         currentCidSum = Cart_List.get(currentIndex).getcID();      
         //currentCidSum = Integer.toString(currentIndex);      
      }
      else {
         currentCidSum = currentCidSum + "," + Cart_List.get(currentIndex).getcID();
         //currentCidSum = currentCidSum + "," + Integer.toString(currentIndex);
      }
      
      
      int cnt = 0;
      if(currentTime.contains("월"))
         cnt++;
      if(currentTime.contains("화"))
         cnt++;
      if(currentTime.contains("수"))
         cnt++;
      if(currentTime.contains("목"))
         cnt++;
      if(currentTime.contains("금"))
         cnt++;
         
      creditSum += Cart_List.get(currentIndex).getcCredit();
      numofclasscnt++;
      
      
      

      dfs(Essential, Cart_List, currentIndex+1, currentCidSum, currentTime, Class_Num_List, Class_Time_List);
      //=============================================================   
      
      
      //전공필수 목록을 하나라도 포함하고 있지 않으면 추가하지 않고 리턴
      for(int i=0; i<Essential.size(); i++)
      {
         if(!currentCidSum.contains(Essential.get(i))) {
            //마지막에 다시 이번 원소를 빼줘야함
            currentCidSum =  currentCidSum.substring(0,temp2);
            currentTime = currentTime.substring(0,temp);   
            creditSum -= Cart_List.get(currentIndex).getcCredit();   
            numofclasscnt--;
            return;
         }   
      }
      
      //모두 포함하고 있다면 추가
      Class_Num_List.add(currentCidSum + "," + Integer.toString(creditSum) + "," + Integer.toString(cnt) + "," + Integer.toString(numofclasscnt));
      Class_Time_List.add(currentTime);
      

      //마지막에 다시 이번 원소를 빼줘야함
      currentCidSum =  currentCidSum.substring(0,temp2);
      currentTime = currentTime.substring(0,temp);   
      creditSum -= Cart_List.get(currentIndex).getcCredit();   
      numofclasscnt--;
   }
   
   
   public void dfs(ArrayList<CourseInfoDO> Cart_List, int currentIndex, String currentCidSum, String currentTime, ArrayList<String> Class_Num_List, ArrayList<String> Class_Time_List) {
      if(currentIndex == Cart_List.size()) return;  //수업목록 범위 초과시 리턴

      //이번 원소를 포함시키지 않고 시도========================================
      dfs(Cart_List,currentIndex+1,currentCidSum,currentTime,Class_Num_List,Class_Time_List);

      //============================================================
      //이번 원소를 포함시키고 시도===========================================
      //============================================================
      //수업 시간이 겹치면 리턴
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime.contains(Cart_List.get(currentIndex).getTime().get(i))) 
            return;
      }

      //같은 이름의 수업이 있으면 리턴
      if(currentCidSum.contains(Cart_List.get(currentIndex).getcID().substring(0, 7)))
         return;

      int temp = currentTime.length();   
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime == "") 
            currentTime = Cart_List.get(currentIndex).getTime().get(i);
         else 
            currentTime = currentTime + "," + Cart_List.get(currentIndex).getTime().get(i);
      }

      
      int temp2 = currentCidSum.length();
      if(currentCidSum == "") {
         currentCidSum = Cart_List.get(currentIndex).getcID();      
         //currentCidSum = Integer.toString(currentIndex);      
      }
      else {
         currentCidSum = currentCidSum + "," + Cart_List.get(currentIndex).getcID();
         //currentCidSum = currentCidSum + "," + Integer.toString(currentIndex);
      }
      
      
      int cnt = 0;
      if(currentTime.contains("월"))
         cnt++;
      if(currentTime.contains("화"))
         cnt++;
      if(currentTime.contains("수"))
         cnt++;
      if(currentTime.contains("목"))
         cnt++;
      if(currentTime.contains("금"))
         cnt++;
         
      creditSum += Cart_List.get(currentIndex).getcCredit();
      numofclasscnt++;
      

      dfs(Cart_List, currentIndex+1, currentCidSum, currentTime, Class_Num_List, Class_Time_List);
      //=============================================================

      Class_Num_List.add(currentCidSum + "," + Integer.toString(creditSum) + "," + Integer.toString(cnt) + "," + Integer.toString(numofclasscnt));
      Class_Time_List.add(currentTime);
      

      //마지막에 다시 이번 원소를 빼줘야함
      currentCidSum =  currentCidSum.substring(0,temp2);
      currentTime = currentTime.substring(0,temp);   
      creditSum -= Cart_List.get(currentIndex).getcCredit();   
      numofclasscnt--;
   }

   public void dfs(ArrayList<String> Essential, ArrayList<CourseInfoDO> Cart_List, int currentIndex, String currentCidSum, String currentTime, ArrayList<String> Class_Num_List, ArrayList<String> Class_Time_List, int creditlow, int creditupp, int numOfday, boolean[] chk, int minclassnum) {
      if(currentIndex == Cart_List.size()) return; //수업목록 범위 초과시 리턴

      
      //이번 원소를 포함시키지 않고 시도========================================
      dfs(Essential, Cart_List,currentIndex+1,currentCidSum,currentTime,Class_Num_List,Class_Time_List,creditlow,creditupp,numOfday,chk,minclassnum);
      
      
      //============================================================
      //이번 원소를 포함시키고 시도===========================================
      //============================================================
      //수업 시간이 겹치면 리턴
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime.contains(Cart_List.get(currentIndex).getTime().get(i))) 
            return;
      }

      //같은 이름의 수업이 있으면 리턴
      if(currentCidSum.contains(Cart_List.get(currentIndex).getcID().substring(0, 7)))
         return;
      //============================================================

      int tp = 0;
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(!currentTime.contains(Cart_List.get(currentIndex).getTime().get(i).substring(0,1))) {
            if(Cart_List.get(currentIndex).getTime().get(i).substring(0,1).compareTo("월") == 0 && !chk[0] && cnt <= numOfday) {
               chk[0] = true;
               cnt++;
               tp++;
            }
            else if(Cart_List.get(currentIndex).getTime().get(i).substring(0,1).compareTo("화") == 0 && !chk[1] && cnt <= numOfday) {
               chk[1] = true;
               cnt++;
               tp++;
            }
            else if(Cart_List.get(currentIndex).getTime().get(i).substring(0,1).compareTo("수") == 0 && !chk[2] && cnt <= numOfday) {
               chk[2] = true;
               cnt++;
               tp++;
            }
            else if(Cart_List.get(currentIndex).getTime().get(i).substring(0,1).compareTo("목") == 0 && !chk[3] && cnt <= numOfday) {
               chk[3] = true;
               cnt++;
               tp++;
            }
            else if(Cart_List.get(currentIndex).getTime().get(i).substring(0,1).compareTo("금") == 0 && !chk[4] && cnt <= numOfday) {
               chk[4] = true;
               cnt++;
               tp++;
            }
         }
      }

      int temp = currentTime.length();   
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime == "") 
            currentTime = Cart_List.get(currentIndex).getTime().get(i);
         else 
            currentTime = currentTime + "," + Cart_List.get(currentIndex).getTime().get(i);
      }


      int temp2 = currentCidSum.length();
      if(currentCidSum == "") {
         currentCidSum = Cart_List.get(currentIndex).getcID();      
      }
      else {
         currentCidSum = currentCidSum + "," + Cart_List.get(currentIndex).getcID();
      }

      creditSum += Cart_List.get(currentIndex).getcCredit();
      numofclasscnt++;

      
      //전공필수 목록을 하나라도 포함하고 있지 않으면 추가하지 않고 리턴
            for(int i=0; i<Essential.size(); i++)
            {
               if(!currentCidSum.contains(Essential.get(i))) {
                  //마지막에 다시 이번 원소를 빼줘야함
                  currentCidSum =  currentCidSum.substring(0,temp2);
                  currentTime = currentTime.substring(0,temp);   
                  creditSum -= Cart_List.get(currentIndex).getcCredit();   
                  numofclasscnt--;
                  return;
               }   
            }
      
      if(creditSum >= creditlow && creditSum <= creditupp && cnt == numOfday && numofclasscnt>=minclassnum) {
         Class_Num_List.add(currentCidSum + "," + Integer.toString(creditSum) + "," + Integer.toString(cnt) + "," + Integer.toString(numofclasscnt));
         Class_Time_List.add(currentTime);
      }

      dfs(Essential, Cart_List, currentIndex+1, currentCidSum, currentTime, Class_Num_List, Class_Time_List,creditlow,creditupp,numOfday,chk,minclassnum);
      //=============================================================

      //마지막에 다시 이번 원소를 빼줘야함
      currentCidSum = currentCidSum.substring(0,temp2);
      currentTime = currentTime.substring(0,temp);
      creditSum -= Cart_List.get(currentIndex).getcCredit();   
      cnt -= tp;
      numofclasscnt--;
      for(int i=0;i<5;i++)
         chk[i] = false;
   }

   public void dfs(ArrayList<String> Essential, ArrayList<CourseInfoDO> Cart_List, int currentIndex, String currentCidSum, String currentTime, ArrayList<String> Class_Num_List, ArrayList<String> Class_Time_List, int creditlow, int creditupp, int minclassnum) {
      if(currentIndex == Cart_List.size()) return;

      //이번 원소를 포함시키지 않고 시도========================================
      dfs(Essential, Cart_List,currentIndex+1,currentCidSum,currentTime,Class_Num_List,Class_Time_List,creditlow,creditupp,minclassnum);



      //============================================================
      //이번 원소를 포함시키고 시도===========================================
      //////////////////////////////////////////////////////////////////////
      //수업 시간이 겹치면 리턴
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime.contains(Cart_List.get(currentIndex).getTime().get(i))) 
            return;
      }

      //같은 이름의 수업이 있으면 리턴
      if(currentCidSum.contains(Cart_List.get(currentIndex).getcID().substring(0, 7)))
         return;
      //////////////////////////////////////////////////////////////////////   

      int temp = currentTime.length();   
      for(int i=0;i<Cart_List.get(currentIndex).getTime().size();i++) {
         if(currentTime == "") 
            currentTime = Cart_List.get(currentIndex).getTime().get(i);
         else 
            currentTime = currentTime + "," + Cart_List.get(currentIndex).getTime().get(i);
      }


      int temp2 = currentCidSum.length();
      if(currentCidSum == "") 
         currentCidSum = Cart_List.get(currentIndex).getcID();      
      else 
         currentCidSum = currentCidSum + "," + Cart_List.get(currentIndex).getcID();

      
      int cnt = 0;
      if(currentTime.contains("월"))
         cnt++;
      if(currentTime.contains("화"))
         cnt++;
      if(currentTime.contains("수"))
         cnt++;
      if(currentTime.contains("목"))
         cnt++;
      if(currentTime.contains("금"))
         cnt++;
      creditSum += Cart_List.get(currentIndex).getcCredit();
      numofclasscnt++;
      

      dfs(Essential, Cart_List, currentIndex+1, currentCidSum, currentTime, Class_Num_List, Class_Time_List,creditlow,creditupp,minclassnum);
      //=============================================================

      //전공필수 목록을 하나라도 포함하고 있지 않으면 추가하지 않고 리턴
      for(int i=0; i<Essential.size(); i++)
      {
         if(!currentCidSum.contains(Essential.get(i))) {
            //마지막에 다시 이번 원소를 빼줘야함
            currentCidSum =  currentCidSum.substring(0,temp2);
            currentTime = currentTime.substring(0,temp);   
            creditSum -= Cart_List.get(currentIndex).getcCredit();   
            numofclasscnt--;
            return;
         }   
      }
      
      if(creditSum>=creditlow && creditSum<=creditupp && numofclasscnt >= minclassnum) {
         Class_Num_List.add(currentCidSum + "," + Integer.toString(creditSum) + "," + Integer.toString(cnt) + "," + Integer.toString(numofclasscnt));
         Class_Time_List.add(currentTime);
      }

      //마지막에 다시 이번 원소를 빼줘야함
      currentCidSum = currentCidSum.substring(0,temp2);
      currentTime = currentTime.substring(0,temp);
      creditSum -= Cart_List.get(currentIndex).getcCredit();   
      numofclasscnt--;
   }
}