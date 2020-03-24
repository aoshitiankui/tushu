package com.model;
/***
*评论信息
*/
import com.util.Page;

public class AdjustModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public AdjustModel(){
	
	}
	private long adid;
	
	public void setAdid(long adid ){
		this.adid=adid;
	}
	public long getAdid(){
		return this.adid;
	}
	private java.lang.String bid;
	public void setBid(java.lang.String bid){
		this.bid=bid;
	}
	public java.lang.String getBid(){
		return this.bid;
	}
	private java.lang.String examined;
	public void setExamined(java.lang.String examined){
		this.examined=examined;
	}
	public java.lang.String getExamined(){
		return this.examined;
	}
	private java.lang.String adjust;
	public void setAdjust(java.lang.String adjust){
		this.adjust=adjust;
	}
	public java.lang.String getAdjust(){
		return this.adjust;
	}
	private java.lang.String username;
	public void setUsername(java.lang.String username){
		this.username=username;
	}
	public java.lang.String getUsername(){
		return this.username;
	}
	private java.lang.String adtime;
	public void setAdtime(java.lang.String adtime){
		this.adtime=adtime;
	}
	public java.lang.String getAdtime(){
		return this.adtime;
	}
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	private String obid;
	public String getObid() {
		return obid;
	}
	public void setObid(String obid) {
		this.obid = obid;
	}
	
}