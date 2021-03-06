package com.model;
/***
*订单商品
*/
import com.util.Page;

public class OrderbooksModel extends Page  implements java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public OrderbooksModel(){
	
	}
	private long obid;
	
	public void setObid(long obid ){
		this.obid=obid;
	}
	public long getObid(){
		return this.obid;
	}
	private long bid;
	public void setBid(long bid){
		this.bid=bid;
	}
	public long getBid(){
		return this.bid;
	}
	private java.lang.String bnum;
	public void setBnum(java.lang.String bnum){
		this.bnum=bnum;
	}
	public java.lang.String getBnum(){
		return this.bnum;
	}
	private java.lang.String bname;
	public void setBname(java.lang.String bname){
		this.bname=bname;
	}
	public java.lang.String getBname(){
		return this.bname;
	}
	private java.lang.String btype;
	public void setBtype(java.lang.String btype){
		this.btype=btype;
	}
	public java.lang.String getBtype(){
		return this.btype;
	}
	private java.lang.String bpublish;
	public void setBpublish(java.lang.String bpublish){
		this.bpublish=bpublish;
	}
	public java.lang.String getBpublish(){
		return this.bpublish;
	}
	private java.lang.String publishdate;
	public void setPublishdate(java.lang.String publishdate){
		this.publishdate=publishdate;
	}
	public java.lang.String getPublishdate(){
		return this.publishdate;
	}
	private java.lang.String pkben;
	public void setPkben(java.lang.String pkben){
		this.pkben=pkben;
	}
	public java.lang.String getPkben(){
		return this.pkben;
	}
	private java.lang.String pfengz;
	public void setPfengz(java.lang.String pfengz){
		this.pfengz=pfengz;
	}
	public java.lang.String getPfengz(){
		return this.pfengz;
	}
	private java.lang.String bbanci;
	public void setBbanci(java.lang.String bbanci){
		this.bbanci=bbanci;
	}
	public java.lang.String getBbanci(){
		return this.bbanci;
	}
	private java.lang.String writer;
	public void setWriter(java.lang.String writer){
		this.writer=writer;
	}
	public java.lang.String getWriter(){
		return this.writer;
	}
	private java.lang.String traner;
	public void setTraner(java.lang.String traner){
		this.traner=traner;
	}
	public java.lang.String getTraner(){
		return this.traner;
	}
	private java.lang.String isbn;
	public void setIsbn(java.lang.String isbn){
		this.isbn=isbn;
	}
	public java.lang.String getIsbn(){
		return this.isbn;
	}
	private long mprice;
	public void setMprice(long mprice){
		this.mprice=mprice;
	}
	public long getMprice(){
		return this.mprice;
	}
	private long vprice;
	public void setVprice(long vprice){
		this.vprice=vprice;
	}
	public long getVprice(){
		return this.vprice;
	}
	private java.lang.String salepoint;
	public void setSalepoint(java.lang.String salepoint){
		this.salepoint=salepoint;
	}
	public java.lang.String getSalepoint(){
		return this.salepoint;
	}
	private java.lang.String sales;
	public void setSales(java.lang.String sales){
		this.sales=sales;
	}
	public java.lang.String getSales(){
		return this.sales;
	}
	private java.lang.String viewcount;
	public void setViewcount(java.lang.String viewcount){
		this.viewcount=viewcount;
	}
	public java.lang.String getViewcount(){
		return this.viewcount;
	}
	private java.lang.String img;
	public void setImg(java.lang.String img){
		this.img=img;
	}
	public java.lang.String getImg(){
		return this.img;
	}
	private java.lang.String stores;
	public void setStores(java.lang.String stores){
		this.stores=stores;
	}
	public java.lang.String getStores(){
		return this.stores;
	}
	private java.lang.String instoresdate;
	public void setInstoresdate(java.lang.String instoresdate){
		this.instoresdate=instoresdate;
	}
	public java.lang.String getInstoresdate(){
		return this.instoresdate;
	}
	private java.lang.String issale;
	public void setIssale(java.lang.String issale){
		this.issale=issale;
	}
	public java.lang.String getIssale(){
		return this.issale;
	}
	private long ratingnum;
	public void setRatingnum(long ratingnum){
		this.ratingnum=ratingnum;
	}
	public long getRatingnum(){
		return this.ratingnum;
	}
	private java.lang.String isnew;
	public void setIsnew(java.lang.String isnew){
		this.isnew=isnew;
	}
	public java.lang.String getIsnew(){
		return this.isnew;
	}
	private java.lang.String bdesc;
	public void setBdesc(java.lang.String bdesc){
		this.bdesc=bdesc;
	}
	public java.lang.String getBdesc(){
		return this.bdesc;
	}
	private java.lang.String isadjust;
	public void setIsadjust(java.lang.String isadjust){
		this.isadjust=isadjust;
	}
	public java.lang.String getIsadjust(){
		return this.isadjust;
	}
	
	private String usersn;
	public String getUsersn() {
		return usersn;
	}
	public void setUsersn(String usersn) {
		this.usersn = usersn;
	}
	private String orid;
	public String getOrid() {
		return orid;
	}
	public void setOrid(String orid) {
		this.orid = orid;
	}
	
}