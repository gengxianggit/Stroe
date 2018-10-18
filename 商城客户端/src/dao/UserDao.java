package dao;

import entity.User;

public interface UserDao {

  Integer addUser(User user) ;
  int  searchId(String userName);
   void addCart(int id) ;
  Integer doLogin(User user);
	

	
	
	
}
