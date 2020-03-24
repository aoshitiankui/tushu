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
@RequestMapping("/message")
public class MessageAction {
	@Autowired
	private MessageMapper dao;
	
	@RequestMapping("addMessage")
	@ResponseBody
	public Res addMessage(MessageModel models){
		models.setIpaddress(Util.getIpAddress(SpringApplicationContext.getRequest()));
		int res = dao.addMessage(models);
		Res r = new Res();
		String msg="添加失败！";
		if(res>=0){
			msg="添加成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;	
	}
	@RequestMapping("updMessage")
	@ResponseBody
	public Res updMessage(MessageModel models){
		int res = dao.updMessage(models);
		Res r = new Res();
		String msg="修改失败！";
		if(res>=0){
			msg="修改成功！";
			r.setCode(0);
		}
		r.setMsg(msg);
		return r;
	}
	@RequestMapping("delMessage")
	@ResponseBody
	public Res  delMessage(MessageModel models){
		Res r = new Res();
		if(dao.delMessage(models)>=0){
			r.setCode(0);
		}
		return r;
	}
	@RequestMapping("findMessageById")
	public ModelAndView findMessageById(MessageModel models){
		ModelAndView mav=new ModelAndView("Message");
		SpringApplicationContext.getRequest().setAttribute("findMessageById",dao.findMessageById(models));
		return mav;
	}
	@RequestMapping("findMessageByCondition")
	@ResponseBody
	public Res findMessageByCondition(MessageModel models){
		Res model = new Res();
		model.setTotal(dao.findMessageByConditionCount(models));
		model.setRows(dao.findMessageByCondition(models));
		return model;
	}
	
}