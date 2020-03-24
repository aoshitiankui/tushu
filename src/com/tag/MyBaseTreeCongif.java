package com.tag;


import javax.servlet.http.HttpServletRequest;

import com.dao.DB;


public class MyBaseTreeCongif extends BaseTreeConfig {

	public String getFirstJOSNData(HttpServletRequest request) {
		String sqlid= request.getParameter("sqlid");
		String sql="";
		if(sqlid==null||"".equals(sqlid)){
			String p = request.getParameter("p");
			sql ="select s.ID,s.FUN_NAME as name ,FUN_PARENT_ID as pid,CASE when r.funid  is null then 'false' else 'true' end as checked from functions s LEFT JOIN functions_role r on r.funid=s.id and r.tid='"+p+"'";
		}else {
			DB util = new DB();
			try {
				sql = util.queryFirst("select sqlcontent from SQLS where sqlid='"+sqlid+"'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(sql==null||"".equals(sql)){
			return null;
		}
		return this.getFirstJOSNData(sql);
	}

	public String getJavascriptPath(HttpServletRequest request) {
		return /*"<link rel=\"stylesheet\" href=\"" + request.getContextPath()
		+ "/js/zTree/css/demo.css\" type=\"text/css\">"
		+ */"<link rel=\"stylesheet\" href=\"" + request.getContextPath()
		+ "/js/zTree/css/zTreeStyle/zTreeStyle.css\" type=\"text/css\" />"
		+ "<link rel=\"stylesheet\" href=\"" + request.getContextPath()
		+ "/js/zTree/css/rightClick.css\" type=\"text/css\" />"
	/*	+ "<script type=\"text/javascript\" src=\""
		+ request.getContextPath()
		+ "/js/zTree/js/jquery-1.4.4.min.js\"></script>"*/
		/**$.browser这个api从jQuery1.9开始就正式废除*/
		+ "<script type=\"text/javascript\" src=\""
		+ request.getContextPath()
		+ "/assets/jquery-migrate-1.2.1.js\"></script>"
		+ "<script type=\"text/javascript\" src=\""
		+ request.getContextPath()
		+ "/js/zTree/js/jquery.ztree.core-3.0.js\"></script>"
		+ "<script type=\"text/javascript\" src=\""
		+ request.getContextPath()
		+ "/js/zTree/js/jquery.ztree.excheck-3.0.js\"></script>"
		+ "<script type=\"text/javascript\"   src=\""
		+ request.getContextPath()
		+ "/js/zTree/js/jquery.form.utf8.js\"></script>"
		+ "<script type=\"text/javascript\"   src=\""
		+ request.getContextPath()
		+ "/js/zTree/js/jquery.ztree.rightclick.js\"></script>";
	}
	
}