<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<!DOCTYPE html>

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
<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap3-dialog/css/bootstrap-dialog.css"> 
<style type="text/css">
html, body{
height: 100%;
}
</style>

</head>

<body class="category-page">

<div class="adcenter"></div><!-- mobile menu -->

<div id="page"> 

  <!-- Header -->
    <jsp:include page="header.jsp"/>
  <!-- end Header -->
  <!-- Breadcrumbs -->

  <div class="breadcrumbs">

    <div class="container">

      <div class="row">

        <div class="col-xs-12">

          <ul>

            <li class="home"> <a href="#" title="Go to Home P登录e">首页</a> <span>/</span> </li>


            <li> <strong>用户登录</strong> </li>

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
                        <div class="col-sm-6 col-sm-offset-3 form-box">
 
                            <div class="form-bottom">
			                    <form role="form" action="" method="post" class="login-form" id="loginForm">
			                    	<div class="form-group">
			                    		<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>用户名:</label>
			                        	<input class="form-control" placeholder="请输入用户名" name="userId" id="userId" type="text" autofocus data-bv-notempty data-bv-notempty-message="用户名不允许为空" data-bv-stringLength data-bv-stringLength-min='4' data-bv-stringLength-max='15'>
			                        </div>
			                        <div class="form-group">
										<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>密码:</label>
			                        	<input class="form-control" placeholder="请输入密码" name="passWord" id="passWord" type="password" value="" data-bv-notempty data-bv-notempty-message="密码不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='15'>
			                        </div>
			                        <div class="form-group clearfix" >
									    <div class="col-sm-12"  style="padding-left: 0px;">
									      <label for="message-text" style="padding-left: 0;" class="control-label col-sm-6"><span style="color:#FF9966">*</span>验证码:</label>	
									      <div class="col-sm-6">
											
										  </div> 
										</div>
										<div class="col-sm-12"  style="padding-left: 0px;">
		
											<div class="col-sm-4" style="padding-left: 0px;">	
										       <input type="text" class="form-control" style="float: none;" name="code" id="code" placeholder="请填写验证码" data-bv-notempty data-bv-notempty-message="验证码不允许为空" data-bv-identifyingcode data-bv-identifyingcode-message='验证码长度有误'>
										     </div>
											<div class="col-sm-8">	
												<img src="<%=request.getContextPath() %>/getImg.do?method=getImg" alt=""  style="padding: 0;width: 65px;margin-top: 5px;"
													 class="form-control" cursor: pointer;" onclick="this.src=this.src+'?'">
											</div>									       
										</div>
									</div>			                        			                        
									<div class="form-group" >
		
											<button  id="login" type="submit" style="float: none;登录rgin-top: 12px;background-color: #dab69c;border: 1px solid #dab69c" class="btn btn-md btn-primary  btn-block col-sm-6">登录</button>
							 
										 
											<a href="<%=request.getContextPath() %>/customer/regest.jsp" id="urserReg" class="btn btn-md btn-success btn-block">注册</a>
										 
										 					
									</div>
						 </form>		                    
                        </div>
                    </div>
                </div>

    </div>

  </section>

  <!-- Main Container End --> 

  


  <!-- footer -->
    
  <!-- end footer -->


</div>

<jsp:include page="footer.jsp"/>

<!-- End Footer --> 


<script>
	var cur_path = "<%=request.getContextPath()%>";
</script>  
<!-- jquery js --> 

<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery.min.js"></script> 
<!-- bootstrap js -->            
    <script src="<%=request.getContextPath() %>/assets/jquery.serializejson.min.js"></script>                                  
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/bootstrap.min.js"></script> 
<!-- jquery-ui js -->             
                       
<script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.js"></script>
<script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.extend.js"></script>
<script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/language/zh_CN.js"></script>  
<script src="<%=request.getContextPath() %>/assets/bootstrap3-dialog/js/bootstrap-dialog.js"></script>                                  
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jquery-ui.js"></script>                               
<!-- owl.carousel.min js -->       
                                  
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/owl.carousel.min.js"></script> 
                                               
                                    
<!-- jtv-jtv-mobile-menu js -->     
                                  
 <script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/jtv-mobile-menu.js"></script> 
                             
<!-- main js -->                 
                                  
<script type="text/javascript" src="<%=request.getContextPath() %>/customer/js/main.js"></script>
<script src="<%=request.getContextPath() %>/assets/md5.js"></script> 
  <!-- Custom  JavaScript -->
  <script src="<%=request.getContextPath() %>/customer/login.js"></script> 

</body>

</html>