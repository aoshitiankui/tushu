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
@RequestMapping("/adjust")
public class AdjustAction {
	@Autowired
	private AdjustMapper dao;
	@Autowired
	private OrderbooksMapper orderbooksMapper;
	
	@RequestMapping("addAdjust")
	@ResponseBody
	public Res addAdjust(AdjustModel models){
		Map user =(Map )SpringApplicationContext.getRequest().getSession().getAttribute("user");
		models.setUsername((String)user.get("username"));
		int res = dao.addAdjust(models);
		OrderbooksModel model2 = new  OrderbooksModel();
		model2.setObid(Long.parseLong(models.getObid()));
		model2.setIsadjust("38");
		orderbooksMapper.updOrderbooks(model2);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updAdjust")
	@ResponseBody
	public Res updAdjust(AdjustModel models){
		int res = dao.updAdjust(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delAdjust")
	@ResponseBody
	public Res  delAdjust(AdjustModel models){
		Res r = new Res();
		if(dao.delAdjust(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findAdjustById")
	public ModelAndView findAdjustById(AdjustModel models){
		ModelAndView mav=new ModelAndView("Adjust");
		SpringApplicationContext.getRequest().setAttribute("findAdjustById",dao.findAdjustById(models));
		return mav;
	}
	@RequestMapping("findAdjustByCondition")
	@ResponseBody
	public Res findAdjustByCondition(AdjustModel models){
		Res model = new Res();
		model.setTotal(dao.findAdjustByConditionCount(models));
		model.setRows(dao.findAdjustByCondition(models));
		return model;
	}
	
}