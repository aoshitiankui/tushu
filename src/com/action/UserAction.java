package com.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import com.dao.*;
import com.model.*;
import com.util.*;
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserMapper dao;
	
	@RequestMapping("addUser")
	@ResponseBody
	public Res addUser(UserModel models){
		int res = dao.addUser(models);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updUser")
	@ResponseBody
	public Res updUser(UserModel models){
		int res = dao.updUser(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delUser")
	@ResponseBody
	public Res  delUser(UserModel models){
		Res r = new Res();
		if(dao.delUser(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findUserById")
	public ModelAndView findUserById(UserModel models){
		String actionType = models.getActionType();
		ModelAndView mav=null;
		if(actionType!=null&&!"".equals(actionType)){
			mav=new ModelAndView("Userme");
		}else{
			mav=new ModelAndView("User");
		}
		SpringApplicationContext.getRequest().setAttribute("findUserById",dao.findUserById(models));
		return mav;
	}
	@RequestMapping("findUserByCondition")
	@ResponseBody
	public Res findUserByCondition(UserModel models){
		Res model = new Res();
		model.setTotal(dao.findUserByConditionCount(models));
		model.setRows(dao.findUserByCondition(models));
		return model;
	}
	
}