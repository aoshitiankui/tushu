package com.util;

import java.util.List;
import java.util.Map;

public class PageModel {
	
	private int pageCount=20;//每页条数
	private int currentPage;//当前页
	private int totalPage;//总页数
	private int prePage;//上一页
	private int nextPage;//下一页
	private int totalCount;//总个数
	private String  sql;//总个数
	private List<Map<String,Object>> res;//结果集合
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public List<Map<String, Object>> getRes() {
		return res;
	}
	public void setRes(List<Map<String, Object>> res) {
		this.res = res;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(pageCount!=0){
			//计算总页数
			int temp = totalCount/pageCount;
			if(totalCount%pageCount!=0){
				temp++;
			}
			this.totalPage=temp;
			//计算上一页
			if(currentPage<=1){
				currentPage=1;
				prePage=1;
			}else{
				prePage=currentPage-1;
			}
			//计算下一页
			if(currentPage>=totalPage){
				nextPage=currentPage;
			}else{
				nextPage=currentPage+1;
			}
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		if (pageCount<=0)
			pageCount=20;
		else
			this.pageCount = pageCount;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
