package entity;

import java.util.List;

public class ShopCart {
private int id;
private double sumCount;
private int userId;
private List<ShopCartDetail> scdList;


public List<ShopCartDetail> getScdList() {
	return scdList;
}
public void setScdList(List<ShopCartDetail> scdList) {
	this.scdList = scdList;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getSumCount() {
	return sumCount;
}
public void setSumCount(double sumCount) {
	this.sumCount = sumCount;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
	
	
	
}
