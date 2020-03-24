<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findDeptById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">部门信息</h4>  
	</div>
  <form   id="deptForm" name="deptForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("id")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("id") %>" id="id" name="id">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>部门名称:</label>  
             <input type="text" class="form-control" id="deptname" name="deptname"  value="<%=data.get("deptname")==null?"":data.get("deptname").toString()%>"  data-bv-notempty data-bv-notempty-message="部门名称不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
            <div class="form-group" class="control-label">
            	<label for="message-text" class="control-label"><span style="color:#FF9966">*</span>父级部门:</label>
            	<input type='text'  class="mytree form-control" readonly onclick="opentree('tipModal','parentdept','0','deptup','deptupName')"  id="deptupName"  name="deptupName"  value="<%=data.get("deptupName")==null?"":data.get("deptupName").toString()%>"/>
				<input type='hidden'  name='deptup' id='deptup'  value="<%=data.get("deptup")==null?"":data.get("deptup").toString()%>" >
            </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>电话:</label>  
             <input type="text" class="form-control" id="tel" name="tel"  value="<%=data.get("tel")==null?"":data.get("tel").toString()%>"   data-bv-stringLength data-bv-stringLength-min='8' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label">传真:</label>  
             <input type="text" class="form-control" id="fax" name="fax"  value="<%=data.get("fax")==null?"":data.get("fax").toString()%>"   data-bv-stringLength data-bv-stringLength-min='8' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label">联系人:</label>  
             <input type="text" class="form-control" id="conperson" name="conperson"  value="<%=data.get("conperson")==null?"":data.get("conperson").toString()%>"   data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
	     <div class="form-group">  
	             <label for="message-text" class="control-label">联系人电话:</label>  
	             <input type="text" class="form-control" id="conpersonphone" name="conpersonphone" value="<%=data.get("conpersonphone")==null?"":data.get("conpersonphone").toString()%>"  data-bv-phone data-bv-phone-message="联系人电话格式不正确" data-bv-phone-country="CN"   >  
	      </div>
         <div class="form-group">  
             <label for="message-text" class="control-label">联系人地址:</label>  
             <input type="text" class="form-control" id="conaddress" name="conaddress"  value="<%=data.get("conaddress")==null?"":data.get("conaddress").toString()%>"   data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label">部门地址:</label>  
             <input type="text" class="form-control" id="address" name="address"  value="<%=data.get("address")==null?"":data.get("address").toString()%>"  data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
             <div class="form-group">  
                 <label for="message-text" class="control-label">部门描述:</label>
                 <textarea id="des" name='des' class="form-control " rows="3" onkeydown="textAreaLengthLmit(60)" placeholder="请输入描述，长度不大于60"><%=data.get("des")==null?"":data.get("des").toString()%></textarea>  
            </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>