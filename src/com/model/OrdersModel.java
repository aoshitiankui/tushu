package com.model;
/***
*订单
*/
import com.util.Page;

public class OrdersModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public OrdersModel(){
	
	}
	private String orid;
	
	public void setOrid(String orid ){
		this.orid=orid;
	}
	public String getOrid(){
		return this.orid;
	}
	private java.lang.String usersn;
	public void setUsersn(java.lang.String usersn){
		this.usersn=usersn;
	}
	public java.lang.String getUsersn(){
		return this.usersn;
	}
	private java.lang.String status;
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	public java.lang.String getStatus(){
		return this.status;
	}
	private java.lang.String address;
	public void setAddress(java.lang.String address){
		this.address=address;
	}
	public java.lang.String getAddress(){
		return this.address;
	}
	private java.lang.String mobile;
	public void setMobile(java.lang.String mobile){
		this.mobile=mobile;
	}
	public java.lang.String getMobile(){
		return this.mobile;
	}
	private String money;
	public void setMoney(String money){
		this.money=money;
	}
	public String getMoney(){
		return this.money;
	}
	private java.lang.String createtime;
	public void setCreatetime(java.lang.String createtime){
		this.createtime=createtime;
	}
	public java.lang.String getCreatetime(){
		return this.createtime;
	}
	private String orname;
	public String getOrname() {
		return orname;
	}
	public void setOrname(String orname) {
		this.orname = orname;
	}
	private String userType;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String[] checkeds;
	public String[] getCheckeds() {
		return checkeds;
	}
	public void setCheckeds(String[] checkeds) {
		this.checkeds = checkeds;
	}
	
}