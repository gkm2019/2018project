package util;

import java.util.ArrayList;

import model.dto.TimeDO;

public class TTParser {

	public String MakecTime(ArrayList<TimeDO> list) {
		String cTime = "";
		
		// string 5媛�
		 String mon = "월";
		 String tue = "화";
		 String wed = "수";
		 String thi = "목";
		 String fri = "금";
		
		for (TimeDO i : list) {
			if(i.getcTime().substring(0, 1).equals("월")) {				
				if(mon.contains(i.getcRoom())) {
					int tmp = mon.indexOf("[");
					mon = mon.substring(0, tmp) 
							+ "," 
							+ i.getcTime().substring(1, 2)
							+ mon.substring(tmp); 
				}
				if(!mon.contains(i.getcRoom())) {
					mon += i.getcTime().substring(1, 2);
					mon += "[" + i.getcRoom() + "]";
				}
			}
			
			if(i.getcTime().substring(0, 1).equals("화")) {
				if(tue.contains(i.getcRoom())) {
					int tmp = tue.indexOf("[");
					tue = tue.substring(0, tmp) 
							+ "," 
							+ i.getcTime().substring(1, 2)
							+ tue.substring(tmp); 
				}
				if(!tue.contains(i.getcRoom())) {
					tue += i.getcTime().substring(1, 2);
					tue += "[" + i.getcRoom() + "]";
				}
			}
			
			if(i.getcTime().substring(0, 1).equals("수")) {
				if(wed.contains(i.getcRoom())) {
					int tmp = wed.indexOf("[");
					wed = wed.substring(0, tmp) 
							+ "," 
							+ i.getcTime().substring(1, 2)
							+ wed.substring(tmp); 
				}
				if(!wed.contains(i.getcRoom())) {
					wed += i.getcTime().substring(1, 2);
					wed += "[" + i.getcRoom() + "]";
				}
			}
			
			if(i.getcTime().substring(0, 1).equals("목")) {
				if(thi.contains(i.getcRoom())) {
					int tmp = thi.indexOf("[");
					thi = thi.substring(0, tmp) 
							+ "," 
							+ i.getcTime().substring(1, 2)
							+ thi.substring(tmp); 
				}
				if(!thi.contains(i.getcRoom())) {
					thi += i.getcTime().substring(1, 2);
					thi += "[" + i.getcRoom() + "]";
				}
			}
			
			if(i.getcTime().substring(0, 1).equals("금")) {
				if(fri.contains(i.getcRoom())) {
					int tmp = fri.indexOf("[");
					fri = fri.substring(0, tmp) 
							+ "," 
							+ i.getcTime().substring(1, 2)
							+ fri.substring(tmp); 
				}
				if(!fri.contains(i.getcRoom())) {
					fri += i.getcTime().substring(1, 2);
					fri += "[" + i.getcRoom() + "]";
				}
			}
		}
		
		if(!mon.equals("월"))
			cTime += mon;
		if(!tue.equals("화"))
			cTime += tue;
		if(!wed.equals("수"))
			cTime += wed;
		if(!thi.equals("목"))
			cTime += thi;
		if(!fri.equals("금"))
			cTime += fri;
		
		return cTime;
	}
	
	public ArrayList<String> MakeTime(ArrayList<TimeDO> list){
		ArrayList<String> time = new ArrayList<String>();
		
		for (TimeDO i : list) {		
				time.add(i.getcTime());
		}		
	
		return time;
	}

}
