package com.tag;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.dao.DB;




/**
 * @author 尹超
 * @date Nov 16, 2011 5:28:44 PM 功能描述: 树形控件配置 如需要此方法不能满足需求 可以重写下面所有方法
 *       getFirstJOSNData为虚方法 返回JSON数据
 */
public abstract class BaseTreeConfig {
	/**
	 * @param request
	 * @return 返回js所在文件
	 * @comment
	 */
	public String getJavascriptPath(HttpServletRequest request) {
		return "<link rel=\"stylesheet\" href=\"" + request.getContextPath()
				+ "/base/popedom/js/zTree/css/demo.css\" type=\"text/css\">"
				+"<link href="+request.getContextPath()+"\"/base/popedom/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />"
				+ "<link rel=\"stylesheet\" href=\"" + request.getContextPath()
				+ "/base/popedom/js/zTree/css/zTreeStyle/zTreeStyle.css\" type=\"text/css\">"
				//打开DIV时 JS冲突
				/*+ "<script type=\"text/javascript\" src=\""
				+ request.getContextPath()
				+ "/base/popedom/js/zTree/js/jquery-1.4.4.min.js\"></script>"*/
				+ "<script type=\"text/javascript\" src=\""
				+ request.getContextPath()
				+ "/base/popedom/js/zTree/js/jquery.ztree.core-3.0.js\"></script>"
				+ "<script type=\"text/javascript\" src=\""
				+ request.getContextPath()
				+ "/base/popedom/js/zTree/js/jquery.ztree.excheck-3.0.js\"></script>"
				+ "<script type=\"text/javascript\"   src=\""
				+ request.getContextPath()
				+ "/base/popedom/js/zTree/js/jquery.form.utf8.js\"></script>";
	}

	/**
	 * @param tree
	 *            树的字符串
	 * @param display
	 *            是否展示确定关闭按钮
	 * @param request
	 * @return 设置树所在位置
	 * @comment
	 */
	public String setTreeLocation(String tree, String display,
			HttpServletRequest request) {
		String display1 = " style=\"display:none;\" ";
		if ("0".equals(display)) {
			display1 = " style=\"display:display;\" ";
		}
		String str = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td>"
				+ tree
				+ "</td></tr><tr "
				+ display1
				+ "><td align=\"center\" height=\"30\" >"
				+ "<input type=\"button\" value=\"确定\" onclick=\"getCkeckBox()\"  class=\"sbttn\"/>&nbsp;"
				+ "<input type=\"button\" value=\"关闭\" onclick=\"self.close()\"  class=\"sbttn\"/>"
				+ "</td></tr></table>";
		return str;
	}

	/**
	 * @param url
	 *            设置异步提交的URL
	 * @param request
	 * @return 返回form字符串
	 * @comment
	 */
	public String setForm(String url, HttpServletRequest request) {
		return "<form action=\""
				+ request.getContextPath()
				+ url
				+ "\" name=\"form1\" id=\"form1\" method=\"post\">"
				+ "<input type=\"hidden\" id=\"jqueryPost\" name=\"jqueryPost\" />"
				+ "<input type=\"hidden\" id=\"common\" name=\"common\" value=\""
				+ request.getParameter("common") + "\" />" + "</form>";
	}

