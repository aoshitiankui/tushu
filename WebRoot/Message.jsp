<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findMessageById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">留言板</h4>  
	</div>
  <form   id="messageForm" name="messageForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("mid")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("mid") %>" id="mid" name="mid">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>EMAIL:</label>  
             <input type="text" class="form-control" id="email" name="email"  value="<%=data.get("email")==null?"":data.get("email").toString()%>"  data-bv-notempty data-bv-notempty-message="EMAIL不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>手机:</label>  
             <input type="text" class="form-control" id="mobile" name="mobile"  value="<%=data.get("mobile")==null?"":data.get("mobile").toString()%>"  data-bv-notempty data-bv-notempty-message="手机不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
             <div class="form-group">  
                 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>留言内容:</label>
                 <textarea id="messages" name='messages' class="form-control " rows="3" onkeydown="textAreaLengthLmit(60)" placeholder="请输入描述，长度不大于60"><%=data.get("messages")==null?"":data.get("messages").toString()%></textarea>  
            </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>留言时间:</label>  
             <input type="text" class="form-control" id="mtime" name="mtime"  value="<%=data.get("mtime")==null?"":data.get("mtime").toString()%>"  data-bv-notempty data-bv-notempty-message="留言时间不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>是否已处理:</label>
              <t:seledata  styleclass="form-control"  code="isdeal" name="isdeal" id="isdeal" data_bv_notempty_message="请选择是否已处理" def='<%=data.get("isdeal")==null?"":data.get("isdeal").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>姓名:</label>  
             <input type="text" class="form-control" id="name" name="name"  value="<%=data.get("name")==null?"":data.get("name").toString()%>"  data-bv-notempty data-bv-notempty-message="姓名不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>留言类型:</label>
              <t:seledata  styleclass="form-control"  code="mestype" name="mtype" id="mtype" data_bv_notempty_message="请选择留言类型" def='<%=data.get("mtype")==null?"":data.get("mtype").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>IP地址:</label>  
             <input type="text" class="form-control" id="ipaddress" name="ipaddress"  value="<%=data.get("ipaddress")==null?"":data.get("ipaddress").toString()%>"  data-bv-notempty data-bv-notempty-message="IP地址不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>主题:</label>  
             <input type="text" class="form-control" id="title" name="title"  value="<%=data.get("title")==null?"":data.get("title").toString()%>"  data-bv-notempty data-bv-notempty-message="主题不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>