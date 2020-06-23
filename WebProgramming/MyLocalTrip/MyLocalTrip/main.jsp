<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.PrintWriter" %>
 <%@page import="user.UserDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% request.setCharacterEncoding("UTF-8");
String userID=null;

if(session.getAttribute("userID")!=null){
	userID=(String)session.getAttribute("userID");
}


if(userID==null){
	
	//여기 매번 홈페이지로 갈 때마다 처음에 실행되서 로그인을 해달라고 하므로 어떻게 해야할 지 고칠것.
	
	//PrintWriter script=response.getWriter();
	//script.println("<script>");
	//script.println("alert('로그인한 상태입니다.');");
	//script.println("location.href='userLogin.jsp';");
	//script.println("</script>");
	//script.close();
	//return;
}

	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>메인페이지</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="assets/css/fonticons.css">
        <link rel="stylesheet" href="assets/css/slider-pro.css">
        <link rel="stylesheet" href="assets/css/stylesheet.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 		<link rel="stylesheet" href="http://www.w3ii.com/lib/w3.css">
		<!-- 커스텀 CSS 추가하기 -->
		<link rel="stylesheet" href="assets/css/custom.css">

        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />
        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <script src="assets/js/jquery-1.11.2.min.js"></script>
		<!-- 파퍼 자바스크립트 추가하기 -->
		<script src="assets/js/pooper.min.js"></script>
        
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
                                        	<li><a href="search.jsp">검색</a></li>
                                        	
                                        	<li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">비디오</a>
                                                <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="Login.jsp">등록</a></li>
												<li><a class="dropdown-item" href="Join.jsp">검색</a></li>
												<li><a class="dropdown-item" href="Join.jsp">삭제</a></li>
												</ul>
												</li>
												
											<li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">대여/반납</a>
                                                <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="Login.jsp">대여</a></li>
												<li><a class="dropdown-item" href="Join.jsp">반납</a></li>
												<li><a class="dropdown-item" href="Join.jsp">연체</a></li>
												<li><a class="dropdown-item" href="Join.jsp">파손 관리</a></li>
												<li><a class="dropdown-item" href="Join.jsp">연체자 목록 출력</a></li>
												</ul>
												</li>	
												
												<li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">주문/납품</a>
                                                <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="Login.jsp">주문</a></li>
												<li><a class="dropdown-item" href="Join.jsp">납픔</a></li>
												<li><a class="dropdown-item" href="Join.jsp">품질</a></li>
												</ul>
												</li>
												
												<li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">업체관리</a>
                                                <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="Login.jsp">업체 등록</a></li>
												<li><a class="dropdown-item" href="Join.jsp">업체 갱신</a></li>
												<li><a class="dropdown-item" href="Join.jsp">업체 삭제</a></li>
												<li><a class="dropdown-item" href="Join.jsp">업체 검색</a></li>
												</ul>
												</li>
                                            
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">회원관리</a>
                                                <ul class="dropdown-menu">
                                                
                                              
<%
					if(userID==null){
					%>
					
					<li><a class="dropdown-item" href="Login.jsp">회원 등록</a></li>
					<li><a class="dropdown-item" href="Join.jsp">회원 갱신</a></li>
					<li><a class="dropdown-item" href="Join.jsp">회원 검색</a></li>
					<%
					} else {
					%>
					
					<li><a class="dropdown-item" href="userLogout.jsp">로그아웃</a></li>
					<%
					}
					%>
					
                                                   
                                           
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




        <!-- Service Section -->
        <section id="work1" class="work1 sections margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title text-center">
                            <h1>비디오 가게 <em style="font-size:40px; font-family: 'Hanna', sans-serif;">에 오신 것을 환영합니다.</em></h1>
                        </div><!-- End of head title -->

                        <div class="main_work1_area">
                            <div class="main_work1_content">
                             	<div class="single_work1" >
                                    <img src="assets/images/main_1.jpg" width="100%" height="100%" alt="" />
                                </div><!-- End of single single_work1 -->
                                <div class="single_work1" >
                                    <img src="assets/images/main_4.JPG" width="100%" height="100%" alt="" />
                                </div><!-- End of single single_work1 -->
                                <div class="single_work1">
                                    <img src="assets/images/main_5.JPG" width="100%" height="100%" alt="" />
                                </div><!-- End of single single_work1 -->
                                <div class="single_work1">
                                    <img src="assets/images/main_2.jpg" width="100%" height="100%" alt="" />
                                </div><!-- End of single single_work1 -->
                                <div class="single_work1">
                                    <img src="assets/images/main_3.jpg" width="100%" height="100%" alt="" />
                                </div><!-- End of single single_work1 -->
                            </div>
                        </div>
                    </div><!-- End of col-sm-12 -->
                </div><!-- End of row -->
            </div><!-- End of Container -->
        </section><!-- End of Service Section -->
        
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
                                   <a href="Course_page.jsp?courseidx=1">
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
                                    <a href="Course_page.jsp?courseidx=16">
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
                                    <a href="Course_page.jsp?courseidx=48">
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
                                    <a href="Course_page.jsp?courseidx=18">
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
                                    <a href="Course_page.jsp?courseidx=10">
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
                                    <a href="Course_page.jsp?courseidx=3">
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
		<script src="assets/js/pooper.js"></script>
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
</html>