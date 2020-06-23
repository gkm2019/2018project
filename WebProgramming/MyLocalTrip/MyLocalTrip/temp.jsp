<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("utf-8"); %>
<%@page import="coursePage.*" %>
<%@page import="java.util.ArrayList" %>
<%
		int courseidx=0; //지역 번호 
		
    	courseDAO dao = new courseDAO();
		ArrayList<courseDTO>courselist = dao.courseList();
		
		locationDAO loc_dao=new locationDAO();
		ArrayList<locationDTO>locationlist = loc_dao.locationList();
		
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
                                        	<li><a href="#">여행 소개</a></li>
                                            <li><a href="#Trip_intro">코스 소개</a></li>
                                            <li><a href="#review">후기 보기</a></li>
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">회원관리</a>
                                                <ul class="dropdown-menu">
                                                    <li style="font-family: 'Hanna', sans-serif;"><a href="Login.jsp">로그인</a></li>
                                                    <li style="font-family: 'Hanna', sans-serif;"><a href="Join.jsp">회원가입</a></li>
                                                </ul>
                                            </li>
                                            
                                            
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
	
	if(imgnum=="First Step"){imgnum="";}
	else if(imgnum=="Second Step"){imgnum="2";}
	else if(imgnum=="Third Step"){imgnum="3";}
	else if(imgnum=="Fourth Step"){imgnum="4";}
	else if(imgnum=="Fifth Step"){imgnum="5";}
	else {imgnum="6";}
	
	if(course==(courseidx+1)){
		System.out.println("코스번호="+course);
			
			if(ldto.getLocationIDX()%2==0){//홀수번이면

%>		
                        <div class="single_service_area margin-top-80">
                                <div class="row">
                                    <div class="col-sm-6">
                                       <div class="signle_service_left">
                                            <img src="assets/images/service2.png" alt="" width=500px; height=350px;/>
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
			
			else{
	
%>

<!-- Second -->
                             <div class="single_service_area  margin-top-80">
                                <div class="row">

                                    <div class="col-sm-6 col-sm-push-6">
                                        <div class="signle_service_left">
                                            <img src="assets/images/service2.png" alt="" width=500px; height=350px;/>
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





<!-- Fifth1 -->
                            <div class="single_service_area margin-top-80">
                                <div class="row">
                                    <div class="col-sm-6">
                                       <div class="signle_service_left">
                                         <!-- ==갤러리 구현 부분== -->
                                         <div id="zoom_img"><img src="assets/images/course11_image1.JPG" width="100%" height="100%" alt="image 1"></div>
										<ul class="thumb">
										    <li class="on">
										        <a href="#"><img src="assets/images/course11_image1.JPG" width="100%" height="100%" alt="image 1"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/images/course17_image1.JPG" width="100%" height="100%" alt="image 2"></a>
										    </li>
										    <li>
										        <a href="#"><img src="assets/images/course19_image1.JPG" width="100%" height="100%" alt="image 3"></a>
										    </li>
										</ul>
										<script>
										$( ".thumb li a" ).click(function() {
										    var address = $(this).children("img");
										    $("#zoom_img img").attr("src",address.attr("src")).attr("alt",address.attr("alt"));
										    $(this).parent().addClass("on").siblings().removeClass("on");
										    return false;
										});
										</script>
                                         <!-- ==end of 갤러리== -->                                        
                                         </div>
                                    </div>
                                    <div class="col-sm-5 col-sm-push-1">
                                        <div class="single_service">
                                            <h3>Fifth step</h3>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:30px;">장소 이름</h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">주소</h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">전화번호</h2>
                                            <div class="separator2"></div>
                                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam,
                                                eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.  </p>

                                        </div>
                                    </div>
                                </div>
                            </div><!-- End of single service area -->
<!-- Fifth2 -->
                            <div class="single_service_area margin-top-80">
                                <div class="row">
                                    <div class="col-sm-6">
                                       <div class="signle_service_left">
                                         <!-- ==갤러리 구현 부분== -->
                                         <div id="zoom_img2"><img src="https://t1.daumcdn.net/cfile/tistory/220E4534516620D324" width="100%" height="100%" alt="image 1"></div>
										<ul class="thumb2">
										    <li class="on">
										        <a href="#"><img src="https://t1.daumcdn.net/cfile/tistory/220E4534516620D324" width="100%" height="100%" alt="image 1"></a>
										    </li>
										    <li>
										        <a href="#"><img src="https://t1.daumcdn.net/cfile/tistory/11729434516620D231" width="100%" height="100%" alt="image 2"></a>
										    </li>
										    <li>
										        <a href="#"><img src="https://t1.daumcdn.net/cfile/tistory/277D9334516620D32D" width="100%" height="100%" alt="image 3"></a>
										    </li>
										</ul>
										<script>
										$( ".thumb2 li a" ).click(function() {
										    var address = $(this).children("img");
										    $("#zoom_img2 img").attr("src",address.attr("src")).attr("alt",address.attr("alt"));
										    $(this).parent().addClass("on").siblings().removeClass("on");
										    return false;
										});
										</script>
                                         <!-- ==end of 갤러리== -->                                        
                                         </div>
                                    </div>
                                    <div class="col-sm-5 col-sm-push-1">
                                        <div class="single_service">
                                            <h3>Sixth step</h3>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:30px;">장소 이름</h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">주소</h2>
                                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px">전화번호</h2>
                                            <div class="separator2"></div>
                                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam,
                                                eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.  </p>

                                        </div>
                                    </div>
                                </div>
                            </div><!-- End of single service area -->
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
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

                        <div id="mixcontent" class="mixcontent text-center">
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course2_image1.JPG" alt="" width="100%" height="100%" />
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">단양</h4>
                                        <div class="separator"></div>
                                      
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course17_image1.JPG" alt="" width="100%" height="100%"/>
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">서울 카페투어</h4>
                                        <div class="separator"></div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course49_image1.jpg" alt="" width="100%" height="100%"/>
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">서울 홍대</h4>
                                        <div class="separator"></div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course19_image1.JPG" alt="" width="100%" height="100%"/>
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">가평 익스트림코스</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course11_image1.JPG" alt="" width="100%" height="100%"/>
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">속초</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/images/course4_image1.JPG" alt="" width="100%" height="100%"/>
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;">대전</h4>
                                        <div class="separator"></div>
                                       
                                    </div>
                                </div>
                            </div>
                        </div>

                        <a href="" class="btn">course more</a>
                    </div>                     
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
        </section><!-- End of portfolio Section -->        
<!-- ===========================================추천 코스=============================================================== -->


        <!-- Team Section -->
        <section id="team" class="team colorsbg sections">
            <div class="container">
                <div class="row">
                    <div class="main_team_area">
                        <div class="head_title text-center">
                        <a name="review"></a>
                            <h1>Best review</h1>
                        </div><!-- End of head title -->

                        <div class="main_team text-center">
                            <div class="single_team">
                                <div class="col-sm-10 col-sm-offset-1">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>paul hall</h4>
                                                <div class="separator"></div>
                                                <p>art director</p>
                                            </div>
                                        </div> <!-- End of col-sm-4 --> 
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team2.jpg" alt="" />
                                                <h4>joshua spencer</h4>
                                                <div class="separator"></div>
                                                <p>founder</p>
                                            </div>
                                        </div> <!-- End of col-sm-4 --> 
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team3.jpg" alt="" />
                                                <h4>diane lewis</h4>
                                                <div class="separator"></div>
                                                <p>artist, designer</p>
                                            </div>
                                        </div><!-- End of col-sm-4 -->  
                                    </div>
                                </div><!-- End of col-sm-10 -->
                            </div>
                            <div class="single_team">
                                <div class="col-sm-10 col-sm-offset-1">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>paul hall</h4>
                                                <div class="separator"></div>
                                                <p>art director</p>
                                            </div>
                                        </div> <!-- End of col-sm-4 --> 
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>joshua spencer</h4>
                                                <div class="separator"></div>
                                                <p>founder</p>
                                            </div>
                                        </div><!-- End of col-sm-4 -->  
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>diane lewis</h4>
                                                <div class="separator"></div>
                                                <p>artist, designer</p>
                                            </div>
                                        </div> <!-- End of col-sm-4 --> 
                                    </div>
                                </div><!-- End of col-sm-10 -->
                            </div>
                            <div class="single_team">
                                <div class="col-sm-10 col-sm-offset-1">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>paul hall</h4>
                                                <div class="separator"></div>
                                                <p>art director</p>
                                            </div>
                                        </div><!-- End of col-sm-4 -->  
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>joshua spencer</h4>
                                                <div class="separator"></div>
                                                <p>founder</p>
                                            </div>
                                        </div> <!-- End of col-sm-4 --> 
                                        <div class="col-sm-4">
                                            <div class="team">
                                                <img class="img-circle" src="assets/images/team1.jpg" alt="" />
                                                <h4>diane lewis</h4>
                                                <div class="separator"></div>
                                                <p>artist, designer</p>
                                            </div>
                                        </div><!-- End of col-sm-4 -->  
                                    </div>
                                </div><!-- End of col-sm-10 -->
                            </div>
                        </div>
                    </div>
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
        </section><!-- End of portfolio Section --> 



        <!-- Clients Section -->
        <section id="clients" class="clients sections">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="main_clients_area text-center">
                            <div class="head_title">
                                <h1>review</h1>
                            </div><!-- End of head title -->

                            <div id="example3" class="slider-pro">
                                <div class="sp-slides sps_slider">
                                    <div class="sp-slide">
                                        <div class="col-sm-12">
                                            <div class="row">
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_left_text text-right">
                                                        <h4 class="sp-layer" 
                                                            data-horizontal="right" data-vertical="0" data-width="81%"
                                                            data-show-transition="left" data-show-delay="200">
                                                            frank sims
                                                        </h4>

                                                        <div class="separator sp-layer sp-black" data-horizontal="340" data-vertical="70"></div>

                                                        <p class="sp-layer" 
                                                           data-horizontal="right" data-vertical="100" data-width="81%" 
                                                           data-show-transition="left" data-show-delay="400">
                                                            photographer
                                                        </p>

                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_right_text text-left">
                                                        <p class="sp-layer right_sp_layer" data-width="100%">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
                                                            totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                            </div>
                                        </div><!-- End of col-sm-12 -->
                                    </div>
                                    <div class="sp-slide">
                                        <div class="col-sm-12">
                                            <div class="row">
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_left_text text-right">
                                                        <h4 class="sp-layer" 
                                                            data-horizontal="right" data-vertical="0" data-width="81%"
                                                            data-show-transition="left" data-show-delay="200">
                                                            frank sims
                                                        </h4>

                                                        <div class="separator sp-layer sp-black" data-horizontal="340" data-vertical="70"></div>

                                                        <p class="sp-layer" 
                                                           data-horizontal="right" data-vertical="100" data-width="81%" 
                                                           data-show-transition="left" data-show-delay="400">
                                                            photographer
                                                        </p>

                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_right_text text-left">
                                                        <p class="sp-layer right_sp_layer" data-width="100%">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
                                                            totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                            </div>
                                        </div><!-- End of col-sm-12 -->
                                    </div>
                                    <div class="sp-slide">
                                        <div class="col-sm-12">
                                            <div class="row">
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_left_text text-right">
                                                        <h4 class="sp-layer" 
                                                            data-horizontal="right" data-vertical="0" data-width="81%"
                                                            data-show-transition="left" data-show-delay="200">
                                                            frank sims
                                                        </h4>

                                                        <div class="separator sp-layer sp-black" data-horizontal="340" data-vertical="70"></div>

                                                        <p class="sp-layer" 
                                                           data-horizontal="right" data-vertical="100" data-width="81%" 
                                                           data-show-transition="left" data-show-delay="400">
                                                            photographer
                                                        </p>

                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_right_text text-left">
                                                        <p class="sp-layer right_sp_layer" data-width="100%">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
                                                            totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                            </div>
                                        </div><!-- End of col-sm-12 -->
                                    </div>
                                    <div class="sp-slide">
                                        <div class="col-sm-12">
                                            <div class="row">
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_left_text text-right">
                                                        <h4 class="sp-layer" 
                                                            data-horizontal="right" data-vertical="0" data-width="81%"
                                                            data-show-transition="left" data-show-delay="200">
                                                            frank sims
                                                        </h4>

                                                        <div class="separator sp-layer sp-black" data-horizontal="340" data-vertical="70"></div>

                                                        <p class="sp-layer" 
                                                           data-horizontal="right" data-vertical="100" data-width="81%" 
                                                           data-show-transition="left" data-show-delay="400">
                                                            photographer
                                                        </p>

                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                                <div class="col-sm-6 col-xs-6">
                                                    <div class="single_right_text text-left">
                                                        <p class="sp-layer right_sp_layer" data-width="100%">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
                                                            totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. </p>
                                                    </div>
                                                </div><!-- End of col-sm-6 -->
                                            </div>
                                        </div><!-- End of col-sm-12 -->
                                    </div>
                                </div>

                                <div class="sp-thumbnails">
                                    <img class="sp-thumbnail" src="assets/images/c1.png"/>
                                    <img class="sp-thumbnail" src="assets/images/c1.png"/>
                                    <img class="sp-thumbnail" src="assets/images/c1.png"/>
                                    <img class="sp-thumbnail" src="assets/images/c1.png"/>
                                </div>
                            </div>
                        </div>
                    </div><!-- End of col-sm-12 -->
                </div><!-- End of row -->
            </div><!-- End of Contaier -->
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