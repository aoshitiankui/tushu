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
@RequestMapping("/codes")
public class CodesAction {
	@Autowired
	private CodesMapper dao;
	
	@RequestMapping("addCodes")
	@ResponseBody
	public Res addCodes(CodesModel models){
		int res = dao.addCodes(models);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updCodes")
	@ResponseBody
	public Res updCodes(CodesModel models){
		int res = dao.updCodes(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delCodes")
	@ResponseBody
	public Res  delCodes(CodesModel models){
		Res r = new Res();
		if(dao.delCodes(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findCodesById")
	public ModelAndView findCodesById(CodesModel models){
		ModelAndView mav=new ModelAndView("Codes");
		SpringApplicationContext.getRequest().setAttribute("findCodesById",dao.findCodesById(models));
		return mav;
	}
	@RequestMapping("findCodesByCondition")
	@ResponseBody
	public Res findCodesByCondition(CodesModel models){
		Res model = new Res();
		model.setTotal(dao.findCodesByConditionCount(models));
		model.setRows(dao.findCodesByCondition(models));
		return model;
	}
	
}