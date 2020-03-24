<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
String userType = (String)user.get("usertype");
%>
<head>
    <meta charset="utf-8">
 	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>主页</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css">


    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/assets/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
	<link href="<%=request.getContextPath() %>/assets/bootstap-start/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.css" rel="stylesheet">  
    <link rel="stylesheet" href="<%=request.getContextPath() %>/znavbar/nvbarbule3.css">

    <style type="text/css">
    	body, html{
	   	height: 100%;
	   	width: 100%;
	       }
    	#wrapper>.navbar-default.sidebar{
    	 height: 100%;
    	}
    </style>
</head>

<body>

    <div id="wrapper">
            <div class="navbar-default sidebar" role="navigation" style="margin-top: 0px;">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form" style="min-height: 20px;">
<!--                                 <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            	</span> -->
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="javascript:window.location.href='<%=request.getContextPath() %>/customer/index.jsp'" ><i class="fa fa-dashboard fa-fw"></i>网上书城</a>
                        </li>
                        <%if (userType.equals("1")) {%>
                        	
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 系统管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/CodesList.jsp">字典管理</a>
                                </li>
<%--                                 <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/DeptList.jsp">部门管理</a>
                                </li> --%>
                                <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/UserList.jsp">用户管理</a>
                                </li>                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 个人信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/user/findUserById.do?actionType=1&usersn=<%=user.get("usersn") %>">个人信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>                         
                             <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/BooksList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>图书管理</a>
                                </li>
                                 <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/OrdersList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>订单管理</a>
                                </li>                                
                                 <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/MessageList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>留言板管理</a>
                                </li>
                               <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/AdjustList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>商品评论审核</a>
                                </li>                      
                        <%}else{%>
                          <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 个人信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/user/findUserById.do?actionType=1&usersn=<%=user.get("usersn") %>">个人信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                          <li>
                               <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/CartList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>购物车</a>
                             </li>
                           <li>
                                    <a href="javascript:void(0)" thref="<%=request.getContextPath() %>/OrdersList.jsp"><i class="fa fa-bar-chart-o fa-fw"></i>订单信息</a>
                                </li>  
                        
                        <%} %>

<!--                         <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Panels and Wells</a>
                                </li>
                                <li>
                                    <a href="buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="typography.html">Typography</a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            /.nav-second-level
                        </li> -->

                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top"   role="navigation" style="margin-bottom: 0;margin-left: 250px;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="javascript:void(0);">
                <i class="fa fa-twitter fa-fw" style='font-weight: bolder;color: black;'></i> <i class="fa"></i> <i class="fa" style='font-weight: bolder;color: black;' >图书商城</i>
				</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                 <img alt="" class="img-circle" style="width: 35px;height:35px;" src='<%if(user.get("img")!=null) {out.print(request.getContextPath()+"/upload.s?method=down&fileid="+user.get("img"));}else{out.print(request.getContextPath()+"/assets/loginassets/default.jpg");} %> '>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                       <i class="fa fa-tasks fa-fw"></i> <i class="fa">欢迎您，</i> <i class="fa"><%=user.get("userid") %></i>
                      
                    </a>
                    
                </li>

                <!-- /.dropdown -->

                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                    	
                        <li><a href="javascript:document.outform.submit();" ><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        <form id="outform" name ="outform" action="<%=request.getContextPath() %>/loginOut.do"></form>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
                
            </ul>
            <!-- /.navbar-top-links -->


            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <!-- Main content -->
            <% String loadAddress= request.getContextPath()+"/user/findUserById.do?actionType=1&usersn="+user.get("usersn");
               String jump = request.getParameter("jumpUrl");
               
            	if(jump!=null&&!jump.equals("") ){
            		loadAddress=jump;
            	}
            %>
			<iframe id="mainFrame" scrolling="no" frameborder="0" src="<%=loadAddress%>" style="width:100%;height:100%;border:none;overflow:auto;"></iframe> 
            <!--         content -->
            <div class="footer-main">
                Copyright &copy Director, 2019. cc
            </div>        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    
    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/assets/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/assets/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/assets/bootstap-start/js/sb-admin-2.js"></script>

</body>

</html>
