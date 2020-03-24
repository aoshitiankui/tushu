<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findAdjustById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">评论信息</h4>  
	</div>
  <form   id="adjustForm" name="adjustForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("adid")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("adid") %>" id="adid" name="adid">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书ID:</label>  
             <input type="text" class="form-control" id="bid" name="bid"  value="<%=data.get("bid")==null?"":data.get("bid").toString()%>"  data-bv-notempty data-bv-notempty-message="图书ID不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>审核状态:</label>
              <t:seledata  styleclass="form-control"  code="ecamined" name="examined" id="examined" data_bv_notempty_message="请选择已审核" def='<%=data.get("examined")==null?"":data.get("examined").toString()%>' />
           </div>
             <div class="form-group">  
                 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>评论内容:</label>
                 <textarea id="adjust" name='adjust' class="form-control " rows="3" onkeydown="textAreaLengthLmit(60)" placeholder="请输入描述，长度不大于60"><%=data.get("adjust")==null?"":data.get("adjust").toString()%></textarea>  
            </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>用户姓名:</label>  
             <input type="text" class="form-control" id="username" name="username"  value="<%=data.get("username")==null?"":data.get("username").toString()%>"  data-bv-notempty data-bv-notempty-message="用户姓名不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>添加时间:</label>  
             <input type="text" class="form-control" id="adtime" name="adtime"  value="<%=data.get("adtime")==null?"":data.get("adtime").toString()%>"  data-bv-notempty data-bv-notempty-message="添加时间不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>