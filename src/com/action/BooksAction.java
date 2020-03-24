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
@RequestMapping("/books")
public class BooksAction {
	@Autowired
	private BooksMapper dao;
	
	@RequestMapping("addBooks")
	@ResponseBody
	public Res addBooks(BooksModel models){
		int res = dao.addBooks(models);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updBooks")
	@ResponseBody
	public Res updBooks(BooksModel models){
		int res = dao.updBooks(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delBooks")
	@ResponseBody
	public Res  delBooks(BooksModel models){
		Res r = new Res();
		if(dao.delBooks(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findBooksById")
	public ModelAndView findBooksById(BooksModel models){
		
		ModelAndView mav = null;
		if(models.getBookView()!=null&&!"".equals(models.getBookView())){
			mav=new ModelAndView("customer/singleGoods");
		}else{
			mav=new ModelAndView("Books");
		}
		SpringApplicationContext.getRequest().setAttribute("findBooksById",dao.findBooksById(models));
		return mav;
	}
	@RequestMapping("findBooksByCondition")
	@ResponseBody
	public Res findBooksByCondition(BooksModel models){
		Res model = new Res();
		Map user =(Map )SpringApplicationContext.getRequest().getSession().getAttribute("user");
		if(user==null&&models!=null &&models.getGuess()!=null){
			model.setTotal(dao.findBooksGuessCount(models));
			model.setRows(dao.findBooksGuess(models));
		}else{
			if(models.getGuess()!=null){
				models.setUsersn(user.get("usersn")+"");
				models.setBtype(dao.queryLatestBuy(models));
			}
			model.setTotal(dao.findBooksByConditionCount(models));
			model.setRows(dao.findBooksByCondition(models));
		}
 

		return model;
	}
	
}