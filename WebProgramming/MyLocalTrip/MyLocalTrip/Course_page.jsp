<%@page import="javax.el.EvaluationListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
 <%@ page import="user.UserDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8");
String userID=null;

if(session.getAttribute("userID")!=null){
	userID=(String)session.getAttribute("userID");
}

if(userID==null){
	//여기 매번 홈페이지로 갈 때마다 처음에 실행되서 로그인을 해달라고 하므로 어떻게 해야할 지 고칠것.
	
	PrintWriter script=response.getWriter();
	script.println("<script>");
	script.println("alert('로그인을 해주세요.');");
	script.println("location.href='login.jsp';");
	script.println("</script>");
	script.close();
	return;
}

if(userID!=null)
{
	//PrintWriter script=response.getWriter();
	//script.println("<script>");
	//script.println("alert('환영합니다!');");
	//script.println("location.href='main.jsp';");
	//script.println("</script>");
	//script.close();
	//return;
}
	%>
<%@page import="coursePage.*" %>
<%@page import="evaluation.*" %>
<%@page import="java.util.ArrayList" %>
<%
		int courseidx=1; //코스 번호 1-50번이니까 (0-49)
		
		courseDAO dao = new courseDAO();
		ArrayList<courseDTO>courselist = dao.courseList();
		
		locationDAO loc_dao=new locationDAO();
		ArrayList<locationDTO>locationlist = loc_dao.locationList();
		
		EvaluationDAO edao = new EvaluationDAO();
		ArrayList<EvaluationDTO>elist = edao.evaluationList();
		
		
		if(request.getParameter("courseidx")==null){courseidx=0;}		
		else{
			System.out.println("request값 출력"+request.getParameter("courseidx"));
			
			String s_courseidx=request.getParameter("courseidx");
			System.out.println("request를 스트링으로 바꾼 값은(s_courseidx)?="+s_courseidx);
			
			int temp = Integer.parseInt(s_courseidx);
			System.out.println("int로 바뀌었나?(temp)="+temp);
			courseidx=temp;
			System.out.println("courseidx=?"+courseidx);
		}

    	
		
		//courseidx받을때 null 값 따로 throw해주기!
		courseDTO dto=courselist.get(courseidx); //지역

		
  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>MyLocalTrip_코스 _상세페이지</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">


        <link rel="stylesheet" href="assets/css/fonticons.css">
        <link rel="stylesheet" href="assets/css/slider-pro.css">
        
        <link rel="stylesheet" href="assets/css/stylesheet.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 		<link rel="stylesheet" href="http://www.w3ii.com/lib/w3.css">


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <script src="assets/js/slide.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

        
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
		<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <header id="main_menu" class="header navbar-fixed-top">            
            <div class="main_menu_bg">
                <div class="container">
                    <div class="row">
                        <div class="nave_menu">
                            <nav class="navbar navbar-default" id="navmenu">
                                <div class="container-fluid">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                        <a class="navbar-brand" href="main.jsp">
     <!-- 메인로고 여기다 -->                      <img src="assets/images/logo.JPG" height="48px" width="200px"/>
                                        </a>
                                    </div>

                                    <!-- Collect the nav links, forms, and other content for toggling -->



                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                        <%
                                        if(userID==null){
                                        }
                                        
                                        //로그인 상태 시,
                                        else {     
                                        %>
                                <p class=" wow fadeInRight" data-wow-duration="1s" style="font-size:15px; text-align:center;"><i class="fa fa-heart" style="color: pink;font-size: 15px;"
                                > </i><a target="_blank"><%out.print(" ");out.print(userID); %></a> 님 환영합니다 <i class="fa fa-heart" style="color: pink;font-size: 15px;"
                                > </i></p><%
                                
                                }%>
                                        	<li><a href="#">여행 소개</a></li>
                                            <li><a href="#Trip_intro">코스 소개</a></li>
                                          
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">회원관리</a>
                                                <ul class="dropdown-menu">
                                                
                                              
