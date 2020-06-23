var request= new XMLHttpRequest();  //전체 체크리스트
var request2 = new XMLHttpRequest();
	//전체 목록 보기 함수
	function sendInfo(){
		var ghGraduateYear=encodeURIComponent(document.getElementById("ghGraduateYear").value);
		
		request.open("Post","./.do?num=1&credit=1&ghGraduateYear="+encodeURIComponent(document.getElementById("ghGraduateYear").value),true);
		request.onreadystatechange = getInfo;
		request.send(null);
	}
	
	function getInfo(){
		
		var table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		var table2 = document.getElementById("ajaxTable2");
		table2.innerHTML = "";
		var table3 = document.getElementById("ajaxTable3");
		table3.innerHTML = "";
		
		if(request.readyState == 4 && request.status == 200){
			
			var obj = eval('(' + request.responseText + ')');
			
			for(var i=0; i<=obj.general.length; i++){
				var row = table.insertRow(0); 
				var cell = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				
				if(i==obj.general.length){
					cell2.innerHTML = obj.GH[0].ghGeneral;
					cell3.innerHTML = 0;
				}
				else{
				cell.innerHTML = obj.general[i].cName;
				cell2.innerHTML = '<p id="cCredit1" value="'+obj.general[i].cCredit+'">'+obj.general[i].cCredit+'</p>';
				cell3.innerHTML = '<p id="cSub1" value="'+obj.general[i].cSub+'">'+obj.general[i].cSub+'</p>';
				cell4.innerHTML = '<input type="checkbox" name="whether" value="'+obj.general[i].cID+'">';
				}
			}
			for(var i=0; i<=obj.essen.length; i++){
				var row = table2.insertRow(0); 
				var cell = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				
				if(i==obj.essen.length){
					cell2.innerHTML = obj.GH[1].ghEssen;
					cell3.innerHTML = obj.GH[2].ghEssen_sub;
				}
				else{
				cell.innerHTML = obj.essen[i].cName;
				cell2.innerHTML = '<p id="cCredit2" value="'+obj.essen[i].cCredit+'">'+obj.essen[i].cCredit+'</p>';
				cell3.innerHTML = '<p id="cSub2" value="'+obj.essen[i].cSub+'">'+obj.essen[i].cSub+'</p>';
				cell4.innerHTML = '<input type="checkbox" name="whether" value="'+obj.essen[i].cID+'">';
				}
			}
			for(var i=0; i<=obj.option.length; i++){
				var row = table3.insertRow(0); 
				var cell = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				
				if(i==obj.option.length){
					cell2.innerHTML = obj.GH[3].ghOP;
					cell3.innerHTML = obj.GH[4].ghOP_sub;
				}
				else{
				cell.innerHTML = obj.option[i].cName;
				cell2.innerHTML = '<p id="cCredit3" value="'+obj.option[i].cCredit+'">'+obj.option[i].cCredit+'</p>';
				cell3.innerHTML = '<p id="cSub3" value="'+obj.option[i].cSub+'">'+obj.option[i].cSub+'</p>';
				cell4.innerHTML = '<input type="checkbox" id="whether" name="whether" onClick="itemSum(this.form);" value="'+obj.option[i].cID+'">';
				}
			}
			}
		}
	
	//여기까지 전체 목록 보기 함수