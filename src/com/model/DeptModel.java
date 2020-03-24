package com.model;
/***
*部门信息
*/
import com.util.Page;

public class DeptModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public DeptModel(){
	
	}
	private long id;
	
	public void setId(long id ){
		this.id=id;
	}
	public long getId(){
		return this.id;
	}
	private java.lang.String deptname;
	public void setDeptname(java.lang.String deptname){
		this.deptname=deptname;
	}
	public java.lang.String getDeptname(){
		return this.deptname;
	}
	private long deptup;
	public void setDeptup(long deptup){
		this.deptup=deptup;
	}
	public long getDeptup(){
		return this.deptup;
	}
	private java.lang.String tel;
	public void setTel(java.lang.String tel){
		this.tel=tel;
	}
	public java.lang.String getTel(){
		return this.tel;
	}
	private java.lang.String fax;
	public void setFax(java.lang.String fax){
		this.fax=fax;
	}
	public java.lang.String getFax(){
		return this.fax;
	}
	private java.lang.String conperson;
	public void setConperson(java.lang.String conperson){
		this.conperson=conperson;
	}
	public java.lang.String getConperson(){
		return this.conperson;
	}
	private java.lang.String conpersonphone;
	public void setConpersonphone(java.lang.String conpersonphone){
		this.conpersonphone=conpersonphone;
	}
	public java.lang.String getConpersonphone(){
		return this.conpersonphone;
	}
	private java.lang.String conaddress;
	public void setConaddress(java.lang.String conaddress){
		this.conaddress=conaddress;
	}
	public java.lang.String getConaddress(){
		return this.conaddress;
	}
	private java.lang.String address;
	public void setAddress(java.lang.String address){
		this.address=address;
	}
	public java.lang.String getAddress(){
		return this.address;
	}
	private java.lang.String des;
	public void setDes(java.lang.String des){
		this.des=des;
	}
	public java.lang.String getDes(){
		return this.des;
	}
	
}