<%
					if(userID==null){
					%>
					
					<li><a class="dropdown-item" href="login.jsp">로그인</a></li>
					<li><a class="dropdown-item" href="join.jsp">회원가입</a></li>
					<%
					} else {
					%>
					
					<li><a class="dropdown-item" href="userLogout.jsp">로그아웃</a></li>
					<%
					}
					%>
					
                                                   
                                           
                                                </ul>
                                            </li>
                                            
                                            <li><a href="#review">후기 보기</a></li>
                                        </ul>    
                                    </div>

                                </div>
                            </nav>
                        </div>	
                    </div>

                </div>

            </div>
        </header> <!--End of header -->
        
        <!-- Home Section -->
        <section id="home" class="home">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 ">
                        <div class="main_home_slider text-center" style="text-align:cetner; margin-right:30px;">


            <!-- main image silde1 -->
                            <div class="single_home_slider">
								<img src="assets/course_image/<%=dto.getCourseImage1() %>" width="100%" height="100%">
                            </div><!-- End of single_home_slider -->
           <!-- main image silde2 -->
                            <div class="single_home_slider">
                                <img src="assets/course_image/<%=dto.getCourseImage2() %>" width="100%" height="100%">
                            </div><!-- End of single_home_slider -->
           <!-- main image silde3 -->
                            <div class="single_home_slider">
                                <img src="assets/course_image/<%=dto.getCourseImage3() %>" width="100%" height="100%">
                            </div><!-- End of single_home_slider -->

                        </div>
                    </div>
                </div>
            </div>
        </section><!-- End of Home Section -->


        <!-- Service Section -->
        <section id="service" class="service sections lightbg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title ">
                        <a name="Trip_intro"></a>
                            <h1 style="font-family: 'Hanna', sans-serif; font-size:30px; margin-bottom:8px;"><%=dto.getCourseName() %></h1>
                            <p style="font-family: 'Hanna', sans-serif; font-size:25px">[<%=dto.getCourseThema() %>]</p> 
                            
                            <hr>
                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px"><%=dto.getCourseInfo() %></h2>
                        </div><!-- End of head title -->
						<hr>
						

						
<!-- First -->				
<%
// location list 반복 시작
for(int i=0;i<locationlist.size();i++){
	locationDTO ldto = locationlist.get(i);
	int course = ldto.getCourseIDX();//해당 코스 번호 받아온다.
	//courseidx 는 넘겨받을 코스 번호
	String imgnum; //step별로 zooming[imgun]붙여서 구별한다.
	imgnum=ldto.getLocationStep();

	
	
	if(imgnum.equals("First Step")){imgnum="";}
	else if(imgnum.equals("Second Step")){imgnum="2";}
	else if(imgnum.equals("Third Step")){imgnum="3";}
	else if(imgnum.equals("Fourth Step")){imgnum="4";}
	else if(imgnum.equals("Fifth Step")){imgnum="5";}
	else {imgnum="6";}
	
	
	if(course==(courseidx+1)){
		
			
			if(ldto.getLocationIDX()%2!=0){//홀수번이면

%>		
                        <div class="single_service_area margin-top-80">
                                <div class="row">
                                    <div class="col-sm-6">
                                       <div class="signle_service_left">
                                         <!-- ==갤러리 구현 부분== -->
                                         <div id="zoom_img<%=imgnum %>"><img src="assets/detail_course_image/<%=ldto.getLocationImage1() %>" width="100%" height="100%" alt="image 1"></div>
										<ul class="thumb<%=imgnum %>">
										    <li class="on">
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage1() %>" width="100%" height="100%" alt="image 1"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage2() %>" width="100%" height="100%" alt="image 2"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage3() %>" width="100%" height="100%" alt="image 3"></a>
										    </li>
										</ul>
										<script>
										$( ".thumb<%=imgnum %> li a" ).click(function() {
										    var address = $(this).children("img");
										    $("#zoom_img<%=imgnum %> img").attr("src",address.attr("src")).attr("alt",address.attr("alt"));
										    $(this).parent().addClass("on").siblings().removeClass("on");
										    return false;
										});
										</script>
                                         <!-- ==end of 갤러리== -->                                        
                                         </div>
                                    </div>
                                    <div class="col-sm-5 col-sm-push-1">
                                        <div class="single_service">
                                            <h3><img src="assets/images/location_step.png" width="20"height="30" style="margin-left:8px;
                                            margin-bottom:3px;">
                                            <%=ldto.getLocationStep() %></h3>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:30px;"><%=ldto.getLocationName() %></h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">주소<br><%=ldto.getLocationAddr() %></h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">전화번호<br><%=ldto.getLocationTel() %></h2>
                                            <div class="separator2"></div>
                                            <p><%=ldto.getLocationInfo() %></p>

                                        </div>
                                    </div>
                                </div>
                            </div><!-- End of single service area -->
                            <hr>
<%

			}//홀수번 일 경우의 if문 종료
			
			else{ //짝수일경우
	
%>

<!-- Second -->
                             <div class="single_service_area margin-top-80">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-push-6">
                                       <div class="signle_service_left">
                                         <!-- ==갤러리 구현 부분== -->
                                         <div id="zoom_img<%=imgnum %>"><img src="assets/detail_course_image/<%=ldto.getLocationImage1() %>" width="100%" height="100%" alt="image 1"></div>
										<ul class="thumb<%=imgnum %>">
										    <li class="on">
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage1() %>" width="100%" height="100%" alt="image 1"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage2() %>" width="100%" height="100%" alt="image 2"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/detail_course_image/<%=ldto.getLocationImage3() %>" width="100%" height="100%" alt="image 3"></a>
										    </li>
										</ul>
										<script>
										$( ".thumb<%=imgnum %> li a" ).click(function() {
										    var address = $(this).children("img");
										    $("#zoom_img<%=imgnum %> img").attr("src",address.attr("src")).attr("alt",address.attr("alt"));
										    $(this).parent().addClass("on").siblings().removeClass("on");
										    return false;
										});
										</script>
                                         <!-- ==end of 갤러리== -->                                        
                                         </div>
                                    </div>
                                     <div class="col-sm-5 col-sm-pull-6">
                                        <div class="single_service">
                                            <h3><img src="assets/images/location_step.png" width="20"height="30" style="margin-left:8px;
                                            margin-bottom:3px;">
                                            <%=ldto.getLocationStep() %></h3>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:30px;"><%=ldto.getLocationName() %></h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">주소<br><%=ldto.getLocationAddr() %></h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">전화번호<br><%=ldto.getLocationTel() %></h2>
                                            <div class="separator2"></div>
                                            <p><%=ldto.getLocationInfo() %></p>

                                        </div>
                                    </div>
                                </div>
                            </div><!-- End of single service area -->
<hr>

<%
			}//짝수일 경우 if 종료
	}//if종료
}//for종료
%>




       
                        
                        
                        
                        
                        
                        
                        
                    </div><!-- End of col-sm-12 -->
                </div><!-- End of row -->
            </div><!-- End of Container -->
        </section><!-- End of Service Section -->


