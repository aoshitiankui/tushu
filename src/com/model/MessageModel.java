package com.model;
/***
*留言板
*/
import com.util.Page;

public class MessageModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public MessageModel(){
	
	}
	private long mid;
	
	public void setMid(long mid ){
		this.mid=mid;
	}
	public long getMid(){
		return this.mid;
	}
	private java.lang.String email;
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	public java.lang.String getEmail(){
		return this.email;
	}
	private java.lang.String mobile;
	public void setMobile(java.lang.String mobile){
		this.mobile=mobile;
	}
	public java.lang.String getMobile(){
		return this.mobile;
	}
	private java.lang.String messages;
	public void setMessages(java.lang.String messages){
		this.messages=messages;
	}
	public java.lang.String getMessages(){
		return this.messages;
	}
	private java.lang.String mtime;
	public void setMtime(java.lang.String mtime){
		this.mtime=mtime;
	}
	public java.lang.String getMtime(){
		return this.mtime;
	}
	private java.lang.String isdeal;
	public void setIsdeal(java.lang.String isdeal){
		this.isdeal=isdeal;
	}
	public java.lang.String getIsdeal(){
		return this.isdeal;
	}
	private java.lang.String name;
	public void setName(java.lang.String name){
		this.name=name;
	}
	public java.lang.String getName(){
		return this.name;
	}
	private java.lang.String mtype;
	public void setMtype(java.lang.String mtype){
		this.mtype=mtype;
	}
	public java.lang.String getMtype(){
		return this.mtype;
	}
	private java.lang.String ipaddress;
	public void setIpaddress(java.lang.String ipaddress){
		this.ipaddress=ipaddress;
	}
	public java.lang.String getIpaddress(){
		return this.ipaddress;
	}
	private java.lang.String title;
	public void setTitle(java.lang.String title){
		this.title=title;
	}
	public java.lang.String getTitle(){
		return this.title;
	}
	
}