package com.model;
/***
*系统字典
*/
import com.util.Page;

public class CodesModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public CodesModel(){
	
	}
	private long id;
	
	public void setId(long id ){
		this.id=id;
	}
	public long getId(){
		return this.id;
	}
	private java.lang.String codetype;
	public void setCodetype(java.lang.String codetype){
		this.codetype=codetype;
	}
	public java.lang.String getCodetype(){
		return this.codetype;
	}
	private java.lang.String codename;
	public void setCodename(java.lang.String codename){
		this.codename=codename;
	}
	public java.lang.String getCodename(){
		return this.codename;
	}
	private long ordernum;
	public void setOrdernum(long ordernum){
		this.ordernum=ordernum;
	}
	public long getOrdernum(){
		return this.ordernum;
	}
	private String pid;
	public void setPid(String pid){
		this.pid=pid;
	}
	public String getPid(){
		return this.pid;
	}
	private java.lang.String codetypename;
	public void setCodetypename(java.lang.String codetypename){
		this.codetypename=codetypename;
	}
	public java.lang.String getCodetypename(){
		return this.codetypename;
	}
	
}