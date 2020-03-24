
package com.tag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.dao.DB;
import com.util.Util;

/**
 * 描述：下拉框数据标签
 */
public class SelectData extends TagSupport {

	private static final long serialVersionUID = 2592840134309221367L;
	private String code;
	private String name;
	private String styleclass;
	private String id;
	private String change;
	private int    size;
	private int selsign;//0显示“请选择”，1为不显示，2为显示“全部”
	private String style;
	private String def;//默认值
	private String data_bv_notempty_message;
	public SelectData() {

	}

	public int doEndTag() throws JspException {
		try {

			//------------------------
			//------------------------
			//取数据下拉框
			List list = new ArrayList();
			if(code!=null){
				//调用业务处理类
				//list数据集合
				DB db = new DB();
				if(!"".equals(code)){
					String sql = db.queryFirst("select sqlcontent from sqls where sqlid='"+code+"'");
					if(sql!=null&&!"".equals(sql)){
						list = db.queryList(sql);
					}
				}
			 }
			HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
			String contPath = request.getContextPath();
			String result = "";
			result = "<select name =\"" + name + "\"";
			if (id != null) {
				result = result + " id=\"" + id + "\"";
			}
			if (size != 0) {
				result = result + " size=" + size + "";
			}
			if (styleclass != null) {
				result = result + " class=\"" + styleclass + "\"";
			}
			if (name != null) {
				result = result + " name=\"" + name + "\"";
			}
			if (change != null) {
				change = change.replaceAll("contPath", contPath);
				result = result + " onChange=\"" + change + "\"";
			}
			if (style != null) {
				result = result + " style=\"" + style + "\"";
			}
			
			if(data_bv_notempty_message!=null){
				result = result + " data-bv-notempty data-bv-notempty-message=\"请选择"+data_bv_notempty_message+"\"";
			}
			result = result + ">";
			pageContext.getOut().write(result);
			if(selsign == 0){
				pageContext.getOut().write(
						"<option value=\'"

								+ "\'>"
								+ "请选择"
								+ "</option>");
			} else if(selsign == 2){
				pageContext.getOut().write(
						"<option value=\'"

								+ "\'>"
								+ "--全部--"
								+ "</option>");
			}
			
			if(list!=null){
			    Iterator iter = list.iterator();
			    while(iter.hasNext()){
			     List temp = (List)iter.next();
			     String sel="";
			     if(def!=null&&def.equals(temp.get(0).toString())){
			    	 sel="selected";
			     }
					pageContext.getOut().write(
							"<option value=\'"
									+ temp.get(0)
									+ "\' "+sel+">"
									+ temp.get(1)
									+ "</option>");
				}
			}
			
			pageContext.getOut().write("</select>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doStartTag();
	}
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public String getChange(){
		return change;
	}
	public void setChange(String change){
		this.change = change;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSelsign() {
		return selsign;
	}

	public void setSelsign(int selsign) {
		this.selsign = selsign;
	}
	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}

	public String getStyleclass() {
		return styleclass;
	}

	public void setStyleclass(String styleclass) {
		this.styleclass = styleclass;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getData_bv_notempty_message() {
		return data_bv_notempty_message;
	}

	public void setData_bv_notempty_message(String data_bv_notempty_message) {
		this.data_bv_notempty_message = data_bv_notempty_message;
	}
	
}