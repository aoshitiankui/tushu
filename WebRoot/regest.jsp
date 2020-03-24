<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	    <meta charset="utf-8">
	 	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <title>用户注册</title>
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
                            <h1><strong>图书商城 </strong></h1>
                            <div class="description">
                            	<p>
	                            	bookmall 
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>用户注册</h3>
                            		<!-- <p>Enter your username and password to log on:</p> -->
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key" style="margin-bottom: 10px;"></i>
                        		</div>
                            </div>
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
	    <script src="<%=request.getContextPath() %>/regest.js"></script>        
        <!--[if lt IE 10]>
            <script src="<%=request.getContextPath() %>/assets/loginassets/placeholder.js"></script>
        <![endif]-->

    </body>

</html>