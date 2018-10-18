package entity;

import java.util.List;

public class ShopCartDetail {
private int id; 
private int num;
 private double subtotal;
 private int commodityId;
 private int shopCartId;
 private Commodity comm;
 
 
public Commodity getComm() {
	return comm;
}
public void setComm(Commodity comm) {
	this.comm = comm;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public int getCommodityId() {
	return commodityId;
}
public void setCommodityId(int commodityId) {
	this.commodityId = commodityId;
}
public int getShopCartId() {
	return shopCartId;
}
public void setShopCartId(int shopCartId) {
	this.shopCartId = shopCartId;
}
 
}
