package com.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class DwonLoadExcelInterface {
	public static String title="title";
	public static String titles="titles";
	public static String content="content";
	//下载excel返回数据 titles返回标题列 标题格式为List<String>   title返回表格标题    content返回数据集合 格式为List<List>
	public static Map<String,String> RELATIONMAP = new HashMap<String, String>();
	static{
		RELATIONMAP.put("stu", "com.im.DeptIm");
		RELATIONMAP.put("UserScore", "com.im.UserScore");
		RELATIONMAP.put("DeptScore", "com.im.DeptScore");
	}
	public abstract Map getData(HttpServletRequest request);
	public abstract String savaData(File file,HttpServletRequest request);
}
