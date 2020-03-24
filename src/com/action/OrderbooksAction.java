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
@RequestMapping("/orderbooks")
public class OrderbooksAction {
	@Autowired
	private OrderbooksMapper dao;
	
	@RequestMapping("updOrderbooks")
	@ResponseBody
	public Res updOrderbooks(OrderbooksModel models){
		int res = dao.updOrderbooks(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delOrderbooks")
	@ResponseBody
	public Res  delOrderbooks(OrderbooksModel models){
		Res r = new Res();
		if(dao.delOrderbooks(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findOrderbooksById")
	public ModelAndView findOrderbooksById(OrderbooksModel models){
		ModelAndView mav=new ModelAndView("Orderbooks");
		SpringApplicationContext.getRequest().setAttribute("findOrderbooksById",dao.findOrderbooksById(models));
		return mav;
	}
	@RequestMapping("findOrderbooksByCondition")
	@ResponseBody
	public Res findOrderbooksByCondition(OrderbooksModel models){
		Res model = new Res();
		model.setTotal(dao.findOrderbooksByConditionCount(models));
		model.setRows(dao.findOrderbooksByCondition(models));
		return model;
	}
	
}