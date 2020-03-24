<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	    <meta charset="utf-8">
	 	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <title>登陆页</title>
        <!-- CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/loginassets/googleRoboto.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap3-dialog/css/bootstrap-dialog.css"> 
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.css" >
		<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/loginassets/form-elements.css"> --%>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/loginassets/style.css">
	    <script type="text/javascript">
			var cur_path = "<%=request.getContextPath() %>";
		</script> 
    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text" style="text-align:center">
                            <h1><strong>网上书城后台管理 </strong></h1>
                            <div class="description">
                            	<p>
	                            	bookmall system 
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>用户登陆 </h3>
                            		
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key" style="margin-bottom: 10px;"></i>
                        		</div>
                            </div>
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
												<img src="<%=request.getContextPath() %>/getImg.do?method=getImg" alt=""  style="padding: 0;width: 65px;"
													 class="form-control" cursor: pointer;" onclick="this.src=this.src+'?'">
											</div>									       
										</div>
									</div>			                        			                        
									<div class="form-group" >
		
											<button  id="login" type="submit" style="float: none;margin-top: 12px;" class="btn btn-md btn-primary  btn-block col-sm-6">登陆</button>
							 
										 
											<a href="<%=request.getContextPath() %>/regest.jsp" id="urserReg" class="btn btn-md btn-success btn-block">注册</a>
										 
										 					
									</div>
						 </form>		                    
                        </div>
                    </div>
                </div>
            </div>
          </div>
   </div>


 

       
	    <script src="<%=request.getContextPath() %>/assets/jquery.min.js"></script>
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.js"></script>
	    <script src="<%=request.getContextPath() %>/assets/loginassets/jquery.backstretch.min.js"></script>	
	    <script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.js"></script>
	    <script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.extend.js"></script>
	    <script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/language/zh_CN.js"></script>  
	    <script src="<%=request.getContextPath() %>/assets/bootstrap3-dialog/js/bootstrap-dialog.js"></script>  
		<script src="<%=request.getContextPath() %>/assets/md5.js"></script> 
	    <!-- Custom  JavaScript -->
	    <script src="<%=request.getContextPath() %>/login.js"></script>        
        <!--[if lt IE 10]>
            <script src="<%=request.getContextPath() %>/assets/loginassets/placeholder.js"></script>
        <![endif]-->

    </body>

</html>