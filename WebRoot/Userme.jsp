<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findUserById");
if(data==null){
	data = new HashMap();
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息</title>
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
    <script src="<%=request.getContextPath() %>/assets/md5.js"></script>     
    <script src="<%=request.getContextPath() %>/assets/common.js"></script>
    <script src="<%=request.getContextPath() %>/Userme.js"></script>

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
          <div class="col-md-12">
              <section class="panel">
                <header class="panel-heading graypanel-heading" style="font-weight: bold;color: black;">
                 	个人信息 》
                </header>
                   <form name="UsermeForm" id="UsermeForm" role="form">
                   	 <div class="modal-body" style ="overflow-y:auto;height: 100%;width:95%"> 
					     <%if(request.getParameter("usersn")!=null) {%>
					    	  <input type="hidden"  value="<%=request.getParameter("usersn") %>" id="usersn" name="usersn"> 
					    	  <input type="hidden" class="form-control" id="password" name="password"  value="<%=data.get("password")==null?"":data.get("password").toString()%>" >     
					    <% }%>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>用户名:</label>  
			             <input type="text" class="form-control" readonly id="userid" name="userid"  value="<%=data.get("userid")==null?"":data.get("userid").toString()%>"  data-bv-notempty data-bv-notempty-message="用户名不允许为空" data-bv-stringLength data-bv-stringLength-min='3' data-bv-stringLength-max='40'>  
			         </div>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>姓名:</label>  
			             <input type="text" class="form-control" id="username" name="username"  value="<%=data.get("username")==null?"":data.get("username").toString()%>"  data-bv-notempty data-bv-notempty-message="姓名不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
			         </div>
			 		  <div class="form-group">
						 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>头像:</label>
						 <div class="file-loading" >
						 	<input type="file" class ="myUpfile bootstrapUpload" name="imgName" id="imgName" value="<%=data.get("imgName")==null?"":data.get("imgName").toString()%>" title="<%=data.get("imgName")==null?"":data.get("imgName").toString()%>" />
						 </div>
						 <input type="hidden" class="filescheck" name="img" id="img" value="<%=data.get("img")==null?"":data.get("img").toString()%>" placeholder="请选择文件" data-bv-trigger="change" data-bv-notEmpty data-bv-notEmpty-message="请上传文件">
					 </div>				         
			          <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>用户类型:</label>
			              <t:seledata  styleclass="form-control"  code="usertype" name="usertype" id="usertype" data_bv_notempty_message="请选择用户类型" def='<%=data.get("usertype")==null?"":data.get("usertype").toString()%>' />
			           </div>
<%-- 			            <div class="form-group" class="control-label">
			            	<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>部门:</label>
			            	<input type='text'  class="mytree form-control" readonly onclick="opentree('tipModal','parentdept','0','dept','deptName')"  id="deptName"  name="deptName"  value="<%=data.get("deptName")==null?"":data.get("deptName").toString()%>"/>
							<input type='hidden'  name='dept' id='dept'  value="<%=data.get("dept")==null?"":data.get("dept").toString()%>" data-bv-trigger="change" data-bv-notempty data-bv-notempty-message="请选择部门" >
			            </div> --%>
				     <div class="form-group">  
				             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>手机:</label>  
				             <input type="text" class="form-control" id="mobile" name="mobile" value="<%=data.get("mobile")==null?"":data.get("mobile").toString()%>" data-bv-notempty data-bv-notempty-message="手机不允许为空" data-bv-phone data-bv-phone-message="手机格式不正确" data-bv-phone-country="CN"   >  
				      </div>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>电话:</label>  
			             <input type="text" class="form-control" id="tel" name="tel"  value="<%=data.get("tel")==null?"":data.get("tel").toString()%>"  data-bv-notempty data-bv-notempty-message="电话不允许为空" data-bv-stringLength data-bv-stringLength-min='3' data-bv-stringLength-max='40'>  
			         </div>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>EMAIL:</label>  
			             <input type="text" class="form-control" id="email" name="email"  value="<%=data.get("email")==null?"":data.get("email").toString()%>"  data-bv-notempty data-bv-notempty-message="EMAIL不允许为空" data-bv-stringLength data-bv-stringLength-min='3' data-bv-stringLength-max='40'>  
			         </div>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>QQ:</label>  
			             <input type="text" class="form-control" id="qq" name="qq"  value="<%=data.get("qq")==null?"":data.get("qq").toString()%>"  data-bv-notempty data-bv-notempty-message="QQ不允许为空" data-bv-stringLength data-bv-stringLength-min='3' data-bv-stringLength-max='40'>  
			         </div>
			         <div class="form-group">  
			             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>地址:</label>  
			             <input type="text" class="form-control" id="address" name="address"  value="<%=data.get("address")==null?"":data.get("address").toString()%>"  data-bv-notempty data-bv-notempty-message="地址不允许为空" data-bv-stringLength data-bv-stringLength-min='3' data-bv-stringLength-max='40'>  
			         </div>
			         <div class="form-group">  
			                 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>介绍:</label>
			                 <textarea id="mem" name='mem' class="form-control " rows="3" onkeydown="textAreaLengthLmit(60)" placeholder="请输入描述，长度不大于60"><%=data.get("mem")==null?"":data.get("mem").toString()%></textarea>  
			         </div>
			         <div class="form-group">  
			         	<button type="submit" id="savefrom" class="btn btn-primary"  >保存	</button>		         
			         </div>			         
				 </div>  
                </form>

              </section>
              </div>
          </div>
	</body>
</html>