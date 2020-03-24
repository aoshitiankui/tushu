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

            <li class="home"> <a href="#" title="Go to Home Page">首页</a> <span>/</span> </li>


            <li> <strong>用户注册</strong> </li>

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
			                    <form role="form" action="" method="post" class="login-form" id="regestForm">
			                    	<div class="form-group">
			                    		<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>用户名:</label>
			                        	<input class="form-control" placeholder="请输入用户名" name="userId" id="userId" type="text" autofocus >
			                        </div>
			                        <div class="form-group">
										<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>密码:</label>
			                        	<input class="form-control" placeholder="请输入密码" name="passWord" id="passWord" type="password" value="" data-bv-notempty data-bv-notempty-message="密码不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='15'>
			                        </div>
			                        <div class="form-group">
										<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>确认密码:</label>
			                        	<input class="form-control" placeholder="请确认密码" name="reppassWord" id="reppassWord" type="password" value="" data-bv-notempty data-bv-notempty-message="密码不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='15' data-bv-identical data-bv-identical-field="passWord" data-bv-identical-message="两次密码不一致">
			                        </div>			                        
									<div class="form-group">
										<label for="message-text" class="control-label"><!-- <span style="color:#FF9966">*</span> -->邮箱:</label>
			                        	<input class="form-control" placeholder="请输入email" name="email" id="email" type="email" value="">
									</div>
									<div class="form-group">
		
									    <button  id="regest" type="submit" style="float: none;margin-top: 12px;" class="btn btn-md btn-success  btn-block col-sm-6">注册</button>
									    <a href="<%=request.getContextPath() %>/customer/login.jsp" id="urserReg" style="background-color: #dab69c;border: 1px solid #dab69c" class="btn btn-md btn-success btn-block">已有账号?去登陆</a>
										 
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
  <script src="<%=request.getContextPath() %>/customer/regest.js"></script> 

</body>

</html>