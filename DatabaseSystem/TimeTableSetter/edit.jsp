<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

		<!-- �⺻ ���� -->
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>CBNU TIMETABLE</title>
		<!-- ������ ���� �ε� -->
		<link href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;amp;lang=en" rel="stylesheet">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" rel="stylesheet">


		<link href="css/less/mixins/vendor-prefixes.less">
		<link href="css/less/normalize.less">
		<link href="css/less/scafolding.less">
		<link href="1.3.0/mateial/indigo-pink/min.css">


		<link href="styles/main.css" rel="stylesheet">
		<link rel="stylesheet" href="styles/custom.css">



		<style type="text/css">
			*	{margin: 0px; padding: 0px;}

			div {
				padding: 0px;
				margin: 5px;
			}
		</style>
	</head>

	<body>
	
		<!-- ������̼� �� -->
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			
			<a href="schedule.jsp" id="contact-button" class="mdl-button mdl-button--fab mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast mdl-shadow--4dp">
				<i class="material-icons">event</i>
			</a>    	
			<header class="mdl-layout__header mdl-layout__header--waterfall site-header">
			<div class="mdl-layout__header-row site-logo-row">
				<span class="mdl-layout__title">
				
					<a href="index.jsp"><span class="site-description"><h4 style="color:white;">CBNU TIMETABLE</h4></span></a>
				</span>
			</div>
			<div class="mdl-layout__header-row site-navigation-row mdl-layout--large-screen-only">
				<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
					<a class="mdl-navigation__link" href="edit.jsp">�ð�ǥ ����</a>
				
					<a class="mdl-navigation__link" href="schedule.jsp">�� �ð�ǥ</a>
					<a class="mdl-navigation__link" href="CheckList.jsp">�������� üũ����Ʈ</a>
					
					<a class="mdl-navigation__link" href="join.jsp">ȸ������</a>

				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer mdl-layout--small-screen-only">
			<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
				<a class="mdl-navigation__link" href="edit.jsp">�ð�ǥ ����</a>
				
					<a class="mdl-navigation__link" href="schedule.jsp">�� �ð�ǥ</a>
					<a class="mdl-navigation__link" href="CheckList.jsp">�������� üũ����Ʈ</a>
					
					<a class="mdl-navigation__link" href="join.jsp">ȸ������</a>

			</nav>
		</div>
		<div class="mdl-layout__content">
			<div class="site-content">
				<div class="container">
					<br><section class="mdl-grid site-max-width">
		<div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp page-content">
			<div class="mdl-card__title">



<div class="mdl-layout__content">
		<div class="site-content">
			<div class="mdl-grid site-max-width">
				<div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp page-content">
					<div class="mdl-card__title">
						<h1 class="mdl-card__title-text">���� �˻�</h1>
					</div>
					<br>
					<form method="POST" action="">
						
						    <div class="col-xs-14 form-group">

						    	<div class="col-xs-20 control-label">����</div>
						        <div class="col-xs-30 selectContainer">
						            <select id="collegeTypeCombobox" class="form-control" name="collegeType" onChange="javascript:collegeTypeEvent(this)">
						                <option value="">�����ϼ���.</option>
						                <option value="����" selected>����</option>
						                <option value="�����ʼ�">�����ʼ�</option>
						                <option value="��������">��������</option>
						            </select>
						        </div>
						    </div>


   
						    <div class="col-xs-6 form-group">

						     						    
						    	    <div class="col-xs-6 form-group">

						        <div class="col-xs-12 selectContainer">
						        	<div class="col-xs-5 control-label">�г�</div>
						            <select id="collegeTypeCombobox" class="form-control" name="collegeType" onChange="javascript:collegeTypeEvent(this)">
						                <option value="">�����ϼ���.</option>
						                <option value="1�г�" selected>1�г�</option>
						                <option value="2�г�">2�г�</option>
						                <option value="3�г�">3�г�</option>
						                <option value="4�г�">4�г�</option>
						            </select>
						        </div>
						    </div>

					
	
						    <div class="col-xs-6 form-group">
						    	<div class="col-xs-5 control-label">����</div>
						        <div class="col-xs-7 selectContainer">
						            <select id="dayCombobox" class="form-control" name="dayCombobox">
						                <option value="��ü">��ü</option>
						                <option value="��">������</option>
						                <option value="ȭ">ȭ����</option>
						                <option value="��">������</option>
						                <option value="��">�����</option>
						                <option value="��">�ݿ���</option>
						           
						            </select>
						        </div>
						    </div>		
						    <BR>			
						    <div class="col-xs-6 form-group">
						    	<div class="col-xs-5 control-label">����</div>
						        <div class="col-xs-7 selectContainer">
						            <select id="creditCombobox" class="form-control" name="creditCombobox">
						                <option value="��ü">��ü</option>
						                <option value="1">1����</option>
						                <option value="2">2����</option>
						                <option value="3">3����</option>
						                <option value="4">4����</option>
						            </select>
						        </div>
						    </div>		
						    		
						    <div class="col-xs-12 form-group">
						        <div class="col-xs-9 selectContainer">
						            <input type="text" id="search" class="form-control" name="search" placeholder="���Ǹ��� �˻��� �� �ֽ��ϴ�.">						        </div>
						        <div class="col-xs-3 selectContainer">
									<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">�˻�</button>
						        </div>
						    </div>				
					    </div>	
					</form>
				</div>
				<script type="text/javascript">
					setSelectedValue(document.getElementById('collegeTypeCombobox'), '����');
					collegeTypeEvent(document.getElementById('collegeTypeCombobox'));
					setSelectedValue(document.getElementById('area3Combobox'), '�г�');
					area3Event(document.getElementById('area3Combobox'));
				</script>		
							
				<div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp page-content">
					<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="8"><h4>�˻� ��� (�� ����: 0��)</h4></th>
							</tr>
							<tr>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>�г�</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>���ǹ�ȣ</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>���Ǹ�</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>����</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>����</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>��������</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>����</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>���� �ð�</h5></th>
								<th style="text-align: center; background-color: #fafafa; color: #000000;"><h5>���ǽ�</h5></th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>	
				</div>
			</div>
		</div>

									
					
				</div>
			</div>
		</div>
	

	
		<footer class="mdl-mini-footer">
			<div class="footer-container">
				<div class="mdl-logo">
					CHUNGBUK NATIONAL UNIVERSITY
				
				</div>
			</div>
		</footer>
		<script src="https://code.getmdl.io/1.3.0/material.min.js" defer></script>
	</div>
</body>
</html>