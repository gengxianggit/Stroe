package entity;

public class User {
	
	
	private String userName;
	private String password;
    private String mail;
	private int shopcart_id;
	



	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getShopcart_id() {
		return shopcart_id;
	}
	public void setShopcart_id(int shopcart_id) {
		this.shopcart_id = shopcart_id;
	}
public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
