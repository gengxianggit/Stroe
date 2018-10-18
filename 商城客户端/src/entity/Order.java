package entity;

import java.util.List;

public class Order {
private int id;
private String orderName;
private double orderprice;
private int orderNum;
private String date;
private int  addressId;
private int userId;
private Address ad;
List<OrderDetail> odlist;
public Address getAd() {
	return ad;
}
public void setAd(Address ad) {
	this.ad = ad;
}
;
public List<OrderDetail> getOdlist() {
	return odlist;
}
public void setOdlist(List<OrderDetail> odlist) {
	this.odlist = odlist;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderName() {
	return orderName;
}
public void setOrderName(String orderName) {
	this.orderName = orderName;
}
public double getOrderprice() {
	return orderprice;
}
public void setOrderprice(double orderprice) {
	this.orderprice = orderprice;
}
public int getOrdernum() {
	return orderNum;
}
public void setOrdernum(int ordernum) {
	this.orderNum = ordernum;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
}
