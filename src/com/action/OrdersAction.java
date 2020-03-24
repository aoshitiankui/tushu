package com.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
@RequestMapping("/orders")
public class OrdersAction {
	@Autowired
	private OrdersMapper dao;
	
	@Autowired
	private OrderbooksMapper orderbooksMapper;
	
	@Autowired
	private CartMapper cartMapper;
	@RequestMapping("addOrders")
	@ResponseBody
	public Res addOrders(OrdersModel models){
		Res r = new Res();
		
		if(models.getCheckeds()!=null&&models.getCheckeds().length>0){
			String obid= UUID.randomUUID().toString().replaceAll("-", "");
			Map user =(Map) SpringApplicationContext.getRequest().getSession().getAttribute("user");
			models.setUserType(user.get("usertype")+"");
			models.setUsersn(user.get("usersn")+"");
			models.setOrid(obid);
			dao.addOrders(models);
			orderbooksMapper.addOrderbooks(models);
			cartMapper.deleteCausBuybooks(models);
			r.setCode(0);
			r.setMsg("操作成功");
			
		}else{
			r.setMsg("无商品信息");
			return r;
		}
		return r;	
	}
	@RequestMapping("updOrders")
	@ResponseBody
	public Res updOrders(OrdersModel models){
		int res = dao.updOrders(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delOrders")
	@ResponseBody
	public Res  delOrders(OrdersModel models){
		Res r = new Res();
		if(dao.delOrders(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findOrdersById")
	public ModelAndView findOrdersById(OrdersModel models){
		ModelAndView mav=new ModelAndView("Orders");
		SpringApplicationContext.getRequest().setAttribute("findOrdersById",dao.findOrdersById(models));
		return mav;
	}
	
	@RequestMapping("findOrdersByIdView")
	public ModelAndView findOrdersByIdView(OrdersModel models){
		ModelAndView mav=new ModelAndView("OrderbooksList");
		SpringApplicationContext.getRequest().setAttribute("findOrdersByIdView",dao.findOrdersById(models));
		return mav;
	}
	
	@RequestMapping("findOrdersByCondition")
	@ResponseBody
	public Res findOrdersByCondition(OrdersModel models){
		Map user =(Map) SpringApplicationContext.getRequest().getSession().getAttribute("user");
		models.setUserType(user.get("usertype")+"");
		models.setUsersn(user.get("usersn")+"");
		Res model = new Res();
		model.setTotal(dao.findOrdersByConditionCount(models));
		model.setRows(dao.findOrdersByCondition(models));
		return model;
	}
	
}