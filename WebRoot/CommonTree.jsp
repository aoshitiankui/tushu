<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="t" uri="/tag" %>
<%-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />   --%>  
  	<script type="text/javascript">
	var cur_path = "<%=request.getContextPath()%>";
	function autoIndex(){
		$("#myTree").height($(document).height()-60);
		$("#myTree").width($(document).width());
	}
	function setTreeVal(){
		var treeObj = $.fn.zTree.getZTreeObj("myTree");
		console.log(treeObj)
		var nodes = treeObj.getCheckedNodes(true);
		console.log(nodes)
		var tempText='',tempVal='',levels='';
		for(i=0;i<nodes.length;i++){
			var node = nodes[i];
			tempText+=nodes[i].name+",";
			tempVal+=nodes[i].id+",";
		}
		if(tempText.length>0){
			tempText = tempText.substring(0,tempText.length-1);
			tempVal = tempVal.substring(0,tempVal.length-1);
		}
		console.log(tempText);
		console.log(tempVal);
		$("#"+'<%=request.getParameter("displayText") %>').val(tempText);
		$("#"+'<%=request.getParameter("displayVlaue") %>').val(tempVal).change();
		
<%-- 		if(parent){
			with(parent.document){
				if(getElementById('<%=request.getParameter("displayText") %>')){
					getElementById('<%=request.getParameter("displayText") %>').value=tempText;
				}
				if(getElementById('<%=request.getParameter("displayVlaue") %>')){
					getElementById('<%=request.getParameter("displayVlaue") %>').value=tempVal;
				}//alert('<%=request.getParameter("levelvalue") %>');
			}
		} --%>
		//$("#"+modal).modal("hide");
<%-- 		if(opener){
			with(opener.document){
				if(getElementById('<%=request.getParameter("displayText") %>')){
					getElementById('<%=request.getParameter("displayText") %>').value=tempText;
				}
				if(getElementById('<%=request.getParameter("displayVlaue") %>')){
					getElementById('<%=request.getParameter("displayVlaue") %>').value=tempVal;
				}//alert('<%=request.getParameter("levelvalue") %>');
			}
			
		} --%>
		//document.getElementById("windown-close").click();
	}
		</script>
 <div class="modal-header">  
     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
             aria-hidden="true">×</span></button>  
     <h4 class="modal-title" id="myModalLabel">产品修改</h4>  
 </div>    


 <div class="modal-body" style ="max-height:800px;overflow-y:scroll;"> 
 <t:TreeTag className="com.tag.MyBaseTreeCongif" 
   queryDataURL=""
   isNeedButton='2' 
   cssName="width:100%;border:0;margin-top:0px;background-color: white;height:280px;width:270px;" 
   displayText='<%=request.getParameter("displayText").toString().trim() %>' 
   displayVlaue='<%=request.getParameter("displayVlaue").toString().trim() %>' 
   isCheckBox='<%=request.getParameter("isCheckBox").toString().trim() %>' 
   isAutoClose='<%=request.getParameter("isAutoClose").toString().trim() %>'
    getTreeValueStyle='<%=request.getParameter("getTreeValueStyle").toString().trim() %>'
   JSONDataFunctionName="getData" 
   autoParam="type"
   treeName="myTree"
    />
<!--     <div style="width:auto; text-align: center;margin-top: 10px">
    <input type="button" id="query" onclick="setTreeVal()" value="确定"  />
    </div>  -->
 </div> 
  <div class="modal-footer">  
     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
     <button type="button" class="btn btn-primary" onclick="setTreeVal()"  id="treeQuery">确定</button>  
 </div>   

