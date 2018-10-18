package entity;

public class OrderDetail {
private int id;
private double subtotal;
private int num;
private int orderId;
private int commodityId;
private Production pro;

public Production getPro() {
	return pro;
}
public void setPro(Production pro) {
	this.pro = pro;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getCommodityId() {
	return commodityId;
}
public void setCommodityId(int commodityId) {
	this.commodityId = commodityId;
}
}
