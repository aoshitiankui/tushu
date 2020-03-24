﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<!-- Basic page needs -->
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title></title>
<meta name="description" content="">
<meta name="keywords" content="">

<!-- Mobile specific metas  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS Style -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/customer/css/stylemain.css">
</head>
<body class="category-page">
<div class="adcenter"></div><!-- mobile menu -->
<div id="page"> 
  <!-- Header -->
  <!-- end Header -->
  <!-- Breadcrumbs -->
  <div class="breadcrumbs">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <ul>
            <li class="home"> <a href="index.html" title="Go to Home Page">首页</a> <span>/</span> </li>

            <li> <strong>分类检索</strong> </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- Breadcrumbs End --> 
  
  <!-- Main Container -->
  <section class="main-container col2-left-layout">
    <div class="container">
      <div class="row">

        <div class="sidebar col-sm-3 col-xs-12">
          <aside class="sidebar">
            <div class="block block-layered-nav">
            <div class="block-title"><h3>检索</h3></div>

            <div class="custom-slider">
              <div>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                  <ol class="carousel-indicators">
                    <li class="active" data-target="#carousel-example-generic" data-slide-to="0"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                  </ol>
                  <div class="carousel-inner">
                    <div class="item active"><img src="images/slide3.jpg" alt="slide3">
                      <div class="carousel-caption">
                        <h3> </h3>
                        <p>劳于读书，逸于作文.</p>
                       </div>
                    </div>
                    <div class="item"><img src="images/slide1.jpg" alt="slide1">
                      <div class="carousel-caption">
                        <h3> </h3>
                        <p>读书之法，在循序而渐进，熟读而精思.</p>
                      </div>
                    </div>
                    <div class="item"><img src="images/slide2.jpg" alt="slide2">
                      <div class="carousel-caption">
                        <h3> </h3>
                        <p>读书使人心明眼亮.</p>
                      </div>
                    </div>
                  </div>
                  <a class="left carousel-control" href="#" data-slide="prev"> <span class="sr-only">Previous</span> </a> <a class="right carousel-control" href="#" data-slide="next"> <span class="sr-only">下一个</span> </a>
              </div>
            </div>

          </aside>
        </div>
      </div>
    </div>
  </section>
  <!-- Main Container End --> 
  
  <!-- footer -->
</div>
 <jsp:include page="footer.jsp"/>
<!-- End Footer --> 

<!-- jquery js --> 
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery-ui.js"></script>                               
<!-- owl.carousel.min js -->       
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/owl.carousel.min.js"></script> 
<!-- jtv-jtv-mobile-menu js -->     
 <script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jtv-mobile-menu.js"></script> 
<!-- countdown js -->             
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/countdown.js"></script> 
<!-- main js -->                 
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/main.js"></script>
</body>
</html>
