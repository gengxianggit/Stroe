package service;

import entity.User;

public interface UserService {
	boolean addUser(User user);
    boolean doLogin(User user);
	int searchId(String  userName);
	void addCart(int id);

}
