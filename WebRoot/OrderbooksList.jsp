<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findOrdersByIdView");
if(data==null){
	data = new HashMap();
}
String status = request.getParameter("status");
String usertype=(String)user.get("usertype");
%>
<!DOCTYPE html>
<html>
<head>
    <title>订单商品</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap-table/src/bootstrap-table.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap-validator/css/bootstrapValidator.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap-fileinput/css/fileinput.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap3-dialog/css/bootstrap-dialog.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/common.css">
    <link href="<%=request.getContextPath() %>/assets/bs-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
    <script>
		var cur_path = "<%=request.getContextPath()%>";
		var cur_status=<%=status%>;
		var userType ="<%=usertype%>";
	</script>  
    <script src="<%=request.getContextPath() %>/assets/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/assets/jquery.serializejson.min.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bootstrap-table/src/bootstrap-table.js"></script>
	<script src="<%=request.getContextPath() %>/assets/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bootstrap-fileinput/js/fileinput.min.js"></script>    	
    <script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/bootstrapValidator.extend.js"></script>    
	<script src="<%=request.getContextPath() %>/assets/bootstrap-validator/js/language/zh_CN.js"></script>
	<script src="<%=request.getContextPath() %>/assets/bootstrap-fileinput/js/locales/zh.js"></script>     
    <script src="<%=request.getContextPath() %>/assets/bootstrap3-dialog/js/bootstrap-dialog.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bs-datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/assets/bs-datetimepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/assets/server-side-pagination.js"></script>
    <script src="<%=request.getContextPath() %>/assets/bootstrap-fileinput-init.js"></script>
    <script src="<%=request.getContextPath() %>/assets/common.js"></script>
    <script src="<%=request.getContextPath() %>/OrderbooksList.js"></script>

    <style type="text/css">

		body, html {
			height: 100%;
			width: 100%;
			overflow-x: hidden!important;
		} 
     
    </style>

</head>
<body>

      <div class="row">
      	<div style="display: none">
      		<form name="OrderbooksForm" id='OrderbooksForm'>
      			<input name="orid" value="<%=request.getParameter("orid") %>"/>
      		</form>
      	</div>
      </div>
		<div class="row">
		     <header class="panel-heading graypanel-heading" style="font-weight: bold;color: black;line-height: 30px">
		     <div style="display: inline;margin-right: 20px;background-color: orange;"><button type="button" onclick="javascript:history.go(-1)" class="btn btn-sm btn-info">返回</button></div> 
                 <span>  订单编号号：<%=request.getParameter("orid") %></span><span> 
                                                  创建时间:<%=data.get("createtime")==null?"":data.get("createtime").toString()%></span>
                                                 
                </header>
    		<div class="col-md-12">
	       	   <table id="Orderbookstable"></table>
       	   </div>
 		</div>
 		<div class="row">
 		<div class="col-md-12">
   <form   id="ordersForm" name="ordersForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
         <div class="form-group" >  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货人:</label>  
            <span><%=data.get("orname")==null?"":data.get("orname").toString()%></span>
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>订单状态:</label>
             <span><%=data.get("statusname")==null?"":data.get("statusname").toString()%></span>
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货地址:</label>  
             <span><%=data.get("address")==null?"":data.get("address").toString()%></span>
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>手机:</label>  
             <span><%=data.get("mobile")==null?"":data.get("mobile").toString()%></span>
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>总金额:</label>  
             <span><%=data.get("money")==null?"":data.get("money").toString()%></span>
         </div>
	 	</div>  
	</form>
	</div>		 		  
        </div>
	</body>
</html>