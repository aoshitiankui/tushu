package com.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class Util {

	/**
	 * 运行时class的位置
	 */
	public static final String APP_CLASS_PATH=Util.class.getClassLoader().getResource("").getPath().substring(1, Util.class.getClassLoader().getResource("").getPath().length());
	/**
	 * 工作空间SRC的位置
	 */
	public static final String APP_WORKSPACE_SRC_PATH=System.getProperty("user.dir")+"\\src\\";
	/**
	 * 工作空间WEBROOT的位置
	 */
	public static final String APP_WORKSPACE_WEBROOT_PATH=System.getProperty("user.dir")+"\\WebRoot\\";
	public static	PropertyResourceBundle getPropertyResourceBundle(String fileName){
		return (PropertyResourceBundle) PropertyResourceBundle.getBundle(fileName);
	}
	public static String getPropertyResourceBundleValue(String fileName,String key){
		return getPropertyResourceBundle(fileName).getString(key);
	}
	/**
	 * 写入Property文件
	 * @param fileName
	 * @param map
	 */
	public static void setPropertyResourceBundleValue(String fileName,Map<String,String> map){
		Properties properties = new Properties();
		try {
			FileOutputStream out = new FileOutputStream(APP_WORKSPACE_SRC_PATH+(fileName+".properties"));
			properties.putAll(map);
			properties.store(out, "author:qq7256663");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 *字符串替换
	 *@param strFrom 要替换的目标子串
	 *@param strTo 替换后的子串
	 *@param strSource 原字符串
	 *@return 替换后的字符串
	 */
	public static String replace(String strSource, String strFrom, String strTo) {
		String strDest = "";

		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;

		return strDest;
	}

	/**
	 *计算一个字符串中的子串数量,
	 */
	public static int childStrNo(String str, String delim) {
		int cur = 0;
		int numno = 1;
		do {

			cur = str.indexOf(delim);
			if (cur == -1) {
				break;
			}
			str = str.substring(cur + 1, str.length());
			numno = numno + 1;
		} while (true);

		return numno;

	}


	/**
	 *字符串分割
	 * @param str 原字符串
	 * @param delim 分割子串
	 * @return String[]
	 */
	public static String[] split(String str, String delim) {
		int last = 0;
		int cur = 0;
		String[] result = null;
		ArrayList holder = new ArrayList();

		do {
			String tmp;
			cur = str.indexOf(delim, cur);
			if (cur == -1) {
				tmp = str.substring(last);
				holder.add(tmp);
				break;
			}
			tmp = str.substring(last, cur);
			holder.add(tmp);
			cur += delim.length();
			last = cur;
		} while (true);
		result = new String[holder.size()];
		for (int i = 0; i < holder.size(); i++) {
			result[i] = (String) holder.get(i);
		}

		return result;
	}

	/**
	 * 将ISO-8859-1编码转换为 GB2312
	 * @param str 目标字符串
	 * @return String
	 */
	public static String ISOtoGb2312(String str) {
		if (str == null) {
			return " ";
		}
		try {
			byte[] bytesStr = str.getBytes("ISO-8859-1");
			return new String(bytesStr, "GB2312");
		} catch (Exception ex) {
			return str;
		}
	}
	/**
	 * 将ISO-8859-1编码转换为 GB2312
	 * @param str 目标字符串
	 * @return String
	 */
	public static String ISOtoUTF8(String str) {
		if (str == null) {
			return " ";
		}
		try {
			byte[] bytesStr = str.getBytes("ISO-8859-1");
			return new String(bytesStr, "UTF-8");
		} catch (Exception ex) {
			return str;
		}
	}

	public static String Gb2312toISO(String str) {
		if (str == null) {
			return " ";
		}
		try {
			byte[] bytesStr = str.getBytes("GBK");
			return new String(bytesStr, "ISO-8859-1");
		} catch (Exception ex) {
			return str;
		}
	}

	/**
	 * 处理空字符串
	 * @param str要处理的字符串 如果str为null返回""
	 * @return String 如果str为null返回"" 否则返回str
	 */
	public static String dealNull(String str) {
		String returnstr = null;
		if (str == null) {
			returnstr = "";
		} else {
			returnstr = str;
		}
		return returnstr;
	}

	/**
	 *处理空对象
	 *将null转化为""对象
	 * @param obj:Object
	 * @return Object
	 */
	public static Object dealNull(Object obj) {
		Object returnstr = null;
		if (obj == null) {
			returnstr = (Object) ("");
		} else {
			returnstr = obj;
		}
		return returnstr;
	}

	/**
	 *将字符串转化为整数
	 *如果参数为null或“”或不能转换为整数则返回0
	 *如“阿不错23”返回结果为0
	 */
	public static int intToString(String s) {
		s = dealNull(s);
		int x = 0;
		if (s.equals("")) {
			return 0;
		}
		try {
			x = Integer.parseInt(s);
		} catch (Exception e) {}
		return x;
	}

	/**
	 *断是否为数字整数
	 * @param number
	 * @return boolean:true or false
	 */
	public static boolean isInt(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException sqo) {
			return false;
		}
	}

	/**
	 * 字符串转换为java.util.Date<br>
	 * 支持格式为 yyyy.MM.dd G 'at' hh:mm:ss z 如 '2002-1-1 AD at 22:10:59 PSD'<br>
	 * yy/MM/dd HH:mm:ss 如 '2002/1/1 17:55:00'<br>
	 * yy/MM/dd HH:mm:ss pm  如 '2002/1/1 17:55:00 pm'<br>
	 * yy-MM-dd HH:mm:ss 如 '2002-1-1 17:55:00' <br>
	 * yy-MM-dd HH:mm:ss am 如 '2002-1-1 17:55:00 am' <br>
	 * @param time String 字符串<br>
	 * @return Date 日期<br>
	 */
	public static Date stringToDate(String time) {
		SimpleDateFormat formatter;
		int tempPos = time.indexOf("AD");
		time = time.trim();
		formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
		if (tempPos > -1) {
			time = time.substring(0, tempPos) +
			"公元" + time.substring(tempPos + "AD".length()); //china
			formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z");
		}
		tempPos = time.indexOf("-");
		if (tempPos > -1 && (time.indexOf(" ") < 0)) {
			formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");
		} else if ((time.indexOf("/") > -1) && (time.indexOf(" ") > -1)) {
			formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		} else if ((time.indexOf("-") > -1) && (time.indexOf(" ") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else if ((time.indexOf("/") > -1) && (time.indexOf("am") > -1) ||
				(time.indexOf("pm") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		} else if ((time.indexOf("-") > -1) && (time.indexOf("am") > -1) ||
				(time.indexOf("pm") > -1)) {
			formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		}
		ParsePosition pos = new ParsePosition(0);
		java.util.Date ctime = formatter.parse(time, pos);

		return ctime;
	}

	/**
	 * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
	 * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
	 * @param time Date 日期<br>
	 * @return String   字符串<br>
	 */

	public static String dateToString() {
		
		return dateToString(new Date());
	}
	public static String dateToString(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = formatter.format(time);

		return ctime;
	}

	/**
	 * 将java.util.Date 格式转换为字符串格式'yyyyMMddHHmmss'(24小时制)<br>
	 * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
	 * @param time Date 日期<br>
	 * @return String   字符串<br>
	 */

	public static String dateToString11(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String ctime = formatter.format(time);

		return ctime;
	}

	/**
	 * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br>
	 * 如Sat May 11 17:23:22 CST 2002 to '2002-05-11 05:23:22 下午'<br>
	 * @param time Date 日期<br>
	 * @param x int 任意整数如：1<br>
	 * @return String 字符串<br>
	 */
	public static String dateToString(Date time, int x) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
		String ctime = formatter.format(time);

		return ctime;
	}
	public static String dateToStringCustom(Date time,String format) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat(format);
		String ctime = formatter.format(time);

		return ctime;
	}

	/**
	 *取系统当前时间:返回值为如下形式
	 * @return String
	 */
	public static String Nowyymmddhhmmss() {
		String dd = dateToString(new Date());
		dd = dd.substring(2, 4) + dd.substring(5, 7) + dd.substring(8, 10) +
		dd.substring(11, 13) + dd.substring(14, 16) + dd.substring(17, 19);
		return dd;
	}

	/**
	 *取系统当前时间:返回只值为如下形式
	 * @return String
	 */
	public static String Now() {
		return dateToString(new Date());
	}

	/**
	 *取系统当前时间:返回只值为如下形式
	 *@param hour 为任意整数
	 *@return String
	 */
	public static String Now(int hour) {
		return dateToString(new Date(), hour);
	}
	/**
	 *取系统当前时间:返回只值为如下形式
	 *@return String
	 */
	public static String NowCustom(String format) {
		return dateToStringCustom(new Date(),format);
	}


	/**
	 *取系统当前时间:返回只值为如下形式
	 *@return String
	 */
	public static String getYYYY_MM_DD() {
		return dateToString(new Date()).substring(0, 10);

	}

	/**
	 *取系统当前时间:返回只值为如下形式
	 *@return String
	 */
	public static String getYYYYMMDD() {
		String L_curDate = Util.getYYYY_MM_DD();
		String L_curDate2 = L_curDate.substring(0, 4) +
		L_curDate.substring(5, 7) +
		L_curDate.substring(8, 10);
		return L_curDate2;
	}
	/**
	 *取系统当前时间:返回只值为如下形式
	 *@return String
	 */
	public static String getYYYY() {
		String L_curDate = Util.getYYYY_MM_DD();
		String L_curDate2 = L_curDate.substring(0, 4) ;       
		return L_curDate2;
	}
	/**
	 *取系统当前时间:返回只值为如下形式
	 *@return String
	 */
	public static String getYYMMDD() {
		String L_curDate = Util.getYYYY_MM_DD();
		String L_curDate2 = L_curDate.substring(2, 4) +
		L_curDate.substring(5, 7) +
		L_curDate.substring(8, 10);
		return L_curDate2;
	}

	/**
	 * 对日期进行相加操作
	 * @param date 日期字符串格式为yyyy-mm-dd
	 * @param addNumber 要增加的天数
	 * @return String 格式yyyy-mm-dd
	 */
	public static String getDateAdd(String date, int addNumber) {
		String returnStr = "";
		StringTokenizer token = new StringTokenizer(date, "-");
		int num = token.countTokens();
		if (num == 3) {
			int year;
			int month;
			int day;
			year = Integer.parseInt(token.nextToken());
			month = Integer.parseInt(token.nextToken());
			day = Integer.parseInt(token.nextToken());
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calen = Calendar.getInstance();
			calen.set(year, month - 1, day);
			calen.add(5, addNumber); //5代表日期，1代表年，2代表月
			returnStr = formatter.format(calen.getTime());
		} else {
			returnStr = date;
		}
		return returnStr;
	}
	/**
	 * 对小时进行相加操作
	 * @param date 日期字符串格式为yyyy-mm-dd
	 * @param addNumber 要增加的小时数
	 * @return String 格式yyyy-mm-dd
	 */
	public static String getHourAdd(int addNumber) {
		String returnStr = "";
		SimpleDateFormat forma=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd=new Date();
		Calendar g=Calendar.getInstance();
		g.setTime(dd);
		g.add(Calendar.HOUR,addNumber);
		returnStr=forma.format(g.getTime());
		return returnStr;
	}

	/**
	 *获得汉字的简拼码 wxx
	 *@return String
	 */
	/*public  static String getSimpleSpell(String name){
        String ls_return,ls_jp;
        String ls_name,ls_temp;
        //例外处理
        if ((name==null) || (name.trim().length()==0))  return "";
        //初始化变量
        ls_return ="";
        ls_name = name;
        ls_jp="";
        ls_temp="";
        char  chatt;
        int itt=0;
        cDataControl cdcon=new cDataControl();//声明类
        for ( int i=0;i<ls_name.length();i++)
        {
          ls_temp=ls_name.substring(0,1);//
          chatt=ls_temp.charAt(0);
          itt=chatt;
          if (ls_name.length()>2){
          ls_name=ls_name.substring(1,ls_name.length());}//
          if (ls_temp==null) ls_temp ="";
           if (itt<128 ){  //小于128代表西文和数字>128代表汉字
             ls_jp = ls_temp;
           }else  if ( itt>128 ){
                 //从简拼表中获得简拼码
     ls_temp=pub.ViewControl.CharControl.Util.Gb2312toISO(ls_temp);
           ls_jp=cdcon.GetFirfield("set rowcount 0 select jp from dict where name='"+ls_temp+"'");
           if (ls_jp==null) {ls_jp="";}
         }
         ls_return = ls_return+ls_jp;
        }
        cdcon.ReturnConn();//释放连接
        return ls_return;
      }*/
	/**
	 *获得汉字的简拼码 wxx
	 *@return String
	 */
	/*
     public  static String getSimpleSpellold(String name){
        String ls_return,ls_jp;
        String ls_name,ls_temp,ls_hz;
        int   ll_len;
        boolean lb_hz;

        //例外处理
        if ((name==null) || (name.trim().length()==0))  return "";
        //初始化变量
        ls_return ="";
        lb_hz = false;
        ls_name = name;
        ls_hz="";
        ls_jp="";
        cDataControl cdcon=new cDataControl();//声明类
        //生成简拼
        for (ll_len = 1;ll_len<name.length();)
        {        //得到汉字
          ls_temp = ls_name.substring(1,1);
           if (ls_temp==null) ls_temp ="";
              ls_name = ls_name.substring(2,ls_name.length());
              //半个汉字判断是否大于128
     if (( Integer.parseInt(ls_temp.getBytes().toString())>128 )&& (lb_hz==false)){
                lb_hz = true;
                ls_hz = ls_temp;
                ls_jp ="";
              }
              else if (( Integer.parseInt(ls_temp.getBytes().toString())>128 )&& (lb_hz==true)){
                ls_hz = ls_hz + ls_temp;
                 //从简拼表中获得简拼码
     ls_jp=cdcon.GetFirfield("select jp from dict where name='"+ls_hz+"'");
                 if (ls_jp==null) {ls_jp="";}
                 lb_hz = false;
              }else{
                lb_hz = false;
                ls_jp = ls_temp;
              }
             ls_return = ls_return+ls_jp;
        }
        cdcon.ReturnConn();//释放连接
        return ls_return;
      }

     /**
	 *获得参数是奇数还是偶数 wxx
	 *返回0 代表偶数 ，-1代表 奇数
	 */
	public static int isOddorEven(int iint) {
		int itmp = 0;
		try {
			itmp = iint % 2;
			if (itmp == 1) {
				itmp = -1; //奇数
			}
			if (itmp == 0) {
				itmp = 0; //偶数
			}
		} catch (Exception e) {
			itmp = -1;
		}
		return itmp;
	}

	/*************************************/
	//功能：转化为html语言输入数据库
	//方法：将字符窜中的
	public static String HtmlToDB(String s) {
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\n", "<br>");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		s = Replace(s, " ", "&nbsp;");
		s=Replace(s, "'", "&single_qu");
		return s;
	}

	//功能：将数据库中的encode过的代码 输出 以td形式输出。
	//方法：
	public static String DBToHtml(String s) {
		s = Replace(s, "&amp", "&;");
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "<br>");
		s = Replace(s, " &nbsp;", " &nbsp; ");
		s=Replace(s, "&single_qu", "'");
		return s;
	}

	//功能：修改显示时将数据库中的encode过的代码 输出 此时是多行文本框
	//方法：
	public static String HtmlWriteMX(String s) {
		s = Replace(s, "&amp", "&;");
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s=Replace(s, "&single_qu", "'");
		return s;
	}

	public static String InvertedCommaReplaceToDB(String s) {
		s=Replace(s, "'", "''");
		return s;
	}

	public static String Replace(
			String source,
			String oldString,
			String newString) {
		if (source == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		int lengOfsource = source.length();
		int lengOfold = oldString.length();
		int posStart;
		int pos;
		for (posStart = 0; (pos = source.indexOf(oldString, posStart)) >= 0;
		posStart = pos + lengOfold) {
			output.append(source.substring(posStart, pos));
			output.append(newString);
		}

		if (posStart < lengOfsource) {
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	/*生成随即字符串*/
	public static String ProduceStr(int strLen) {
		if (strLen < 1) {
			return null;
		}
		if (strLen > 50) {
			strLen = 50;
		}
		String Vchar =
			"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";
		int Vlength = Vchar.length();
		char[] rchars = new char[strLen];
		for (int i = 0; i < strLen; i++) {
			rchars[i] = Vchar.charAt((int) (Math.random() * Vlength));
		}
		return String.valueOf(rchars);
	}

	/*
	 *字符串查找,反回字符串要查找字符串前面有多少个字符
	 *原字符串str
	 *要查找的字符strfrom
	 *原字符串中出现第几个ifrom
	 */
	public static int formstr(String str, String strfrom, int ifrom) {
		int from = 0;
		int strfromlen = strfrom.length();
		for (int i = 0; i < ifrom; i++) {
			if (str.indexOf(strfrom, from) != -1) {
				from = str.indexOf(strfrom, from) + strfromlen;
			}
		}
		return from;
	}

	/*
	 *返回当前日期是本月的第几周
	 */
	public static String getWeek() {
		String week = "";
		Calendar calen = Calendar.getInstance();
		week=String.valueOf(calen.get(Calendar.WEEK_OF_MONTH));
		return week;
	}

	/*检测某一对象是否是SortedMap对象的函数*/
	public boolean CheckSortedMap(Object obj){
		if(obj instanceof SortedMap){
			return true;
		}
		return false;
	}

	/*检测某一对象是否是List对象的函数*/
	public boolean CheckList(Object obj){
		if(obj instanceof List){
			return true;
		}
		return false;
	}

	/*检测某一对象是否是Map对象的函数*/
	public boolean CheckMap(Object obj){
		if(obj instanceof Map){
			return true;
		}
		return false;
	}
	/**
	 *功能：将url地址转递进来的值进行转换(url 转换 数据)*/
	public static String transUrlToData(String str){
		String temp=str;
		temp=replace(temp,"%2F","/");
		temp=replace(temp,"%26","&");
		temp=replace(temp,"%3F","?");
		temp=replace(temp,"%40","@");
		temp=replace(temp,"%23","#");
		temp=replace(temp,"%3B",";");
		temp=replace(temp,"%24","$");
		temp=replace(temp,"%2B","+");
		temp=replace(temp,"%3D","=");
		temp=replace(temp,"%25","%");
		return temp;
	}

	/**
	 *功能：将url地址转递进来的值进行转换(数据 转换 url)
	 */
	public static String transDataToUrl(String str){
		String temp=str;
		temp=replace(temp,"/","%2F");
		temp=replace(temp,"&","%26");
		temp=replace(temp,"?","%3F");
		temp=replace(temp,"@","%40");
		temp=replace(temp,"#","%23");
		temp=replace(temp,";","%3B");
		temp=replace(temp,"$","%24");
		temp=replace(temp,"+","%2B");
		temp=replace(temp,"=","%3D");
		temp=replace(temp,"%","%25");
		return temp;
	}

	/**判断整形*/
	public static boolean checkInt(String str){
		if(str!=null && str.matches("[\\d]+")){
			return true;
		}
		return false;
	}

	/**
	 * 对日期进行相加操作(对月操作)
	 * @param date 日期字符串格式为yyyy-mm-dd
	 * @param addNumber 要月
	 * @return String 格式yyyy-mm-dd
	 */
	public static String getDateMonthAdd(String date, int addNumber) {
		String returnStr = "";
		StringTokenizer token = new StringTokenizer(date, "-");
		int num = token.countTokens();
		if (num == 3) {
			int year;
			int month;
			int day;
			year = Integer.parseInt(token.nextToken());
			month = Integer.parseInt(token.nextToken());
			day = Integer.parseInt(token.nextToken());
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calen = Calendar.getInstance();
			calen.set(year, month - 1, day);
			calen.add(2, addNumber); //5代表日期，1代表年，2代表月
			returnStr = formatter.format(calen.getTime());
		} else {
			returnStr = date;
		}
		return returnStr;
	}	
	/**
	 * 非空校验
	 * @param object
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(Object object){
		if(object==null||"".equals(object.toString().trim())){
			return true;
		}
		return false;
	}
	/**
	 * @param obj 字符串对此
	 * @param subLength 截取长度
	 * @return 如果字符串长度小于等于 subLength 则返回原字符串 否则返回截取的字符串加...
	 */
	public static String subString(Object obj,int subLength){
		if(obj==null){
			return "";
		}
		String temp = obj.toString();
		int length= temp.length();
		if(subLength>=length){
			return temp;
		}
		return temp.substring(0, subLength)+"……";
	}
	public static void printResult(HttpServletResponse response,String content,String contentType,boolean isClose){
		try {
			response.setContentType(contentType);
			response.getWriter().write(content);
			if(isClose){
				response.getWriter().flush();
				response.getWriter().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void printResult(HttpServletResponse response,String content,boolean isClose){
		printResult(response,content,"application/json;charset=utf-8",true);
	}
	public static void printResult(HttpServletResponse response,String content){
		printResult(response,content,true);
	}
	public static void printResult(HttpServletResponse response,Object content){
		printResult(response,JSONUtil.converObject2String(content));
	}
	public static String getCamleToLower(String name){
		return name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf((char)(name.charAt(0)+32)));
	}
	public static String getCamle(String name){
		name=name.toLowerCase();
		String replace=getPropertyResourceBundle("template").getString("template.replace.tablename");
		if(replace!=null){
			replace =replace.toLowerCase();
			String[] replaceTemp=replace.split("\\|");
			for(String temp :replaceTemp){
				String[] temp1=temp.split(",");
				if(temp1.length>1){
					if(!"_".equals(temp1[1])){
						name=name.replace(temp1[0], temp1[1]);
					}
				}else{
					if(!"_".equals(temp1[0])){
						name=name.replace(temp1[0], "");
					}
				}
			}
		}
		StringBuffer res = new StringBuffer();
		String[] temp = name.split("_");
		for(String temp1:temp){
			try {
				res.append(temp1.replaceFirst(String.valueOf(temp1.charAt(0)), String.valueOf((char)(temp1.charAt(0)-32))));
			} catch (Exception e) {
				System.out.println(temp1); 
				e.printStackTrace();
			}
		}
		return res.toString();
	}
	/**
	 * 将unicode转成汉字
	 * @param utfString
	 * @return 
	 */
	public static String unicodeToChinses(String utfString){ 
		if(utfString==null){
			return "";
		}
		StringBuilder sb = new StringBuilder();  
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");    
		Matcher matcher = pattern.matcher(utfString);
		char ch;
		while (matcher.find()) {
			ch = (char) Integer.parseInt(matcher.group(2), 16);
			utfString = utfString.replace(matcher.group(1), ch + "");    
		}
		return utfString;
	} 
	private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
		'B', 'C', 'D', 'E', 'F' };

	private static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
	}

	/**
	 * 将字符串编码成 Unicode 形式的字符串. 如 "黄" to "\u9EC4"
	 * @param theString
	 *        待转换成Unicode编码的字符串。
	 * @param escapeSpace
	 *        是否忽略空格，为true时在空格后面是否加个反斜杠。
	 * @return 返回转换后Unicode编码的字符串。
	 */

	public static String chinsesToUnicode(String theString, boolean escapeSpace) {
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuffer outBuffer = new StringBuffer(bufLen);
		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
			case ' ':
				if (x == 0 || escapeSpace) outBuffer.append('\\');
				outBuffer.append(' ');
				break;
			case '\t':
				outBuffer.append('\\');
				outBuffer.append('t');
				break;
			case '\n':
				outBuffer.append('\\');
				outBuffer.append('n');
				break;
			case '\r':
				outBuffer.append('\\');
				outBuffer.append('r');
				break;
			case '\f':
				outBuffer.append('\\');
				outBuffer.append('f');
				break;
			case '=': // Fall through
			case ':': // Fall through
			case '#': // Fall through
			case '!':
				outBuffer.append('\\');
				outBuffer.append(aChar);
				break;
			default:
				if ((aChar < 0x0020) || (aChar > 0x007e)) {
					// 每个unicode有16位，每四位对应的16进制从高位保存到低位
					outBuffer.append('\\');
					outBuffer.append('u');
					outBuffer.append(toHex((aChar >> 12) & 0xF));
					outBuffer.append(toHex((aChar >> 8) & 0xF));
					outBuffer.append(toHex((aChar >> 4) & 0xF));
					outBuffer.append(toHex(aChar & 0xF));
				} else {
					outBuffer.append(aChar);
				}
			}
		}
		return outBuffer.toString();
	}
	public static String parseListToJson(List list){
		if(list==null||list.size()==0){
			return "[]";
		}
		StringBuffer sb = new StringBuffer("[");
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i);
			if(i>0){
				sb.append(",");
			}
			int j=0;
			if (obj instanceof java.util.Map) {
				Map map = (Map) obj;
				sb.append("{");
				Iterator it = map.keySet().iterator();
				while (it.hasNext()) {
					if(j>0){
						sb.append(",");
					}
					String key = it.next().toString();
					sb.append(key+":\"");
					sb.append(map.get(key));
					sb.append("\"");
					j++;
				}
				sb.append("}");
			}else if (obj instanceof java.util.List) {
				List listtemp = (List) obj;
				sb.append("[");
				Iterator it = listtemp.iterator();
				while (it.hasNext()) {
					if(j>0){
						sb.append(",");
					}
					String key = it.next().toString();
					sb.append("\"");
					sb.append(key);
					sb.append("\"");
					j++;
				}
				sb.append("]");
			}else{
				if(j>0){
					sb.append(",");
				}
				sb.append("\""+obj.toString()+"\"");
				j++;
			}
		}
		sb.append("]");
		return sb.toString();
	}
	public static String parseMapToJson(Map map){
		if(map==null){
			return "{}";
		}
		StringBuffer sb = new StringBuffer("{");
		int j=0;
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			if(j>0){
				sb.append(",");
			}
			String key = it.next().toString();
			Object obj = map.get(key);
			if (obj instanceof java.util.List){
				List list1 = (List)obj;
				sb.append(key+":");
				sb.append(parseListToJson(list1));
			}
			else{
				sb.append(key+":\"");
				sb.append(obj);
				sb.append("\"");
			}
			j++;
		}
		sb.append("}");
		return sb.toString();
	}
	public static boolean isChinese(char c) {  
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
			return true;  
		}  
		return false;  
	}  

	/**
	 * 判断是否乱码 返回true说明乱码
	 * @param strName
	 * @return 
	 */
	public static boolean isMessyCode(String strName) {  
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");  
		Matcher m = p.matcher(strName);  
		String after = m.replaceAll("");  
		String temp = after.replaceAll("\\p{P}", "");  
		char[] ch = temp.trim().toCharArray();  
		float chLength = ch.length;  
		float count = 0;  
		for (int i = 0; i < ch.length; i++) {  
			char c = ch[i];  
			if (!Character.isLetterOrDigit(c)) {  

				if (!isChinese(c)) {  
					count = count + 1;  
					System.out.print(c);  
				}  
			}  
		}  
		float result = count / chLength;  
		if (result > 0.4) {  
			return true;  
		} else {  
			return false;  
		}  

	}
	
	/**
	 * @param 将list转换成String数组
	 * @return
	 */
	public static String[] parseListToArray(List list){
		if(list==null){
			return null;
		}
		String[] str = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			str[i]=(String) list.get(i);
		}
		return str;
	}
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
            throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    public static Map<?, ?> objectToMap(Object obj) {
    	if (obj == null) {
			return null;
		}
		Map map = new TreeMap();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					if(getter!=null){
						Object value = getter.invoke(obj);
						if (value != null && !"".equals(value) && !"null".equals(value)) {
							map.put(key.substring(0, 1).toLowerCase() + key.substring(1), value);
						}
					}
				}
			}
		} catch (Exception e) {
		}
        return map;
    }
	/** 
	 * 向指定URL发送GET方法的请求 
	 * @param url 发送请求的URL 
	 * @param params 请求参数，请求参数应该是name1=value1&name2=value2的形式。 
	 * @return URL所代表远程资源的响应     */ 
	public static String sendGet(String url, String params,String encode) { 
		String result = ""; 
		BufferedReader in = null; 
		try { 
			String urlName = url + "?" + params; 
			//创建URL
			URL realUrl = new URL(urlName); 
			// 打开和URL之间的连接 
			URLConnection conn = realUrl.openConnection(); 
			// 设置通用的请求属性 
			conn.setRequestProperty("accept", "*/*"); 
			conn.setRequestProperty("connection", "Keep-Alive"); 
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
			// 建立实际的连接 
			conn.connect(); 
			// 获取所有响应头字段 
			Map<String, List<String>> map = conn.getHeaderFields(); 
			// 遍历所有的响应头字段 
			for (String key : map.keySet()) { 
				//                 System.out.println(key + "--->" + map.get(key)); 
			} 
			// 定义BufferedReader输入流来读取URL的响应 
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),encode)); 
			String line; 
			while ((line = in.readLine()) != null) { 
				result += line; 
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		// 使用finally块来关闭输入流 
		finally { 
			try { 
				if (in != null) { 
					in.close(); 
				} 
			} catch (IOException ex) { 
				ex.printStackTrace(); 
			} 
		} 
		return result; 
	} 
	/** 
	 * 向指定URL发送POST方法的请求 
	 *  
	 * @param url 
	 *            发送请求的URL 
	 * @param params 
	 *            请求参数，请求参数应该是name1=value1&name2=value2的形式。 
	 * @return URL所代表远程资源的响应 
	 */ 
	public static String sendPost(String url, String params) { 
		PrintWriter out = null; 
		BufferedReader in = null; 
		String result = ""; 
		try { 
			URL realUrl = new URL(url); 
			// 打开和URL之间的连接 
			URLConnection conn = realUrl.openConnection(); 
			// 设置通用的请求属性 
			conn.setRequestProperty("accept", "*/*"); 
			conn.setRequestProperty("connection", "Keep-Alive"); 
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
			// 发送POST请求必须设置如下两行 
			conn.setDoOutput(true); 
			conn.setDoInput(true); 
			// 获取URLConnection对象对应的输出流 
			out = new PrintWriter(conn.getOutputStream()); 
			// 发送请求参数 
			out.print(params); 
			// flush输出流的缓冲 
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应 
			in = new BufferedReader(new InputStreamReader(conn.getInputStream())); 
			String line; 
			while ((line = in.readLine()) != null) { 
				result += "\n" + line; 
			} 
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		// 使用finally块来关闭输出流、输入流 
		finally { 
			try { 
				if (out != null) { 
					out.close(); 
				} 
				if (in != null) { 
					in.close(); 
				} 
			} catch (IOException ex) { 
				ex.printStackTrace();
			} 
		} 
		return result; 
	} 
	/**
	 * @param Exception
	 * @return 将异常信息放到字符串里
	 */
	public static String getStackTraceDes(Exception ex){
		StackTraceElement[] elements = ex.getStackTrace();
		if (elements==null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(ex.getMessage()+"\r\n");
		int length = elements.length;
		for (int i = 0; i <length ; i++) {
			StackTraceElement element = elements[i];
			sb.append(element.getClassName()+"："+element.getMethodName()+"："+element.getLineNumber()+"\r\n");
		}
		return sb.toString();
	}
	public static Set<Integer> get(int min, int max,int size){
		if (size > (max - min + 1) || max < min) {  
		  return null;  
		}  

		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<size){
			int num = (int) (Math.random() * (max - min)) + min;  
			set.add(num);// 将不同的数存入HashSet中  
		}
		return set;
	}
	public static List<Map<String,Object>> parseMapKeyToLower( List<Map> list){
		if(list ==null){
			return null;
		}
		List<Map<String,Object>> temp = new ArrayList<Map<String,Object>>(list.size());
		for(Map map: list){
			Map<String,Object> m = new HashMap<String,Object>();
			temp.add(m);
			for (Object key : map.keySet()) {  
	            m.put(key.toString().toLowerCase(), map.get(key)) ;
	        }
		}
		return temp;
	}
	public static Set<Integer> getRandomSet(int min, int max,int size){
		if (size > (max - min + 1) || max < min) {  
		  return null;  
		}  

		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<size){
			int num = (int) (Math.random() * (max - min)) + min;  
			set.add(num);// 将不同的数存入HashSet中  
		}
		return set;
	}
	public static void main(String[] args) {
		System.out.println(isMessyCode("你好")); 
	}

	   public static String getIpAddress(HttpServletRequest request) {  
	        String ip = request.getHeader("x-forwarded-for");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_CLIENT_IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	        }  
	        return ip;  
	    }  
}
