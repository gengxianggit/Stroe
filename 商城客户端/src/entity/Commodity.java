package entity;

import java.util.List;

public class Commodity {
private int id;
private String name;
private double price;
private int Inventory;
private int salenum;
private String intriduceproduction;
private String  samllClassification_id;
private List<Img> pictures;




public List<Img> getPictures() {
	return pictures;
}
public void setPictures(List<Img> pictures) {
	this.pictures = pictures;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getInventory() {
	return Inventory;
}
public void setInventory(int inventory) {
	Inventory = inventory;
}
public int getSalenum() {
	return salenum;
}
public void setSalenum(int salenum) {
	this.salenum = salenum;
}
public String getIntriduceproduction() {
	return intriduceproduction;
}
public void setIntriduceproduction(String intriduceproduction) {
	this.intriduceproduction = intriduceproduction;
}
public String getSamllClassification_id() {
	return samllClassification_id;
}
public void setSamllClassification_id(String samllClassification_id) {
	this.samllClassification_id = samllClassification_id;
}
}
