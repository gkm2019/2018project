//수강한 과목 조회
var request2= new XMLHttpRequest();	//수강한 과목 정보

		function userlist(){
			var ghGraduateYear=encodeURIComponent(document.getElementById("ghGraduateYear").value);
			
			request2.open("Post","./.do?num=2&credit=1&ghGraduateYear="+encodeURIComponent(document.getElementById("ghGraduateYear").value),true);
			request2.onreadystatechange = getuserlistInfo;
			request2.send(null);
		}
		
		
		function getuserlistInfo(){
			var table = document.getElementById("ajaxTable");
			table.innerHTML = "";
			var table2 = document.getElementById("ajaxTable2");
			table2.innerHTML = "";
			var table3 = document.getElementById("ajaxTable3");
			table3.innerHTML = "";
			
			if(request2.readyState == 4 && request2.status == 200){

				var obj = eval('(' + request2.responseText + ')');
				
				var sum=0;
				var sum_sub=0;
				
				for(var i=0;i<obj.general.length;i++){
					sum+=parseInt(obj.general[i].cCredit);
				}
				
				for(var i=-2; i<=obj.general.length; i++){
					var row = table.insertRow(0); 
					var cell = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					
					if(i==-2){
						cell.innerHTML = "남은 학점";
						cell2.innerHTML =parseInt(obj.GH[0].ghGeneral)-sum;
						cell3.innerHTML = 0;
					}
					else if(i==-1){
						cell.innerHTML = "이수한 학점";
						cell2.innerHTML = sum;
						cell3.innerHTML = 0;
					}
					else if(i==obj.general.length){
						cell.innerHTML = "";
						cell2.innerHTML = obj.GH[0].ghGeneral;
						cell3.innerHTML = 0;
					}
					else{
					 row = table.insertRow(0); 
					 cell = row.insertCell(0);
					 cell2 = row.insertCell(1);
					 cell3 = row.insertCell(2);
					 cell4 = row.insertCell(3);
					
					cell.innerHTML = obj.general[i].cName;
					cell2.innerHTML = '<p id="cCredit1" value="'+obj.general[i].cCredit+'">'+obj.general[i].cCredit+'</p>';
					cell3.innerHTML = '<p id="cSub1" value="'+obj.general[i].cSub+'">'+obj.general[i].cSub+'</p>';
					cell4.innerHTML = '<input type="checkbox" checked name="whether" value="'+obj.general[i].cID+'">';
					}
				}
				
				sum=0;
				sum_sub=0;
				
				for(var i=0;i<obj.essen.length;i++){
					sum+=parseInt(obj.essen[i].cCredit);
					sum_sub+=parseInt(obj.essen[i].cSub);
				}
				
				for(var i=-2; i<=obj.essen.length; i++){
					var row = table2.insertRow(0); 
					var cell = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					
					if(i==-2){
						cell.innerHTML = "남은 학점";
						cell2.innerHTML =parseInt(obj.GH[1].ghEssen)-sum;
						cell3.innerHTML =parseInt(obj.GH[2].ghEssen_sub)-sum_sub;
					}
					else if(i==-1){
						cell.innerHTML = "이수한 학점";
						cell2.innerHTML = sum;
						cell3.innerHTML = sum_sub;
					}
					else if(i==obj.essen.length){
						cell.innerHTML = "";
						cell2.innerHTML = obj.GH[1].ghEssen;
						cell3.innerHTML = obj.GH[2].ghEssen_sub;
					}
					else{
					cell.innerHTML = obj.essen[i].cName;
					cell2.innerHTML = '<p id="cCredit2" value="'+obj.essen[i].cCredit+'">'+obj.essen[i].cCredit+'</p>';
					cell3.innerHTML = '<p id="cSub2" value="'+obj.essen[i].cSub+'">'+obj.essen[i].cSub+'</p>';
					cell4.innerHTML = '<input type="checkbox" checked name="whether" value="'+obj.essen[i].cID+'">';
					}
				}
					
				//선택
				sum=0;
				sum_sub=0;
				
				for(var i=0;i<obj.option.length;i++){
					sum+=parseInt(obj.option[i].cCredit);
					sum_sub+=parseInt(obj.option[i].cSub);
				}
				
				for(var i=-2; i<=obj.option.length; i++){
					var row = table3.insertRow(0); 
					var cell = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					
					if(i==-2){
						cell.innerHTML = "남은 학점";
						cell2.innerHTML =parseInt(obj.GH[3].ghOP)-sum;
						cell3.innerHTML =parseInt(obj.GH[4].ghOP_sub)-sum_sub;
					}
					else if(i==-1){
						cell.innerHTML = "이수한 학점";
						cell2.innerHTML = sum;
						cell3.innerHTML = sum_sub;
					}
					else if(i==obj.option.length){
						cell.innerHTML = "";
						cell2.innerHTML = obj.GH[3].ghOP;
						cell3.innerHTML = obj.GH[4].ghOP_sub;
					}
					else{
					cell.innerHTML = obj.option[i].cName;
					cell2.innerHTML = '<p id="cCredit3" value="'+obj.option[i].cCredit+'">'+obj.option[i].cCredit+'</p>';
					cell3.innerHTML = '<p id="cSub3" value="'+obj.option[i].cSub+'">'+obj.option[i].cSub+'</p>';
					cell4.innerHTML = '<input type="checkbox" checked id="whether" name="whether" onClick="itemSum(this.form);" value="'+obj.option[i].cID+'">';
				}
				
				}
				}
		}
		//여기까지 수강한 과목 조회 함수