<!-- ===========================================추천 코스=============================================================== -->
        <!-- Work Section -->
        <section id="work" class="work sections">
            <div class="container">
                <div class="row">
                    <div class="main_mix_content text-center">
                        <div class="head_title">
                            <h1 style="font-size: 40px; font-family: 'Hanna', sans-serif;">당신을 위한 추천 코스</h1>
                        </div><!-- End of head title -->
<!-- 단양: 2
	서울카페투어: 17
	서울 홍대: 49
	가평 익스트림: 19
	속초: 11
	대전: 4-->
						<form action="Course_page.jsp" method="post">
                        <div id="mixcontent" class="mixcontent text-center">
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    
                                    <img src="assets/images/course2_image1.JPG" alt="" width="100%" height="100%" />
                                   <a href="?courseidx=1">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">단양</h4>
                                        <div class="separator"></div>
                                      
                                    </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course17_image1.JPG" alt="" width="100%" height="100%"/>
                                    <a href="?courseidx=16">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">서울 카페투어</h4>
                                        <div class="separator"></div>
                                        
                                    </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course49_image1.jpg" alt="" width="100%" height="100%"/>
                                    <a href="?courseidx=48">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">서울 홍대</h4>
                                        <div class="separator"></div>
                                        
                                    </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course19_image1.JPG" alt="" width="100%" height="100%"/>
                                    <a href="?courseidx=18">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">가평 익스트림코스</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                    </a>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course11_image1.JPG" alt="" width="100%" height="100%"/>
                                    <a href="?courseidx=10">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">속초</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                    </a>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course4_image1.JPG" alt="" width="100%" height="100%"/>
                                    <a href="?courseidx=3">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">대전</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        </form>

	
                        <a href="search.jsp" class="btn">course more</a>
                    </div>                     
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
        </section><!-- End of portfolio Section -->        
<!-- ===========================================추천 코스=============================================================== -->


     

        <!-- Clients Section -->
        <section id="clients" class="clients sections">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="main_clients_area text-center">
                            <div class="head_title">
                            <a name="review"></a>
                                <h1>review</h1>
                            </div><!-- End of head title -->
