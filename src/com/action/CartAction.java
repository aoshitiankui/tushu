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
@RequestMapping("/cart")
public class CartAction {
	@Autowired
	private CartMapper dao;
	
	@RequestMapping("addCart")
	@ResponseBody
	public Res addCart(CartModel models){
		
		
		Map user =(Map )SpringApplicationContext.getRequest().getSession().getAttribute("user");
		models.setUsersn(user.get("usersn")+"");
		CartModel c = dao.checkaddCart(models);
		int res=-1;

		if(c!=null){
			if(models.getCnum()>1){
				c.setCnum(models.getCnum());
			}else{
				c.setCnum(1);
			}
			res=dao.updCartThrothAdd(c);
		}else{
			if(models.getCnum()<=0){
				models.setCnum(1);
			}
			res=dao.addCart(models);
		}
		Res r = new Res();
		String msg="添加购物车成功！";
		if(res>=0){
			msg="添加购物车成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updCart")
	@ResponseBody
	public Res updCart(CartModel models){
		int res = dao.updCart(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	
	@RequestMapping("findCartOfMini")
	@ResponseBody
	public Map findCartOfMini(CartModel models){
		Map user =(Map)SpringApplicationContext.getRequest().getSession().getAttribute("user");
		models.setUsersn(""+user.get("usersn"));
		Map map = dao.findCartOfMini(models);
		return map;
	}
	@RequestMapping("delCart")
	@ResponseBody
	public Res  delCart(CartModel models){
		Res r = new Res();
		if(dao.delCart(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findCartById")
	public ModelAndView findCartById(CartModel models){
		ModelAndView mav=new ModelAndView("Cart");
		SpringApplicationContext.getRequest().setAttribute("findCartById",dao.findCartById(models));
		return mav;
	}
	@RequestMapping("findCartByCondition")
	@ResponseBody
	public Res findCartByCondition(CartModel models){
		Map user =(Map )SpringApplicationContext.getRequest().getSession().getAttribute("user");
		models.setUsersn(user.get("usersn")+"");
		 
		Res model = new Res();
		model.setTotal(dao.findCartByConditionCount(models));
		model.setRows(dao.findCartByCondition(models));
		return model;
	}
	
}