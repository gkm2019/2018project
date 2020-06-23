//체크박스 값 넘겨서 체크리스 저장하기
		function CheckBox(){
			var params = jQuery("input[name='whether']:checked").serialize(); //입력된 모든 데이터 문자열로 serialize한다
			var ghGraduateYear=encodeURIComponent(document.getElementById("ghGraduateYear").value);
			
			var whether=[];
			var count=0;
			$("input[name='whether']:checked").each(function(i){
				whether.push($(this).val()); //체크된 것만 값을 뽑아서 배열에 push
				count++;
			});
			
			jQuery.ajax({
				url:'UserCheckList.do',
				type: 'POST',
				data:{
					'ghGraduateYear':ghGraduateYear,
					'cID':params,
					'count':count
				},
				contentType:'application/x-www-form-urlencoded; charset=UTF-8',
				success:function(data){
					alert('수강 체크 완료!');
				},
				error:function(){
					alert("수강 체크 완료!");
				}
			});	
		}