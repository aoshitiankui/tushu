<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findOrdersById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">订单</h4>  
	</div>
  <form   id="ordersForm" name="ordersForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	      <div class="form-group" >  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>订单编号:</label>  
             <input type="text" class="form-control" id="usersn" name="usersn"  value="<%=request.getParameter("orid") %>"  data-bv-notempty data-bv-notempty-message="订单编号不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group" >  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货人:</label>  
             <input type="text" class="form-control" id="usersn" name="usersn"  value="<%=data.get("orname")==null?"":data.get("orname").toString()%>"  data-bv-notempty data-bv-notempty-message="收货人不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>订单状态:</label>
              <t:seledata  styleclass="form-control"  code="orstatus" name="status" id="status" data_bv_notempty_message="请选择订单状态" def='<%=data.get("stauts")==null?"":data.get("stauts").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>收货地址:</label>  
             <input type="text" class="form-control" id="address" name="address"  value="<%=data.get("address")==null?"":data.get("address").toString()%>"  data-bv-notempty data-bv-notempty-message="收货地址不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>手机:</label>  
             <input type="text" class="form-control" id="mobile" name="mobile"  value="<%=data.get("mobile")==null?"":data.get("mobile").toString()%>"  data-bv-notempty data-bv-notempty-message="手机不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>总金额:</label>  
             <input type="text" class="form-control" id="money" name="money" value="<%=data.get("money")==null?"":data.get("money").toString()%>" data-bv-notempty data-bv-notempty-message="总金额不允许为空"  data-bv-numeric data-bv-numeric-message="数字有误"  max='9999'  min="0.01" step="0.01" data-bv-minNumber data-bv-minNumber-message="小数位数为2位">  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>创建时间:</label>  
             <input type="text" class="form-control" id="createtime" name="createtime"  value="<%=data.get("createtime")==null?"":data.get("createtime").toString()%>"  data-bv-notempty data-bv-notempty-message="创建时间不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>