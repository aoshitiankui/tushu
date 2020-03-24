package com.model;
/***
*购物车
*/
import com.util.Page;

public class CartModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public CartModel(){
	
	}
	private long cid;
	
	public void setCid(long cid ){
		this.cid=cid;
	}
	public long getCid(){
		return this.cid;
	}
	private java.lang.String usersn;
	public void setUsersn(java.lang.String usersn){
		this.usersn=usersn;
	}
	public java.lang.String getUsersn(){
		return this.usersn;
	}
	private long cnum;
	public void setCnum(long cnum){
		this.cnum=cnum;
	}
	public long getCnum(){
		return this.cnum;
	}
	public String bid;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String[] checkeds;
	public String[] getCheckeds() {
		return checkeds;
	}
	public void setCheckeds(String[] checkeds) {
		this.checkeds = checkeds;
	}
	
}