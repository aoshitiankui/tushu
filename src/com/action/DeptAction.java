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
@RequestMapping("/dept")
public class DeptAction {
	@Autowired
	private DeptMapper dao;
	
	@RequestMapping("addDept")
	@ResponseBody
	public Res addDept(DeptModel models){
		int res = dao.addDept(models);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updDept")
	@ResponseBody
	public Res updDept(DeptModel models){
		int res = dao.updDept(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delDept")
	@ResponseBody
	public Res  delDept(DeptModel models){
		Res r = new Res();
		if(dao.delDept(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findDeptById")
	public ModelAndView findDeptById(DeptModel models){
		ModelAndView mav=new ModelAndView("Dept");
		SpringApplicationContext.getRequest().setAttribute("findDeptById",dao.findDeptById(models));
		return mav;
	}
	@RequestMapping("findDeptByCondition")
	@ResponseBody
	public Res findDeptByCondition(DeptModel models){
		Res model = new Res();
		model.setTotal(dao.findDeptByConditionCount(models));
		model.setRows(dao.findDeptByCondition(models));
		return model;
	}
	
}