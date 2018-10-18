package entity;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Img {
private int id;
private String path;
private  int order;
private int commodity_id;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public int getCommodity() {
	return commodity_id;
}
public void setCommodity(int commodity) {
	this.commodity_id = commodity;
}
}
