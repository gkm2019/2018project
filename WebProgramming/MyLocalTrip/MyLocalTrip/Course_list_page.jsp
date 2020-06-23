<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@page import="coursePage.*" %>
<%@page import="java.util.ArrayList" %>
 
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%	

	String userID=null;
	if(session.getAttribute("userID")!=null){
		userID = (String)session.getAttribute("userID");
	}
	if(userID==null){
		PrintWriter script=response.getWriter();
		   script.println("<script>");
		   script.println("alert('로그인을 해주세요.');");
		   script.println("location.href='login.jsp';");
		   script.println("</script>");
		   script.close();
		   return;	
	}
	/////////////////////////
	//본 페이지에서는 코스정보만 띄운다!!//
	////////////////////////
	/*
	(실제 번호에서 -1 해야 인덱스 값이 된다.) 귀찮아서 db테이블 안만들었음!
	1: 서울	7: 울산	13: 전북
	2: 부산	8: 세종	14: 전남
	3: 대구	9: 경기	15: 경북
	4: 인천	10: 강원	16: 경남
	5: 광주	11: 충북	17: 제주
	6: 대전	12: 충남
	
	*/
	
	//전체 지도에서 해당 지역을 클릭하면 이 페이지로 들어온다 (course_list_page.jps)
	//지도에서 받아온 지역 번호는 areaidx라고 놓는다
	
	request.getParameter("areaidx");
	System.out.println("request된 areaidx=?"+request.getParameter("areaidx"));
	
	String temp=request.getParameter("areaidx");
	
	int areaidx=Integer.parseInt(temp);
	
	//int courseidx=0;//코스 번호 0-49 
	//코스는 course db안의 areaidx와 현재의 areaidx가 일치하면 코스 다 출력해
	courseDAO dao = new courseDAO();
	ArrayList<courseDTO>courselist = dao.courseList();
	
	//지역번호 request하는 부분 여기에다!
	
	String AREA;
	
	
	if(areaidx==0){AREA="서울";}
	else if(areaidx==1){AREA="부산";}
	else if(areaidx==2){AREA="대구";}
	else if(areaidx==3){AREA="인천";}
	else if(areaidx==4){AREA="광주";}
	else if(areaidx==5){AREA="대전";}
	else if(areaidx==6){AREA="울산";}
	else if(areaidx==7){AREA="세종";}
	else if(areaidx==8){AREA="경기도";}
	else if(areaidx==9){AREA="강원도";}
	else if(areaidx==10){AREA="충청북도";}
	else if(areaidx==11){AREA="충청남도";}
	else if(areaidx==12){AREA="전라북도";}
	else if(areaidx==13){AREA="전라남도";}
	else if(areaidx==14){AREA="경상북도";}
	else if(areaidx==15){AREA="경상남도";}
	else if(areaidx==16){AREA="제주도";}
	else{AREA="지역을 선택하세요.";}
	
			
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>코스 리스트 페이지</title>
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

<% 
if(userID==null){
	
}
else{
%>
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                        
                                <p class=" wow fadeInRight" data-wow-duration="1s" style="font-size:15px; text-align:center;"><i class="fa fa-heart" style="color: pink;font-size: 15px;"
                                > </i><a target="_blank"><%out.print(" "+userID); %></a> 님 환영합니다 <i class="fa fa-heart" style="color: pink;font-size: 15px;"
                                > </i></p><%} %>
                                           
                                            <li><a href="search.jsp">검색</a></li>
                                          
                                            <li class="dropdown"><a href="#" class="dropdown-toggle" onclick="LoginCheck()" data-toggle="dropdown" role="button" aria-haspopup="true">회원관리</a>
                                                <ul class="dropdown-menu">
                                                
                                          
<% 
if(userID==null){
%>
               
               
               <li><a class="dropdown-item" href="userLogin.jsp">로그인</a></li>
               <li><a class="dropdown-item" href="userJoin.jsp">회원가입</a></li>
               
 <%}else{ %>             
               <li><a class="dropdown-item" href="userLogout.jsp">로그아웃</a></li>
 <%} %>                                                  
                                           
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


        <!-- Work Section -->
        <section id="work" class="work sections">
            <div class="container" style="margin-top:120px;">
                <div class="row">
                    <div class="main_mix_content text-center">
                        <div class="head_title">
                            <h1 style="font-size: 40px; font-family: 'Hanna', sans-serif;"><em>"<%=AREA %>"</em>  코스</h1>
                        </div><!-- End of head title -->
                        <div id="mixcontent" class="mixcontent text-center">
                        
<%     

 for(int i=0;i < courselist.size();i++){ //코스 50개 반복
		courseDTO cdto = courselist.get(i); 
		int course = cdto.getCourseIDX(); //코스 번호 받는다.
		int dtoareaidx = cdto.getAreaIDX();//해당 코스의 지역 번호를 받는다.
		
		
		if(dtoareaidx==areaidx+1){ //검색하려는 지역번호areaidx와 실제 코스의 areaidx가 일치하면 출력        
			
			System.out.println("받아온 코스번호(course)="+course);
			System.out.println("받아온 코스의 지역번호(dtoareaidx)="+dtoareaidx);
			System.out.println("받아온 코스의 이미지(courseImage)="+cdto.getCourseImage1());
			
%>
                        <form action="Course_page.jsp" method="post">
                        <!-- 반복 시작 -->
                            <div class="col-sm-4 col-xs-12">
                                <div class="single_mixi_portfolio">
                                    <img src="assets/course_image/<%=cdto.getCourseImage1() %>" alt="" width="100%" height="100%" />
                                    <a href="Course_page.jsp?courseidx=<%=cdto.getCourseIDX()-1 %>">
                                    <div class="single_work_overlay">
                                        <h4 style="font-size: 20px; font-family: 'Hanna', sans-serif;"><%=cdto.getCourseName() %></h4>
                                        <h2 style="font-size: 15px; font-family: 'Hanna', sans-serif;">[<%=cdto.getCourseThema() %>]</h2>
                                      
                                    </div>
                                    </a>
                                </div>
                            </div>
                            <!-- 반복 종료 -->
                            </form>
<%
 }
 else{ //일치 하지 않으면 넘어가
    continue; 
 }
 
}
%>

                            
                            
                        </div><!-- end of -->
						
                        
                    </div>                     
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

<script src="assets/js/pooper.js"></script>
        <!-- jQuery -->
        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>

        <!-- jQuery Bootstrap js  -->
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <!-- jQuery easing js  -->
        <script src="assets/js/jquery.easing.1.3.js"></script>

        <!-- jQuery masonry js  -->
        <script src="assets/js/masonry/masonry.min.js"></script>
        <script type="text/javascript">
            $('.mixcontent').masonry();
        </script>

        <!-- jQuery Mixitup  -->
        <script src="assets/js/jquery.mixitup.min.js"></script>
        <script type="text/javascript">
//            jQuery('#').mixItUp({
//                selectors: {
//                    target: '.tile',
//                    filter: '.filter'
//                },
//                animation: {
//                    animateResizeContainer: false,
//                    effects: 'fade scale'
//                }
//
//            });

            //           $('.mixitupId').mixItUp();
        </script>



        <!-- jQuery plugins  -->
        <script src="assets/js/plugins.js"></script>

        <!-- jQuery Main js  -->
        <script src="assets/js/main.js"></script>

    </body>
      
      </html>