	/**
	 * @param request
	 * @param DisplayText
	 * @param DisplayVlaue
	 * @param CommitURL
	 * @param IsCheckBox
	 * @param QueryURL
	 * @param OtherParam
	 * @param GetTreeValueStyle
	 * @param IsAutoClose
	 * @param QueryDataURL
	 * @param DocumentObject
	 * @return 返回javascript代码
	 * @comment
	 */
	public String getScript(HttpServletRequest request, String DisplayText,
			String DisplayVlaue, String CommitURL, String IsCheckBox,
			String QueryURL, String autoParam, String GetTreeValueStyle,
			String IsAutoClose, String QueryDataURL, String DocumentObject,
			String JSONDataFunctionName,String treeName,String treeNodeClickFunctionName
			,String sql,String rightClick,String rightClickId) {
		if(treeNodeClickFunctionName==null||"".equals(treeNodeClickFunctionName.trim())){
			treeNodeClickFunctionName="zTreeOnClick";
		}
		// JS打印
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<script  type=\"text/javascript\">");
			sb.append("var textVal='" + DisplayText + "';" + "var vals='"
					+ DisplayVlaue + "';" + "var url='" + CommitURL + "';"
					+ "var ischeckbox = '" + IsCheckBox + "';");
			String enable="true";
			if("-1".equals(IsCheckBox)){
				enable="false";
			}
			if ("0".equals(IsCheckBox)) {
				IsCheckBox = (",chkStyle: \"radio\",radioType: \"all\"");
			} else {
				IsCheckBox = "";
			}
			String right="";
			if("0".equals(rightClick)){
				right=",onRightClick:OnRightClick";
			}
			sb.append("var setting = {" + "view: {" + "showIcon: true" + "},"
					+ "check: {" + "enable: "+enable+"" + IsCheckBox + "},"
					+ "data: {"
					+ "simpleData: {"
					+ "enable: true"
					+ "}"
					+ "},async: {"
					+ "enable: true,"
					+ "url:\""
					+ QueryURL
					+ "\","
					+ "autoParam:[\"id\",\"pId\",\"name\""
					+ autoParam
					+ "]"
					+ "}," + "callback: {" + "onClick:"+treeNodeClickFunctionName+"" + right+"}"
					+ "};");
			if (QueryURL != null && !"".equals(QueryURL.trim())) {
				sb.append("$(document).ready(function(){"
						+ "$.fn.zTree.init($(\"#"+treeName+"\"), setting);});");
			} else if(sql!=null&&!"".equals(sql.trim())) {
				sb
						.append("var zNodes=eval("
								+ getFirstJOSNData(sql)
								+ ");"
								+ "$.fn.zTree.init($(\"#"+treeName+"\"), setting, zNodes);");
			}else {
				sb
				.append("var zNodes=eval("
						+ getFirstJOSNData(request)
						+ ");"
						+ "$.fn.zTree.init($(\"#"+treeName+"\"), setting, zNodes);");
			}
			String functionString = "function getCkeckBox(){"
					+ "var tempVal=\"\";" + "var tempText=\"\";"
					+ "var groupid=\"\";"
					+ "var treeObj = $.fn.zTree.getZTreeObj(\""+treeName+"\");"
					+ "var nodes = treeObj.getCheckedNodes(true);"
					+ "var p=null;" + "for(i=0;i<nodes.length;i++){"
					+ "if('0'=='"
					+ GetTreeValueStyle
					+ "'){"
					+ "if(!nodes[i].isParent){"
					+ "	tempText+=nodes[i].name+\",\";"
					+ "tempVal+=nodes[i].id+\",\";"
					+ "}"
					+ "}"
					+ "if('1'=='"
					+ GetTreeValueStyle
					+ "'){"
					+ "if(nodes[i].isParent){"
					+ "	tempText+=nodes[i].name+\",\";"
					+ "tempVal+=nodes[i].id+\",\";"
					+ "}"
					+ "}"
					+ "if('2'=='"
					+ GetTreeValueStyle
					+ "'){"
					+ "	tempText+=nodes[i].name+\",\";"
					+ "tempVal+=nodes[i].id+\",\";"
					+ "}"
					+ "}"
					+ "if(opener&&(url=='null'||url=='')){"
					+ "if(textVal!='null'){"
					+ "if(opener.document.getElementById(textVal)){"
					+ "	try{"
					+ "		opener.document.getElementById(textVal).value=tempText.substring(0,tempText.length-1);"
					+ "	}catch(err){"
					+ "		opener.document.getElementById(textVal).innerHTML=tempText;"
					+ "	}"
					+ "}"
					+ "}"
					+ "if(vals!='null'){"
					+ "	if(opener.document.getElementById(vals)){"
					+ "	try{"
					+ "			opener.document.getElementById(vals).value=tempVal.substring(0,tempVal.length-1);"
					+ "	}catch(err){"
					+ "		opener.document.getElementById(vals).innerHTML=tempVal;"
					+ "	}"
					+ "}"
					+ "}"
					+ "self.close();"
					+ "}else if(url!='null'){"
					+ "	$(\"#jqueryPost\").val(tempVal);"
					+ "	 var option={beforeSubmit:function() "
					+ " {},success:function(responseText,statusText){eval(responseText);}};"
					+ "jQuery('#form1').ajaxForm(option);"
					+ "	jQuery('#form1').submit();"
					+ "}else if(document.getElementById('jqueryPost')){$(\"#jqueryPost\").val(tempVal);}else if (url=='null'||url==''){window.returnValue=tempVal.substring(0,tempVal.length-1)+'~'+tempText.substring(0,tempText.length-1);}"
					+ "if('"
					+ IsAutoClose + "'=='0'){self.close()}" + "}";
			if (QueryDataURL != null && !"".equals(QueryDataURL.trim())) {
				sb
						.append("function zTreeOnClick(event,treeId,treeNode){"
								+ "var queryUrl='"
								+ request.getContextPath()
								+ ""
								+ QueryDataURL
								+ "';"
								+ "for(tempKey in treeNode){"
								+ "if(isNaN(treeNode[tempKey])&&treeNode[tempKey].toString().indexOf('function')>=0){continue;};"
								+ "if(queryUrl.indexOf('?')>0){queryUrl+='&'+tempKey+'='+treeNode[tempKey];}else{queryUrl+='?'+tempKey+'='+treeNode[tempKey];}"
								+ "}" + "" + DocumentObject
								+ ".src=queryUrl;" + "}");
			} else {
				sb
						.append("function zTreeOnClick(event,treeId,treeNode){}");
			}

