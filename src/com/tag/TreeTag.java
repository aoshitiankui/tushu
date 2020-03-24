package com.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * 功能描述:生成树控件，如果需要向后台提交数据，提交的方式为异步提交form
 *       为了提高灵活性，后台响应方式为javascript代码， 如添加成功
 *       respose.getWrite.print("alert('添加成功');");
 */
public class TreeTag extends TagSupport {
	private String className;//类全名 必填
	private String isNeedButton;// 是否出现 确定关闭按钮 0出现 其他不出现
	private String isAutoClose;// 是否自动关闭 0关闭 其他不关闭
	private String queryURL;// 展开子节点查询的url 次数异步查询 服务端相应出JSON数据 设置了此属性 在设置sql属性 sql无用
	private String commitURL;// 单击确定按钮提交数据的URL  设置了此属性 在设置displayText，displayVlaue属性 displayText，displayVlaue无用
	private String queryDataURL;// 根据数据查询展现的url
	private String displayText;// 父页面展示的文本
	private String displayVlaue;// 父页隐藏的value
	private String JSONDataFunctionName;// 前台页面生成json数据的方法名称
	private String isCheckBox;// 是否多选-1禁用单选或多选,0单选 其他多选
	private String getTreeValueStyle;// 获取值的方式 只获取子节点的值 只获取父节点的值 获取所有选中的值
	// 0子节点 1父节点 2全部
	private String cssName;// tree样式
	private String autoParam;// 另外的参数
	private String documentObject;// 展现查询结果集对象 此处为iframe对象
	private String treeName;// 树id 必填
	private String treeNodeClickFunctionName;//单击节点调用的函数
	private String sql;//获取json数据的sql sql格式 第一列为 id 第二列为 name 第三列为Pid 第四列可选 如果出现 则是判断本身是否被选中 不为null则选中
	private String rightClick;//0为添加右键事件 引用jquery.ztree.rightclick.js
	private String rightClickNodeValueId;//当前单击节点信息存在在id为rightClickNodeValueId的隐藏域里
	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) this.pageContext
				.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		JspWriter out = pageContext.getOut();
		try {
			Object object = Class.forName(this.getClassName()).newInstance();
			BaseTreeConfig config = null;
			if (object instanceof BaseTreeConfig) {
				config = (BaseTreeConfig) object;
			}
			if (config == null) {
				return super.doEndTag();
			}
			out.print(config.getJavascriptPath(request));
			out.print(config.setTreeLocation("<ul id=\"" + this.getTreeName()
					+ "\" class=\"ztree\"  style=\"" + this.getCssName()
					+ "\" ></ul>", this.getIsNeedButton(), request));
			if (this.getCommitURL() != null
					&& !"".equals(this.getCommitURL().trim())) {
				out.print(config.setForm(this.getCommitURL(), request));
			}
			out.print(config.getScript(request, displayText, displayVlaue,
					commitURL, isCheckBox, queryURL, this.getAutoParam(),
					getTreeValueStyle, isAutoClose, queryDataURL,
					documentObject, JSONDataFunctionName, treeName,
					treeNodeClickFunctionName, sql,this.getRightClick(),this.getRightClickNodeValueId()));
			if("0".equals(this.getRightClick())){
				out.print("<script>$(document).ready(function(){	myTreeId='"+this.getRightClickNodeValueId()+"',rMenu = $(\"#rMenu\");zTree = $.fn.zTree.getZTreeObj(\""+this.getTreeName()+"\");});</script>");
				out.print("<input type='hidden' name='"+this.getRightClickNodeValueId()+"' id='"+this.getRightClickNodeValueId()+"' />");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("TreeTag....类路径不对");
		} catch (InstantiationException e) {
			System.out.println("TreeTag....实例化出错");
		} catch (IllegalAccessException e) {
			System.out.println("TreeTag....实例化出错");
		} finally {
//			try {
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//			}
		}
		return super.doEndTag();
	}

	public String getQueryDataURL() {
		return queryDataURL;
	}

	public void setQueryDataURL(String queryDataURL) {
		this.queryDataURL = queryDataURL;
	}

	public String getDocumentObject() {
		return documentObject;
	}

	public void setDocumentObject(String documentObject) {
		this.documentObject = documentObject;
	}

	public String getIsNeedButton() {
		return isNeedButton;
	}

	public void setIsNeedButton(String isNeedButton) {
		this.isNeedButton = isNeedButton;
	}

	public String getIsAutoClose() {
		return isAutoClose;
	}

	public void setIsAutoClose(String isAutoClose) {
		this.isAutoClose = isAutoClose;
	}

	public String getQueryURL() {
		return queryURL;
	}

	public void setQueryURL(String queryURL) {
		this.queryURL = queryURL;
	}

	public String getCommitURL() {
		return commitURL;
	}

	public void setCommitURL(String commitURL) {
		this.commitURL = commitURL;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getDisplayVlaue() {
		return displayVlaue;
	}

	public void setDisplayVlaue(String displayVlaue) {
		this.displayVlaue = displayVlaue;
	}

	public String getJSONDataFunctionName() {
		return JSONDataFunctionName;
	}

	public void setJSONDataFunctionName(String dataFunctionName) {
		JSONDataFunctionName = dataFunctionName;
	}

	public String getIsCheckBox() {
		return isCheckBox;
	}

	public void setIsCheckBox(String isCheckBox) {
		this.isCheckBox = isCheckBox;
	}

	public String getGetTreeValueStyle() {
		return getTreeValueStyle;
	}

	public void setGetTreeValueStyle(String getTreeValueStyle) {
		if(!"0".equals(getTreeValueStyle)&&!"1".equals(getTreeValueStyle)&&!"2".equals(getTreeValueStyle)){
			this.getTreeValueStyle="0";
		}else {
			this.getTreeValueStyle = getTreeValueStyle;
		}
	}

	public String getCssName() {
		return cssName;
	}

	public void setCssName(String cssName) {
		this.cssName = cssName;
	}

	public String getAutoParam() {
		if(autoParam==null)
			autoParam="";
		return autoParam;
	}

	public void setAutoParam(String autoParam) {
		if (autoParam != null&&!"null".equals(autoParam) && !"".equals(autoParam.trim())) {
			this.autoParam = "";
			String[] temp = autoParam.trim().split(",");
			for (int i = 0; i < temp.length; i++) {
				this.autoParam += ",\"" + temp[i] + "\"";
			}
		} else {
			this.autoParam = "";
		}
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public String getTreeNodeClickFunctionName() {
		return treeNodeClickFunctionName;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setTreeNodeClickFunctionName(String treeNodeClickFunctionName) {
		if (treeNodeClickFunctionName != null
				&& !"".equals(treeNodeClickFunctionName.trim())) {
			this.treeNodeClickFunctionName = treeNodeClickFunctionName;
		} else {
			this.treeNodeClickFunctionName = "zTreeOnClick";
		}
	}

	public String getRightClick() {
		return rightClick;
	}

	public void setRightClick(String rightClick) {
		this.rightClick = rightClick;
	}

	public String getRightClickNodeValueId() {
		return rightClickNodeValueId;
	}

	public void setRightClickNodeValueId(String rightClickNodeValueId) {
		this.rightClickNodeValueId = rightClickNodeValueId;
	}
	
}