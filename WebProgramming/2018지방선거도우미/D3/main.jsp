<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>
<%@page import="candidate.*" %>
<%@page import="java.util.ArrayList" %>
<%
//후보지역 명, 총 후보자 수 출력
		int btnidx=0;
		int btnidx0=0, btnidx1=1, btnidx2=2, btnidx3=3, btnidx4=4, btnidx5=5, btnidx6=6, btnidx7=7, btnidx8=8, btnidx9=9, btnidx10=10;
		int btnidx11=11, btnidx12=12, btnidx13=13, btnidx14=14, btnidx15=15, btnidx16=16;
		
    	areaDAO dao = new areaDAO();
		ArrayList<areaDTO>arealist = dao.areaList();
		
		CandidateDAO candidao = new CandidateDAO();
		ArrayList<CandidateDTO>candilist = candidao.candiList();
		
  %>
    
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Main(Map)</title>
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
 		
 		
 		
 		
 		<!-- map -->
 		<link rel="stylesheet" href="geo.css">

		<script src="jquery-3.3.1.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
		<script type="text/javascript" src="d3-geo.min.js"></script>
		<script type="text/javascript" src="d3.geo.projection.min.js"></script>
		<script type="text/javascript" src="d3.v3.min.js"></script>
 		<!-- End of map -->


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body data-spy="scroll" data-target=".navbar-collapse">
    
    
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <!-- <div class='preloader'><div class='loaded'>&nbsp;</div></div>-->
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
     <!-- 메인로고 여기다 -->            <h1 style="font-family: 'Hanna', sans-serif; font-size:30px">제<em style="color:blue;">7 </em>회 전국동시지방선거
     								<img src="assets/images/vote_logo.JPG" width="30" height="30"/>
     							
     								</h1>
                                        </a>
                                    </div>

                                    <!-- Collect the nav links, forms, and other content for toggling -->



                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                        	<li><a href="main.jsp">홈</a></li>
                                            <li><a href="candidate.jsp">후보자</a></li>
                                            <li><a href="public_opinion.html">여론 조사</a></li>
                                            <li><a href="search.jsp">후보자 검색</a></li>
                                            <li><a href="location.html">투표소 검색</a>
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
        <section id="home" class="home" style="margin-top:170px; background-image:url('assets/images/menu_img.JPG');">
            <div class="container" >
                <div class="row">
                    <div class="col-sm-12 ">
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <form action="candidate.jsp" method="post">
                                        <ul class="nav navbar-nav navbar-left">
                                        	<li><a href="?btnidx=<%=btnidx0 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >서울</a></li>
                                            <li><a href="?btnidx=<%=btnidx1 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >부산</a></li>
                                            <li><a href="?btnidx=<%=btnidx2 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >대구</a></li>
                                            <li><a href="?btnidx=<%=btnidx3 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >인천</a></li>
                                            <li><a href="?btnidx=<%=btnidx4 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >광주</a></li>
                                            <li><a href="?btnidx=<%=btnidx5 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >대전</a></li>
                                            <li><a href="?btnidx=<%=btnidx6 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >울산</a></li>
                                            <li><a href="?btnidx=<%=btnidx8 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >경기</a></li>
                                            <li><a href="?btnidx=<%=btnidx9 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >강원</a></li>
                                            <li><a href="?btnidx=<%=btnidx10 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >충북</a></li>
                                            <li><a href="?btnidx=<%=btnidx11 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >충남</a></li>
                                            <li><a href="?btnidx=<%=btnidx12 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >전북</a></li>
                                            <li><a href="?btnidx=<%=btnidx13 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >전남</a></li>
                                            <li><a href="?btnidx=<%=btnidx14 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >경북</a></li>
                                            <li><a href="?btnidx=<%=btnidx15 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >경남</a></li>
                                            <li><a href="?btnidx=<%=btnidx16 %>" style="font-family: 'Jeju Gothic', serif; font-size:20px" >제주</a></li>
                                        </ul> 
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>	
                    
        </section><!-- End of Home Section -->
<% 

/*
jsp 안에서 jsp로 값 넘기기! 
form 형식으로 자신에게 post한다. 위의 href참고
넘겨진 값을 request.getParameter();로 받고
string 에 담고
int temp에 담고
그다음에 !!! btnidx에 넣는다.  왜인지는 모르나 바로 string 에서 btnidx로 바꾸면 오류가 난다.
*/
/*request.getParameter값이 null이면 기본값설정!!! 이거 꼭 해줘야함 !!*/

