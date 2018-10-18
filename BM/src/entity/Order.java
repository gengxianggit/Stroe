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
private String goodCondition;
private String payCondition;
List<OrderDetail> odlist;
public String getGoodCondition() {
	return goodCondition;
}
public void setGoodCondition(String goodCondition) {
	this.goodCondition = goodCondition;
}


public String getPayCondition() {
	return payCondition;
}
public void setPayCondition(String payCondition) {
	this.payCondition = payCondition;
}
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

public int getOrderNum() {
	return orderNum;
}
public void setOrderNum(int orderNum) {
	this.orderNum = orderNum;
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
