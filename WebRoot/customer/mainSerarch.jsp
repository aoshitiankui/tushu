<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ taglib prefix="t" uri="/tag" %><!DOCTYPE html>
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/customer/css/stylemain.css"><link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap3-dialog/css/bootstrap-dialog.css"><style type="text/css">body,html{width:100%;}</style>
</head>
<body class="category-page">
<div class="adcenter"></div><!-- mobile menu -->
<div id="page"> 
  <!-- Header -->    <jsp:include page="header.jsp"/>
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
            <div class="block-title"><h3>检索</h3></div>			 				<div class="row">					<div class="mychecks">					<form role="form" id="mysearchform">						<div class="form-group">							<label for="name">图书类型:</label> 							 <t:seledata  styleclass="form-control"  code="btype" name="btype" data_bv_notempty_message="请选择图书类型" def='' />						</div>						<div class="form-group">							<label for="name">图书作者:</label> <input type="text"								class="form-control" name="writer" placeholder="请输入名称">						</div>						<div class="form-group">							<label for="name">ISBN:</label> <input type="text"								class="form-control" name="isbn" placeholder="请输入名称">						</div>						<div class="form-group">							<label for="name">出版社:</label> <input type="text"								class="form-control" name="bpublish" placeholder="请输入名称">						</div>						<div class="form-group">							<label for="name">图书译者:</label> <input type="text"								class="form-control" name="traner" placeholder="请输入名称">						</div>						<div class="form-group">							<label for="name">名称</label> <input type="text"								class="form-control" name="bname" placeholder="请输入名称">						</div>						<button type="button" id="mybtn" class="btn btn-warning">查询</button>					</form>					</div>									</div>			 			</div>

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
                  <a class="left carousel-control" href="#" data-slide="prev"> <span class="sr-only">Previous</span> </a> <a class="right carousel-control" href="#" data-slide="next"> <span class="sr-only">下一个</span> </a>                  </div>
              </div>
            </div>

          </aside>
        </div>          <div class="col-sm-9" >          <article id="artsiss" style="width:100%">          </article>          <!--	///*///======    End article  ========= //*/// -->         </div>
      </div>
    </div>
  </section>
  <!-- Main Container End --> 
  
  <!-- footer -->     <!-- end footer -->
</div>
 <jsp:include page="footer.jsp"/>
<!-- End Footer --> 
<script>	var cur_path = "<%=request.getContextPath()%>";</script>  
<!-- jquery js --> 
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery.min.js"></script> <!-- bootstrap js -->                <script src="<%=request.getContextPath() %>/assets/jquery.serializejson.min.js"></script>                                  
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/bootstrap.min.js"></script> <!-- jquery-ui js -->                                             
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery-ui.js"></script>                               
<!-- owl.carousel.min js -->                                         
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/owl.carousel.min.js"></script>                                                                                    
<!-- jtv-jtv-mobile-menu js -->                                       
 <script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jtv-mobile-menu.js"></script>                                  
<!-- countdown js -->                                                
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/countdown.js"></script>                              
<!-- main js -->                                                   
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/main.js"></script><script src="<%=request.getContextPath() %>/assets/bootstrap3-dialog/js/bootstrap-dialog.js"></script><script type="text/javascript" src="<%=request.getContextPath() %>/assets/bootstrap-div/bootstrap-div.js"></script><script src="<%=request.getContextPath() %>/assets/bootstrap-div/bootstrap-div-zh-CN.js"></script><script type="text/javascript" src="<%=request.getContextPath() %>/customer/manageCart.js"></script><script type="text/javascript" src="<%=request.getContextPath() %>/assets/Lipagination.js"></script><script type="text/javascript" src="<%=request.getContextPath() %>/customer/mainSearchList.js"></script>
</body>
</html>

