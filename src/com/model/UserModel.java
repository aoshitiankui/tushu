package com.model;
/***
*用户信息
*/
import com.util.Page;

public class UserModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public UserModel(){
	
	}
	private long usersn;
	
	public void setUsersn(long usersn ){
		this.usersn=usersn;
	}
	public long getUsersn(){
		return this.usersn;
	}
	private java.lang.String userid;
	public void setUserid(java.lang.String userid){
		this.userid=userid;
	}
	public java.lang.String getUserid(){
		return this.userid;
	}
	private java.lang.String username;
	public void setUsername(java.lang.String username){
		this.username=username;
	}
	public java.lang.String getUsername(){
		return this.username;
	}
	private java.lang.String password;
	public void setPassword(java.lang.String password){
		this.password=password;
	}
	public java.lang.String getPassword(){
		return this.password;
	}
	private java.lang.String usertype;
	public void setUsertype(java.lang.String usertype){
		this.usertype=usertype;
	}
	public java.lang.String getUsertype(){
		return this.usertype;
	}
	private java.lang.String dept;
	public void setDept(java.lang.String dept){
		this.dept=dept;
	}
	public java.lang.String getDept(){
		return this.dept;
	}
	private java.lang.String mobile;
	public void setMobile(java.lang.String mobile){
		this.mobile=mobile;
	}
	public java.lang.String getMobile(){
		return this.mobile;
	}
	private java.lang.String tel;
	public void setTel(java.lang.String tel){
		this.tel=tel;
	}
	public java.lang.String getTel(){
		return this.tel;
	}
	private java.lang.String email;
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	public java.lang.String getEmail(){
		return this.email;
	}
	private java.lang.String qq;
	public void setQq(java.lang.String qq){
		this.qq=qq;
	}
	public java.lang.String getQq(){
		return this.qq;
	}
	private java.lang.String img;
	public void setImg(java.lang.String img){
		this.img=img;
	}
	public java.lang.String getImg(){
		return this.img;
	}
	private java.lang.String address;
	public void setAddress(java.lang.String address){
		this.address=address;
	}
	public java.lang.String getAddress(){
		return this.address;
	}
	private java.lang.String mem;
	public void setMem(java.lang.String mem){
		this.mem=mem;
	}
	public java.lang.String getMem(){
		return this.mem;
	}
	private String actionType ;
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	private double wallet;
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
}