<!-- 내용 넣기!! -->    
<button class="btn btn-default" data-target="#layerpop" data-toggle="modal">후기 등록</button><br/>
<div class="modal fade" id="layerpop" >
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <!-- 닫기(x) 버튼 -->
        <button type="button" class="close" data-dismiss="modal">×</button>
        <!-- header title -->
        <h4 class="modal-title">Review</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
  <!-- form 관리 -->    
      <form action="evaluationRegisterAction.jsp?course_idx=<%=courseidx+1 %>" method="post">
            <div class="form-row">
						<div class="form-group col-sm-6">
							<label>연령</label>
							<select name="age" class="form-control">
								<option value="10대미만">10대미만</option>
								<option value="10대">10대</option>
								<option value="20대" >20대</option>
								<option value="30대"selected>30대</option>
								<option value="40대">40대</option>
								<option value="50대">50대</option>
								<option value="60대이상">60대이상</option>
							</select>
						</div>	
						<div class="form-group col-sm-6">
							<label>여행지</label>
							<select name="reviewDivide" class="form-control">
								<option value="서울" >서울</option>
								<option value="부산">부산</option>
								<option value="인천">인천</option>
								<option value="대전">대전</option>
								<option value="울산">울산</option>
								<option value="경기도">경기도</option>
								<option value="강원도">강원도</option>
								<option value="충청북도"selected>충청북도</option>
								<option value="충청남도">충청남도</option>
								<option value="전라북도">전라북도</option>
								<option value="전라남도">전라남도</option>
								<option value="경상북도">경상북도</option>
								<option value="경상남도">경상남도</option>
								<option value="제주도">제주도</option>
							</select>
						</div>
					</div>
					<div class="form-row">
					<div class="form-group">
						<label>제목</label>
						<input type="text" name="evaluationTitle" class="form-control" maxlength="30">
					</div></div>
					<div class="form-row">
					<div class="form-group">
						<label>내용</label>
						<textarea name="evaluationContent" class="form-control" maxlength="2048" style="height:180px;">
						</textarea>
					</div></div>
					<div class="form-row">
					<div class="form-group col-sm-6">
						<label>종합평</label>
						<select name="totalScore" class="form-control">
							<option value="5" >★★★★★</option>
							<option value="4">★★★★☆</option>
							<option value="3"selected>★★★☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="1">★☆☆☆☆</option>
						</select>
					</div>
					</div>
						<div class="form-group col-sm-6">
						<label>추천</label>
						<select name="recomendScore" class="form-control">
							<option value="5" >★★★★★</option>
							<option value="4">★★★★☆</option>
							<option value="3"selected>★★★☆☆</option>
							<option value="2">★★☆☆☆</option>
							<option value="1">★☆☆☆☆</option>
						</select>
					</div>
      <!-- Footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-default">등록하기</button>
      </div> 
      
      </form>
      </div>
    </div>
  </div>
</div>
                            
