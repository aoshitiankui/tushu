<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findCodesById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">系统字典</h4>  
	</div>
  <form   id="codesForm" name="codesForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("id")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("id") %>" id="id" name="id">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>编码类型:</label>  
             <input type="text" class="form-control" id="codetype" name="codetype"  value="<%=data.get("codetype")==null?"":data.get("codetype").toString()%>"  data-bv-notempty data-bv-notempty-message="编码不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>编码名称:</label>  
             <input type="text" class="form-control" id="codename" name="codename"  value="<%=data.get("codename")==null?"":data.get("codename").toString()%>"  data-bv-notempty data-bv-notempty-message="名称不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>组内排序:</label>  
             <input type="number" class="form-control" id="ordernum" name="ordernum" value="<%=data.get("ordernum")==null?"":data.get("ordernum").toString()%>" data-bv-notempty data-bv-notempty-message="编号不允许为空"  data-bv-numeric data-bv-numeric-message="数字有误"  max='9999'  min="0.01" step="0.01" data-bv-minNumber data-bv-minNumber-message="小数位数为2位">  
         </div>

         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>类型名称:</label>  
             <input type="text" class="form-control" id="codetypename" name="codetypename"  value="<%=data.get("codetypename")==null?"":data.get("codetypename").toString()%>"  data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group" style="display: none">  
             <label for="message-text" class="control-label">父级编码:</label>  
             <input type="text" class="form-control" id="pid" name="pid" value="<%=data.get("pid")==null?"":data.get("pid").toString()%>" >  
         </div>        
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>