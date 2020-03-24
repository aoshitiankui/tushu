package com.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.DB;
import com.util.DwonLoadExcelInterface;
import com.util.ExcelOper;
import com.util.Res;
import com.util.Util;

public class UploadAction extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		//上传
		if("up".equals(method)){ 
			Res rs = new Res();
			String uploadPath=request.getSession().getServletContext().getRealPath("");
			String path = "";
			try {
				path = Util.getPropertyResourceBundleValue("template", "template.upload.path");
			} catch (RuntimeException e1) {
				path = "upload";
			}
			uploadPath+=path;
			String buffer = uploadPath+"\\buffer";
			File uploadFile = new File(uploadPath);
			if(!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			uploadFile = new File(buffer);
			if(!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			String msg="";
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart==true){
				try{
					DiskFileItemFactory  factory = new DiskFileItemFactory();
					factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
					factory.setRepository(uploadFile);// 设置缓冲区目
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> items = upload.parseRequest(request);//得到所有的文件
					Iterator<FileItem> itr = items.iterator();
					List<Map<String,String>> list = new ArrayList<Map<String,String>>();
					while(itr.hasNext()){//依次处理每个文件
						FileItem item=(FileItem)itr.next();
						String fileName=item.getName();//获得文件名，包括路径
						if(fileName!=null){
							Map<String,String> map = new HashMap<String, String>();
							String id = UUID.randomUUID().toString();
							File fullFile=new File(item.getName());
							String oldName=fullFile.getName();
							String filetype=oldName.substring(oldName.lastIndexOf("."), oldName.length());
							String filenewname=id+filetype;
							File savedFile=new File(uploadPath,filenewname);
							map.put("id", id);
							map.put("name", item.getName());
							map.put("newname", filenewname);
							map.put("path", path);
							item.write(savedFile);
							String sql="insert into files(fileid,filepath,filename,newname) values('"+id+"','"+path+"','"+oldName+"','"+filenewname+"')";
							DB db = new DB();
							db.executeSql(sql);
							list.add(map);
						}
					}
					//request.setAttribute("list", list);
					rs.setRows(list);
					rs.setCode(1);
					rs.setMsg("上传文件成功！");
					 
				}
				catch(Exception e){
					msg="上传文件失败！"+e.getMessage();
					rs.setCode(-1);
					rs.setMsg("上传文件失败！");
				}
			}
			else{
				rs.setCode(-1);
				rs.setMsg("没有发现文件！");
			}
			Util.printResult(response ,rs);
			return ;
		}
		//下载
		else if("down".equals(method)){
			String id = request.getParameter("fileid");
			String sql="select * from files where fileid='"+id+"'";
			DB db = new DB();
			List<Map<String, Object>> res=db.query(sql);
			if(res==null||res.size()==0){
				return ;
			}
			Map<String, Object> map = res.get(0);
			String name_cn=(String) map.get("filename");
			
			
			String uploadPath=request.getSession().getServletContext().getRealPath("");
			
			String url=map.get("filepath").toString()+"/"+map.get("newname").toString();
			//url = request.getSession().getServletContext().getRealPath(uploadPath+url);
			url = uploadPath+url;
			response.setContentType("application/octet-stream;charset=gbk");
			String ffnmae=new String(name_cn.getBytes("gb2312"),"iso8859-1");//格式化 名称
			response.setHeader("Content-Disposition","attachment; filename="+ffnmae);  

			java.io.FileInputStream in = null;     
			java.io.BufferedInputStream binpu = null;  
			java.io.BufferedOutputStream bout = null;  
			try{       
				in = new java.io.FileInputStream(url);     
				binpu = new java.io.BufferedInputStream(in);  
				bout = new java.io.BufferedOutputStream(response.getOutputStream());  
				byte[] b = new byte[1024];     
				int i = 0;     
				while((i = binpu.read(b,0,b.length)) > 0){     
					bout.write(b, 0, i);     
				}         
				bout.flush();   
				//要加以下两句话，否则会报错      
//				out = pageContext.pushBody();   
				response.flushBuffer(); 
//				out.clear();     
			}catch(Exception e){     
				e.printStackTrace();
			}finally{     
				if(in != null){     
					in.close();  
					in = null;     
				}    
				if(binpu != null){     
					binpu.close();  
					binpu = null;     
				}    
				if(bout != null){     
					bout.close();  
					bout = null;     
				}    
			}  
			return ;
		}
		//下载
		else if("dwonexcel".equals(method)){
			String key = request.getParameter("key");
			String classFullName = DwonLoadExcelInterface.RELATIONMAP.get(key);
			if(classFullName==null){
				return ;
			}
			Object obj = null;
			try {
				obj = Class.forName(classFullName).newInstance();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(!(obj instanceof DwonLoadExcelInterface)){
				return ;
			}
			DwonLoadExcelInterface dl = (DwonLoadExcelInterface) obj;
			Map data = dl.getData(request);
			String name_cn="dl.xls";
			String url="/";
			url = request.getSession().getServletContext().getRealPath(url)+"/"+name_cn;
			ExcelOper oper = new ExcelOper();
			oper.writeExcel(data, url);
			response.setContentType("application/octet-stream;charset=gbk"); 
			String ffnmae=new String(name_cn.getBytes("gb2312"),"iso8859-1");//格式化 名称
			response.setHeader("Content-Disposition","attachment; filename="+ffnmae);  
			
			java.io.FileInputStream in = null;     
			java.io.BufferedInputStream binpu = null;  
			java.io.BufferedOutputStream bout = null;  
			try{       
				in = new java.io.FileInputStream(url);     
				binpu = new java.io.BufferedInputStream(in);  
				bout = new java.io.BufferedOutputStream(response.getOutputStream());  
				byte[] b = new byte[1024];     
				int i = 0;     
				while((i = binpu.read(b,0,b.length)) > 0){     
					bout.write(b, 0, i);     
				}         
				bout.flush();   
				//要加以下两句话，否则会报错      
//				out = pageContext.pushBody();   
				response.flushBuffer(); 
//				out.clear();     
			}catch(Exception e){     
				e.printStackTrace();
			}finally{     
				if(in != null){     
					in.close();  
					in = null;     
				}    
				if(binpu != null){     
					binpu.close();  
					binpu = null;     
				}    
				if(bout != null){     
					bout.close();  
					bout = null;     
				}    
			} 
			File f = new File(url);
			f.deleteOnExit();
			return ;
		}else if("upexcel".equals(method)){
			String key = request.getParameter("key");
			String classFullName = DwonLoadExcelInterface.RELATIONMAP.get(key);
			if(classFullName==null){
				return ;
			}
			Object obj = null;
			try {
				obj = Class.forName(classFullName).newInstance();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(!(obj instanceof DwonLoadExcelInterface)){
				return ;
			}
			DwonLoadExcelInterface dl = (DwonLoadExcelInterface) obj;
			String uploadPath=request.getSession().getServletContext().getRealPath("/");
			String path = "";
			try {
				path = Util.getPropertyResourceBundleValue("template", "template.upload.path");
			} catch (RuntimeException e1) {
				path = "/upload";
			}
			uploadPath+=path;
			String buffer = uploadPath+"\\buffer";
			File uploadFile = new File(uploadPath);
			if(!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			uploadFile = new File(buffer);
			if(!uploadFile.exists()) {
				uploadFile.mkdirs();
			}
			String msg="";
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart==true){
				try{
					DiskFileItemFactory  factory = new DiskFileItemFactory();
					factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
					factory.setRepository(uploadFile);// 设置缓冲区目
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> items = upload.parseRequest(request);//得到所有的文件
					Iterator<FileItem> itr = items.iterator();
					List<Map<String,String>> list = new ArrayList<Map<String,String>>();
					while(itr.hasNext()){//依次处理每个文件
						FileItem item=(FileItem)itr.next();
						String fileName=item.getName();//获得文件名，包括路径
						if(fileName!=null){
							Map<String,String> map = new HashMap<String, String>();
							String id = UUID.randomUUID().toString();
							File fullFile=new File(item.getName());
							String oldName=fullFile.getName();
							String filetype=oldName.substring(oldName.lastIndexOf("."), oldName.length());
							String filenewname=id+filetype;
							File savedFile=new File(uploadPath,filenewname);
							item.write(savedFile);
							msg = dl.savaData(savedFile,request);
						}
					}
				}
				catch(Exception e){
					msg="上传文件失败！"+e.getMessage();
				}
			}
			else{
				msg="没有发现上传文件！";
			}
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("/uploadExcel.jsp").forward(request, response);
			return ;
		}
	}
	
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(arg0, arg1);
	}

	public static void main(String[] args) {
		String test="1.txt";
	}

}