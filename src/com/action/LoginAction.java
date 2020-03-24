package com.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.DB;
import com.dao.UserMapper;
import com.util.ImagerHelp;
import com.util.Res;
import com.util.SpringApplicationContext;
import com.util.Util;
@Controller
@RequestMapping("/")
public class LoginAction  {

	
	@Autowired
	private UserMapper userMapper ;
	@RequestMapping("getImg")
	public ModelAndView getImg(){
		try {
			ImagerHelp.createImage( SpringApplicationContext.getResponse(),SpringApplicationContext.getRequest(), 60, 30, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//验证验证码
	@RequestMapping("checkCode")
	public ModelAndView checkCode(){
		HttpSession session = SpringApplicationContext.getRequest().getSession();
		try{
			String checkcode = (String) session.getAttribute("code");
			String code = SpringApplicationContext.getRequest().getParameter("code");
			String res = "";
			if(!code.equals(checkcode)){
				res=("{\"return_code\":\"error\"}");
			}else{
				res=("{\"return_code\":\"ok\"}");
			}
			Util.printResult(SpringApplicationContext.getResponse(), res, true);
		}catch(Exception e){
		}finally{
			try {
				SpringApplicationContext.getResponse().getWriter().flush();
				SpringApplicationContext.getResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//检查用户名密码
	@RequestMapping("login")
	public String login(){
		String userId = SpringApplicationContext.getRequest().getParameter("userId");
		String passWord = SpringApplicationContext.getRequest().getParameter("passWord");
		String sql = "select * from users where userId='"+userId+"' and password='"+passWord+"'";
		DB db = new DB();
		List<Map<String, Object>> res = db.query(sql);
		String content = "";
		if(res==null||res.size()==0){
			content=("{\"return_code\":\"error\"}");
		}else{
			SpringApplicationContext.getRequest().getSession().setAttribute("user", res.get(0));
			Map map = res.get(0);
			content=("{\"return_code\":\"ok\",\"type\":\""+map.get("usertype")+"\"}");
		}
		Util.printResult(SpringApplicationContext.getResponse(), content, true);
		return null;
	}
	//检查用户名密码
	@RequestMapping("updpwd")
	public String updpwd(){
		String userId = SpringApplicationContext.getRequest().getParameter("userId");
		String passWord = SpringApplicationContext.getRequest().getParameter("passWord");
		String sql = "update users set password='"+passWord+"' where userId='"+userId+"'";
		DB db = new DB();
		int i = db.executeSql(sql);
		Res res = new Res();
		if(i>=0){
			res.setCode(0);
			res.setMsg("修改成功！");
		}else{
			res.setMsg("修改失败！");
		}
		Util.printResult(SpringApplicationContext.getResponse(), res);
		return null;
	}
	//检查用户名是否被占用
	@RequestMapping("checkusername")
	public String checkusername(){
		String userId = SpringApplicationContext.getRequest().getParameter("userid");
		String sql = "select count(1) from users where userId='"+userId+"'";
		DB db = new DB();
    	String res = db.queryFirst(sql);
    	int count = Integer.parseInt(res);
    	if(count>0){
    		res="{\"valid\":false}";
    	}else{
    		res="{\"valid\":true}";
    	}
		Util.printResult(SpringApplicationContext.getResponse(), res, "text/html;charset=gbk", true);
		return null;
	}
	@RequestMapping("loginOut") 
	public ModelAndView loginOut(){
		SpringApplicationContext.getRequest().getSession().removeAttribute("user");
		try {
			SpringApplicationContext.getResponse().sendRedirect(SpringApplicationContext.getRequest().getContextPath()+"/customer/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
		 
	}
	
	@RequestMapping("regest") 
	public void regest(){
		String userId = SpringApplicationContext.getRequest().getParameter("userId");
		String passWord = SpringApplicationContext.getRequest().getParameter("passWord");
		String email = SpringApplicationContext.getRequest().getParameter("email");
		if(email==null){
			email = "";
		}
		String sql = "insert into users( userid,password,email,usertype,username) VALUES('"+userId+"','"+passWord+"','"+email+"','2','"+userId+"')";
		DB db = new DB();
		int i = db.executeSql(sql);
		Res res = new Res();
		if(i>=0){
			res.setCode(0);
			res.setMsg("注册成功！");
		}else{
			res.setCode(1);
			res.setMsg("注册失败！");
		}
		Util.printResult(SpringApplicationContext.getResponse(), res);
	}

}