if(request.getParameter("btnidx")==null){btnidx=0;}
else{
System.out.println("reqeust값 출력"+request.getParameter("btnidx"));
String s_btnidx=request.getParameter("btnidx");
System.out.println("reqeust를 스트링으로 바꾼값"+s_btnidx);
int temp = Integer.parseInt(s_btnidx);
System.out.println("int로 바뀌었나?="+temp);
btnidx=temp;
System.out.println("btnidx값은?="+btnidx);
}
areaDTO dto = arealist.get(btnidx);
%>



        <!-- Service Section -->
        <section id="service" class="service sections lightbg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title ">
                        <a name="Trip_intro"></a>
                            <h1 style="font-family: 'Hanna', sans-serif; font-size:30px; text-align:center;">해당 지역을 눌러주세요!
                            <img src="assets/images/map_point.png" width="40" height="40"></h1>
                            <h2 style="font-family: 'Hanna', sans-serif; font-size:20px"></h2>
                        </div><!-- End of head title -->
                        <div style="text-align:center;">
                        	<div id="geo">
					        	<div id="container"></div>
					    				</div>
									    <div id="dashboard">
									
									    </div>
									</div>
									    <script>
        var width = 700,
            height = 700,
            initialScale = 5500,
            initialX = -11900,
            initialY = 4050,
            centered,
            labels;


        var projection = d3.geo.mercator()
            .scale(initialScale)
            .translate([initialX, initialY]);

        var path = d3.geo.path()
            .projection(projection);

        var zoom = d3.behavior.zoom()
            .translate(projection.translate())
            .scale(projection.scale())
            .scaleExtent([height, 800 * height])
            .on("zoom", zoom);


        var svg = d3.select("#container").append("svg")
            .attr("width", width)
            .attr("height", height)
            .attr('id', 'map');


        var states = svg.append("g")
            .attr("id", "states")
            .call(zoom);

        states.append("rect")
            .attr("class", "background")
            .attr("width", width)
            .attr("height", height)
            .attr("fill", "#f9f9f9");



        d3.json("koreaMap1.json", function (err, json) {
            if (err)
                console.log("error fetching data");
            
            
            //지도에 링크달기
            states.selectAll("path")
                .data(json.features)
                .enter()
                .append("a")
                .attr("xlink:href", function (d,i){
                	switch (d.id) {
                    case 0:
                    	return ("candidate.jsp?btnidx=0");
                    case 1:
                    	return ("candidate.jsp?btnidx=1");
                    case 2:
                    	return ("candidate.jsp?btnidx=2");
                    case 3:
                    	return ("candidate.jsp?btnidx=3");
                    case 4:
                    	return ("candidate.jsp?btnidx=4");
                    case 5:
                    	return ("candidate.jsp?btnidx=5");
                    case 6:
                    	return ("candidate.jsp?btnidx=6");
                    case 8:
                    	return ("candidate.jsp?btnidx=8");
                    case 9:
                    	return ("candidate.jsp?btnidx=9");
                    case 10:
                    	return ("candidate.jsp?btnidx=10");
                    case 11:
                    	return ("candidate.jsp?btnidx=11");
                    case 12:
                    	return ("candidate.jsp?btnidx=12");
                    case 13:
                    	return ("candidate.jsp?btnidx=13");
                    case 14:
                    	return ("candidate.jsp?btnidx=14");
                    case 15:
                    	return ("candidate.jsp?btnidx=15");
                    case 16:
                    	return ("candidate.jsp?btnidx=16");
                	}
                return d.properties.Name;
                	
                	
                	console.log(d.properties.Name +" "+ d.id.toString()+" "+i.toString());
                	return ("candidate.jsp?btnidx=" + i.toString());
                })
                .append("path")
                .attr("d", path)
                .attr("id", function (d) { return 'path-' + d.id; });


                //states.selectAll("path")
                //    .data(json.features)
                //    .enter()
                //    .append("path")
                //    .attr("d", path)
                //    .attr("id", function (d) { return 'path-' + d.id; })
                //    .on("click", click);


            labels = states.selectAll("text")
                .data(json.features)
                .enter().append("text")
                .attr("transform", labelsTransform)
                .attr("id", function (d) {
                    return 'label-' + d.id;
                })
                .attr('text-anchor', 'middle')
                .attr("dy", ".35em")
                .on("click", click)
                .text(function (d) {
                    switch (d.id) {
                        case 0:
                            return "서울";
                        case 1:
                            return "부산";
                        case 2:
                            return "대구";
                        case 3:
                            return "인천";
                        case 4:
                            return "광주";
                        case 5:
                            return "대전";
                        case 6:
                            return "울산";
                        case 8:
                            return "경기";
                        case 9:
                            return "강원";
                        case 10:
                            return "충북";
                        case 11:
                            return "충남";
                        case 12:
                            return "전북";
                        case 13:
                            return "전남";
                        case 14:
                            return "경북";
                        case 15:
                            return "경남";
                        case 16:
                            return "제주";
                    }
                    return d.properties.Name;
                });
        }); 



        function click(d) {
            var x, y, k;

            if (d && centered !== d) {
                var centroid = path.centroid(d);
                x = centroid[0];
                y = centroid[1];
                k = 4;
                centered = d;
            } else {
                x = width / 2;
                y = height / 2;
                k = 1;
                centered = null;
            }

            states.selectAll("path")
                .classed("active", centered && function (d) { return d === centered; });


            //지도 확대
            //states.transition()
            //    .duration(1000)
            //    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")scale(" + k + ")translate(" + -x + "," + -y + ")")
            //    .style("stroke-width", 1.5 / k + "px");
        }


        //function zoom() {
        //    projection.translate(d3.event.translate).scale(d3.event.scale);
        //    states.selectAll("path").attr("d", path);

        //    labels.attr("transform", labelsTransform);
        //}

        function labelsTransform(d) {
            console.log(path.centroid(d));

            if (d.id == 8) {
                var arr = path.centroid(d);
                arr[1] += (d3.event && d3.event.scale) ? (d3.event.scale / height + 20) : (initialScale / height + 20);

                return "translate(" + arr + ")";
            } else {
                return "translate(" + path.centroid(d) + ")";
            }
        }

    </script>
                        
                        
                                        </div>
                                    </div>
                                 
                            </div><!-- End of single service area -->
<hr>






       



        

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

                                                <li><i class="fa fa-mobile-phone"></i> <span>+82) 010-2868-8330 명제석</span><br><span>
                                                												+82) 010-9948-9625 구경민</span><br><span>
                                                												+82) 010-3516-3562 김주형</span></li>

                                                <li><i class="fa fa-envelope-o"></i> <span>cro000@naver.com</span><br><span>
                                                												popo2019@naver.com</span><br><span>
                                                												princess_ap@naver.com</span></li>
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