			sb.append(functionString);
			if (JSONDataFunctionName != null
					&& !"".equals(JSONDataFunctionName.trim())) {
				sb
						.append("function "
								+ JSONDataFunctionName.trim()
								+ "(){"
								+ "var treeObj = $.fn.zTree.getZTreeObj(\""+treeName+"\");"
								+ "var nodes = treeObj.getCheckedNodes(true);"
								+ "var jsonString=\"[\";"
								+ "for(i=0;i<nodes.length;i++){"
								+ "	if(i>0){"
								+ "		jsonString+=\",\";"
								+ "	}"
								+ "	if(nodes[i].pId!=null){"
								+ "		jsonString+=\"{id:'\"+nodes[i].id+\"',pId:'\"+nodes[i].pId+\"',name:'\"+nodes[i].name+\"'}\";"
								+ "	}else{"
								+ "		jsonString+=\"{id:'\"+nodes[i].id+\"',pId:'1',name:'\"+nodes[i].name+\"'}\";"
								+ "	}" + "}" + "jsonString+=\"]\";" + " return jsonString;}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</script>");
		
		return sb.toString();
	}
	/**
	 * @param sql
	 * @return json 数据
	 * @comment json中加入isParent:true设置为父节点
	 */
	public String getFirstJOSNData(String sql) {
		DB proxy = new DB();
		try {
			List pubList = proxy.query(sql);
			return parseList(pubList);
		} catch (Exception e) {
			System.err.println("在加载基础数据的时候，数据库联接创建失败！");
		} finally {
		}
		return null;
	}
	public static String parseList(List list) {
		if(list==null){
			return "";
		}
		StringBuffer sb = new StringBuffer("[");
		try {
			int i=0;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				Set set = map.keySet();
				int j=0;
				if(i>0){
					sb.append(",{");
				}else {
					sb.append("{");
				}
				for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
					String key = (String) iterator2.next();
					Object val = map.get(key);
					if(val==null){
						val="";
					}
					key = key.toLowerCase();
					if("pid".equals(key)){
						key="pId";
					}
					if(j>0){
						sb.append(",\""+key+"\":\""+val+"\"");
					}else {
						sb.append("\""+key+"\":\""+val+"\"");
					}
					
					j++;
				}
				sb.append("}");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("]");
		if ("[]".equals(sb.toString())) {
			return "[{id:'',name:'无',pId:''}]";
		}
		return sb.toString();
	}
	/**
	 * @param request
	 * @return JOSN格式字符串
	 * @comment
	 */
	public abstract String getFirstJOSNData(HttpServletRequest request);
	
}