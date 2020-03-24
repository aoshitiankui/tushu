<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findCartById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">购物车</h4>  
	</div>
  <form   id="cartForm" name="cartForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("cid")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("cid") %>" id="cid" name="cid">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书名称:</label>  
             <input type="text" class="form-control" id="usersn" name="usersn" readonly value="<%=data.get("bname")==null?"":data.get("bname").toString()%>"  data-bv-notempty data-bv-notempty-message="用户ID不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>购买数量:</label>  
             <input type="number" class="form-control" id="cnum" name="cnum"  value="<%=data.get("cnum")==null?"":data.get("cnum").toString()%>"  data-bv-integer data-bv-integer-message="数字格式不正确" data-bv-between data-bv-between-min='1' data-bv-between-max='99'    data-bv-notempty data-bv-notempty-message="购买数量不允许为空">  
         </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>