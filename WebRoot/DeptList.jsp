<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<!DOCTYPE html>
<html>
<head>
    <title>部门信息</title>
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
    <script src="<%=request.getContextPath() %>/DeptList.js"></script>

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
			<button id="btn_search" type="button" class="btn btn-default" >
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
			<button id="btn_view" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>查看
			</button>			
		</div>
	</div>
      <div class="row">
          <div class="col-md-12">
              <section class="panel">
                <header class="panel-heading graypanel-heading" style="font-weight: bold;color: black;">
                 	 部门信息管理 》
                </header>
                <div class="panel-body">
                   <form name="DeptForm" id="DeptForm" role="form">
                   	   <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >部门名称：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="deptname" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >父级部门：</label>
                           <div class="col-md-4 col-lg-4">
				            	<input type='text'  class="mytree form-control" readonly onclick="opentree('tipModal','parentdept','0','deptups','deptupNames')"  id="deptupNames"  name="deptupName"/>
								<input type='hidden'  name='deptup' id='deptups' >
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
				         <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >电话：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="tel" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >传真：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="fax" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >联系人：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="conperson" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >联系人电话：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="conpersonphone" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >联系人地址：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="conaddress" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                       <!--  开始 -->
                       <div class="form-group col-md-6 col-lg-6">
                           <div class="col-md-2 col-lg-2"></div>
                           <label for="exampleInputPassword1" class="col-md-2 col-lg-2 control-label" >部门地址：</label>
                           <div class="col-md-4 col-lg-4">
	                           <input type="text" class="form-control" name="address" data-bv-stringLength data-bv-stringLength-min='0' data-bv-stringLength-max='40'>  
                           </div>
                          <div class="col-md-4 col-lg-4"></div>
                       </div>
                   </form>

                </div>
              </section>
          </div>
      </div>
		<div class="row">
    		<div class="col-md-12">
	       	   <table id="Depttable"></table>
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
				<div class="modal fade" id="DeptModal" style="z-index:2030;" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">  
				    <div class="modal-dialog">  
				        <div class="modal-content">  
		
				        </div>  
				    </div>  
				</div> 
			</div> 		  
        </div>
	</body>
</html>