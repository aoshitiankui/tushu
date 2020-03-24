<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Map user = (Map)session.getAttribute("user");
Map data = (Map)request.getAttribute("findBooksById");
if(data==null){
	data = new HashMap();
}
%>
	<div class="modal-header">  
	     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
	             aria-hidden="true">×</span></button>  
	     <h4 class="modal-title" id="modalTitle">图书</h4>  
	</div>
  <form   id="booksForm" name="booksForm">  
 	<div class="modal-body" style ="max-height:680px;overflow-y:scroll;height: 80%;">  
	     <%if(request.getParameter("bid")!=null) {%>
	    	  <input type="hidden"  value="<%=request.getParameter("bid") %>" id="bid" name="bid">  
	    <% }%>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书编号:</label>  
             <input type="text" class="form-control" id="bnum" name="bnum"  value="<%=data.get("bnum")==null?"":data.get("bnum").toString()%>"  data-bv-notempty data-bv-notempty-message="图书编号不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书名称:</label>  
             <input type="text" class="form-control" id="bname" name="bname"  value="<%=data.get("bname")==null?"":data.get("bname").toString()%>"  data-bv-notempty data-bv-notempty-message="图书名称不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书类型:</label>
              <t:seledata  styleclass="form-control"  code="btype" name="btype" id="btype" data_bv_notempty_message="请选择图书类型" def='<%=data.get("btype")==null?"":data.get("btype").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>出版社:</label>  
             <input type="text" class="form-control" id="bpublish" name="bpublish"  value="<%=data.get("bpublish")==null?"":data.get("bpublish").toString()%>"  data-bv-notempty data-bv-notempty-message="出版社不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
            <div class="form-group">  
	             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>出版日期:</label>  
	             <input type="text" class="form_date form-control" id="publishdate" name="publishdate" value="<%=data.get("publishdate")==null?"":data.get("publishdate").toString()%>" data-bv-trigger="change" data-bv-notempty data-bv-notempty-message="出版日期不允许为空">  
	        </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>开本:</label>  
             <input type="text" class="form-control" id="pkben" name="pkben"  value="<%=data.get("pkben")==null?"":data.get("pkben").toString()%>"  data-bv-notempty data-bv-notempty-message="开本不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>封装方式:</label>
              <t:seledata  styleclass="form-control"  code="fztype" name="pfengz" id="pfengz" data_bv_notempty_message="请选择封装方式" def='<%=data.get("pfengz")==null?"":data.get("pfengz").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>版次:</label>  
             <input type="text" class="form-control" id="bbanci" name="bbanci"  value="<%=data.get("bbanci")==null?"":data.get("bbanci").toString()%>"  data-bv-notempty data-bv-notempty-message="版次不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>作者:</label>  
             <input type="text" class="form-control" id="writer" name="writer"  value="<%=data.get("writer")==null?"":data.get("writer").toString()%>"  data-bv-notempty data-bv-notempty-message="作者不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>译者:</label>  
             <input type="text" class="form-control" id="traner" name="traner"  value="<%=data.get("traner")==null?"":data.get("traner").toString()%>"  data-bv-notempty data-bv-notempty-message="译者不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>ISBN:</label>  
             <input type="text" class="form-control" id="isbn" name="isbn"  value="<%=data.get("isbn")==null?"":data.get("isbn").toString()%>"  data-bv-notempty data-bv-notempty-message="ISBN不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>市场价:</label>  
             <input type="number" class="form-control" id="mprice" name="mprice" value="<%=data.get("mprice")==null?"":data.get("mprice").toString()%>" data-bv-notempty data-bv-notempty-message="市场价不允许为空"  data-bv-numeric data-bv-numeric-message="数字有误"  max='9999'  min="0.01" step="0.01" data-bv-minNumber data-bv-minNumber-message="小数位数为2位">  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>会员价:</label>  
             <input type="number" class="form-control" id="vprice" name="vprice" value="<%=data.get("vprice")==null?"":data.get("vprice").toString()%>" data-bv-notempty data-bv-notempty-message="会员价不允许为空"  data-bv-numeric data-bv-numeric-message="数字有误"  max='9999'  min="0.01" step="0.01" data-bv-minNumber data-bv-minNumber-message="小数位数为2位">  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>折扣:</label>  
             <input type="text" class="form-control" id="salepoint" name="salepoint"  value="<%=data.get("salepoint")==null?"":data.get("salepoint").toString()%>"  data-bv-notempty data-bv-notempty-message="折扣不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>销量:</label>  
             <input type="text" class="form-control" id="sales" name="sales"  value="<%=data.get("sales")==null?"":data.get("sales").toString()%>"  data-bv-notempty data-bv-notempty-message="销量不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>浏览次数:</label>  
             <input type="text" class="form-control" id="viewcount" name="viewcount"  value="<%=data.get("viewcount")==null?"":data.get("viewcount").toString()%>"  data-bv-notempty data-bv-notempty-message="浏览次数不允许为空" data-bv-stringLength data-bv-stringLength-min='1' data-bv-stringLength-max='40'>  
         </div>
 		   <div class="form-group">
			 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>封面:</label>
			 <div class="file-loading" >
			 	<input type="file" class ="myUpfile bootstrapUpload" name="imgName" id="imgName" value="<%=data.get("imgName")==null?"":data.get("imgName").toString()%>" title="<%=data.get("imgName")==null?"":data.get("imgName").toString()%>" />
			 </div>
			 <input type="hidden" class="filescheck" name="img" id="img" value="<%=data.get("img")==null?"":data.get("img").toString()%>" placeholder="请选择文件" data-bv-trigger="change" data-bv-notEmpty data-bv-notEmpty-message="请上传文件">
			 </div>	
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>库存:</label>  
             <input type="number" class="form-control" id="stores" name="stores" value="<%=data.get("stores")==null?"":data.get("stores").toString()%>" data-bv-integer data-bv-integer-message="数字格式不正确" data-bv-between data-bv-between-min='0' data-bv-between-max='9999'    data-bv-notempty data-bv-notempty-message="库存不允许为空">  
         </div>
         <div class="form-group" id="instoresdatediv">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>入库时间:</label>  
             <input type="text" readonly class="form-control" id="instoresdate" name="instoresdate"  value="<%=data.get("instoresdate")==null?"":data.get("instoresdate").toString()%>">  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>是否上架:</label>
              <t:seledata  styleclass="form-control"  code="issale" name="issale" id="issale" data_bv_notempty_message="请选择是否上价" def='<%=data.get("issale")==null?"":data.get("issale").toString()%>' />
           </div>
         <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>推荐指数:</label>  
             <input type="number" class="form-control" id="ratingnum" name="ratingnum" value="<%=data.get("ratingnum")==null?"":data.get("ratingnum").toString()%>" data-bv-integer data-bv-integer-message="数字格式不正确" data-bv-between data-bv-between-min='0' data-bv-between-max='9999'    data-bv-notempty data-bv-notempty-message="推荐指数不允许为空">  
         </div>
          <div class="form-group">  
             <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>是否新品:</label>
              <t:seledata  styleclass="form-control"  code="isnew" name="isnew" id="isnew" data_bv_notempty_message="请选择是否新品" def='<%=data.get("isnew")==null?"":data.get("isnew").toString()%>' />
           </div>
             <div class="form-group">  
                 <label for="message-text" class="control-label"><span style="color:#FF9966">*</span>图书介绍:</label>
                 <textarea id="bdesc" name='bdesc' class="form-control " rows="3" onkeydown="textAreaLengthLmit(500)" placeholder="请输入描述，长度不大于500"><%=data.get("bdesc")==null?"":data.get("bdesc").toString()%></textarea>  
            </div>
	 	</div>  
	  	<div class="modal-footer">  
	     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	     <button type="submit" class="btn btn-primary" id="bsSave">保存</button>  
	 	</div> 
	</form>