<!-- 후기 등록 후 등록되는 카드만들기 --><br/>
                            <div id="example3" class="slider-pro">
                                <div class="sp-slides sps_slider">
 <%
 
 for(int i=0;i<elist.size();i++){
	 EvaluationDTO edto = elist.get(i);
	 int evacourse=edto.getcourse_idx();//리뷰의 코스 번호를 받아온다.
	 //courseidx 는 현재 코스번호 
	 
	 
 	if(evacourse==(courseidx+1)){ //리뷰 코스번호랑 현재 코스번호가 같으면
 		
 	
 
 %>                           
                               
                                
                                <!-- 반복시작 -->
                                    <div class="sp-slide">
                                     <div class="col-3 text-right">
					<a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>
					<a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>
			</div>
                                        <div class="col-sm-12">
                                            <div class="row">
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_left_text text-right">
                                                        <h4 class="sp-layer" 
                                                            data-horizontal="right" data-vertical="0" data-width="81%"
                                                            data-show-transition="left" data-show-delay="200"><%=edto.getEvaluationTitle() %>
                                                        </h4>

                                                        <div class="separator sp-layer sp-black" data-horizontal="340" data-vertical="70"></div>
                                                        <p class="sp-layer" 
                                                           data-horizontal="right" data-vertical="100" data-width="81%" 
                                                           data-show-transition="left" data-show-delay="400">#<%=edto.getAge() %>#<%=edto.getReviewDivide() %>
                                                        </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_right_text text-left">
                                                        <p class="sp-layer right_sp_layer" data-width="100%"><%=edto.getEvaluationContent() %>
                                                        
                                                       
                                                        <%if(edto.getTotalScore().equals("5")){ %> 
                                                        (종합추천 :<span style="color:orange;">★★★★★ )</span>
                                                        <%}
                                                        else if(edto.getTotalScore().equals("4")){ %> 
                                                        (종합추천 :<span style="color:orange;">★★★★☆ )</span>
                                                        <%}
                                                        else if(edto.getTotalScore().equals("3")){ %> 
                                                        (종합추천 :<span style="color:orange;">★★★☆☆ )</span>
                                                        <%}
                                                        else if(edto.getTotalScore().equals("2")){ %> 
                                                        (종합추천 :<span style="color:orange;">★★☆☆☆ )</span>
                                                        <%}
                                                        else if(edto.getTotalScore().equals("1")){ %> 
                                                        (종합추천 :<span style="color:orange;">★☆☆☆☆ )</span>
                                                        <%}%>
                                                        
                                                        </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                            </div>
                                        </div><!-- End of col-sm-12 -->
                                    </div>
                                    <!-- 반복 종료 -->
  <%
  
 	}//if 종료
 	else{
 		
 		continue;
 	}
 }//반복문 종료
  %>                                  

                        </div>
                    </div><!-- End of col-sm-12 -->
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
            </div>
            </div>
        </section><!-- End of portfolio Section --> 



        <!-- Contact Section -->
        <section id="contact" class="contact">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="main_contact sections">
                            <div class="head_title text-center whitetext">
                                <h1>get in touch</h1>
                            </div><!-- End of head title -->

                            <div class="row">
                                <div class="contact_contant">
                                    <div class="col-sm-6 col-xs-12">
                                        <div class="single_message_right_info whitetext">
                                            <ul>
                                                <li><i class="fa fa-map-marker"></i> <span>충청북도 청주시 서원구 충대로1</span></li>

                                                <li><i class="fa fa-mobile-phone"></i> <span>+82) 010-9948-9625 구경민</span><br><span>
                                                												+82) 010-3072-7753 강유빈</span></li>

                                                <li><i class="fa fa-envelope-o"></i> <span>popo2019@naver.com</span><br><span>
                                                												cola68@naver.com</span></li>
                                            </ul>

                                            <div class="contact_socail transition">
                                                <a href=""><i class="fa fa-facebook img-circle"></i></a>
                                                <a href=""><i class="fa fa-twitter img-circle"></i></a>
                                                <a href=""><i class="fa fa-google-plus img-circle"></i></a>
                                                <a href=""><i class="fa fa-pinterest img-circle"></i></a>
                                                <a href=""><i class="fa fa-instagram img-circle"></i></a>
                                            </div>
                                        </div>
                                    </div><!-- End of col-sm-6 -->

                                    <div class="col-sm-6 col-xs-12">
                                        <div class="single_contant_left margin-top-60">
                                            <form action="#" id="formid">
                                                <!--<div class="col-lg-8 col-md-8 col-sm-10 col-lg-offset-2 col-md-offset-2 col-sm-offset-1">-->

                                                
                                                <!--</div>--> 
                                            </form>
                                        </div>
                                    </div>
                                </div> <!-- End of messsage contant-->
                            </div>
                        </div>
                    </div><!-- End of col-sm-12 -->
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
        </section><!-- End of portfolio Section --> 



        <!-- footer Section -->
        <footer id="footer" class="footer">
            <div class="container">
                <div class="main_footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="copyright_text text-center">
                                <p class=" wow fadeInRight" data-wow-duration="1s">Made by <i class="fa fa-heart"></i> 경민&유빈 <a target="_blank" href="http://bootstrapthemes.co">전문프로젝트</a>2018. 06. 15</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- End of container -->
        </footer><!-- End of footer -->



        <!-- START SCROLL TO TOP  -->

        <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>

        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/jquery.easing.1.3.js"></script>
        <script src="assets/js/masonry/masonry.min.js"></script>
        <script type="text/javascript">
            $('.mixcontent').masonry();
        </script>

        <script src="assets/js/jquery.sliderPro.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function ($) {
                $('#example3').sliderPro({
                    width: 960,
                    height: 200,
                    fade: true,
                    arrows: false,
                    buttons: true,
                    fullScreen: false,
                    shuffle: true,
                    smallSize: 500,
                    mediumSize: 1000,
                    largeSize: 3000,
                    thumbnailArrows: true,
                    autoplay: false,
                    thumbnailsContainerSize: 960

                });
            });
        </script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
		
</body>
</html>