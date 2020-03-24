<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<!DOCTYPE html>
<html>
<head>
    <title>购物车</title>
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
    <script src="<%=request.getContextPath() %>/CartList.js"></script>

    <style type="text/css">

		body, html {
			height: 100%;
			width: 100%;
			overflow-x: hidden!important;
		} 
     
    </style>

</head>
<body>

    <div class="row" >
		<div id="toolbar" class="btn-group col-md-12">
 
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>结算
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
 		
		</div>
	</div>
      <div class="row">
          <div class="col-md-12">
              <section class="panel">
                <header class="panel-heading graypanel-heading" style="font-weight: bold;color: black;">
                 	 购物车管理 》
                </header>
              </section>
          </div>
      </div>

		<div class="row">
    		<div class="col-md-12">
	       	   <table id="Carttable"></table>
       	   </div>
 		</div>
      <div class="row">
      	<div style="margin-left: 10px;display: none;" class="col-md-8" id="checkDiv">
		  <form   id="checkordersForm" name="checkordersForm">  
		 	<div class="modal-body">  
		 			<input id="checkeds" type ="hidden" name ="checkeds" value="">
		         <div class="form-group" >  
		             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货人:</label>  
		             <input type="text" class="form-control" id="orname" name="orname"  value=""  data-bv-notempty data-bv-notempty-message="收货人不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
		         </div>
		         <div class="form-group">  
		             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货地址:</label>  
		             <input type="text" class="form-control" id="address" name="address"  value=""  data-bv-notempty data-bv-notempty-message="收货地址不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
		         </div>
		         <div class="form-group">  
		             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>手机:</label>  
		             <input type="text" class="form-control" id="mobile" name="mobile"  value=""  data-bv-notempty data-bv-notempty-message="手机不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
		         </div>
		         <div class="form-group">  
		             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>总金额:</label>  
		             <input type="text" class="form-control" readonly id="money" name="money" value="0" data-bv-notempty data-bv-notempty-message="总金额不允许为空"  data-bv-numeric data-bv-numeric-message="数字有误"  max='9999'  min="0.00" step="0.01" data-bv-minNumber data-bv-minNumber-message="小数位数为2位">  
		         </div>
				  	<div class="modal-footer">  
				     <button type="submit" class="btn btn-primary" id="mycheckSave">确认订单</button>  
				 	</div>		         
			 	</div>  
			</form>
			</div>
      </div> 		
 		<div class="row">
 		   <div class="col-md-12">
				<div class="modal fade" id="tipModal" style="z-index:2040;"  tabindex="100" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
					<div class="modal-dialog">
						<div class="modal-content">
		
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>
				<div class="modal fade" id="CartModal" style="z-index:2030;" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">  
				    <div class="modal-dialog">  
				        <div class="modal-content">  
		
				        </div>  
				    </div>  
				</div> 
			</div> 		  
        </div>
	</body>
</html>