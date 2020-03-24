package com.util;

import java.util.List;

public class Res {
	private int total = 0;
	private List rows = null;
	private int code =-1;
	private String msg;
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public List getRows() {
		return rows;
	}
	
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
