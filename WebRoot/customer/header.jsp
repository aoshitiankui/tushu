<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
String usersn="";
if(user!=null&&user.size()>0){
	usersn= user.get("usersn")+"";
}
%>
<script type="text/javascript">
var cur_user='<%=usersn%>';
</script>
<header>

    <div class="header-container">

      <div class="header-top">

        <div class="container">

          <div class="row"> 

            <!-- Header Language -->

            <div class="col-xs-6 col-sm-6">

              <div class="welcome-msg"><% if(user!=null){out.print(user.get("username"));}else{ out.print("游客");} %></div>
             <div class="welcome-msg">欢迎您 </div>

              

            </div>

            <div class="col-xs-6 col-sm-6"> 

              

              <div class="jtv-top-links">
               
                <div class="links">
                <% if(user==null) {%>
                	 <a href="javascript:window.location.href='<%=path%>/customer/login.jsp'"><span >登陆</span></a> 
               <% }else{%>
                <a href="<%=path%>/loginOut.do"><span >登出</span></a> 
               <%} %>
                </div>

              </div>

              <!-- End Header Top Links --> 

            </div>

          </div>

        </div>

      </div>

      <div class="container">

        <div class="row">
         <div class="col-lg-6 col-md-4 col-sm-4 col-xs-12 jtv-logo-box"> 

            <!-- Header Logo -->

            <div class="logo"> <h1>图书商城</h1> </div>

            <!-- End Header Logo --> 

          </div>
          <div class="col-lg-3 col-md-4 col-sm-4 col-xs-9 clearfix">
          

<!--             <div class="search-box clearfix" id="myCategories" >

              <form id="search_mini_form" name="Categories" >

                <input type="text" placeholder="图书搜索.." value="" maxlength="70" name="search" id="search">

                <button type="button" class="search-btn-bg"><span class="glyphicon glyphicon-search"></span>&nbsp;</button>

              </form>

            </div> -->

          </div>
          

          <div class="col-lg-3 col-md-4 col-sm-4 col-xs-3">

            <div class="jtv-top-cart-box"> 

              <!-- Top Cart -->

              <div class="mini-cart">

                <div data-toggle="dropdown" data-hover="dropdown" class="basket dropdown-toggle"> <a href="javascript:void(0);" onclick="loadCart();"> <span class="price">购物车:</span><span id="mycount" class="cart_count">0</span><span class="price">/¥</span><span id="mymoney" class="price">0.00</span> </a> </div>

                <div>

                </div>

              </div>

            </div>

          </div>




        </div>

      </div>

    </div>

  </header>
    <!-- Navigation -->
  
  <nav>
    <div class="container">
      <div class="mm-toggle-wrap">
        <div class="mm-toggle"><i class="fa fa-align-justify"></i><span class="mm-label">菜单</span> </div>
      </div>
      <div class="nav-inner"> 
        <!-- BEGIN NAV -->
        <ul id="nav" >
          <li class="drop-menu"><a href="<%=request.getContextPath() %>/customer/index.jsp" class="level-top active"><span>&nbsp;&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;&nbsp;</span></a> </li>
          <li class="drop-menu"><a href="<%=request.getContextPath() %>/customer/mainSerarch.jsp" class="level-top active"><span>&nbsp;&nbsp;&nbsp;&nbsp;分类检索&nbsp;&nbsp;&nbsp;&nbsp;</span></a> </li>
          
          
          <li class="drop-menu"><a href="<%=request.getContextPath() %>/customer/messageWrite.jsp" class="level-top active"><span>&nbsp;&nbsp;&nbsp;&nbsp;留言板&nbsp;&nbsp;&nbsp;&nbsp;</span></a> </li>
          <li class="drop-menu"><a href="javascript:void(0)" class="level-top active"><span>更多...</span></a> </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- end nav --> 